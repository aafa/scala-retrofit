import com.github.aafa.DefaultRetrofitBuilder
import org.scalatest.FlatSpec
import retrofit.RestAdapter

/**
  * Created by Alexey Afanasev on 20.03.16.
  */
class APIWrapperSpec extends FlatSpec {
  val api = new DefaultRetrofitBuilder()
    .setEndpoint("https://api.bitfinex.com/v1")
    .setLogLevel(RestAdapter.LogLevel.FULL)
    .build()
    .create(classOf[APIServiceDescriptor])

  val pubticker: Ticker = api.pubticker("btcusd")

  "DefaultRetrofitBuilder" should "work" in {
    println(pubticker)
    assert(pubticker.low.nonEmpty)
  }

  "Option[Java Type]" should "work" in {
    assert(pubticker.last_price.nonEmpty)
    assert(pubticker.last_price.exists(_ > 1))
  }

  "AnyVal" should "work" in {
    assert(pubticker.mid > 1)
  }

  "Option[AnyVal]" should "work" in {
    // see https://github.com/FasterXML/jackson-module-scala/issues/209
    assert(pubticker.high.exists(_ > 1))
  }
}
