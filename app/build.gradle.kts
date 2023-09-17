plugins {
    id("com.android.application")
    id("org.jetbrains.kotlin.android")
    id("kotlin-kapt")
    id("com.google.dagger.hilt.android")
    id("androidx.navigation.safeargs")
}

android {
    namespace = "com.example.dota_heroes"
    compileSdk= Config.compileSdk

    defaultConfig {
        applicationId = "com.example.dota_heroes"
        minSdk = Config.minSdk
        targetSdk = Config.targetSdk
        versionCode = Config.versionCode
        versionName = "1.0"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
    }

    buildTypes {
        getByName("release"){
            isMinifyEnabled  = false
            proguardFiles(getDefaultProguardFile("proguard-android-optimize.txt"), "proguard-rules.pro")
        }
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }
    kotlinOptions {
        jvmTarget = "1.8"
    }
    sourceSets {
        getByName("debug").res.srcDirs("${rootDir}/navigation/src/main/sharedRes")
    }
}

dependencies {

    implementation(project(":core:data"))
    implementation(project(":core:ui"))
    implementation(project(":core:common"))
    implementation(project(":core:domain"))
    implementation(project(":feature:home"))
    implementation(project(":feature:detail"))
    implementation(project(":feature:saved"))
    implementation(project(":navigation"))

    implementation (Libs.coreKtx)
    implementation (Libs.appCompat)
    implementation (Libs.material)

    //Hilt
    implementation (Libs.hilt)
    kapt (Libs.hiltCompiler)

    //Navigation
    implementation(Libs.navigationFragment)
    implementation(Libs.navigationUi)

    testImplementation (Libs.junit)
    androidTestImplementation (Libs.junitTest)
    androidTestImplementation (Libs.espressoCore)
}