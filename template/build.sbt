scalaVersion := "2.12.13"

scalacOptions ++= Seq(
  "-feature",
  "-language:reflectiveCalls",
)

// Chisel 3.5
addCompilerPlugin("edu.berkeley.cs" % "chisel3-plugin" % "latest.release" cross CrossVersion.full)
libraryDependencies += "edu.berkeley.cs" %% "chisel3" % "latest.release"
libraryDependencies += "edu.berkeley.cs" %% "chiseltest" % "latest.release"
