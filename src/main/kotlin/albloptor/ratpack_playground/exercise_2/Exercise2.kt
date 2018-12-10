package albloptor.ratpack_playground.exercise_2

internal class Exercise2(
  private val asyncKafkaProducer: AsyncKafkaProducer,
  private val syncKafkaProducer: SyncKafkaProducer,
  private val asyncNumberRepository: AsyncNumberRepository,
  private val syncNumberRepository: SyncNumberRepository,
  private val restClient: RestClient) {

  fun doSomething() {
    TODO()
  }
}