package albloptor.ratpack_playground.application

import ratpack.exec.Promise

class Ratpack {
    fun call(): Promise<String> {
        return Promise.value("d")
    }

}
