package com.example.cdgialumini.utils

import java.util.regex.Matcher
import java.util.regex.Pattern

object Check {
    fun isEmail(emailAddress: String): Boolean {
        val pattern: Pattern = Pattern.compile(
            """^[A-Z0-9_!#$%&'*+/=?`{|}~^-]+(?:\.[A-Z0-9_!#$%&'*+/=?`{|}~^-]+↵)*@[A-Z0-9-]+(?:\.[A-Z0-9-]+)*$""".trimIndent(), Pattern.CASE_INSENSITIVE
        )
        val matcher: Matcher = pattern.matcher(emailAddress)
        return matcher.find()
    }
}