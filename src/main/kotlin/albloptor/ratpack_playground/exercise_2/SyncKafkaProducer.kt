package albloptor.ratpack_playground.exercise_2

internal open class SyncKafkaProducer {

  open fun publish(message: String) {
    println("Publishing message '$message' synchronously... [${Thread.currentThread().name}]")
    Thread.sleep(200L)
  }
}