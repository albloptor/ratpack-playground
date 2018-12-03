package albloptor.ratpack_playground.application


import ratpack.exec.Promise
import ratpack.test.exec.ExecHarness
import spock.lang.Specification

class PromiseTest extends Specification {

    private RatpackExecutor executor

    void setup() {
        executor = new RatpackExecutor()
    }

    def "promise refactoring"() {
        when:
        def result = executor.secuencialRun()

        then:
        result == "abcde"
    }



    def "nested promises"() {
        when:
        def result = executor.nestedRun()

        then:
        result == "1234"
    }



}
