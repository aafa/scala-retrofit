package api

import scala.concurrent.Future
import scala.concurrent.ExecutionContext.Implicits.global

/**
  * Created by Alexey Afanasev on 21.03.16.
  */

// todo macro?
class UiService(api: APIServiceDescriptor) {
  def apply(f: APIServiceDescriptor => Unit) = Future {
    f(api)
  }
}