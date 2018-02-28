package int09h.facebook.com.sbtexhere3

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView

import int09h.facebook.com.sbtexhere3.AtmFragment.OnListFragmentInteractionListener
import int09h.facebook.com.sbtexhere3.models.Atm

/**
 * [RecyclerView.Adapter] that can display a [DummyItem] and makes a call to the
 * specified [OnListFragmentInteractionListener].
 * TODO: Replace the implementation with code for your data type.
 */
class AtmRecyclerViewAdapter(private val mValues: List<Atm>, private val mListener: OnListFragmentInteractionListener?) : RecyclerView.Adapter<AtmRecyclerViewAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context)
                .inflate(R.layout.fragment_atm, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = mValues[position]
        with(holder, {
            mItem = item
            mStreetNameView.text = item.street
            mAtmTypeView.text = item.type
            mAtmDescriptionView.text = item.description
            mAtmDistanceView.text = mView.context.resources.getString(R.string.atm_distance).format(item.distance)

            mView.setOnClickListener {
                mListener?.onListFragmentInteraction(mItem!!)
            }
        })
    }

    override fun getItemCount(): Int {
        return mValues.size
    }

    inner class ViewHolder(val mView: View) : RecyclerView.ViewHolder(mView) {
        val mAtmTypeView: TextView
        val mStreetNameView: TextView
        val mAtmDistanceView: TextView
        val mAtmDescriptionView: TextView
        var mItem: Atm? = null

        init {
            mAtmTypeView = mView.findViewById<View>(R.id.atmType) as TextView
            mAtmDistanceView = mView.findViewById<View>(R.id.atmDistance) as TextView
            mStreetNameView = mView.findViewById<View>(R.id.atmStreetName) as TextView
            mAtmDescriptionView = mView.findViewById<View>(R.id.atmDescription) as TextView

        }

    }
}
