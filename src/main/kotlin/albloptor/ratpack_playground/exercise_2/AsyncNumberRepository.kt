package albloptor.ratpack_playground.exercise_2

import ratpack.exec.Promise

internal open class AsyncNumberRepository {

  open fun giveMeAOne(): Promise<Int> {
    return Promise.async<Int> {
      println("Returning 1 from repository... [${Thread.currentThread().name}]")
      Thread.sleep(500L)
      it.success(1)
    }
  }
}