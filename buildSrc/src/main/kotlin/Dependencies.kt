import Versions.paging
import org.gradle.api.artifacts.dsl.DependencyHandler
import org.gradle.kotlin.dsl.project

object Dependencies {

    const val composeMaterial = "androidx.compose.material3:material3"
    const val composeUiToolingPreview = "androidx.compose.ui:ui-tooling-preview"
    const val composeUi = "androidx.compose.ui:ui"
    const val composeUiTooling = "androidx.compose.ui:ui-tooling"

    const val lifeCycleKtx = "androidx.lifecycle:lifecycle-runtime-ktx:${Versions.ktx}"



    const val composeUiGraphics = "androidx.compose.ui:ui-graphics:${Versions.compose}"
    const val composeRuntime = "androidx.compose.runtime:runtime:${Versions.compose}"

    const val hiltAndroid = "com.google.dagger:hilt-android:${Versions.hilt}"
    const val hiltCompiler = "com.google.dagger:hilt-android-compiler:${Versions.hilt}"
    const val hiltAgp = "com.google.dagger:hilt-android-gradle-plugin:${Versions.hilt}"
    const val hiltCompose = "androidx.hilt:hilt-navigation-compose:${Versions.hiltCompose}"

    const val okHttp = "com.squareup.okhttp3:okhttp:${Versions.okHttp}"
    const val okHttpLoggingInterceptor = "com.squareup.okhttp3:logging-interceptor:${Versions.okHttp}"
    const val moshi = "com.squareup.moshi:moshi-kotlin:1.15.2"


    const val retrofit = "com.squareup.retrofit2:retrofit:${Versions.retrofit}"
    const val moshiConverter = "com.squareup.retrofit2:converter-moshi:${Versions.retrofit}"

    const val roomRuntime = "androidx.room:room-runtime:${Versions.room}"
    const val roomCompiler = "androidx.room:room-compiler:${Versions.room}"
    const val roomKtx = "androidx.room:room-ktx:${Versions.room}"

    const val coilCompose = "io.coil-kt.coil3:coil-compose:${Versions.coil}"
    const val coilOkHttp = "io.coil-kt.coil3:coil-network-okhttp:${Versions.coil}"
    const val coilGIF = "io.coil-kt.coil3:coil-gif:${Versions.coil}"

    const val navigationCompose = "androidx.navigation:navigation-compose:${Versions.nav_version}"
    const val navigationFragments  = "androidx.navigation:navigation-fragment:${Versions.nav_version}"
    const val navigationUI  = "androidx.navigation:navigation-ui:${Versions.nav_version}"

    const val pagingRuntime = "androidx.paging:paging-runtime:$paging"
    const val pagingCompose = "androidx.paging:paging-compose:$paging"

}
fun DependencyHandler.room(){
    implementation(Dependencies.roomRuntime)
    implementation(Dependencies.roomKtx)
    kapt(Dependencies.roomCompiler)
}

fun DependencyHandler.hilt(){
    implementation(Dependencies.hiltAndroid)
    implementation(Dependencies.hiltCompose)
    kapt(Dependencies.hiltCompiler)
}

fun DependencyHandler.retrofit(){
    implementation(Dependencies.retrofit)
    implementation(Dependencies.moshiConverter)
    implementation(Dependencies.okHttp)
    implementation(Dependencies.okHttpLoggingInterceptor)
    implementation(Dependencies.moshi)
}

fun DependencyHandler.compose(){
    val composeBom = platform("androidx.compose:compose-bom:2025.05.00")
    implementation(composeBom)
    implementation(Dependencies.composeUi)
    debugImplementation(Dependencies.composeUiTooling)
    implementation(Dependencies.composeUiToolingPreview)
    implementation(Dependencies.composeMaterial)

}

fun DependencyHandler.navigation(){
    implementation(Dependencies.navigationCompose)
    implementation(Dependencies.navigationFragments)
    implementation(Dependencies.navigationUI)
}

fun DependencyHandler.coil(){
    implementation(Dependencies.coilCompose)
    implementation(Dependencies.coilOkHttp)
    implementation(Dependencies.coilGIF)
}

fun DependencyHandler.paging(){
    implementation(Dependencies.pagingRuntime)
    implementation(Dependencies.pagingCompose)
}

fun DependencyHandler.data(){
    implementation(project(":data"))

}

fun DependencyHandler.core(){
    implementation(project(":core"))
}

fun DependencyHandler.feaure_movie(){
    implementation(project(":feature_movie"))
}

fun DependencyHandler.feaure_actor(){
    implementation(project(":feature_actors"))
}

fun DependencyHandler.feaure_series(){
    implementation(project(":feature_series"))
}

fun DependencyHandler.feaure_watchlist(){
    implementation(project(":feature_watchlist"))
}

fun DependencyHandler.feaure_movieDetails(){
    implementation(project(":feature_movie_details"))
}

fun DependencyHandler.feaure_seriesDetails(){
    implementation(project(":feature_series_details"))
}


