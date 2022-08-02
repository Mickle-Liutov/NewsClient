import libs.AndroidCore.androidCore
import libs.Coil.coil
import libs.Compose.compose
import libs.Hilt.hilt
import libs.Navigation.navigation
import libs.Networking.networking
import libs.Room.room
import libs.Testing.testing

plugins {
    id("com.android.application")
    id("org.jetbrains.kotlin.android")
    id("dagger.hilt.android.plugin")
    id("kotlin-kapt")
}

android {
    compileSdk = Config.COMPILE_SDK

    signingConfigs {
        create("release") {
            storeFile = file("../keystore/newsclient-keys.jks")
            storePassword = "9%a9&8cEXIHe"
            keyAlias = "key0"
            keyPassword = "9%a9&8cEXIHe"
        }
    }


    defaultConfig {
        applicationId = "com.sample.newsclient"
        minSdk = Config.MIN_SDK
        targetSdk = Config.TARGET_SDK
        versionCode = 1
        versionName = "1.0"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
        vectorDrawables {
            useSupportLibrary = true
        }
    }

    buildTypes {
        release {
            isMinifyEnabled = true
            isShrinkResources = true
            signingConfig = signingConfigs.getByName("release")
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
        }
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_11
        targetCompatibility = JavaVersion.VERSION_11
    }
    kotlinOptions {
        jvmTarget = "11"
    }
    composeOptions {
        kotlinCompilerExtensionVersion = "1.3.0-rc01"
    }
    buildFeatures {
        compose = true
    }
}

dependencies {
    implementation(project(":core"))
    implementation(project(":api"))

    androidCore()
    compose()
    coil()
    hilt()
    navigation()
    networking()
    room()

    testing()
}