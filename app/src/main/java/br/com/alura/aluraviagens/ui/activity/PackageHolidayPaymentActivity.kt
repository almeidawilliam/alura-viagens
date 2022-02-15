package br.com.alura.aluraviagens.ui.activity

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import br.com.alura.aluraviagens.R
import br.com.alura.aluraviagens.model.PackageHoliday

class PackageHolidayPaymentActivity : AppCompatActivity() {

    companion object {
        private const val APPBAR_TITLE = "PAGAMENTO"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_package_holiday_payment)
        title = APPBAR_TITLE
        if (intent.hasExtra("packageHoliday")) {
            val packageHoliday: PackageHoliday =
                intent.getSerializableExtra("packageHoliday") as PackageHoliday
            showAmount(packageHoliday)
            configureEffectuatePaymentButton(packageHoliday)
        }
    }

    private fun configureEffectuatePaymentButton(packageHoliday: PackageHoliday) =
        findViewById<Button>(R.id.activity_package_holiday_payment_button_proceed_payment)
            .apply {
                this.setOnClickListener {

                    val intent = Intent(
                        this@PackageHolidayPaymentActivity,
                        PurchaseSummaryActivity::class.java
                    ).apply {
                        this.putExtra("packageHoliday", packageHoliday)
                    }

                    startActivity(intent)
                }
            }

    private fun showAmount(packageHoliday: PackageHoliday) {
        val amount = findViewById<TextView>(R.id.activity_package_holiday_payment_amount)
        amount.text = packageHoliday.formattedAmount()
    }
}