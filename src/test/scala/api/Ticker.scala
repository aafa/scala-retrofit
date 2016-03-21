package api

import com.fasterxml.jackson.annotation.{JsonCreator, JsonProperty}

/**
  * Created by Alexey Afanasev on 20.03.16.
  */
@JsonCreator
case class Ticker(
                   @JsonProperty("last_price") var last_price: Option[java.lang.Float],
                   @JsonProperty("low") var low: Option[String],
                   @JsonProperty("high") var high: Option[Float],
                   @JsonProperty("mid") var mid: Float
                 )
