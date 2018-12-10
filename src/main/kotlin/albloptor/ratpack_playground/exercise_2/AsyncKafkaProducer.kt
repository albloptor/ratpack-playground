package albloptor.ratpack_playground.exercise_2

import ratpack.exec.Operation

internal open class AsyncKafkaProducer {

  open fun publish(message: String): Operation {
    return Operation.of {
      println("Publishing message '$message' asynchronously... [${Thread.currentThread().name}]")
      Thread.sleep(200)
    }
  }
}