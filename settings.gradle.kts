pluginManagement {
    repositories {
        mavenCentral()
        gradlePluginPortal()
        maven("https://maven.pkg.jetbrains.space/public/p/compose/dev")
        google()
    }
    
}
rootProject.name = "uiAutomation"
include("parser")
include("consumer")
include("annotation")
