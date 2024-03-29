pluginManagement {
    repositories {
        google()
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
rootProject.name = "Dota-Heroes"
include (":app")
include (":core:data")
include (":core:domain")
include (":core:ui")
include (":core:common")
include (":feature:home")
include (":navigation")
include (":feature:detail")
include (":feature:saved")
