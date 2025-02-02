/*
 *  This file is part of Robok © 2024.
 *
 *  Robok is free software: you can redistribute it and/or modify
 *  it under the terms of the GNU General Public License as published by
 *  the Free Software Foundation, either version 3 of the License, or
 *  (at your option) any later version.
 *
 *  Robok is distributed in the hope that it will be useful,
 *  but WITHOUT ANY WARRANTY; without even the implied warranty of
 *  MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 *  GNU General Public License for more details.
 *
 *  You should have received a copy of the GNU General Public License
 *   along with Robok.  If not, see <https://www.gnu.org/licenses/>.
 */

import org.jetbrains.kotlin.gradle.dsl.JvmTarget

plugins {
  alias(libs.plugins.kotlin)
  alias(libs.plugins.kotlin.serialization)
  `maven-publish`
  `java-library`
}

group = "org.robok"
version = libs.versions.lib.version.get()

java {
  sourceCompatibility = JavaVersion.VERSION_21
  targetCompatibility = JavaVersion.VERSION_21
}

tasks.withType<org.jetbrains.kotlin.gradle.tasks.KotlinCompile>().configureEach {
  compilerOptions {
    jvmTarget.set(JvmTarget.JVM_21)
  }
}

afterEvaluate {
  publishing {
    publications {
      register("mavenRelease", MavenPublication::class) {
        groupId = "org.robok"
        artifactId = "amix"
        version = libs.versions.lib.version.get()
        from(components["java"])
      }
    }
  }
}

dependencies {
  implementation(libs.antlr4)
  implementation(libs.antlr4.runtime)
  implementation(libs.ktx.serialization.json)
}