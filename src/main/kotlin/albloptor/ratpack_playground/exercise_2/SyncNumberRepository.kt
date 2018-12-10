package albloptor.ratpack_playground.exercise_2

internal open class SyncNumberRepository {

  open fun giveMeATwo(): Int {
    println("Returning 2 from repository... [${Thread.currentThread().name}]")
    Thread.sleep(500)
    return 2
  }
}