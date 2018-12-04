package albloptor.ratpack_playground.application

class Repository {

    fun find() : String {
        Thread.sleep(1000L)
        return "b"
    }

}