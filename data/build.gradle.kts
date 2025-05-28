import java.io.FileInputStream
import java.util.Properties

plugins {
    id(libs.plugins.android.library.get().pluginId)
    id(libs.plugins.kotlin.android.get().pluginId)
    id("dagger.hilt.android.plugin")
}
hilt{
    enableAggregatingTask  = false
}
apply<MainGradlePlugin>()

android {
    namespace = "com.kfrawy.data"
    defaultConfig{

        val properties = Properties()
        properties.load(project.rootProject.file("local.properties").inputStream())

        buildConfigField("String", "API_KEY", "\"${properties.getProperty("API_KEY")}\"")
        buildConfigField("String", "AUTH", "\"${properties.getProperty("AUTH")}\"")
    }

    buildFeatures{
        buildConfig = true
    }
}

dependencies {
    implementation(libs.androidx.core.ktx)
    implementation(libs.androidx.appcompat)
    implementation(libs.material)
    testImplementation(libs.junit)
    androidTestImplementation(libs.androidx.junit)
    androidTestImplementation(libs.androidx.espresso.core)
    room()
    retrofit()
    hilt()
    core()

}