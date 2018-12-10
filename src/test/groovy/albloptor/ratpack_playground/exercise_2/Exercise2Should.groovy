package albloptor.ratpack_playground.exercise_2

import ratpack.exec.Operation
import ratpack.exec.Promise
import ratpack.test.exec.ExecHarness
import spock.lang.Specification

class Exercise2Should extends Specification {

    def asyncKafkaProducer = Mock(AsyncKafkaProducer)
    def syncKafkaProducer = Mock(SyncKafkaProducer)
    def asyncNumberRepository = Mock(AsyncNumberRepository)
    def syncNumberRepository = Mock(SyncNumberRepository)
    def restClient = Mock(RestClient)

    def exercise2 = new Exercise2(
            asyncKafkaProducer,
            syncKafkaProducer,
            asyncNumberRepository,
            syncNumberRepository,
            restClient)

    def "do something really confusing"() {
        when:
        ExecHarness.runSingle {
            exercise2.doSomething()
        }

        then:
        1 * asyncNumberRepository.giveMeAOne() >> Promise.value(1)

        then:
        1 * restClient.callRemoteEndpoint(1) >> "Number one!"

        then:
        1 * asyncKafkaProducer.publish("Number one!") >> Operation.noop()

        then:
        1 * syncKafkaProducer.publish("Number one!")

        then:
        1 * syncNumberRepository.giveMeATwo() >> 2

        then:
        1 * asyncNumberRepository.giveMeAOne() >> Promise.value(1)

        then:
        1 * restClient.callRemoteEndpoint(2) >> "Some other number..."

        then:
        1 * syncKafkaProducer.publish("Some other number...")

        then:
        1 * asyncKafkaProducer.publish("Some other number...") >> Operation.noop()
    }
}
