import java.util.concurrent.ScheduledThreadPoolExecutor

import com.fasterxml.jackson.annotation.{JsonCreator, JsonProperty}
import com.fasterxml.jackson.databind.{DeserializationFeature, ObjectMapper}
import com.fasterxml.jackson.module.scala.DefaultScalaModule
import com.fasterxml.jackson.module.scala.experimental.ScalaObjectMapper
import com.github.aafa.{DefaultRetrofitBuilder, ScalaRetrofitBuilder}
import helpers.JacksonConverter
import org.scalatest.{FlatSpec, Matchers}
import retrofit.RestAdapter
import retrofit.client.OkClient
import retrofit.http.{GET, Path}

/**
  * Created by Alexey Afanasev on 19.03.16.
  */

class APISpec extends FlatSpec with Matchers {
  "API" should "work" in {
    val jackson = new ObjectMapper() with ScalaObjectMapper
    jackson.registerModule(DefaultScalaModule)
    jackson.disable(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES)
    val converter = new JacksonConverter(jackson)

    val api = new RestAdapter.Builder()
      .setConverter(converter)
      .setClient(new OkClient())
      .setExecutors(new ScheduledThreadPoolExecutor(5), null)
      .setEndpoint("https://api.bitfinex.com/v1")
      .setLogLevel(RestAdapter.LogLevel.FULL)
      .build()
      .create(classOf[APIServiceDescriptor])


    val pubticker: Ticker = api.pubticker("btcusd")
    println(pubticker)

    println(pubticker.last_price)
    assert(pubticker.last_price.nonEmpty)
    assert(pubticker.last_price.exists(_ > 100))
  }
}

trait APIServiceDescriptor {
  @GET("/pubticker/{symbol}") def pubticker(@Path("symbol") symbol: String): Ticker
}

@JsonCreator
case class Ticker(
                   @JsonProperty("last_price") var last_price: Option[java.lang.Float]
                 )