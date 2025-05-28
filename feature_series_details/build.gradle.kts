plugins {
    id("com.android.library")
    id("org.jetbrains.kotlin.android")
    id("org.jetbrains.kotlin.plugin.compose") version "2.0.21"
    id("dagger.hilt.android.plugin")
}

hilt{
    enableAggregatingTask  = false
}

apply<MainGradlePlugin>()
android {
    namespace = "com.kfrawy.feature_series_details"
}

dependencies {

    implementation(libs.androidx.core.ktx)
    implementation(libs.androidx.appcompat)
    implementation(libs.material)
    testImplementation(libs.junit)
    androidTestImplementation(libs.androidx.junit)
    androidTestImplementation(libs.androidx.espresso.core)
    compose()
    hilt()
    core()
    data()
    coil()
    retrofit()
}