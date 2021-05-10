package eu.balzo.foryouandme.src.app_package

fun app(packageName: String) =
    """
package $packageName

import com.foryouandme.core.arch.app.ForYouAndMeApp
import com.foryouandme.data.datasource.Environment
import com.foryouandme.core.arch.deps.ImageConfiguration
import com.foryouandme.core.arch.deps.VideoConfiguration
import com.google.firebase.analytics.FirebaseAnalytics
import dagger.hilt.android.HiltAndroidApp

@HiltAndroidApp
class StudyApp : ForYouAndMeApp() {

    override val environment: Environment
        get() = StudyEnvironment(this)

    override val imageConfiguration: ImageConfiguration
        get() = StudyImageConfiguration()

    override val videoConfiguration: VideoConfiguration
        get() = StudyVideoConfiguration()

    override val firebaseAnalytics: FirebaseAnalytics
        get() = FirebaseAnalytics.getInstance(this)


}
    """