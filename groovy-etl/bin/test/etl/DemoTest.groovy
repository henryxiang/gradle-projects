/*
 * This Spock specification was generated by the Gradle 'init' task.
 */
package etl

import spock.lang.Specification

class DemoTest extends Specification {
    def "application has a greeting"() {
        setup:
        def demo = new Demo()

        when:
        def result = demo.greeting

        then:
        result == 'Hello Gradle'
    }
}