package int09h.facebook.com.sbtexhere3.dummy

import int09h.facebook.com.sbtexhere3.models.Atm
import java.util.ArrayList
import java.util.HashMap

/**
 * Helper class for providing sample content for user interfaces created by
 * Android template wizards.
 *
 *
 * TODO: Replace all uses of this class before publishing your app.
 */
object ListContent {

    /**
     * An array of sample (dummy) items.
     */
    val ITEMS:MutableList<Atm> = ArrayList<Atm>()

    /**
     * A map of sample (dummy) items, by ID.
     */
    val ITEM_MAP:MutableMap<String, Atm> = HashMap<String, Atm>()

    private val COUNT = 25

    init{
        // Add some sample items.
        for (i in 1..COUNT)
        {
            addItem(createDummyItem(i))
        }
    }

    private fun addItem(item: Atm) {
        ITEMS.add(item)
        ITEM_MAP.put(item.hashCode().toString(), item)
    }

    private fun createDummyItem(position:Int): Atm {
        return Atm("г Москва, ул Нижегородская, д. 13б",
                "Платежное устройство",
                "Прием наличных, наличные платежи, безналичные платежи",
                200.0f)
    }

    private fun makeDetails(position:Int):String {
        val builder = StringBuilder()
        builder.append("Details about Item: ").append(position)
        for (i in 0 until position)
        {
            builder.append("\nMore details information here.")
        }
        return builder.toString()
    }

}
