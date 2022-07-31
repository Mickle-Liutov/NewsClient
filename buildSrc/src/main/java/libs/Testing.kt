package libs

import org.gradle.api.artifacts.dsl.DependencyHandler

object Testing {
    private const val JUNIT_VERSION = "4.13.2"
    private const val JUNIT_EXT_VERSION = "1.1.3"
    private const val ESPRESSO_VERSION = "3.4.0"
    private const val COMPOSE_JUNIT_VERSION = "1.2.0"

    private val testDependencies = listOf(
        "junit:junit:$JUNIT_VERSION"
    )
    private val androidTestDependencies = listOf(
        "androidx.test.ext:junit:$JUNIT_EXT_VERSION",
        "androidx.test.espresso:espresso-core:$ESPRESSO_VERSION",
        "androidx.compose.ui:ui-test-junit4:$COMPOSE_JUNIT_VERSION"
    )

    fun DependencyHandler.testing(configurationName: String = "androidTestImplementation") {
        testDependencies.forEach {
            add("testImplementation", it)
        }
        androidTestDependencies.forEach {
            add(configurationName, it)
        }
    }
}