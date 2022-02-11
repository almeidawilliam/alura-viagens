package br.com.alura.aluraviagens.ui.activity

import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import br.com.alura.aluraviagens.R
import br.com.alura.aluraviagens.model.PackageHoliday
import br.com.alura.aluraviagens.util.getDrawable
import java.math.BigDecimal
import java.text.SimpleDateFormat
import java.util.*

class PackageHolidaySummaryActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_package_holiday_summary)
        setTitle("Resumo do pacote")

        val packageHoliday = PackageHoliday("São Paulo", "sao_paulo_sp", 2, BigDecimal(243.99))

        findViewById<TextView>(R.id.activity_package_holiday_summary_place)
            .apply {
                this.text = packageHoliday.place
            }

        val drawable = getDrawable(this, packageHoliday.image)
        findViewById<ImageView>(R.id.activity_package_holiday_summary_image)
            .apply {
                this.setImageDrawable(drawable)
            }

        findViewById<TextView>(R.id.activity_package_holiday_summary_days)
            .apply {
                this.text = packageHoliday.formattedDays()
            }

        findViewById<TextView>(R.id.activity_package_holiday_summary_amount)
            .apply {
                this.text = packageHoliday.formattedAmount()
            }

        val brazilianFormat = SimpleDateFormat("dd/MM")
        val departureDate = Calendar.getInstance()
        val returnDate: Calendar = Calendar.getInstance()
        returnDate.add(Calendar.DATE, packageHoliday.days)
        val formattedDepartureDate: String = brazilianFormat.format(departureDate.time)
        val formattedReturnDate = brazilianFormat.format(returnDate.time)

        findViewById<TextView>(R.id.activity_package_holiday_summary_days_range)
            .apply {
                this.text =
                    "$formattedDepartureDate - $formattedReturnDate de ${returnDate.get(Calendar.YEAR)}"
            }

    }
}