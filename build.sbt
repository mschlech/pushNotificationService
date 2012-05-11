name := "PlotPushNotificationService"
  
version := "1.0"
   
scalaVersion := "2.9.1"
   
resolvers += "Typesafe Repository" at "http://repo.typesafe.com/typesafe/releases/"
     
libraryDependencies += "se.scalablesolutions.akka" %  "akka-actor"   % "2.0" % "compile" withSources()
