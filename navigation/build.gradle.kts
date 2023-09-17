plugins {
    id("com.android.library")
    id("org.jetbrains.kotlin.android")
    id("androidx.navigation.safeargs")
}

android {
    namespace = "com.example.navigation"
    compileSdk  = Config.compileSdk


    defaultConfig {
        minSdk = Config.minSdk
        targetSdk = Config.targetSdk

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
        consumerProguardFiles("consumer-rules.pro")
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
        getByName("main").res.srcDirs(
                "$rootDir/navigation/src/main/sharedRes"
        )
    }
}

dependencies {
    implementation(project(":core:ui"))

    implementation(Libs.coreKtx)
    implementation(Libs.appCompat)
    implementation(Libs.material)

    //Navigation
    implementation(Libs.navigationFragment)
    implementation(Libs.navigationUi)

    testImplementation(Libs.junit)
    androidTestImplementation(Libs.junitTest)
    androidTestImplementation(Libs.espressoCore)
}