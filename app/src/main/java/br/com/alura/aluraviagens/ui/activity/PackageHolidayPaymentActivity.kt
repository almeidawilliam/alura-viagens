package br.com.alura.aluraviagens.ui.activity

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import br.com.alura.aluraviagens.R
import br.com.alura.aluraviagens.model.PackageHoliday
import br.com.alura.aluraviagens.ui.activity.PackageHolidayActivityConstants.HOLIDAY_PACKAGE_KEY

class PackageHolidayPaymentActivity : AppCompatActivity() {

    companion object {
        private const val APPBAR_TITLE = "Pagamento"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_package_holiday_payment)
        title = APPBAR_TITLE
        loadReceivedHolidayPackage()
    }

    private fun loadReceivedHolidayPackage() {
        if (intent.hasExtra(HOLIDAY_PACKAGE_KEY)) {
            val packageHoliday: PackageHoliday =
                intent.getSerializableExtra(HOLIDAY_PACKAGE_KEY) as PackageHoliday
            showAmount(packageHoliday)
            configureEffectuatePaymentButton(packageHoliday)
        }
    }

    private fun configureEffectuatePaymentButton(packageHoliday: PackageHoliday) =
        findViewById<Button>(R.id.activity_package_holiday_payment_button_proceed_payment)
            .apply {
                this.setOnClickListener {
                    moveToPurchaseSummary(packageHoliday)
                }
            }

    private fun moveToPurchaseSummary(packageHoliday: PackageHoliday) {
        val intent = Intent(
            this@PackageHolidayPaymentActivity,
            PurchaseSummaryActivity::class.java
        ).apply {
            this.putExtra(HOLIDAY_PACKAGE_KEY, packageHoliday)
        }

        startActivity(intent)
    }

    private fun showAmount(packageHoliday: PackageHoliday) {
        val amount = findViewById<TextView>(R.id.activity_package_holiday_payment_amount)
        amount.text = packageHoliday.formattedAmount()
    }
}