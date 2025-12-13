plugins {
    alias(libs.plugins.android.library)
    alias(libs.plugins.kotlin.android)
    alias(libs.plugins.navigation.safe.args.gradle.plugin)
}

android {
    namespace = "com.henrique.openbrewery"
    compileSdk = 36

    defaultConfig {
        minSdk = 24
        targetSdk = 36

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
    }

    buildFeatures {
        viewBinding = true
    }

    buildTypes {
        release {
            isMinifyEnabled = false
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
}

dependencies {

    // Modules

    // Core
    implementation(libs.core.ktx)
    implementation(libs.test.core)
    implementation(libs.arch.core.testing)

    // Layout
    implementation(libs.appcompat)
    implementation(libs.material)
    implementation(libs.constraintlayout)

    // Koin
    implementation(libs.koin.core)
    implementation(libs.koin.android.compat)
    implementation(libs.koin.androidx.navigation)

    // Coroutines
    implementation(libs.kotlinx.coroutines.core)
    implementation(libs.kotlinx.coroutines.android)

    // Recyclerview
    implementation(libs.recyclerview)

    // Navigation
    implementation(libs.navigation.fragment.ktx)
    implementation(libs.navigation.ui.ktx)
    implementation(libs.navigation.dynamic.features.fragment)

    // OkHttp
    implementation(libs.okhttp.logging.interceptor)

    // Retrofit
    implementation(libs.retrofit)
    implementation(libs.retrofit.converter.gson)

    // Test
    testImplementation(libs.junit)
    testImplementation(libs.mockk)
    testImplementation(libs.mockk.android)
    testImplementation(libs.kotlintest.assertions)
    testImplementation(libs.koin.test)
    testImplementation(libs.kotlinx.coroutines.test)
}