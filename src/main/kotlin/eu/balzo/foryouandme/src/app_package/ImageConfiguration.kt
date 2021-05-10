package eu.balzo.foryouandme.src.app_package

import com.android.tools.idea.wizard.template.ProjectTemplateData

fun imageConfiguration(project: ProjectTemplateData) =
    """
package ${project.applicationPackage}

import com.foryouandme.core.arch.deps.ImageConfiguration

class StudyImageConfiguration : ImageConfiguration {

    /* --- common ---*/

    override fun splashLogo(): Int = //TODO: set res image id

    override fun pushSmallIcon(): Int = //TODO: set res image id

    override fun loading(): Int = //TODO: set res image id

    override fun back(): Int = //TODO: set res image id

    override fun backSecondary(): Int = //TODO: set res image id

    override fun close(): Int = //TODO: set res image id

    override fun closeSecondary(): Int = //TODO: set res image id

    override fun clear(): Int = //TODO: set res image id

    override fun logo(): Int = //TODO: set res image id

    override fun logoStudy(): Int = //TODO: set res image id

    override fun logoStudySecondary(): Int = //TODO: set res image id

    override fun nextStep(): Int = //TODO: set res image id

    override fun nextStepSecondary(): Int = //TODO: set res image id

    override fun previousStepSecondary(): Int = //TODO: set res image id

    /* --- auth --- */

    override fun entryWrong(): Int = //TODO: set res image id

    override fun entryValid(): Int = //TODO: set res image id

    /* --- main --- */

    override fun tabFeed(): Int = //TODO: set res image id

    override fun tabTask(): Int = //TODO: set res image id

    override fun tabUserData(): Int = //TODO: set res image id

    override fun tabStudyInfo(): Int = //TODO: set res image id

    /* --- task --- */

    override fun timer(): Int = //TODO: set res image id

    override fun pocket(): Int = //TODO: set res image id

    override fun videoDiaryIntro(): Int = //TODO: set res image id

    override fun videoDiaryTime(): Int = //TODO: set res image id

    override fun videoDiaryClose(): Int = //TODO: set res image id

    override fun videoDiaryRecord(): Int = //TODO: set res image id

    override fun videoDiaryPause(): Int = //TODO: set res image id

    override fun videoDiaryPlay(): Int = //TODO: set res image id

    override fun videoDiaryFlashOn(): Int = //TODO: set res image id

    override fun videoDiaryFlashOff(): Int = //TODO: set res image id

    override fun videoDiaryToggleCamera(): Int = //TODO: set res image id

    override fun heartBeat(): Int = //TODO: set res image id

    override fun sittingMan(): Int = //TODO: set res image id

    override fun walkingMan(): Int = //TODO: set res image id

    override fun phoneShake(): Int = //TODO: set res image id

    override fun phoneShakeCircle(): Int = //TODO: set res image id

    override fun trailMaking(): Int = //TODO: set res image id

    /* --- menu item --- */

    override fun aboutYou(): Int = //TODO: set res image id

    override fun contactInfo(): Int = //TODO: set res image id

    override fun rewards(): Int = //TODO: set res image id

    override fun faq(): Int = //TODO: set res image id

    override fun arrow(): Int = //TODO: set res image id

    override fun pregnancy(): Int = //TODO: set res image id

    override fun devices(): Int = //TODO: set res image id

    override fun reviewConsent(): Int = //TODO: set res image id

    override fun permissions(): Int = //TODO: set res image id

    override fun dailySurveyTime(): Int = //TODO: set res image id

    override fun smartwatch(): Int = //TODO: set res image id

    override fun oura(): Int = //TODO: set res image id

    override fun deactivatedButton(): Int = //TODO: set res image id

    override fun location(): Int = //TODO: set res image id

    override fun pushNotification(): Int = //TODO: set res image id

    override fun editContainer(): Int = //TODO: set res image id

    override fun pencil(): Int = //TODO: set res image id

    override fun instagram(): Int = //TODO: set res image id

    override fun rescuetime(): Int = //TODO: set res image id

    override fun twitter(): Int = //TODO: set res image id

    override fun garmin(): Int = //TODO: set res image id
}
    """