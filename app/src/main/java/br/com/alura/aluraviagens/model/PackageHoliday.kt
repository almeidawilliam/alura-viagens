package br.com.alura.aluraviagens.model

import java.io.Serializable
import java.math.BigDecimal
import java.text.DecimalFormat
import java.util.*

class PackageHoliday(
    val place: String,
    val image: String,
    val days: Int,
    val amount: BigDecimal,
): Serializable {
    fun formattedDays(): String =
        if (days > 1)
            "$days dias"
        else
            "$days dia"


    fun formattedAmount(): String =
        DecimalFormat
            .getCurrencyInstance(Locale("pt", "br"))
            .run {
                this.format(amount)
            }
            .apply {
                this.replace("R$", "R$ ")
            }
}