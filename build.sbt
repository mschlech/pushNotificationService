name := "PushNotificationService"
  
version := "1.0"
   
scalaVersion := "2.9.1"
   
resolvers ++= Seq("Typesafe Repository" at "http://repo.typesafe.com/typesafe/releases/",
  "Spray Repository" at "http://repo.spray.cc",
  ScalaToolsSnapshots,
  "org.specs2" at "http://oss.sonatype.org/content/repositories/releases" ,
  "Sonatype OSS Snapshots" at "http://oss.sonatype.org/content/repositories/snapshots/",
  "Public online Restlet repository" at "http://maven.restlet.org"
)

libraryDependencies += "com.typesafe.akka" %  "akka-actor"   % "2.0" % "compile" withSources()

libraryDependencies += "com.typesafe.akka" %  "akka-kernel"   % "2.0" % "compile" withSources()

libraryDependencies += "com.typesafe.akka" %  "akka-remote"   % "2.0" % "compile" withSources()

libraryDependencies += "org.apache.httpcomponents" %  "httpClient" % "4.1.2" % "compile" withSources()

libraryDependencies += "cc.spray" %% "spray-json" % "1.1.1" % "compile" withSources()

libraryDependencies +=  "cc.spray" % "spray-io" % "1.0-M1" % "compile" withSources()

libraryDependencies += "com.typesafe.akka" %  "akka-testkit"  %  "2.0" % "test" withSources()

libraryDependencies += "org.specs2" % "specs2_2.9.1"  % "1.6.1" % "test"

libraryDependencies += "org.slf4j" % "slf4j-api" % "1.6.1" % "compile" withSources()

libraryDependencies += "com.ning" % "async-http-client" % "1.8.0-SNAPSHOT" withSources()
