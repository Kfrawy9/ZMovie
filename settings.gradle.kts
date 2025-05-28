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

rootProject.name = "ZMovie"
include(":app")
include(":data")
include(":feature_movie")
include(":core")
include(":feature_series")
include(":feature_watchlist")
include(":feature_movie_details")
include(":feature_series_details")
include(":feature_actors")
