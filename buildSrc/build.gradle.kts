import org.jetbrains.kotlin.gradle.dsl.JvmTarget


plugins{
    `kotlin-dsl`
}

repositories {
    mavenCentral()
    google()
}

dependencies{
    implementation("org.jetbrains.kotlin:kotlin-gradle-plugin:2.1.20")
    implementation("com.android.tools.build:gradle:8.6.1")
}

kotlin{
    compilerOptions {
        jvmTarget.set(JvmTarget.JVM_21)
    }
}