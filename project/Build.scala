import sbt._
import Keys._


object Build extends Build {


  lazy val PPNSKernelBuild = Project(
    "plot-pushNotificationServiceKernel",
    file ("."),
    settings = basicSettings ++ Seq(
      libraryDependencies ++= Seq(
        Compile.akkaActor,
        Compile.akkaStm,
        Compile.sprayJson,
        Compile.jodaTime,
        Compile.jodaConvert,
        Compile.httpClient,
        Compile.scalate,
        Test.specs2,
        Test.akkaTestKit,
        Test.mockito,
        Run.akkaSlf4j,
        Run.slf4j,
        Run.logback
      )
    )
  )

//  lazy val buildSettings = Defaults.defaultSettings ++ Seq(
//    organization := "com.plotproject",
//    version := "0.1beta",
//    scalaVersion := "2.9.1",
//    crossPaths := false,
//    organizationName := "Typesafe Inc.",
//    organizationHomepage := Some(url("http://www.typesafe.com"))
//  )

//  lazy val defaultSettings = buildSettings ++ Seq(
//    resolvers += "Typesafe Repo" at "http://repo.typesafe.com/typesafe/releases/",
//
//    // compile options
//    scalacOptions ++= Seq("-encoding", "UTF-8", "-deprecation", "-unchecked"),
//    javacOptions ++= Seq("-Xlint:unchecked", "-Xlint:deprecation")
//
//  )

  lazy val basicSettings = Defaults.defaultSettings ++
    Seq(
      organization := "com.plotprojects",
      version := "0.1-SNAPSHOT",
      scalaVersion := "2.9.1",
      scalacOptions := Seq("-unchecked", "-deprecation", "-encoding", "utf8", "-Xmax-classfile-name", "128"),
      resolvers ++= Dependencies.resolutionRepos
    )
}

object Dependencies {
  val resolutionRepos = Seq(
    "Typesafe Repository" at "http://repo.typesafe.com/typesafe/releases/",
    ScalaToolsSnapshots,
    "Spray Repository" at "http://repo.spray.cc",
    "Public online Restlet repository" at "http://maven.restlet.org"
  )
}

object V {
  val akka = "2.0"
  val sprayJson = "1.1.0"
  val specs2 = "1.6.1"
  val slf4j = "1.6.1"
  val logback = "0.9.29"
  val jodaTime = "2.0"
  val jodaConvert = "1.1"
  val httpClient = "4.1.2"
  val mockito = "1.8.5"
  val scalate = "1.5.3"
}

object Compile {
  val akkaActor = "se.scalablesolutions.akka" % "akka-actor" % V.akka % "compile" withSources()
  val akkaKernel = "se.scalablesolutions.akka" % "akka-kernel" % V.akka % "compile" withSources()
  val akkaStm = "se.scalablesolutions.akka" % "akka-stm" % V.akka % "compile" withSources()
  val akkaSbt = "se.scalablesolutions.akka" % "akka-sbt-plugin" % V.akka % "compile" withSources()

  val sprayJson = "cc.spray" %% "spray-json" % V.sprayJson % "compile" withSources()
  val jodaTime = "joda-time" % "joda-time" % V.jodaTime % "compile"
  val jodaConvert = "org.joda" % "joda-convert" % V.jodaConvert % "compile"
  val httpClient = "org.apache.httpcomponents" % "httpclient" % V.httpClient % "compile"
  val scalate = "org.fusesource.scalate" % "scalate-core" % V.scalate % "compile"
}

object Test {
  val specs2 = "org.specs2" %% "specs2" % V.specs2 % "test"
  val akkaTestKit = "se.scalablesolutions.akka" % "akka-testkit" % V.akka % "test" withSources()
  val mockito = "org.mockito" % "mockito-all" % V.mockito % "test"

}

object Run {
  val akkaSlf4j = "se.scalablesolutions.akka" % "akka-slf4j" % V.akka withSources()
  val slf4j = "org.slf4j" % "slf4j-api" % V.slf4j
  val logback = "ch.qos.logback" % "logback-classic" % V.logback
}



