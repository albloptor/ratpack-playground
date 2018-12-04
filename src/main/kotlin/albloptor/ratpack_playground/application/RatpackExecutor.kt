package albloptor.ratpack_playground.application

import ratpack.exec.Promise

class RatpackExecutor(private val repository: Repository,
                      private val controller: Controller,
                      private val ratpack: Ratpack) {


    private fun secuencialRun(): String {
        var result = ""
        result = result.plus("a")
                .plus(repository.find())
                .plus(controller.call())
                .plus(ratpack.call())
                .plus("e")

        return result
    }

    private fun nestedRun(): String {
        var result = ""
        Promise.value("1").map {
            result += it
            Promise.value("2").then {
                result += it
                Promise.value("3")
            }
        }.then {
            result += "4"
        }

        return result
    }


}