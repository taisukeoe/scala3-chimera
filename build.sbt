ThisBuild / organization := "com.example"
ThisBuild / version := "1.0-SNAPSHOT"

val scala213 = "2.13.6-bin-9468b9a"
val scala3 = "3.0.0"

ThisBuild / resolvers += "scala-integration" at "https://scala-ci.typesafe.com/artifactory/scala-integration/"

val scala2OptionSetting = scalacOptions ++= Seq("-Xsource:3", "-Ytasty-reader")

lazy val app = (project in file("."))
.enablePlugins(PlayScala)
.settings(
    scalaVersion := scala213,
    scala2OptionSetting,
    libraryDependencies ++= Seq(
        guice,
        "org.scalatestplus.play" %% "scalatestplus-play" % "5.1.0" % Test
    ),
    libraryDependencies := libraryDependencies.value.map(_ exclude("com.typesafe.play", "play-json_2.13"))
)
.dependsOn(adapter, utils)
.aggregate(utils, adapter, domain)

lazy val utils = project
.settings(
    scalaVersion := scala3
).dependsOn(adapter)

lazy val adapter = project
.settings(
    scalaVersion := scala3,
    libraryDependencies ++= 
    Seq(
        ("com.typesafe.play" % "play-json" % "2.10.0-RC2").cross(CrossVersion.for3Use2_13),
        "org.scalatest" %% "scalatest" % "3.2.9" % Test
    )
).dependsOn(domain)

lazy val domain = project
.settings(
    scalaVersion := scala3
)

// Adds additional packages into Twirl
//TwirlKeys.templateImports += "com.example.controllers._"

// Adds additional packages into conf/routes
// play.sbt.routes.RoutesKeys.routesImport += "com.example.binders._"
