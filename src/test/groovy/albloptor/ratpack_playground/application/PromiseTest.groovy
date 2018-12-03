package albloptor.ratpack_playground.application


import spock.lang.Specification

class PromiseTest extends Specification {

    private RatpackExecutor executor

    void setup() {
        executor = new RatpackExecutor(new Repository(), new Controller(), new Ratpack())
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
