name := "fabric8-client-test"

version := "0.1"

scalaVersion := "2.13.2"

libraryDependencies ++= Seq(
  "io.fabric8" % "kubernetes-client" % "4.6.0"
)

mainClass in (Compile, run) := Some("Fabric8ClientTest")

assemblyMergeStrategy in assembly := {
 case PathList("META-INF", xs @ _*) => MergeStrategy.discard
 case x => MergeStrategy.first
}

assemblyJarName in assembly := "fabric8-client-test.jar"
