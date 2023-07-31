rootProject.name = "version-catalog"

dependencyResolutionManagement {
  repositoriesMode.set(RepositoriesMode.FAIL_ON_PROJECT_REPOS)
  repositories {

    // example of adding your corporate repo's with advanced settings like filtering content
    /*
    maven {
        url = uri("https://repo.google.com/repository/internal")
        mavenContent {
            releasesOnly()
        }
    }

    exclusiveContent {
        forRepository {
            maven {
                url = uri("https://repo.google.com/repository/snapshots")
                mavenContent {
                    snapshotsOnly()
                }
            }
        }
        filter {
            includeGroupByRegex("com\\.google.*")
        }
    }*/
    mavenLocal()
    mavenCentral()
  }
}