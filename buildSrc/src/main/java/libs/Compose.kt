package libs

import org.gradle.api.artifacts.dsl.DependencyHandler

object Compose {
    private const val COMPOSE_VERSION = "1.2.0"
    private const val ACTIVITY_COMPOSE_VERSION = "1.5.1"
    private const val HILT_NAVIGATION_COMPOSE_VERSION = "1.0.0"

    private val dependencies = listOf(
        "androidx.compose.ui:ui:$COMPOSE_VERSION",
        "androidx.compose.material:material:$COMPOSE_VERSION",
        "androidx.compose.ui:ui-tooling-preview:$COMPOSE_VERSION",
        "androidx.activity:activity-compose:$ACTIVITY_COMPOSE_VERSION",
        "androidx.hilt:hilt-navigation-compose:$HILT_NAVIGATION_COMPOSE_VERSION"
    )

    fun DependencyHandler.compose(configurationName: String = "implementation") {
        dependencies.forEach {
            add(configurationName, it)
        }
        add("debugImplementation", "androidx.compose.ui:ui-tooling:$COMPOSE_VERSION")
    }
}