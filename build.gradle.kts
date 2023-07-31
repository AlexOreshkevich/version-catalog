import net.researchgate.release.ReleaseExtension

plugins {
  `version-catalog`
  `maven-publish`
  id("net.researchgate.release") version "3.0.2"
}

group = "com.google"

catalog {
  // declare the aliases, bundles and versions in this block
  versionCatalog {
    version("sdk", rootProject.version.toString())

    version("springBoot", "2.1.1.RELEASE")
    version("springCloud", "Finchley.RELEASE") // replace with Greenwich

    version("junit", "5.3.2")
    version("assertj", "3.24.2")
    version("testcontainers", "1.17.3")

    library("javax-inject", "javax.inject:javax.inject:1")

    library("junit-api", "org.junit.jupiter", "junit-jupiter-api").versionRef("junit")
    library("junit-engine", "org.junit.jupiter", "junit-jupiter-engine").versionRef("junit")
    library("assertj", "org.assertj", "assertj-core").versionRef("assertj")

    bundle("junit", listOf("junit-api", "junit-engine", "assertj"))
  }
}

publishing {
  publications {
    create<MavenPublication>("maven") {
      from(components["versionCatalog"])
    }
  }
  // add your corporate repo's like in the example below
  /*
  repositories {
      maven {
          name = "yourRepository"
          val releasesRepoUrl = "https://repo.google.com/repository/internal"
          val snapshotsRepoUrl = "https://repo.google.com/repository/snapshots"
          url = uri(if (project.version.toString().endsWith("SNAPSHOT")) snapshotsRepoUrl else releasesRepoUrl)
          credentials(PasswordCredentials::class)
      }
  }*/
}

configure<ReleaseExtension> {
  ignoredSnapshotDependencies.set(listOf("net.researchgate:gradle-release"))
  tagTemplate.set(
      "${property("version")}".replace("-SNAPSHOT", "") + "-release"
  )
  failOnUnversionedFiles.set(false)
  failOnSnapshotDependencies.set(true)
  with(git) {
    requireBranch.set("master")
    pushToRemote.set("origin")
  }
}