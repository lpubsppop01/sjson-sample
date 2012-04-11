organization := "jp.lpubsppop01"

name := "sjson-sample"

version := "0.1.0-SNAPSHOT"

scalaVersion := "2.9.1"

libraryDependencies ++= Seq(
  "net.debasishg" %% "sjson" % "0.15"
)

resolvers += "Sonatype OSS Snapshots" at "http://oss.sonatype.org/content/repositories/snapshots/"
