import com.fasterxml.jackson.annotation.JsonProperty
import com.github.aafa.ScalaRetrofitBuilder
import org.scalatest.{FlatSpec, Matchers}
import retrofit.http.{GET, Path}

/**
  * Created by Alexey Afanasev on 19.03.16.
  */

class APISpec extends FlatSpec with Matchers {
  "API" should "work" in {
    val api = new ScalaRetrofitBuilder()
      .setEndpoint("https://api.bitfinex.com/v1")
      .build()
      .create(classOf[APIServiceDescriptor])

    val pubticker: Ticker = api.pubticker("btcusd")
    println(pubticker)

    println(pubticker.last_price)
    assert(pubticker.last_price.nonEmpty)
  }
}

trait APIServiceDescriptor {
  @GET("/pubticker/{symbol}") def pubticker(@Path("symbol") symbol: String): Ticker
}

case class Ticker(@JsonProperty("last_price") var last_price: String)