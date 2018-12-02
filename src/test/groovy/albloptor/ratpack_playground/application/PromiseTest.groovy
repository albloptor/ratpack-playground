package albloptor.ratpack_playground.application


import ratpack.exec.Promise
import ratpack.test.exec.ExecHarness
import spock.lang.Specification

class PromiseTest extends Specification {

    def "promise refactoring"() {
        given:
        def result = ""

        when:
        ExecHarness.harness().run {
            result += "a"
            result += databaseCall()
            result += restCall()
            result += ratpackCall()
            result += "e"
        }

        then:
        result == "abcde"
    }

    private static def databaseCall() {
        Thread.sleep(1000L)
        "b"
    }

    private static def restCall() {
        Thread.sleep(1000L)
        "c"
    }

    private static def ratpackCall() { Promise.value("d") }

    /*
    1. Is the test going to succeed?
    2. If it succeeds, is the implementation correct?
    3. How can it be improved so that the test still passes?
     */

    def "nested promises"() {
        given:
        def result = ""

        when:
        ExecHarness.harness().run {
            Promise.value("1").flatMap {
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

    /*
    *
    * 1. Why is the exception thrown?
    * 2. Make the test pass.
    *
    * */

}
