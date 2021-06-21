enableFeaturePreview("VERSION_CATALOGS")

rootProject.name = "test-automation"

include(":test-automation-core")
include(":test-automation-postman")
include(":test-automation-arch-rules")
include(":test-automation-dev")
include("test-automation-containers")
include("test-automation-report")
include("test-automation-jdbc")
include("int-test-modules:ams-int-test-automation")

plugins {
    val kotlinVersion = "1.5.10"
    kotlin("jvm") version kotlinVersion apply false
    kotlin("plugin.spring") version kotlinVersion apply false
    kotlin("kapt") version kotlinVersion apply false
    id("io.freefair.lombok") version "6.0.0-m2" apply false
    id("pl.allegro.tech.build.axion-release") version "1.13.2" apply false
}

dependencyResolutionManagement {
    versionCatalogs {
        create("libs") {
            version("gradle", "7.0.2")

            version("cucumber", "6.10.3")
            version("spring-boot", "2.4.5")
            version("retrofit", "2.9.0")
            version("jackson", "2.12.2")
            version("testcontainers", "1.15.3")

            alias("cucumber-java").to("io.cucumber", "cucumber-java").versionRef("cucumber")
            alias("cucumber-testng").to("io.cucumber", "cucumber-testng").versionRef("cucumber")
            alias("cucumber-reporting").to("net.masterthought", "cucumber-reporting").version("5.5.3")

            alias("springboot-starter_").to("org.springframework.boot", "spring-boot-starter").versionRef("spring-boot")
            alias("springboot-starter-web").to("org.springframework.boot", "spring-boot-starter-web").versionRef("spring-boot")
            alias("springboot-starter-jdbc").to("org.springframework.boot", "spring-boot-starter-jdbc").versionRef("spring-boot")
            alias("springboot-starter-test").to("org.springframework.boot", "spring-boot-starter-test").versionRef("spring-boot")
            alias("springboot-starter-log4j2").to("org.springframework.boot", "spring-boot-starter").versionRef("spring-boot")
            alias("springboot-starter-mail").to("org.springframework.boot", "spring-boot-starter-mail").versionRef("spring-boot")
            alias("springboot-configuration-processor").to("org.springframework.boot", "spring-boot-configuration-processor")
                .versionRef("spring-boot")

            alias("retrofit2").to("com.squareup.retrofit2", "retrofit").versionRef("retrofit")
            alias("converter-gson").to("com.squareup.retrofit2", "converter-gson").versionRef("retrofit")
            alias("converter-jackson").to("com.squareup.retrofit2", "converter-jackson").versionRef("retrofit")
            alias("converter-scalars").to("com.squareup.retrofit2", "converter-scalars").versionRef("retrofit")

            alias("tika-core").to("org.apache.tika", "tika-core").version("1.26")
            alias("guava").to("com.google.guava", "guava").version("30.1.1-jre")
            alias("commons-codec").to("commons-codec", "commons-codec").version("1.15")
            alias("swagger_request_validator_core").to("com.atlassian.oai", "swagger-request-validator-core").version("2.18.0")
            alias("org.eclipse.jgit").to("org.eclipse.jgit", "org.eclipse.jgit").version("5.11.0.202103091610-r")

            alias("testcontainers-core").to("org.testcontainers", "testcontainers").versionRef("testcontainers")
            alias("testcontainers-postgresql").to("org.testcontainers", "postgresql").versionRef("testcontainers")

            alias("jackson-module-kotlin").to("com.fasterxml.jackson.module", "jackson-module-kotlin").versionRef("jackson")
            alias("jackson-datatype-jsr310").to("com.fasterxml.jackson.datatype", "jackson-datatype-jsr310").versionRef("jackson")

            alias("postgresql").to("org.postgresql", "postgresql").version("42.2.21")

            alias("jacoco-core").to("org.jacoco", "org.jacoco.core").version("0.8.7")
            alias("jacoco-report").to("org.jacoco", "org.jacoco.report").version("0.8.7")

            bundle("cucumber", listOf("cucumber-java", "cucumber-testng"))
            bundle(
                "springboot", listOf(
                    "springboot-starter_", "springboot-starter-web", "springboot-starter-test",
                    "springboot-starter-log4j2", "springboot-starter-mail", "springboot-starter-jdbc"
                )
            )
            bundle("retrofit2", listOf("retrofit2", "converter-gson", "converter-jackson", "converter-scalars"))
            bundle("jacoco", listOf("jacoco-core", "jacoco-report"))
        }
    }
}
