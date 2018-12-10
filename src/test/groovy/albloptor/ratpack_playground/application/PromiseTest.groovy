package albloptor.ratpack_playground.application

import ratpack.exec.Promise
import ratpack.test.exec.ExecHarness
import spock.lang.Specification

class PromiseTest extends Specification {

    private RatpackExecutor executor = new RatpackExecutor(
            new Repository(),
            new Controller(),
            new Ratpack(),
            new NumberProvider())

    def "promise refactoring"() {
        when:
        def result = ExecHarness.harness().yield() {
            executor.sequentialRun()
        }.value

        then:
        result == "abcde"
    }

    def "nested promises"() {
        when:
        def result = ExecHarness.harness().yield {
            executor.nestedPromises()
        }.valueOrThrow

        then:
        result == "1234"
    }

}
