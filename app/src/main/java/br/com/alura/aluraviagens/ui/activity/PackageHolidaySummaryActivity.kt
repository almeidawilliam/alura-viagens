package br.com.alura.aluraviagens.ui.activity

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import br.com.alura.aluraviagens.R
import br.com.alura.aluraviagens.model.PackageHoliday
import br.com.alura.aluraviagens.util.getDrawable
import br.com.alura.aluraviagens.util.getFormattedPeriod

class PackageHolidaySummaryActivity : AppCompatActivity() {

    companion object {
        private const val APPBAR_TITLE = "Resumo do pacote"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_package_holiday_summary)
        title = APPBAR_TITLE

        if (intent.hasExtra("packageHoliday")) {
            val packageHoliday: PackageHoliday =
                intent.getSerializableExtra("packageHoliday") as PackageHoliday
            showPlace(packageHoliday)
            showImage(packageHoliday)
            showDays(packageHoliday)
            showAmount(packageHoliday)
            showDates(packageHoliday)
            configureProceedPaymentButton(packageHoliday)
        }
    }

    private fun configureProceedPaymentButton(packageHoliday: PackageHoliday) =
        findViewById<Button>(R.id.activity_package_holiday_summary_proceed_payment_button)
            .apply {
                this.setOnClickListener {

                    val intent = Intent(
                        this@PackageHolidaySummaryActivity,
                        PackageHolidayPaymentActivity::class.java
                    ).apply {
                        this.putExtra("packageHoliday", packageHoliday)
                    }

                    startActivity(intent)
                }
            }

    private fun showDates(packageHoliday: PackageHoliday) =
        findViewById<TextView>(R.id.activity_package_holiday_summary_days_period)
            .apply {
                this.text =
                    getFormattedPeriod(packageHoliday.days)
            }


    private fun showAmount(packageHoliday: PackageHoliday) =
        findViewById<TextView>(R.id.activity_package_holiday_summary_amount)
            .apply {
                this.text = packageHoliday.formattedAmount()
            }


    private fun showDays(packageHoliday: PackageHoliday) =
        findViewById<TextView>(R.id.activity_package_holiday_summary_days)
            .apply {
                this.text = packageHoliday.formattedDays()
            }


    private fun showImage(packageHoliday: PackageHoliday) {
        val drawable = getDrawable(this, packageHoliday.image)
        findViewById<ImageView>(R.id.activity_package_holiday_summary_image)
            .apply {
                this.setImageDrawable(drawable)
            }
    }

    private fun showPlace(packageHoliday: PackageHoliday) =
        findViewById<TextView>(R.id.activity_package_holiday_summary_place)
            .apply {
                this.text = packageHoliday.place
            }
}