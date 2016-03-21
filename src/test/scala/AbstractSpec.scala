import api.{APIServiceDescriptor, Ticker}
import com.github.aafa.DefaultRetrofitBuilder
import org.scalatest.FlatSpec
import retrofit.RestAdapter

/**
  * Created by Alexey Afanasev on 21.03.16.
  */
abstract class AbstractSpec extends FlatSpec{
  val api = new DefaultRetrofitBuilder()
    .setEndpoint("https://api.bitfinex.com/v1")
    .setLogLevel(RestAdapter.LogLevel.FULL)
    .build()
    .create(classOf[APIServiceDescriptor])

  lazy val pubticker: Ticker = api.pubticker("btcusd")

}
