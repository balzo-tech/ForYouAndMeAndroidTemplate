package eu.balzo.foryouandme.src.app_package

fun videoConfiguration(packageName: String) =
    """
package $packageName

import com.foryouandme.core.arch.deps.VideoConfiguration

class StudyVideoConfiguration: VideoConfiguration {

    override fun introVideo(): Int = //TODO: set video res id

}
    """