package albloptor.ratpack_playground.application

class Controller {
    fun call(): String {
        Thread.sleep(1000L)
        return "c"
    }

}
