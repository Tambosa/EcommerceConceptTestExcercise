plugins {
    id("com.android.application")
    id("org.jetbrains.kotlin.android")
    id("kotlin-kapt")
    id("kotlin-parcelize")
}

android {
    compileSdk = 32

    defaultConfig {
        applicationId = "com.aroman.ecommerceconcepttestexcercise"
        minSdk = 27
        targetSdk = 32
        versionCode = 1
        versionName = "1.0"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
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
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }
    kotlinOptions {
        jvmTarget = "1.8"
    }
    buildFeatures {
        viewBinding = true
    }
}

dependencies {
    //retrofit
    implementation(Libs.retrofit)
    implementation(Libs.retrofit_converter_gson)

    //coil
    implementation(Libs.coil)

    //koin
    implementation(Libs.koin_android)
    implementation(Libs.koin_core)

    // Coroutine Lifecycle Scopes
    implementation(Libs.lifecycle_vm)
    implementation(Libs.lifecycle_runtime)

    //adapter delegates
    implementation(Libs.adapter_delegates)

    implementation(Libs.core_ktx)
    implementation(Libs.appcompat)
    implementation(Libs.material)
    implementation(Libs.constraint)
}