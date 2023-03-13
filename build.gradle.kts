import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

val springBootVersion = "2.7.9"
val jacksonVersion = "2.13.2"
val jacksonDatabindVersion = "2.13.4.2"
val jupiterVersion = "5.8.2"

plugins {
	id("org.springframework.boot") version "2.7.9"
	id("io.spring.dependency-management") version "1.0.15.RELEASE"
	kotlin("jvm") version "1.6.21"
	kotlin("plugin.spring") version "1.6.21"
}

group = "com.mercadolibre"
version = "0.0.1-SNAPSHOT"
java.sourceCompatibility = JavaVersion.VERSION_11

repositories {
	mavenCentral()
	maven("https://repo.spring.io/milestone")
	maven("https://dl.bintray.com/arturbosch/generic")
	maven("https://maven.artifacts.furycloud.io/content/groups/Arquitectura")
	maven("https://maven.artifacts.furycloud.io/nexus/content/repositories/releases")
	maven("https://maven.artifacts.furycloud.io/nexus/content/repositories/MLGrailsPlugins")
	maven("https://plugins.gradle.org/m2/")
	maven("https://maven.artifacts.furycloud.io/repository/all")
	maven("https://dl.bintray.com/arturbosch/generic")
}

dependencies {
	annotationProcessor("org.springframework.boot:spring-boot-configuration-processor:${springBootVersion}")
	implementation("org.springframework.boot:spring-boot-starter-web:${springBootVersion}")
	implementation("org.springframework.boot:spring-boot-starter-jetty:${springBootVersion}")
	implementation("org.jetbrains.kotlin:kotlin-reflect")
	implementation("org.jetbrains.kotlin:kotlin-stdlib-jdk8")
	implementation(kotlin("stdlib-jdk8"))
	implementation("com.fasterxml.jackson.module:jackson-module-kotlin:2.13.1")
	implementation("com.mercadolibre:conductor:1.0.27")
	implementation("com.mercadolibre.restclient:meli-restclient-default:1.0.6")
	implementation("com.mercadolibre:kvsclient:0.5.7")
	implementation("com.mercadolibre:mqclient:1.0.2")
	implementation("com.fasterxml.jackson.core:jackson-databind:${jacksonDatabindVersion}")
	implementation("com.fasterxml.jackson.core:jackson-annotations:${jacksonVersion}")
	implementation("com.fasterxml.jackson.core:jackson-core:${jacksonVersion}")
	implementation("com.fasterxml.jackson.datatype:jackson-datatype-jsr310:${jacksonVersion}")
	implementation("com.mercadolibre.metrics:metrics-core:0.0.13")
	implementation("com.mercadolibre.metrics:datadog-metric-wrapper:0.0.15") {
		exclude(group = "commons-io", module = "commons-io")
	}
	implementation("com.newrelic.agent.java:newrelic-api:7.1.1")
	implementation("com.newrelic.agent.java:newrelic-agent:7.1.1")
	implementation("org.springdoc:springdoc-openapi-kotlin:1.6.6")
	implementation("org.springdoc:springdoc-openapi-ui:1.6.6")
	implementation("com.mercadolibre:lockclient:2.2.2")
	implementation("org.springframework.cloud:spring-cloud-contract-wiremock:3.1.1")
	implementation("org.springframework.cloud:spring-cloud-starter-bootstrap:3.1.1")
	implementation("org.reflections:reflections:0.10.2")
	implementation("net.sourceforge.plantuml:plantuml:8059")
	implementation("org.apache.commons:commons-text") {
		version {
			strictly("1.10.0")
		}
	}
	testImplementation("org.springframework.boot:spring-boot-starter-test:${springBootVersion}") {
		exclude(group = "junit", module = "junit")
		exclude(group = "junit-vintage-engine", module = "org.junit.vintage")
		exclude(group = "com.vaadin.external.google", module = "android-json")
	}
	testImplementation("io.mockk:mockk:1.12.3")
	testImplementation("org.junit.jupiter:junit-jupiter-api:${jupiterVersion}")
	testImplementation("org.junit.jupiter:junit-jupiter-engine:${jupiterVersion}")
	testImplementation("com.willowtreeapps.assertk:assertk-jvm:0.25")
	testImplementation("com.github.tomakehurst:wiremock-jre8:2.32.0") {
		exclude(group = "commons-io", module = "commons-io")
	}
	testImplementation("org.json:json:20220924")
	testImplementation("com.ninja-squad:springmockk:3.1.2")
	implementation("commons-io:commons-io:2.11.0")
}

tasks.withType<KotlinCompile> {
	kotlinOptions {
		freeCompilerArgs = listOf("-Xjsr305=strict")
		jvmTarget = "11"
	}
}

tasks.withType<Test> {
	useJUnitPlatform()
}
