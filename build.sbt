name := "scala-course"

scalaVersion := "2.11.8"

resolvers += Resolver.bintrayRepo("underscoreio", "training")

libraryDependencies += "underscoreio" %% "doodle" % "0.7.0"

initialCommands in console := """
  |import doodle.core._
  |import doodle.core.Image._
  |import doodle.syntax._
  |import doodle.backend.StandardInterpreter._
  |import doodle.jvm.Java2DCanvas._
""".trim.stripMargin
