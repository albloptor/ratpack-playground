package albloptor.ratpack_playground.application

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
}