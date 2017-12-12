import org.jetbrains.kotlin.gradle.tasks.KotlinCompile


group = "com.example"
version = "1.0-SNAPSHOT"

buildscript {
    val kotlinVersion = "1.2.0"
    extra["kotlin_version"] = kotlinVersion

    repositories {
        mavenCentral()
    }
    dependencies {
        classpath("org.jetbrains.kotlin:kotlin-gradle-plugin:$kotlinVersion")
    }
}

plugins {
    id("org.springframework.boot") version "1.5.8.RELEASE"
}

apply {
    plugin("kotlin")
    plugin("war")
}


repositories {
    mavenCentral()
    jcenter()
}

dependencies {
    val kotlinVersion = extra["kotlin_version"] as String
    "compile"("org.jetbrains.kotlin:kotlin-stdlib-jre8:$kotlinVersion")
    compile("org.springframework.boot:spring-boot-starter-web:1.5.8.RELEASE")

    compile("org.springframework.boot:spring-boot-starter-data-jpa")
    compile("org.postgresql:postgresql:42.1.4")

    val kotlinxHtmlVersion = "0.6.6"
    compile("org.jetbrains.kotlinx:kotlinx-html-jvm:$kotlinxHtmlVersion")

}

tasks.withType<KotlinCompile>(KotlinCompile::class.java).all {
    kotlinOptions {
        jvmTarget = "1.8"
    }
}
