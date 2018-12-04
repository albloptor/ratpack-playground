package albloptor.ratpack_playground.application

import ratpack.exec.Promise
import ratpack.test.exec.ExecHarness
import spock.lang.Specification

class PromiseTest extends Specification {

    private RatpackExecutor executor

    void setup() {
        executor = new RatpackExecutor(new Repository(), new Controller(), new Ratpack())
    }

    def "promise refactoring"() {
        when:
        def result = ExecHarness.harness().yield() {
            executor.sequentialRun()
        }.value

        then:
        result == "abcde"
    }

    def "nested promises2"() {
        given:
        def result = ""

        when:
        ExecHarness.harness().run {
            Promise.value("1").map {
                result += it
                Promise.value("2").then {
                    result += it
                    Promise.value("3")
                }
            }.then {
                result += "4"
            }
        }

        then:
        result == "1234"
    }

}
