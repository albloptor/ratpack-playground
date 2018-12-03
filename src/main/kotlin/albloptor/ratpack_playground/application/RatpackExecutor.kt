package albloptor.ratpack_playground.application

import ratpack.exec.Promise
import ratpack.test.exec.ExecHarness

class RatpackExecutor {

    private fun secuencialRun() : String {
        var result = ""
         ExecHarness.harness().run {
            result += "a"
            result += databaseCall()
            result += restCall()
            result += ratpackCall()
            result += "e"
        }
        return result
    }

    private fun databaseCall() : String{
        Thread.sleep(1000L)
        return "b"
    }

    private fun restCall() : String{
        Thread.sleep(1000L)
        return "c"
    }

    private fun ratpackCall(): Promise<String> {
        return Promise.value("d")
    }

    private fun nestedRun() : String{
        var result = ""
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
        return result
    }


}