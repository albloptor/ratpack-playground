package albloptor.ratpack_playground.application

import ratpack.test.exec.ExecHarness
import spock.lang.Specification

class PromiseTest extends Specification {

    private RatpackExecutor executor

    void setup() {
        executor = new RatpackExecutor(new Repository(), new Controller(), new Ratpack())
    }

    def "promise refactoring"() {
        given:
        def result = ""

        when:
        ExecHarness.harness().run {
            result = executor.secuencialRun()
        }

        then:
        result == "abcde"
    }



    def "nested promises"() {
        given:
        def result = ""

        when:
        ExecHarness.harness().run {
            result = executor.nestedRun()
        }

        then:
        result == "1234"
    }



}
