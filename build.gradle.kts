fun properties(key: String) = project.findProperty(key).toString()

buildscript {
    dependencies {
        classpath("com.h2database:h2:1.4.197")
    }
}

plugins {
    // Java support
    id("java")
    // Gradle IntellJ Plugin
    // id("org.jetbrains.intellij") version "1.7.0"
    // Gradle Changelog Plugin
    id("org.jetbrains.changelog") version "1.3.1"
    // Gradle Qodana Plugin
    id("org.jetbrains.qodana") version "0.1.13"
    // Gradle IntelliJ Plugin
    id("org.jetbrains.intellij") version "1.3.0"
    // flyway and h2 for persistence stuff
    id("org.flywaydb.flyway") version "9.0.1"
}


dependencies {
    implementation("javax")
}



group = properties("pluginGroup")
version = properties("pluginVersion")

// Configure project's dependencies
repositories {
    mavenCentral()
}


// Configure Gradle IntelliJ Plugin - read more: https://github.com/JetBrains/gradle-intellij-plugin
intellij {
    pluginName.set(properties("pluginName"))
    version.set(properties("platformVersion"))
    type.set(properties("platformType"))
    // Plugin Dependencies. Uses `platformPlugins` property from the gradle.properties file.
    plugins.set(properties("platformPlugins").split(',').map(String::trim).filter(String::isNotEmpty))

}

tasks {
    // Set the JVM compatibility versions
    properties("javaVersion").let {
        withType<JavaCompile> {
            sourceCompatibility = it
            targetCompatibility = it
        }
    }

    wrapper {
        gradleVersion = properties("gradleVersion")
    }

    patchPluginXml {
        version.set(properties("pluginVersion"))
        sinceBuild.set(properties("pluginSinceBuild"))
        untilBuild.set(properties("pluginUntilBuild"))
    }
}

flyway {
    url = "jdbc:h2:file:./target/foobar"
    user = "sa"
}
