import scalariform.formatter.preferences._

name := """play-bootstrap-core"""

version := "1.5-P27-SNAPSHOT"

scalaVersion := "2.13.0-M5"

crossScalaVersions := Seq("2.13.0-M5", "2.12.8")

resolvers += "scalaz-bintray" at "https://dl.bintray.com/scalaz/releases"


lazy val root = (project in file(".")).enablePlugins(PlayScala).disablePlugins(PlayFilters)


scalariformPreferences := scalariformPreferences.value
  .setPreference(AlignSingleLineCaseStatements, true)
  .setPreference(DoubleIndentConstructorArguments, true)
  .setPreference(DanglingCloseParenthesis, Preserve)


PlayKeys.playOmnidoc := false

//*******************************
// Maven settings
//*******************************

sonatypeProfileName := "com.adrianhurt"

publishMavenStyle := true

organization := "com.adrianhurt"

description := "This is a collection of input helpers and field constructors for Play Framework to render Bootstrap HTML code."

import xerial.sbt.Sonatype._
sonatypeProjectHosting := Some(GitHubHosting("adrianhurt", "play-bootstrap", "adrianhurt@gmail.com"))

homepage := Some(url("http://adrianhurt.github.io/play-bootstrap"))

licenses := Seq("Apache License" -> url("https://github.com/adrianhurt/play-bootstrap/blob/master/LICENSE"))

startYear := Some(2014)

publishTo := {
  val nexus = "https://oss.sonatype.org/"
  if (isSnapshot.value)
    Some("snapshots" at nexus + "content/repositories/snapshots")
  else
    Some("releases"  at nexus + "service/local/staging/deploy/maven2")
}

publishArtifact in Test := false

pomIncludeRepository := { _ => false }

pomExtra := (
  <scm>
    <url>git@github.com:adrianhurt/play-bootstrap.git</url>
    <connection>scm:git:git@github.com:adrianhurt/play-bootstrap.git</connection>
  </scm>
  <developers>
    <developer>
      <id>adrianhurt</id>
      <name>Adrian Hurtado</name>
      <url>https://github.com/adrianhurt</url>
    </developer>
  </developers>
)

credentials += Credentials(Path.userHome / ".sbt" / "sonatype.credentials")