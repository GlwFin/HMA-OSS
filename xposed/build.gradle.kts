plugins {
    alias(libs.plugins.agp.lib)
    alias(libs.plugins.refine)
    alias(libs.plugins.kotlin)
}

val appPackageName: String by rootProject.extra

android {
    // ========== 核心修改：添加包名空值校验，避免非法命名空间 ==========
    val basePackage = if (appPackageName.isBlank()) "org.frknkrc44.hma_oss" else appPackageName
    namespace = "$basePackage.xposed"

    buildFeatures {
        buildConfig = false
    }
}

kotlin {
    jvmToolchain(21)
}

dependencies {
    implementation(projects.common)

    implementation(libs.androidx.annotation.jvm)
    implementation(libs.com.github.kyuubiran.ezxhelper)
    implementation(libs.dev.rikka.hidden.compat)
    compileOnly(libs.de.robv.android.xposed.api)
    compileOnly(libs.dev.rikka.hidden.stub)
}
