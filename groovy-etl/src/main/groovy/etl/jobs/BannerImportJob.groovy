package etl.jobs

import etl.Config
import etl.util.CopyTable


class BannerImportJob {
    static void main(String[] args) {
        Properties props = Config.getAppProperties()
        Map dbSrc = [
                url     : props.getProperty('src.url'),
                user    : props.getProperty('src.username'),
                password: props.getProperty('src.password'),
                driver  : props.getProperty('src.driver'),
        ]
        Map dbDst = [
                url     : props.getProperty('dst.url'),
                user    : props.getProperty('dst.username'),
                password: props.getProperty('dst.password'),
                driver  : props.getProperty('dst.driver'),
        ]
        List jobs = [
//                new CopyTable(dbSrc, dbDst, 'SPRIDEN', "SPRIDEN_ACTIVITY_DATE >= '1-jan-10'"),
                new CopyTable(dbSrc, dbDst, 'STVTERM'),
                new CopyTable(dbSrc, dbDst, 'TBBDETC'),
//                new CopyTable(dbSrc, dbDst, 'TBRACCD', "TBRACCD_ENTRY_DATE >= '1-jan-19'"),
                new CopyTable(dbSrc, dbDst, 'TTVDCAT'),
        ]

        jobs.each {
//            it.cleanup()
            it.run()
        }
    }
}