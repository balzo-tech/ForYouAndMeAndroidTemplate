package eu.balzo.foryouandme

import com.android.tools.idea.wizard.template.Template
import com.android.tools.idea.wizard.template.WizardTemplateProvider
import eu.balzo.foryouandme.ForYouAndMeSetupTemplate

class WizardTemplateProviderImpl  : WizardTemplateProvider() {

    override fun getTemplates(): List<Template> = listOf(ForYouAndMeSetupTemplate)
}
