plugins {
    alias(libs.plugins.android.application)
    alias(libs.plugins.jetbrains.kotlin.android)
}

android {
    namespace = "com.example.logindemoapp"
    compileSdk = 34

    defaultConfig {
        applicationId = "com.example.logindemoapp"
        minSdk = 24
        targetSdk = 34
        versionCode = 1
        versionName = "1.0"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
        vectorDrawables {
            useSupportLibrary = true
        }
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
        compose = true
    }
    composeOptions {
        kotlinCompilerExtensionVersion = "1.5.1"
    }
    packaging {
        resources {
            excludes += "/META-INF/{AL2.0,LGPL2.1}"
        }
    }
}

dependencies {

    implementation(libs.androidx.core.ktx)
    implementation(libs.androidx.lifecycle.runtime.ktx)
    implementation(libs.androidx.activity.compose)
    implementation(platform(libs.androidx.compose.bom))
    implementation(libs.androidx.ui)
    implementation(libs.androidx.ui.graphics)
    implementation(libs.androidx.ui.tooling.preview)
    implementation(libs.androidx.material3)
    implementation(libs.androidx.appcompat)
    implementation(libs.material)
    implementation(libs.androidx.activity)
    implementation(libs.androidx.constraintlayout)
    testImplementation(libs.junit)
    androidTestImplementation(libs.androidx.junit)
    androidTestImplementation(libs.androidx.espresso.core)
    androidTestImplementation(platform(libs.androidx.compose.bom))
    androidTestImplementation(libs.androidx.ui.test.junit4)
    debugImplementation(libs.androidx.ui.tooling)
    debugImplementation(libs.androidx.ui.test.manifest)

    // navigation dependencies
    implementation ("androidx.navigation:navigation-compose:2.6.0")
    implementation ("androidx.compose.material:material:1.5.0") // Use the latest version
    implementation ("androidx.compose.ui:ui-tooling-preview:1.5.0")
    implementation ("androidx.compose.ui:ui:1.5.0")

    // top app bar material design dependency
    implementation ("androidx.compose.material:material:1.5.0")


    // Mockito for mocking
    testImplementation ("org.mockito:mockito-core:5.0.0")

    // Mockito-Kotlin for more concise Kotlin syntax
    testImplementation ("org.mockito.kotlin:mockito-kotlin:4.0.0")

    // Compose testing dependencies (if not already included)
    androidTestImplementation ("androidx.compose.ui:ui-test-junit4:1.5.0")
    debugImplementation ("androidx.compose.ui:ui-tooling:1.5.0")

    // JUnit 4 for unit testing
    testImplementation ("junit:junit:4.13.2")
}