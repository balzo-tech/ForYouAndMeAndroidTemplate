package eu.balzo.foryouandme.services

import com.intellij.openapi.project.Project
import eu.balzo.foryouandme.MyBundle

class MyProjectService(project: Project) {

    init {
        println(MyBundle.message("projectService", project.name))
    }
}
