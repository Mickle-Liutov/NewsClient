package libs

import org.gradle.api.artifacts.dsl.DependencyHandler

object Coil {
    private const val COIL_VERSION = "2.1.0"

    private val dependencies = listOf(
        "io.coil-kt:coil:$COIL_VERSION",
        "io.coil-kt:coil-compose:$COIL_VERSION"
    )

    fun DependencyHandler.coil(configurationName: String = "implementation") {
        dependencies.forEach {
            add(configurationName, it)
        }
    }

}