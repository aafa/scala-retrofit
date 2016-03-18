package com.github.aafa

import com.fasterxml.jackson.databind.{DeserializationFeature, ObjectMapper}
import com.fasterxml.jackson.module.scala.DefaultScalaModule
import com.fasterxml.jackson.module.scala.experimental.ScalaObjectMapper
import helpers.JacksonConverter
import retrofit.RestAdapter
import retrofit.RestAdapter.Builder

/**
  * Created by Alexey Afanasev on 18.03.16.
  */
class ScalaRetrofitBuilder {

  def builder: Builder = {
    val jackson = new ObjectMapper() with ScalaObjectMapper
    jackson.disable(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES)
    jackson.registerModule(DefaultScalaModule)

    val converter = new JacksonConverter(jackson)

    new RestAdapter.Builder().setConverter(converter)
  }


}
