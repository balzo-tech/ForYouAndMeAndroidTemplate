package eu.balzo.foryouandme

import com.android.tools.idea.wizard.template.*
import java.io.File


val ForYouAndMeSetupTemplate
    get() = template {

        val template = Template.NoActivity

        name = "ForYouAndMe Template"
        description = "Setup project for ForYouAndMe StudyApp"
        minApi = 23
        category = Category.Other // Check other categories
        formFactor = FormFactor.Mobile
        screens =
            listOf(
                WizardUiContext.FragmentGallery,
                WizardUiContext.MenuEntry,
                WizardUiContext.NewProject,
                WizardUiContext.NewModule
            )

        val packageNameParam = defaultPackageNameParameter

        thumb { File("preview_analog.png") }

        recipe = { data: TemplateData ->
            forYouAndMeSetup(data as ModuleTemplateData)
        }
    }

val defaultPackageNameParameter
    get() = stringParameter {
        name = "Package name"
        visible = { !isNewModule }
        default = "com.mycompany.myapp"
        constraints = listOf(Constraint.PACKAGE)
        suggest = { packageName }
    }