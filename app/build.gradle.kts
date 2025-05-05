import java.util.Properties

plugins {
    alias(libs.plugins.android.application)
    alias(libs.plugins.kotlin.android)
}
//
//val localProperties = Properties()
//localProperties.load(File(rootDir, "local.properties").inputStream())
//val apiKey = localProperties["API_KEY"] as String


android {
    namespace = "com.nagaraju.whatsthenews"
    compileSdk = 35

//    val apiKey: String = project.findProperty("NEWS_API_KEY") as? String ?: ""

    defaultConfig {
        applicationId = "com.nagaraju.whatsthenews"
        minSdk = 24
        targetSdk = 35
        versionCode = 1
        versionName = "1.0"
//        buildConfigField("String", "API_KEY", "\"$apiKey\"")
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
        sourceCompatibility = JavaVersion.VERSION_11
        targetCompatibility = JavaVersion.VERSION_11
    }
    buildFeatures {
        dataBinding = true
        buildConfig = true
    }
    kotlinOptions {
        jvmTarget = "11"
    }



}

dependencies {

    implementation(libs.androidx.core.ktx)
    implementation(libs.androidx.appcompat)
    implementation(libs.material)
    implementation(libs.androidx.activity)
    implementation(libs.androidx.constraintlayout)
    implementation(libs.androidx.navigation.fragment.ktx)
    implementation(libs.androidx.navigation.ui.ktx)
    implementation(libs.retrofit)
    implementation(libs.androidx.paging)
    implementation(libs.retrofit.gson.converter)
    implementation(libs.coroutine)
    implementation(libs.glide)
    implementation(libs.koin.core)
    implementation(libs.koin.android)
    implementation(libs.androidx.swiperefreshlayout)
    testImplementation(libs.junit)
    androidTestImplementation(libs.androidx.junit)
    androidTestImplementation(libs.androidx.espresso.core)
}




