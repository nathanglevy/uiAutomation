plugins {
    kotlin("jvm") version "1.8.20" apply false
}

group = "nglevy"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

buildscript {
    dependencies {
        classpath(kotlin("gradle-plugin", version = "1.8.0"))
    }
}