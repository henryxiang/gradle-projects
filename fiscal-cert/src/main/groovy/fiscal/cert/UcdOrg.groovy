package fiscal.cert

import groovy.sql.*

class UcdOrg {
  static void main(String[] args) {
    Properties props = getProperties()
    println props.getProperty('jdbc.url')
    def db = Sql.newInstance(
      props.getProperty('jdbc.url'),
      props.getProperty('jdbc.username'),
      props.getProperty('jdbc.password'),
      props.getProperty('jdbc.driver')
    )
    def orgs = db.rows('select * from KFS.CA_ORG_T')
    println orgs.size()
  }

  static Properties getProperties() {
    Properties props = new Properties()
    props.load(UcdOrg.class.getResourceAsStream('/application.properties'))
    return props  
  }
}