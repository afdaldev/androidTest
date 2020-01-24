/**
 * Created by DhytoDev on 2020-01-24.
 * Email : dhytodev@gmail.com
 */

import Versions.androidAnnotationsVersion
import Versions.androidPluginVersion
import Versions.androidXCore
import Versions.constraintLayoutVersion
import Versions.gsonVersion
import Versions.koinVersion
import Versions.kotlinVersion
import Versions.lifecycleVersion
import Versions.materialVersion
import Versions.navigationVersion
import Versions.okHttpVersion
import Versions.pagingVersion
import Versions.playServiceVersion
import Versions.retrofitVersion
import Versions.roomVersion
import Versions.rxAndroidVersion
import Versions.rxKotlinVersion

object Versions {
    val androidBuildToolsVersion = "29.0.2"
    val androidMinSdkVersion = 21
    val androidTargetSdkVersion = 29
    val androidCompileSdkVersion = 29
    val kotlinVersion = "1.3.50"
    val androidPluginVersion = "3.5.0"

    val rxKotlinVersion = "2.4.0"
    val rxAndroidVersion = "2.1.1"
    val gsonVersion = "2.8.6"
    val okHttpVersion = "4.0.1"
    val retrofitVersion = "2.6.1"
    val androidAnnotationsVersion = "28.0.0"
    val archCompVersion = "2.1.0"
    val roomVersion = "2.2.0"
    val pagingVersion = "2.1.1"
    val koinVersion = "2.0.1"
    val androidXCore = "1.1.0"
    val lifecycleVersion = "2.1.0"
    val constraintLayoutVersion = "1.1.3"
    val navigationVersion = "2.1.0"
    val materialVersion = "1.2.0-alpha02"

    val playServiceVersion = "17.0.0"

    //Testing
    val jUnitVersion = "4.12"
    val androidXTestExtKotlinRunnerVersion = "1.1.1"
    val assertJVersion = "3.8.0"
    val mockitoKotlinVersion = "1.5.0"
    val mockitoAndroidVersion = "2.8.9"
    val robolectricVersion = "3.4.2"
    val androidSupportRunnerVersion = "1.2.0"
    val androidSupportRulesVersion = "1.2.0"
    val espressoVersion = "3.2.0"
}

object Core {
    val kotlinStdlib = "org.jetbrains.kotlin:kotlin-stdlib-jdk7:$kotlinVersion"
}

object RxJava {
    val rxKotlin = "io.reactivex.rxjava2:rxkotlin:${rxKotlinVersion}"
    val rxAndroid = "io.reactivex.rxjava2:rxandroid:${rxAndroidVersion}"
}

object Network {
    val gson = "com.google.code.gson:gson:${gsonVersion}"
    val okHttp = "com.squareup.okhttp3:okhttp:${okHttpVersion}"
    val okHttpLogger = "com.squareup.okhttp3:logging-interceptor:${okHttpVersion}"
    val retrofit = "com.squareup.retrofit2:retrofit:${retrofitVersion}"
    val retrofitConverter = "com.squareup.retrofit2:converter-gson:${retrofitVersion}"
    val retrofitAdapter = "com.squareup.retrofit2:adapter-rxjava2:${retrofitVersion}"
}

object Room {
    val roomRuntime = "androidx.room:room-runtime:${roomVersion}"
    val roomCompiler = "androidx.room:room-compiler:${roomVersion}"
    val roomRxJava = "androidx.room:room-rxjava2:${roomVersion}"
    val roomTesting = "androidx.room:room-testing:${roomVersion}"
}

object Jetpack {
    val navigation = "androidx.navigation:navigation-fragment-ktx:$navigationVersion"
    val navigationFragment = "androidx.navigation:navigation-ui-ktx:$navigationVersion"
    val lifecycle = "androidx.lifecycle:lifecycle-extensions:${lifecycleVersion}"
    val pagingRuntime = "androidx.paging:paging-runtime-ktx:$pagingVersion"
    val pagingCommon = "androidx.paging:paging-common-ktx:$pagingVersion"
    val pagingRxJava = "androidx.paging:paging-rxjava2:$pagingVersion"
}

object Koin {
    val koin = "org.koin:koin-android:${koinVersion}"
    val koinScope = "org.koin:koin-androidx-scope:${koinVersion}"
    val koinViewModel = "org.koin:koin-androidx-viewmodel:${koinVersion}"
    val koinExt = "org.koin:koin-androidx-ext:${koinVersion}"
}

object Android {
    val appCompat = "androidx.appcompat:appcompat:${androidXCore}"
    val coreKtx = "androidx.core:core-ktx:${androidXCore}"
    val androidAnnotations = "com.android.support:support-annotations:${androidAnnotationsVersion}"
    val constraintLayout = "androidx.constraintlayout:constraintlayout:${constraintLayoutVersion}"
    val playServiceAuth = "com.google.android.gms:play-services-auth:$playServiceVersion"
    val playServiceLocation = "com.google.android.gms:play-services-location:$playServiceVersion"
    val dataBinding = "com.android.databinding:compiler:$androidPluginVersion"
    val legacySupport = "androidx.legacy:legacy-support-v4:1.0.0"
    val material = "com.google.android.material:material:$materialVersion"
}


