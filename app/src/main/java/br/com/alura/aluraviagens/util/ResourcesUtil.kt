package br.com.alura.aluraviagens.util

import android.content.Context
import android.graphics.drawable.Drawable
import androidx.core.content.res.ResourcesCompat

fun getDrawable(context: Context, resource: String): Drawable? {
    val resources = context.resources
    val identifier = resources.getIdentifier(
        resource,
        Drawable::class.simpleName?.lowercase(),
        context.packageName
    )
    return ResourcesCompat.getDrawable(resources, identifier, context.theme)
}