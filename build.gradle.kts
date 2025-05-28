// Top-level build file where you can add configuration options common to all sub-projects/modules.
plugins {
    id("com.google.dagger.hilt.android") version "2.56.2" apply false
    id(libs.plugins.android.library.get().pluginId) apply false
    id(libs.plugins.kotlin.android.get().pluginId) apply false

}
buildscript{
    repositories{
        google()
        mavenCentral()
    }


    dependencies{
        classpath(Dependencies.hiltAgp)
        classpath(libs.kotlin.gradle.plugin)
    }
}