plugins {
    kotlin("multiplatform") version "1.4.0"
}
group = "me.da"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()

}



kotlin {
    val hostOs = System.getProperty("os.name")
    val isMingwX64 = hostOs.startsWith("Windows")
    val nativeTarget = when {
        hostOs == "Mac OS X" -> macosX64("native")
        hostOs == "Linux" -> linuxX64("native")
        isMingwX64 -> mingwX64("native")
        else -> throw GradleException("Host OS is not supported in Kotlin/Native.")
    }

    nativeTarget.apply {
        binaries {
            executable {
                entryPoint = "main"
            }
        }
    }
    sourceSets {
        val nativeMain by getting{
            dependencies {
                implementation("io.ktor:ktor-client-core:1.4.1")
            }
        }
        
        val nativeTest by getting

    }

}

