package libs

import org.gradle.api.artifacts.dsl.DependencyHandler

object Navigation {
    private const val NAVIGATION_VERSION = "2.5.1"

    private val dependencies = listOf(
        "androidx.navigation:navigation-compose:$NAVIGATION_VERSION",
    )

    fun DependencyHandler.navigation(configurationName: String = "implementation") {
        dependencies.forEach {
            add(configurationName, it)
        }
    }

}