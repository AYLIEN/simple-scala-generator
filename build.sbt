import scala.sys.process._

name := "simple-scala-generator"
organization := "io.grhodes"
version := "1.2.0"

scalaVersion := "2.12.13"

javacOptions in doc := Seq("-encoding", "UTF-8")

licenses += ("MIT", url("http://opensource.org/licenses/MIT"))

githubTokenSource := TokenSource.GitConfig("github.token") || TokenSource.Environment("GITHUB_TOKEN")
githubOwner := "AYLIEN"
githubRepository := "simple-scala-generator"

libraryDependencies ++= Seq(
  "io.swagger.codegen.v3" % "swagger-codegen-generators" % "1.0.8",
  "io.swagger.codegen.v3" % "swagger-codegen" % "3.0.8",
  "org.scalatest" %% "scalatest" % "3.0.1" % Test,
  "org.scalacheck" %% "scalacheck" % "1.13.4" % Test
)
