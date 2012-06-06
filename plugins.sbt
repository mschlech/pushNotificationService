resolvers ++= Seq(
  "sbteclipse" at "http://repo.typesafe.com/typesafe/releases/com.typesafe.sbteclipse/sbteclipse-plugin/scala_2.9.1/sbt_0.11.2/",
  "sbt-idea-repo" at "http://mpeltonen.github.com/maven/",
  "retronym-releases" at "http://retronym.github.com/repo/releases",
  "retronym-snapshots" at "http://retronym.github.com/repo/snapshots"
)

addSbtPlugin("com.github.retronym" % "sbt-onejar" % "0.6")

addSbtPlugin("com.github.mpeltonen" % "sbt-idea" % "0.11.0")

