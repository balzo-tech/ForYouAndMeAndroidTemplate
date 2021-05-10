package eu.balzo.foryouandme.src.app_package

fun appBuildGradle(packageName: String) =
    """
import java.io.FileInputStream
import java.util.*

plugins {
    id("com.android.application")
    kotlin("android")
    kotlin("kapt")
    kotlin("android.extensions")
    id("com.google.gms.google-services")
    id("com.google.firebase.crashlytics")
    id("dagger.hilt.android.plugin")
}

android {
    compileSdk = 30
    buildToolsVersion = "30.0.3"
    defaultConfig {
        applicationId = "$packageName"
        minSdk = 21
        targetSdk = 30
        versionCode = 1
        versionName = "1.0"
        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
    }
    
    signingConfigs {
        if (rootProject.file("app/signing.properties").exists()) {
            val signingRelease = Properties()
            signingRelease.load(FileInputStream(rootProject.file("app/signing.properties")))
            create("foryouandmedemo") {
                storeFile = rootProject.file("app/keystore.jks")
                storePassword = signingRelease.getProperty("storePassword")
                keyAlias = signingRelease.getProperty("keyAlias")
                keyPassword = signingRelease.getProperty("keyPassword")
            }
        }
    }
    
    buildTypes {
        create("production") {
            matchingFallbacks.add("release")
            isMinifyEnabled = false
            signingConfig = signingConfigs.maybeCreate("foryouandmedemo")
            firebaseCrashlytics { mappingFileUploadEnabled = true }
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
            isDebuggable = false
        }
        
        create("staging") {
            matchingFallbacks.add("release")
            isMinifyEnabled = false
            signingConfig = signingConfigs.maybeCreate("foryouandmedemo")
            applicationIdSuffix = ".staging"
            versionNameSuffix = "-staging"
            firebaseCrashlytics { mappingFileUploadEnabled = true }
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
            isDebuggable = false
        }
        
        create("staging-dev") {
            matchingFallbacks.add("debug")
            signingConfig = signingConfigs.maybeCreate("foryouandmedemo")
            applicationIdSuffix = ".staging"
            versionNameSuffix = "-staging"
            firebaseCrashlytics { mappingFileUploadEnabled = true }
            isDebuggable = true
        }
        
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

    /* --- 4youAndMe --- */
    implementation("net.4youandme:foryouandme:0.1.44")
    
    /* --- firebase --- */
    implementation("com.google.firebase:firebase-analytics-ktx:18.0.2")
    implementation("com.google.firebase:firebase-crashlytics-ktx:17.4.1")
    implementation("com.google.firebase:firebase-messaging-ktx:21.0.1")
    
    /* --- kotlin --- */
    implementation("org.jetbrains.kotlin:kotlin-stdlib:1.4.30")
    implementation("androidx.core:core-ktx:1.4.30")
    
    /* --- android --- */
    implementation("androidx.appcompat:appcompat:1.2.0")
    implementation("com.google.android.material:material:1.3.0")
    
    /* --- dagger --- */
    implementation("com.google.dagger:hilt-android:2.35")
    kapt("com.google.dagger:hilt-android-compiler:2.35")
    
    /* --- test --- */
    testImplementation("junit:junit:4.13.2")
    androidTestImplementation("androidx.test.ext:junit:1.1.2")
    androidTestImplementation("androidx.test.espresso:espresso-core:3.3.0")
    
}
    """