import org.scalatest.Ignore

/**
  * Created by Alexey Afanasev on 21.03.16.
  */
@Ignore
class APIProblemsSpec extends AbstractSpec{

  "Option[AnyVal]" should "deserialize" in {
    // see https://github.com/FasterXML/jackson-module-scala/issues/209
    assert(pubticker.high.exists(_ > 1))
  }
}
