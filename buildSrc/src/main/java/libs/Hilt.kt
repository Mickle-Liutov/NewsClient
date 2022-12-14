package libs

import org.gradle.api.artifacts.dsl.DependencyHandler

object Hilt {
    const val HILT_VERSION = "2.43.1"

    fun DependencyHandler.hilt(configurationName: String = "implementation") {
        add(configurationName, "com.google.dagger:hilt-android:$HILT_VERSION")
        add("kapt", "com.google.dagger:hilt-android-compiler:$HILT_VERSION")
    }

}