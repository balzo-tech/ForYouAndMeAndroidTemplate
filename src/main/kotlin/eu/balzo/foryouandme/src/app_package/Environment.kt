package eu.balzo.foryouandme.src.app_package

import com.android.tools.idea.wizard.template.ProjectTemplateData

fun environment(packageName: String) =
    """
package $packageName

import android.content.Context
import com.foryouandme.data.datasource.Environment

class StudyEnvironment(private val context: Context) : Environment() {

    override fun isDebuggable(): Boolean = true

    override fun isStaging(): Boolean = true

    override fun studyId(): String =
        context.getString(R.string.STUDY_ID)

    override fun getApiBaseUrl(): String =
        context.getString(R.string.BASE_URL)

    override fun getOAuthBaseUrl(): String =
        context.getString(R.string.OAUTH_BASE_URL)

    override fun useCustomData(): Boolean = false

    override fun pinCodeSuffix(): String =
        context.getString(R.string.PIN_CODE_SUFFIX)

}
    """