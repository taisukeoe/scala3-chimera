ThisBuild / name := """play-scala-seed"""
ThisBuild / organization := "com.example"
ThisBuild / version := "1.0-SNAPSHOT"

val scala213 = "2.13.4-bin-d66ebf4"
val scala3 = "0.27.0-RC1"

ThisBuild / resolvers += "scala-integration" at "https://scala-ci.typesafe.com/artifactory/scala-integration/"

lazy val app = (project in file("."))
.enablePlugins(PlayScala)
.settings(
    scalaVersion := scala213,
    libraryDependencies ++= Seq(
        guice,
        "org.scalatestplus.play" %% "scalatestplus-play" % "5.0.0" % Test
    )
)
.dependsOn(adapter, utils)
.aggregate(utils, adapter, domain)

lazy val utils = project
.settings(
    scalaVersion := scala3
).dependsOn(adapter)

lazy val adapter = project
.settings(
    scalaVersion := scala213,
    libraryDependencies += "com.typesafe.play" %% "play-json" % "2.9.1"
).dependsOn(domain)

lazy val domain = project
.settings(
    scalaVersion := scala3
)

// Adds additional packages into Twirl
//TwirlKeys.templateImports += "com.example.controllers._"

// Adds additional packages into conf/routes
// play.sbt.routes.RoutesKeys.routesImport += "com.example.binders._"
