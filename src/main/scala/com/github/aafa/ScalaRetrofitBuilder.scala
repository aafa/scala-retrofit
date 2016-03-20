package com.github.aafa

import java.util.concurrent.ScheduledThreadPoolExecutor

import com.fasterxml.jackson.databind.{DeserializationFeature, ObjectMapper}
import com.fasterxml.jackson.module.scala.DefaultScalaModule
import com.fasterxml.jackson.module.scala.experimental.ScalaObjectMapper
import helpers.JacksonConverter
import retrofit.RestAdapter
import retrofit.RestAdapter.Builder
import retrofit.client.OkClient

/**
  * Created by Alexey Afanasev on 18.03.16.
  */
class ScalaRetrofitBuilder(settings: ObjectMapper => Unit = () => _) extends Builder{
  {
    val jackson = new ObjectMapper() with ScalaObjectMapper
    jackson.registerModule(DefaultScalaModule)
    settings(jackson)

    val converter = new JacksonConverter(jackson)

    new RestAdapter.Builder()
      .setConverter(converter)
      .setClient(new OkClient())
      .setExecutors(new ScheduledThreadPoolExecutor(5), null)
  }
}

class DefaultRetrofitBuilder extends ScalaRetrofitBuilder(_.disable(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES))
