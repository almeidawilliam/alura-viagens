package br.com.alura.aluraviagens.ui.activity

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import br.com.alura.aluraviagens.R
import br.com.alura.aluraviagens.model.PackageHoliday
import java.math.BigDecimal

class PackageHolidayPaymentActivity : AppCompatActivity() {

    companion object {
        private const val APPBAR_TITLE = "PAGAMENTO"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_package_holiday_payment)
        title = APPBAR_TITLE
        val packageHoliday = PackageHoliday("São Paulo", "sao_paulo_sp", 2, BigDecimal(243.99))
        showAmount(packageHoliday)
        configureEffectuatePaymentButton()
    }

    private fun configureEffectuatePaymentButton() =
        findViewById<Button>(R.id.activity_package_holiday_payment_button_proceed_payment)
            .apply {
                this.setOnClickListener {
                    startActivity(
                        Intent(
                            this@PackageHolidayPaymentActivity,
                            PurchaseSummaryActivity::class.java
                        )
                    )
                }
            }

    private fun showAmount(packageHoliday: PackageHoliday) {
        val amount = findViewById<TextView>(R.id.activity_package_holiday_payment_amount)
        amount.text = packageHoliday.formattedAmount()
    }
}