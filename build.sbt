lazy val root = (project in file(".")).
	settings(
		name := "projetGraphs",
		version := "0.0.1",
		scalaVersion := "2.11.7",
		libraryDependencies += "org.scalatest" % "scalatest_2.11" % "2.2.4" % "test",
		libraryDependencies += "org.specs2" %% "specs2-core" % "3.6.4" % "test"
	)
