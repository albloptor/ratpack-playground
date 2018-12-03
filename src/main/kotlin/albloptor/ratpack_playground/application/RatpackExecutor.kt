package albloptor.ratpack_playground.application

import ratpack.exec.Promise
import ratpack.test.exec.ExecHarness

class RatpackExecutor(private val repository: Repository,
                      private val controller: Controller,
                      private val ratpack: Ratpack) {


    private fun secuencialRun() : String {
        var result = ""
         ExecHarness.harness().run {
            result += "a"
            result += repository.find()
            result += controller.call()
            result += ratpack.call()
            result += "e"
        }
        return result
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