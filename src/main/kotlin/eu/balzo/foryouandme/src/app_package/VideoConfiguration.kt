package eu.balzo.foryouandme.src.app_package

import com.android.tools.idea.wizard.template.ProjectTemplateData

fun videoConfiguration(project: ProjectTemplateData) =
    """
package ${project.applicationPackage}

import com.foryouandme.core.arch.deps.VideoConfiguration

class StudyVideoConfiguration: VideoConfiguration {

    override fun introVideo(): Int = //TODO: set video res id

}
    """