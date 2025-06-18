plugins {
    // разворачиваем Java-проект
    id("java")
    // поддержка Kotlin
    id("org.jetbrains.kotlin.jvm") version "1.9.22"
    // плагин IntelliJ Platform
    id("org.jetbrains.intellij") version "2.5.0"
}

group = "com.example"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

intellij {
    // версия IDE-SDK, в котором вы тестируете плагин
    version.set("2021.3")
    // подтягиваем поддержку PHP-плагина
    plugins.set(listOf("com.jetbrains.php"))
    // тип IDE: IC = Community, IU = Ultimate
    type.set("IC")
}

java {
    // используем toolchain для установки Java 17
    toolchain {
        languageVersion.set(JavaLanguageVersion.of(17))
    }
}

tasks {
    // если хочется ещё явную совместимость — но toolchain обычно достаточно
    withType<JavaCompile> {
        sourceCompatibility = "17"
        targetCompatibility = "17"
    }
}

dependencies {
    implementation(kotlin("stdlib"))
}
