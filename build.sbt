name := "autoscout-play"

version := "1.0-SNAPSHOT"

lazy val root = (project in file(".")).enablePlugins(PlayScala)

scalaVersion := "2.11.8"

libraryDependencies ++= Seq(
  ws,
  "org.scala-lang.modules" % "scala-async_2.11" % "0.9.6-RC5",
  "org.scalatestplus.play" %% "scalatestplus-play" % "1.5.1" % "test"
)
