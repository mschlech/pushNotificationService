resolvers ++= Seq(
  "sbteclipse" at "http://repo.typesafe.com/typesafe/releases/com.typesafe.sbteclipse/sbteclipse-plugin/scala_2.9.1/sbt_0.11.3/",
  "sbt-idea-repo" at "http://mpeltonen.github.com/maven/",
  "retronym-releases" at "http://retronym.github.com/repo/releases",
  "Typesafe Repo" at "http://repo.typesafe.com/typesafe/releases/",
  "retronym-snapshots" at "http://retronym.github.com/repo/snapshots"
)


addSbtPlugin("com.github.mpeltonen" % "sbt-idea" % "1.0.0")

