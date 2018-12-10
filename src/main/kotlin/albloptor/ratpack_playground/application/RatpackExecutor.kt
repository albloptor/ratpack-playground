package albloptor.ratpack_playground.application

import ratpack.exec.Promise

class RatpackExecutor(private val repository: Repository,
                      private val controller: Controller,
                      private val ratpack: Ratpack,
                      private val numberProvider: NumberProvider) {


  fun sequentialRun(): Promise<String> {
    var result = ""
    result = result.plus("a")
      .plus(repository.find())
      .plus(controller.call())
      .plus(ratpack.call())
      .plus("e")

    return Promise.value(result)
  }

  fun nestedPromises(): Promise<String> {
    return numberProvider.giveMeAOneEventually().map {
      numberProvider.giveMeATwo()
      numberProvider.giveMeAThreeEventually()
    }.map {
      numberProvider.giveMeAFour().toString()
    }
  }
}