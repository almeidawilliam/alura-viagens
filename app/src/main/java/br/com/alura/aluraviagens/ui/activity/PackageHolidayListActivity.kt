package br.com.alura.aluraviagens.ui.activity

import android.os.Bundle
import android.widget.ListView
import androidx.appcompat.app.AppCompatActivity
import br.com.alura.aluraviagens.R
import br.com.alura.aluraviagens.dao.PackageHolidayDAO
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

    private fun configureList() {
        val packageHolidayList = findViewById<ListView>(R.id.package_holiday_list_listview)
        packageHolidayList.adapter = PackageHolidayListAdapter(this, packageHolidayDAO.list())
    }
}