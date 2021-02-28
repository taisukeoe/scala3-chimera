ThisBuild / organization := "com.example"
ThisBuild / version := "1.0-SNAPSHOT"

val scala213 = "2.13.5"
val scala3 = "3.0.0-RC1"

ThisBuild / resolvers += "scala-integration" at "https://scala-ci.typesafe.com/artifactory/scala-integration/"

lazy val app = (project in file("."))
.enablePlugins(PlayScala)
.settings(
    scalaVersion := scala213,
    scalacOptions ++= Seq("-Xsource:3", "-Ytasty-reader"),
    libraryDependencies ++= Seq(
        guice,
        "org.scalatestplus.play" %% "scalatestplus-play" % "5.1.0" % Test
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
    scalacOptions ++= Seq("-Xsource:3", "-Ytasty-reader"),
    libraryDependencies += "com.typesafe.play" %% "play-json" % "2.10.0-RC1"
).dependsOn(domain)

lazy val domain = project
.settings(
    scalaVersion := scala3
)

// Adds additional packages into Twirl
//TwirlKeys.templateImports += "com.example.controllers._"

// Adds additional packages into conf/routes
// play.sbt.routes.RoutesKeys.routesImport += "com.example.binders._"
