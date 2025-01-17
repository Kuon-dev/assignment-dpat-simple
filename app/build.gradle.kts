/*
 * This file was generated by the Gradle 'init' task.
 *
 * This generated file contains a sample Java application project to get you started.
 * For more details on building Java & JVM projects, please refer to https://docs.gradle.org/8.5/userguide/building_java_projects.html in the Gradle documentation.
 */

plugins {
    // Apply the application plugin to add support for building a CLI application in Java.
    application
}

repositories {
    // Use Maven Central for resolving dependencies.
    mavenCentral()
}

dependencies {
    // Use JUnit Jupiter for testing.
    testImplementation(libs.junit.jupiter)

    testRuntimeOnly("org.junit.platform:junit-platform-launcher")

    // This dependency is used by the application.
    implementation(libs.guava)

    implementation("org.projectlombok:lombok:1.18.22") // Use the latest version available
    annotationProcessor("org.projectlombok:lombok:1.18.22")
}

// Apply a specific Java toolchain to ease working on different environments.
java {
    toolchain {
        languageVersion.set(JavaLanguageVersion.of(21))
    }
}

application {
    // Define the main class for the application.
    mainClass.set("dpat.App")
}

tasks.named<Test>("test") {
    // Use JUnit Platform for unit tests.
    useJUnitPlatform()
}
tasks.jar {
    manifest {
        attributes(
            "Main-Class" to "dpat.App"
        )
    }
    // This line ensures that the compiled classes and resources are included in the JAR
    from(configurations.runtimeClasspath.get().map { if (it.isDirectory) it else zipTree(it) }, project.sourceSets.main.get().output)
}
