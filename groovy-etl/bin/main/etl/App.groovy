/*
 * This Groovy source file was generated by the Gradle 'init' task.
 */
package etl

import etl.jobs.CopyTableJob


class App {
    static void main(String[] args) {
        Properties props = getAppProperties()
        props.keySet().toSorted().each {
            println("$it = ${props.getProperty(it)}")    
        }
    }

    static Properties getAppProperties() {
        Properties props = new Properties()
        props.load(App.class.getResourceAsStream('/application.properties'))
        return props  
    }
}
