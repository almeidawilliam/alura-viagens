package br.com.alura.aluraviagens.ui.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import br.com.alura.aluraviagens.R
import br.com.alura.aluraviagens.model.PackageHoliday

class PackageHolidayListAdapter(
    private val context: Context,
    private val packageHolidayList: List<PackageHoliday>
) : BaseAdapter() {

    override fun getCount(): Int =
        packageHolidayList.size

    override fun getItem(position: Int): PackageHoliday =
        packageHolidayList[position]


    override fun getItemId(position: Int): Long =
        0

    override fun getView(position: Int, view: View?, parent: ViewGroup?): View {
        val createdView: View =
            LayoutInflater
                .from(context)
                .inflate(R.layout.item_package_holiday, parent, false)

        return createdView
    }

}
