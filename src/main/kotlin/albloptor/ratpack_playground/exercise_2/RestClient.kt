package albloptor.ratpack_playground.exercise_2

internal open class RestClient {

  open fun callRemoteEndpoint(number: Int): String {
    println("Calling remote endpoint... [${Thread.currentThread().name}]")
    Thread.sleep(500L)
    return when (number) {
      1 -> "Number one!"
      else -> "Some other number..."
    }
  }
}