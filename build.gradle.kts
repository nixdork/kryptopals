import com.adarshr.gradle.testlogger.theme.ThemeType

plugins {
    kotlin("jvm") version "1.7.20"
    id("com.adarshr.test-logger") version "3.2.0"
    id("idea")
    id("java")
    application
}

group = "org.nixdork"
version = "0.0.1"

repositories {
    mavenCentral()
    gradlePluginPortal()
}

dependencies {
    implementation("org.jetbrains.kotlin:kotlin-stdlib-jdk8:1.7.20")
    implementation("org.jetbrains.kotlin:kotlin-stdlib:1.7.20")

    testImplementation("io.kotest:kotest-runner-junit5-jvm:5.5.3")
    testImplementation("io.kotest:kotest-assertions-core-jvm:5.5.3")
    testImplementation("io.kotest:kotest-property-jvm:5.5.3")
}

sourceSets {
    main {
        java {
            srcDirs("$projectDir/src/main/kotlin/")
        }
    }
    test {
        java {
            srcDirs("$projectDir/src/test/kotlin/")
        }
    }
}

tasks {
    test { useJUnitPlatform() }
    compileKotlin { kotlinOptions.jvmTarget = "17" }
    compileTestKotlin { kotlinOptions.jvmTarget = "17" }
    jar {
        duplicatesStrategy = DuplicatesStrategy.EXCLUDE
        archiveBaseName.set("kryptopals")
        manifest {
            attributes["Main-Class"] = "MainKt"
        }
        from(sourceSets.main.get().output)
        dependsOn(configurations.runtimeClasspath)
        from({
            configurations.runtimeClasspath.get().map {
                if (it.isDirectory)
                    it
                else
                    zipTree(it)
            }
        })
    }
}

java {
    sourceCompatibility = JavaVersion.VERSION_17
    targetCompatibility = JavaVersion.VERSION_17
}

application {
    mainClass.set("MainKt")
}

testlogger {
    theme = ThemeType.STANDARD
    logLevel = LogLevel.LIFECYCLE
}
