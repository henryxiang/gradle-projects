package etl

import etl.jobs.BannerImportJob

class Config {
    static Properties getAppProperties() {
        Properties props = new Properties()
        props.load(BannerImportJob.class.getResourceAsStream('/application.properties'))
        return props
    }
}
