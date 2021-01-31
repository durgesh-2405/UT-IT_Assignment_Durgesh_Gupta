name := "UT-IT_Assignement_Durgesh_Gupta"

version := "1.0"

scalaVersion := "2.13.4"

lazy val module_1 = project.in(file("module_1"))
  .settings(
    libraryDependencies ++= Seq(
      "org.scalatest" %% "scalatest" % "3.3.0-SNAP3" % Test,
      "org.mockito" %% "mockito-scala-scalatest" % "1.15.0" % Test,
      "org.mockito" % "mockito-core" % "1.9.5" % "test"
    )

  )
lazy val module_2 = project.in(file("module_2"))
  .settings(
    libraryDependencies ++= Seq(
      "org.scalatest" %% "scalatest" % "3.3.0-SNAP3" % Test,
      "org.mockito" %% "mockito-scala-scalatest" % "1.15.0" % Test,
      "org.mockito" % "mockito-core" % "1.9.5" % "test"

    )

  )

lazy val root = project.in(file(".")).aggregate(module_1, module_2)