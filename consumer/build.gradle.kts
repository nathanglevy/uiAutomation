plugins {
    kotlin("jvm")
    id("com.google.devtools.ksp") version "1.8.20-1.0.11"
    id("org.jetbrains.compose") version "1.4.0"
}

group = "nglevy"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

dependencies {
    implementation(compose.desktop.currentOs)
    testImplementation("org.junit.jupiter:junit-jupiter-api:5.8.1")
    testRuntimeOnly("org.junit.jupiter:junit-jupiter-engine:5.8.1")
    implementation(project(":annotation"))
    implementation(project(":parser"))
    ksp(project(":parser"))
}

tasks.getByName<Test>("test") {
    useJUnitPlatform()
}

tasks.withType<org.jetbrains.kotlin.gradle.tasks.KotlinCompile> {
    kotlinOptions.jvmTarget = "16"
}