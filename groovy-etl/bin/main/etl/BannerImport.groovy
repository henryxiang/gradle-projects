package etl

import etl.jobs.CopyTableJob


class BannerTbraccd {
    static void main(String[] args) {
        Properties props = App.getAppProperties()
        Map dbSrc = [
            url: props.getProperty('src.url'),
            user: props.getProperty('src.user'),
            password: props.getProperty('src.password'),
            driver: props.getProperty('src.driver'),
        ]
        Map dbDst = [
            url: props.getProperty('dst.url'),
            user: props.getProperty('dst.user'),
            password: props.getProperty('dst.password'),
            driver: props.getProperty('dst.driver'),
        ]
        List jobs = [
            new CopyTableJob(dbSrc, dbDst, 'SPRIDEN', "SPRIDEN_ACTIVITY_DATE >= '1-jan-10'"),
            new CopyTableJob(dbSrc, dbDst, 'STVTERM'),
            new CopyTableJob(dbSrc, dbDst, 'TBBDETC'),
            new CopyTableJob(dbSrc, dbDst, 'TBRACCD', "TBRACCD_ENTRY_DATE >= '1-jan-19'"),
            new CopyTableJob(dbSrc, dbDst, 'TTVDCAT'),
        ]
        
        jobs.each {
            it.cleanup()
            it.run()
        }
    }
}