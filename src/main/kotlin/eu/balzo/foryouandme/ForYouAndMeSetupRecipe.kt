package eu.balzo.foryouandme

import com.android.tools.idea.wizard.template.ModuleTemplateData
import com.android.tools.idea.wizard.template.RecipeExecutor
import com.android.tools.idea.wizard.template.impl.activities.common.addAllKotlinDependencies
import eu.balzo.foryouandme.listeners.MyProjectManagerListener.Companion.projectInstance
import eu.balzo.foryouandme.src.app_package.*

fun RecipeExecutor.forYouAndMeSetup(
    moduleData: ModuleTemplateData,
) {
    val (projectData) = moduleData
    val project = projectInstance ?: return

    addAllKotlinDependencies(moduleData)

    // project build.gradle
    projectData.rootDir.resolve("build.gradle.kts").delete()
    save(projectBuildGradle(), projectData.rootDir.resolve("build.gradle.kts"))

    // app build.gradle
    moduleData.rootDir.resolve("build.gradle.kts").delete()
    save(appBuildGradle(moduleData.packageName), moduleData.rootDir.resolve("build.gradle.kts"))

    // secrets file
    save(secrets(), moduleData.resDir.resolve("values/secrets.xml"))

    // environment
    save(environment(moduleData.packageName), moduleData.srcDir.resolve("StudyEnvironment.kt"))

    // image configuration
    save(
        imageConfiguration(moduleData.packageName),
        moduleData.srcDir.resolve("StudyImageConfiguration.kt")
    )

    // video configuration
    save(
        videoConfiguration(moduleData.packageName),
        moduleData.srcDir.resolve("StudyVideoConfiguration.kt")
    )

    // module
    save(
        module(moduleData.packageName),
        moduleData.srcDir.resolve("StudyModule.kt")
    )

    // app
    save(
        app(moduleData.packageName),
        moduleData.srcDir.resolve("StudyApp.kt")
    )

    // manifest
    moduleData.manifestDir.resolve("AndroidManifest.xml").delete()
    save(
        manifest(moduleData.packageName),
        moduleData.manifestDir.resolve("AndroidManifest.xml")
    )

}