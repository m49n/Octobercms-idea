package com.example.october

import com.intellij.lang.Language
import com.intellij.lang.injection.MultiHostInjector
import com.intellij.lang.injection.MultiHostRegistrar
import com.intellij.openapi.util.TextRange
import com.intellij.psi.PsiElement
import com.intellij.psi.PsiFile
import com.intellij.psi.PsiPlainText
import com.jetbrains.php.PhpLanguage

class OctoberPagePhpInjector : MultiHostInjector {
    override fun getLanguagesToInject(host: PsiElement, registrar: MultiHostRegistrar) {
        if (host !is PsiPlainText) return
        val file = host.containingFile ?: return
        if (file.fileType !is OctoberPageFileType) return
        val text = file.text
        val markers = Regex("^==\s*$", RegexOption.MULTILINE).findAll(text).toList()
        if (markers.size < 2) return
        val phpStart = markers[1].range.last + 1
        if (phpStart >= text.length) return
        registrar.startInjecting(PhpLanguage.INSTANCE)
        registrar.addPlace(null, null, host, TextRange(phpStart, text.length))
        registrar.doneInjecting()
    }

    override fun elementsToInjectIn(): List<Class<out PsiElement>> = listOf(PsiPlainText::class.java)
}
