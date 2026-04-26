pluginManagement {
    repositories {
        google {
            content {
                includeGroupByRegex("com\\.android.*")
                includeGroupByRegex("com\\.google.*")
                includeGroupByRegex("androidx.*")
            }
        }
        mavenCentral()
        gradlePluginPortal()
    }
}
dependencyResolutionManagement {
    repositoriesMode.set(RepositoriesMode.FAIL_ON_PROJECT_REPOS)
    repositories {
        google()
        mavenCentral()
    }
}

rootProject.name = "Wheather"
include(":app")
include(":feature-auth-impl")
include(":feature-splash-impl")

include(":core:session")
project(":core:session").projectDir = file("core/session")
include(":core:designsystem")
include(":feature-home-impl")
include(":core:ui")
include(":core:network")
include(":core:di")
include(":core-navigation")
include(":feature-auth-api")
