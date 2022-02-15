package br.com.alura.aluraviagens.ui.activity

import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import br.com.alura.aluraviagens.R
import br.com.alura.aluraviagens.model.PackageHoliday
import br.com.alura.aluraviagens.util.getFormattedPeriod
import java.math.BigDecimal

class PurchaseSummaryActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_purchase_summary)
        title = "RESUMO DA COMPRA"

        val packageHoliday = PackageHoliday("São Paulo", "sao_paulo_sp", 2, BigDecimal(243.99))

        val placeView = findViewById<TextView>(R.id.activity_purchase_summary_place_name)
        placeView.text = packageHoliday.place

        val amountView = findViewById<TextView>(R.id.activity_purchase_summary_amount)
        amountView.text = packageHoliday.formattedAmount()

        val imageView = findViewById<ImageView>(R.id.activity_purchase_summary_place_image)
        val drawable = br.com.alura.aluraviagens.util.getDrawable(this, packageHoliday.image)
        imageView.setImageDrawable(drawable)

        val periodView = findViewById<TextView>(R.id.activity_purchase_summary_date_period)
        periodView.text = getFormattedPeriod(packageHoliday.days)

    }
}