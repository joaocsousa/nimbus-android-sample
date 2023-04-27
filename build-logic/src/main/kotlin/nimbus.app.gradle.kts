plugins {
    id("com.android.application")
    kotlin("android")
}

android {
    compileSdk = 31

    defaultConfig {
        minSdk = 21
        targetSdk = 31
    }

    /* Ensures the jvmTarget is aligned at 17 for both languages */
    compileOptions.targetCompatibility = JavaVersion.VERSION_1_8
}
