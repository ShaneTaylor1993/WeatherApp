// Top-level build file where you can add configuration options common to all sub-projects/modules.
plugins {
    id("com.android.application") version "8.1.2" apply false
    id("org.jetbrains.kotlin.android") version "1.8.10" apply false
    kotlin("jvm") version "1.9.20" apply false
    id("com.google.devtools.ksp") version "1.9.0-1.0.12"
    id("com.google.dagger.hilt.android") version "2.44" apply false
    kotlin("plugin.serialization") version "1.9.20"
    id("com.google.android.libraries.mapsplatform.secrets-gradle-plugin") version "2.0.1" apply false
}

buildscript {
    dependencies {
        classpath(kotlin("gradle-plugin", version = "1.9.20"))
        classpath ("com.google.dagger:hilt-android-gradle-plugin:2.49")
        classpath("org.jetbrains.kotlinx:kotlinx-serialization-json:1.6.2")
    }
}