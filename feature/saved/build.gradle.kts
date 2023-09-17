plugins {
    id("com.android.library")
    id("org.jetbrains.kotlin.android")
    id("kotlin-kapt")
    id("com.google.dagger.hilt.android")
    id("androidx.navigation.safeargs")
}


android {
    namespace = "com.example.saved"
    compileSdk  = Config.compileSdk

    defaultConfig {
        minSdk = Config.minSdk

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
        consumerProguardFiles("consumer-rules.pro")
    }

    buildTypes {
        getByName("release"){
            isMinifyEnabled  = false
            proguardFiles(getDefaultProguardFile("proguard-android-optimize.txt"), "proguard-rules.pro")
        }
    }
    buildFeatures{
        viewBinding = true
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }
    kotlinOptions {
        jvmTarget = "1.8"
    }
}

dependencies {

    implementation(project(":core:ui"))
    implementation(project(":core:common"))
    implementation(project(":core:domain"))
    implementation(project(":navigation"))

    implementation(Libs.coreKtx)
    implementation(Libs.appCompat)
    implementation(Libs.material)

    //Navigation
    implementation(Libs.navigationFragment)
    implementation(Libs.navigationUi)

    //Hilt
    implementation(Libs.hilt)
    kapt(Libs.hiltCompiler)
    implementation(Libs.legacySupport)

    //Lifecycle
    implementation(Libs.lifecycleViewModel)
    implementation(Libs.lifecycle)
    implementation(Libs.fragment)
    
    testImplementation(Libs.junit)
    androidTestImplementation(Libs.junitTest)
    androidTestImplementation(Libs.espressoCore)
}