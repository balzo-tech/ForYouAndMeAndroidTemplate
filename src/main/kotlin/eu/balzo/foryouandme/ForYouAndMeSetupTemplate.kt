package eu.balzo.foryouandme

import com.android.tools.idea.wizard.template.*
import java.io.File

val ForYouAndMeSetupTemplate
    get() = template {

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
        val entityName = stringParameter {
            name = "Entity Name"
            default = "Wurst"
            help = "The name of the entity class to create and use in Activity"
            constraints = listOf(Constraint.NONEMPTY)
        }

        val layoutName = stringParameter {
            name = "Layout Name"
            default = "my_act"
            help = "The name of the layout to create for the activity"
            constraints = listOf(Constraint.LAYOUT, Constraint.UNIQUE, Constraint.NONEMPTY)
            suggest = { "${activityToLayout(entityName.value.toLowerCase())}s" }
        }

        widgets(
            TextFieldWidget(entityName),
            TextFieldWidget(layoutName),
            PackageNameWidget(packageNameParam)
        )

       thumb { File("src/main/resources/foryouandme.png") }

        recipe = { data: TemplateData ->
            mviSetup(
                data as ModuleTemplateData,
                packageNameParam.value,
                entityName.value,
                layoutName.value
            )
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