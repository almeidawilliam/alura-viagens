package br.com.alura.aluraviagens.ui.activity

import android.content.Intent
import android.os.Bundle
import android.widget.ListView
import androidx.appcompat.app.AppCompatActivity
import br.com.alura.aluraviagens.R
import br.com.alura.aluraviagens.dao.PackageHolidayDAO
import br.com.alura.aluraviagens.model.PackageHoliday
import br.com.alura.aluraviagens.ui.activity.PackageHolidayActivityConstants.HOLIDAY_PACKAGE_KEY
import br.com.alura.aluraviagens.ui.adapter.PackageHolidayListAdapter

class PackageHolidayListActivity : AppCompatActivity() {

    companion object {
        private const val APPBAR_TITLE = "Pacotes"
    }

    private val packageHolidayDAO: PackageHolidayDAO = PackageHolidayDAO()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_package_holiday_list)
        title = APPBAR_TITLE
        configureList()
    }

    private fun configureList() =
        findViewById<ListView>(R.id.package_holiday_list_listview)
            .apply {
                this.adapter =
                    PackageHolidayListAdapter(
                        this@PackageHolidayListActivity,
                        packageHolidayDAO.list()
                    )
            }
            .also {
                it.setOnItemClickListener { _, _, position, _ ->
                    val selectedPackageHoliday: PackageHoliday =
                        packageHolidayDAO.list()[position]
                    moveToPackageHolidaySummary(selectedPackageHoliday)
                }
            }

    private fun moveToPackageHolidaySummary(selectedPackageHoliday: PackageHoliday) {
        val intent = Intent(
            this@PackageHolidayListActivity,
            PackageHolidaySummaryActivity::class.java
        ).apply {
            this.putExtra(HOLIDAY_PACKAGE_KEY, selectedPackageHoliday)
        }

        startActivity(intent)
    }
}