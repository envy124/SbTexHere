package int09h.facebook.com.sbtexhere3

import android.content.res.Resources
import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.google.android.gms.maps.CameraUpdateFactory
import com.google.android.gms.maps.GoogleMap
import com.google.android.gms.maps.MapView
import com.google.android.gms.maps.MapsInitializer
import com.google.android.gms.maps.model.*
import int09h.facebook.com.sbtexhere3.models.Point
import android.graphics.Bitmap
import android.provider.MediaStore.Images.Media.getBitmap
import android.graphics.drawable.BitmapDrawable
import android.support.v4.content.ContextCompat


/**
 * Created by int09h on 01/03/2018.
 */

class MapFragment : Fragment() {
    private var googleMap: GoogleMap? = null
    private var mMapView: MapView? = null
    private val markers = HashSet<LatLng>()
    private var markerIcon: Bitmap? = null

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        val rootView = inflater.inflate(R.layout.fragment_main, container, false)

        val bitmapdraw = ContextCompat.getDrawable(activity, R.drawable.map_point_orange) as BitmapDrawable
        markerIcon = Bitmap.createScaledBitmap(bitmapdraw.bitmap, 37, 28, false)

        mMapView = rootView.findViewById(R.id.mapView) as MapView
        mMapView!!.onCreate(savedInstanceState)
        mMapView!!.onResume()

        try {
            MapsInitializer.initialize(activity.applicationContext)
        } catch (e: Exception) {
            e.printStackTrace()
        }


        mMapView!!.getMapAsync({ mMap ->
            googleMap = mMap

            try {
                // For showing a move to my location button
                googleMap?.isMyLocationEnabled = true
            }
            catch (e: SecurityException) {

            }

        })

        return rootView
    }

    override fun onResume() {
        super.onResume()
        mMapView?.onResume()
    }

    override fun onPause() {
        super.onPause()
        mMapView?.onPause()
    }

    override fun onDestroy() {
        super.onDestroy()
        mMapView?.onDestroy()
    }

    override fun onLowMemory() {
        super.onLowMemory()
        mMapView?.onLowMemory()
    }

    fun addMarker(p: Point) {
        val marker = LatLng(p.latitude, p.longitude)
        if (!markers.contains(marker)) {
            googleMap?.addMarker(MarkerOptions()
                    .position(marker)
                    .icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_GREEN)))
            markers.add(marker)
        }
        setCameraPosition(p)
    }

    fun setCameraPosition(p: Point, zoom: Float = 11f) {
        val pos = LatLng(p.latitude, p.longitude)
        val cameraPosition = CameraPosition.Builder().target(pos).zoom(zoom).build()
        googleMap?.animateCamera(CameraUpdateFactory.newCameraPosition(cameraPosition))
    }


    companion object {
        /**
         * The fragment argument representing the section number for this
         * fragment.
         */
        private val ARG_SECTION_NUMBER = "section_number"

        var instance: MapFragment? = null

        /**
         * Returns a new instance of this fragment for the given section
         * number.
         */
        fun newInstance(sectionNumber: Int): MapFragment {
            if (instance == null) {
                instance = MapFragment()
                val args = Bundle()
                args.putInt(ARG_SECTION_NUMBER, sectionNumber)
                instance?.arguments = args
            }
            return instance!!
        }
    }
}