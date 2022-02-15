package br.com.alura.aluraviagens.ui.activity

import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import br.com.alura.aluraviagens.R
import br.com.alura.aluraviagens.model.PackageHoliday
import br.com.alura.aluraviagens.util.getFormattedPeriod

class PurchaseSummaryActivity : AppCompatActivity() {

    companion object {
        private const val APPBAR_TITLE = "Resumo do pacote"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_purchase_summary)
        title = APPBAR_TITLE

        if (intent.hasExtra("packageHoliday")) {
            val packageHoliday: PackageHoliday =
                intent.getSerializableExtra("packageHoliday") as PackageHoliday
            showPlace(packageHoliday)
            showAmount(packageHoliday)
            showImage(packageHoliday)
            showPeriod(packageHoliday)
        }
    }

    private fun showPeriod(packageHoliday: PackageHoliday) =
        findViewById<TextView>(R.id.activity_purchase_summary_date_period)
            .apply {
                this.text = getFormattedPeriod(packageHoliday.days)
            }

    private fun showImage(packageHoliday: PackageHoliday) {
        val imageView = findViewById<ImageView>(R.id.activity_purchase_summary_place_image)
        val drawable = br.com.alura.aluraviagens.util.getDrawable(this, packageHoliday.image)
        imageView.setImageDrawable(drawable)
    }

    private fun showAmount(packageHoliday: PackageHoliday) =
        findViewById<TextView>(R.id.activity_purchase_summary_amount)
            .apply {
                this.text = packageHoliday.formattedAmount()
            }

    private fun showPlace(packageHoliday: PackageHoliday) =
        findViewById<TextView>(R.id.activity_purchase_summary_place_name)
            .apply {
                this.text = packageHoliday.place
            }
}