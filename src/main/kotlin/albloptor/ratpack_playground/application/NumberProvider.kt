package albloptor.ratpack_playground.application

import ratpack.exec.Operation
import ratpack.exec.Promise

class NumberProvider {

  fun giveMeAOneEventually(): Promise<Int> {
    Thread.sleep(500)
    return Promise.value(1)
  }

  fun giveMeATwo(): Int {
    Thread.sleep(500)
    return 2
  }

  fun giveMeAThreeEventually(): Promise<Int> {
    Thread.sleep(500)
    return Promise.value(3)
  }

  fun giveMeAFour(): Int {
    Thread.sleep(500)
    return 4
  }

  fun giveMeNothingEventually(): Promise<Unit> {
    Thread.sleep(500)
    return Promise.ofNull()
  }

  fun pretendToDoSomething(): Operation {
    Thread.sleep(500)
    return Operation.noop()
  }
}