object Libs {
    const val retrofit = "com.squareup.retrofit2:retrofit:${Versions.retrofit}"
    const val retrofit_converter_gson = "com.squareup.retrofit2:converter-gson:${Versions.retrofit}"
    const val coil = "io.coil-kt:coil:${Versions.coil}"
    const val koin_android = "io.insert-koin:koin-android:${Versions.koin}"
    const val koin_core = "io.insert-koin:koin-core:${Versions.koin}"
    const val lifecycle_vm = "androidx.lifecycle:lifecycle-viewmodel-ktx:${Versions.lifecycle}"
    const val lifecycle_runtime = "androidx.lifecycle:lifecycle-runtime-ktx:${Versions.lifecycle}"
    const val adapter_delegates =
        "com.hannesdorfmann:adapterdelegates4-kotlin-dsl:${Versions.adapter_delegates}"
    const val adapter_delegates_viewbinding =
        "com.hannesdorfmann:adapterdelegates4-kotlin-dsl-viewbinding:${Versions.adapter_delegates}"
    const val core_ktx = "androidx.core:core-ktx:${Versions.core_ktx}"
    const val appcompat = "androidx.appcompat:appcompat:${Versions.appcompat}"
    const val material = "com.google.android.material:material:${Versions.material}"
    const val constraint = "androidx.constraintlayout:constraintlayout:${Versions.constraint}"

    //test
    const val junit = "junit:junit:${Versions.junit}"
    const val mockito = "org.mockito:mockito-core:${Versions.mockito}"
    const val mockito_inline = "org.mockito:mockito-inline:${Versions.mockito_inline}"
    const val core_testing = "androidx.arch.core:core-testing:${Versions.core_testing}"
    const val coroutines_test = "org.jetbrains.kotlinx:kotlinx-coroutines-test:${Versions.coroutines_test}"
}

object Versions {
    const val retrofit = "2.9.0"
    const val coil = "2.1.0"
    const val koin = "3.2.2"
    const val lifecycle = "2.5.1"
    const val adapter_delegates = "4.3.2"
    const val core_ktx = "1.8.0"
    const val appcompat = "1.5.1"
    const val material = "1.7.0"
    const val constraint = "2.1.4"

    //test
    const val junit = "4.13.2"
    const val mockito = "2.28.2"
    const val mockito_inline = "4.9.0"
    const val core_testing = "2.1.0"
    const val coroutines_test = "1.5.2"
}