// Top-level build file where you can add configuration options common to all sub-projects/modules.
buildscript {
    repositories {
        google()
        mavenCentral()
        maven(url = "https://jitpack.io")
    }
    dependencies {
        classpath("com.android.tools.build:gradle:7.2.1")
        classpath("org.jetbrains.kotlin:kotlin-gradle-plugin:1.7.10")
        classpath("androidx.navigation:navigation-safe-args-gradle-plugin:2.5.1")
        classpath("com.google.gms:google-services:4.3.13")
        classpath("com.google.dagger:hilt-android-gradle-plugin:${libs.Hilt.HILT_VERSION}")
        // NOTE: Do not place your application dependencies here; they belong
        // in the individual module build.gradle files
    }
}

tasks.register("clean", Delete::class) {
    delete(rootProject.buildDir)
}
