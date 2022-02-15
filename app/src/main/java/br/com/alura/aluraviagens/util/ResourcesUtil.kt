package br.com.alura.aluraviagens.util

import android.content.Context
import android.graphics.drawable.Drawable
import androidx.core.content.res.ResourcesCompat
import java.text.SimpleDateFormat
import java.util.*

fun getDrawable(context: Context, resource: String): Drawable? {
    val resources = context.resources
    val identifier = resources.getIdentifier(
        resource,
        Drawable::class.simpleName?.lowercase(),
        context.packageName
    )
    return ResourcesCompat.getDrawable(resources, identifier, context.theme)
}

fun getFormattedPeriod(days: Int): String {
    val brazilianFormat = SimpleDateFormat("dd/MM")
    val departureDate = Calendar.getInstance()
    val returnDate = Calendar.getInstance()
    returnDate.add(Calendar.DATE, days)
    val formattedDepartureDate: String = brazilianFormat.format(departureDate.time)
    val formattedReturnDate = brazilianFormat.format(returnDate.time)

    return "$formattedDepartureDate - $formattedReturnDate de ${returnDate.get(Calendar.YEAR)}"
}