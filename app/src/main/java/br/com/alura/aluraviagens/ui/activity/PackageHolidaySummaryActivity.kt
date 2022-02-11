package br.com.alura.aluraviagens.ui.activity

import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import br.com.alura.aluraviagens.R
import br.com.alura.aluraviagens.model.PackageHoliday
import br.com.alura.aluraviagens.util.getDrawable
import java.math.BigDecimal

class PackageHolidaySummaryActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_package_holiday_summary)

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

        findViewById<TextView>(R.id.activity_package_holiday_summary_days_range)
            .apply {
                this.text = ""
            }

    }
}