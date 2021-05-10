package eu.balzo.foryouandme

import com.android.tools.idea.wizard.template.ModuleTemplateData
import com.android.tools.idea.wizard.template.RecipeExecutor
import com.android.tools.idea.wizard.template.impl.activities.common.addAllKotlinDependencies
import com.intellij.openapi.roots.ProjectRootManager
import com.intellij.psi.PsiDirectory
import com.intellij.psi.PsiFileFactory
import com.intellij.psi.PsiManager
import eu.balzo.foryouandme.listeners.MyProjectManagerListener.Companion.projectInstance
import eu.balzo.foryouandme.src.app_package.*
import org.jetbrains.kotlin.idea.KotlinLanguage

fun RecipeExecutor.forYouAndMeSetup(
    moduleData: ModuleTemplateData,
    packageName: String,
) {
    val (projectData) = moduleData
    val project = projectInstance ?: return

    addAllKotlinDependencies(moduleData)

    val virtualFiles = ProjectRootManager.getInstance(project).contentSourceRoots
    val virtSrc = virtualFiles.first { it.path.contains("src") }
    val virtRes = virtualFiles.first { it.path.contains("res") }
    val directorySrc = PsiManager.getInstance(project).findDirectory(virtSrc)!!
    val directoryRes = PsiManager.getInstance(project).findDirectory(virtRes)!!

    // project build.gradle
    moduleData.rootDir.resolve("build.gradle.kts").delete()
    save(projectBuildGradle(), projectData.rootDir.resolve("build.gradle.kts"))

    // app build.gradle
    moduleData.rootDir.resolve("build.gradle.kts").delete()
    save(appBuildGradle(), moduleData.rootDir.resolve("build.gradle.kts"))

    // secrets file
    save(secrets(), moduleData.resDir.resolve("values/secrets.xml"))

    // environment
    save(environment(projectData), moduleData.srcDir.resolve("StudyEnvironment.kt"))

    // image configuration
    save(imageConfiguration(projectData), moduleData.srcDir.resolve("StudyImageConfiguration.kt"))

}

fun String.save(srcDir: PsiDirectory, subDirPath: String, fileName: String) {
    try {
        val destDir = subDirPath.split(".").toDir(srcDir)
        val psiFile = PsiFileFactory
            .getInstance(srcDir.project)
            .createFileFromText(fileName, KotlinLanguage.INSTANCE, this)
        destDir.add(psiFile)
    } catch (exc: Exception) {
        exc.printStackTrace()
    }
}

fun List<String>.toDir(srcDir: PsiDirectory): PsiDirectory {
    var result = srcDir
    forEach {
        result = result.findSubdirectory(it) ?: result.createSubdirectory(it)
    }
    return result
}