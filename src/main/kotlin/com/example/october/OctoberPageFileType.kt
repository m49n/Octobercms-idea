package com.example.october

import com.intellij.openapi.fileTypes.LanguageFileType
import javax.swing.Icon

object OctoberPageFileType : LanguageFileType(OctoberPageLanguage) {
    override fun getName() = "October Page"
    override fun getDescription() = "OctoberCMS page file"
    override fun getDefaultExtension() = "htm"
    override fun getIcon(): Icon? = null
}
