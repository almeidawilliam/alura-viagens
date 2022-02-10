package br.com.alura.aluraviagens.ui.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.ImageView
import android.widget.TextView
import br.com.alura.aluraviagens.R
import br.com.alura.aluraviagens.model.PackageHoliday
import br.com.alura.aluraviagens.util.getDrawable

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

        val packageHoliday = packageHolidayList[position]

        showPlace(createdView, packageHoliday)
        showImage(createdView, packageHoliday)
        showDays(createdView, packageHoliday)
        showAmount(createdView, packageHoliday)

        return createdView
    }

    private fun showAmount(createdView: View, packageHoliday: PackageHoliday) =
        createdView.findViewById<TextView>(R.id.item_package_holiday_amount)
            .apply {
                this.text = packageHoliday.formattedAmount()
            }


    private fun showDays(createdView: View, packageHoliday: PackageHoliday) =
        createdView.findViewById<TextView>(R.id.item_package_holiday_days)
            .apply {
                this.text = packageHoliday.formattedDays()
            }


    private fun showImage(
        createdView: View,
        packageHoliday: PackageHoliday
    ) {
        val imageView = createdView.findViewById<ImageView>(R.id.item_package_holiday_image)
        val drawable = getDrawable(context, packageHoliday.image)
        imageView.setImageDrawable(drawable)
    }

    private fun showPlace(createdView: View, packageHoliday: PackageHoliday) =
        createdView.findViewById<TextView>(R.id.item_package_holiday_place)
            .apply {
                this.text = packageHoliday.place
            }
}
