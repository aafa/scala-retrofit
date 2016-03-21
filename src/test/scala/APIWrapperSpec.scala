import com.github.aafa.DefaultRetrofitBuilder
import org.scalatest.{FlatSpec, Ignore, Suite}
import retrofit.RestAdapter

/**
  * Created by Alexey Afanasev on 20.03.16.
  */
class APIWrapperSpec extends AbstractSpec {

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


}
