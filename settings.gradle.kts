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

rootProject.name = "SequeniaTest"

include(":app")
includeDir(":movies", "modules/movies")
includeDir(":theme", "modules/common/theme")

fun includeDir(moduleName: String, modulePath: String) {
    include(moduleName)
    project(moduleName).projectDir = File(rootDir, modulePath)
}
