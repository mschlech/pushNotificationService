resolvers ++= Seq(
  "sbt-idea-repo" at "http://mpeltonen.github.com/maven/",
  "retronym-releases" at "http://retronym.github.com/repo/releases",
  "retronym-snapshots" at "http://retronym.github.com/repo/snapshots"
)

addSbtPlugin("com.github.retronym" % "sbt-onejar" % "0.5")

addSbtPlugin("com.github.mpeltonen" % "sbt-idea" % "0.11.0")
