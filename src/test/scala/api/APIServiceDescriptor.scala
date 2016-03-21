package api

import retrofit.http.{GET, Path}

/**
  * Created by Alexey Afanasev on 20.03.16.
  */
trait APIServiceDescriptor {
  @GET("/pubticker/{symbol}") def pubticker(@Path("symbol") symbol: String): Ticker
}
