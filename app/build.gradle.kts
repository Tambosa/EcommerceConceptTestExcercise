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
    implementation(project(":domain"))
    implementation(project(":data"))

    //retrofit
    implementation(Libs.retrofit)
    implementation(Libs.retrofit_converter_gson)

    //coil
    implementation(Libs.coil)

    // Coroutine Lifecycle Scopes
    implementation(Libs.lifecycle_vm)
    implementation(Libs.lifecycle_runtime)

    //koin
    implementation(Libs.koin_android)
    implementation(Libs.koin_core)

    //adapter delegates
    implementation(Libs.adapter_delegates_viewbinding)

    implementation("org.imaginativeworld.whynotimagecarousel:whynotimagecarousel:2.1.0")
    implementation("com.github.ismaeldivita:chip-navigation-bar:1.4.0")

    implementation(Libs.core_ktx)
    implementation(Libs.appcompat)
    implementation(Libs.material)
    implementation(Libs.constraint)

    testImplementation(Libs.junit)
    testImplementation(Libs.mockito)
    testImplementation(Libs.mockito_inline)
    testImplementation(Libs.core_testing)
    testImplementation(Libs.coroutines_test)
}