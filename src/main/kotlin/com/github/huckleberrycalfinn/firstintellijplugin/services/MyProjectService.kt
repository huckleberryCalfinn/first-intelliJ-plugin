package com.github.huckleberrycalfinn.firstintellijplugin.services

import com.intellij.openapi.project.Project
import com.github.huckleberrycalfinn.firstintellijplugin.MyBundle

class MyProjectService(project: Project) {

    init {
        println(MyBundle.message("projectService", project.name))
    }
}
