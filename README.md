# version-catalog

Demo of defining custom version catalog using Gradle `version-catalog` plugin

### How to build

```shell
./gradlew build
```

### How to publish

For testing and development purposes use publishing to Maven local:

```shell
./gradlew publishToMavenLocal
```

For production purpose publish to your protected corporate repo:

```shell
./gradlew publish
```

### How to consume version catalog

Just add the following lines to your `settings.gradle.kts`:

```kotlin
dependencyResolutionManagement {
  versionCatalogs {
    create("libs") {
      from("com.google:version-catalog:DEV-SNAPSHOT")
    }
  }
}
```

It would the only place where you would have hardcoded version of `DEV-SNAPSHOT` which should match your version catalog
version from `gradle.properties` version property.