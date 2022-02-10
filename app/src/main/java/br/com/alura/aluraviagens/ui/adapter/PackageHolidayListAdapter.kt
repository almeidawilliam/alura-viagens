package br.com.alura.aluraviagens.ui.adapter

import android.content.Context
import android.graphics.drawable.Drawable
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.ImageView
import android.widget.TextView
import br.com.alura.aluraviagens.R
import br.com.alura.aluraviagens.model.PackageHoliday
import java.math.RoundingMode

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

        val placeView = createdView.findViewById<TextView>(R.id.item_package_holiday_place)
        val imageView = createdView.findViewById<ImageView>(R.id.item_package_holiday_image)
        val daysView = createdView.findViewById<TextView>(R.id.item_package_holiday_days)
        val amountView = createdView.findViewById<TextView>(R.id.item_package_holiday_amount)

        placeView.text = packageHoliday.place
        val resources = context.resources
        val identifier = resources.getIdentifier(
            packageHoliday.image,
            Drawable::class.simpleName?.lowercase(),
            context.packageName
        )
        val drawable = resources.getDrawable(identifier, context.theme)
        imageView.setImageDrawable(drawable)

        daysView.text = packageHoliday.formattedDays()
        amountView.text = packageHoliday.formattedAmount()

        return createdView
    }
}
