package etl.util


import groovy.sql.Sql

class CopyTable {
    Sql sqlSrc
    Sql sqlDst
    String table
    String whereClause

    CopyTable(Map dbSrc, Map dbDst, String table, String whereClause = '') {
        sqlSrc = Sql.newInstance(dbSrc.url, dbSrc.user, dbSrc.password, dbSrc.driver)
        sqlDst = Sql.newInstance(dbDst.url, dbDst.user, dbDst.password, dbDst.driver)
        this.table = table
        this.whereClause = whereClause
    }

    def run() {
        String select = whereClause ? "select * from $table where $whereClause" : "select * from $table"
        sqlSrc.eachRow(select) { row ->
            def md = row.getMetaData()
            def columns = (1..md.columnCount).collect { md.getColumnName(it) }
            def values = (1..md.columnCount).collect { row[it - 1] }
            def insert = "insert into $table(${columns.join(",")}) values(${columns.collect { "?" }.join(",")})"
            println(values)
            sqlDst.execute(insert, values)
        }
    }

    def cleanup() {
        sqlDst.execute("truncate table $table".toString())
    }
}