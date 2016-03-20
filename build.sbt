name := "scala-retrofit"

organization := "com.github.aafa"

version := "0.1.0-SNAPSHOT"

scalaVersion := "2.11.7"

resolvers ++= Seq(
  Resolver.mavenLocal,
  DefaultMavenRepository,
  "jcenter" at "http://jcenter.bintray.com",
  Resolver.defaultLocal
)

libraryDependencies ++= Seq(
  "com.squareup.retrofit" % "retrofit" % "1.9.0" exclude("gson", "gson"),
  "com.squareup.okhttp" % "okhttp" % "2.3.0",
  "com.fasterxml.jackson.core" % "jackson-databind" % "2.7.2",
  "com.fasterxml.jackson.module" %% "jackson-module-scala" % "2.7.2"
)

libraryDependencies ++= Seq(
  "org.scalatest" %% "scalatest" % "2.2.1" % "test",
  "org.scalacheck" %% "scalacheck" % "1.12.1" % "test"
)


