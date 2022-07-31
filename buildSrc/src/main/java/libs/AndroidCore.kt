package libs

import org.gradle.api.artifacts.dsl.DependencyHandler

object AndroidCore {
    private const val CORE_VERSION = "1.8.0"
    private const val LIFECYCLE_VERSION = "2.5.1"

    private val dependencies = listOf(
        "androidx.core:core-ktx:$CORE_VERSION",
        "androidx.lifecycle:lifecycle-viewmodel-ktx:$LIFECYCLE_VERSION",
        "androidx.lifecycle:lifecycle-livedata-ktx:$LIFECYCLE_VERSION"
    )


    fun DependencyHandler.androidCore(configurationName: String = "implementation") {
        dependencies.forEach {
            add(configurationName, it)
        }
    }

}