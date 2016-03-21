import api.UiService

/**
  * Created by Alexey Afanasev on 21.03.16.
  */
class AsyncSpec extends AbstractSpec {
  it should "do async calls" in {
    val service: UiService = new UiService(api)

    service(_.pubticker("btcusd"))
  }
}
