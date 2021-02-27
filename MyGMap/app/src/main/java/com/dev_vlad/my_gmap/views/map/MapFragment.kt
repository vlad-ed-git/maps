package com.dev_vlad.my_gmap.views.map

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.dev_vlad.my_gmap.databinding.FragmentMapBinding
import com.dev_vlad.my_gmap.view_models.map.MapViewModel
import com.google.android.gms.maps.GoogleMap
import com.google.android.gms.maps.MapView
import com.google.android.gms.maps.OnMapReadyCallback

class MapFragment : Fragment(), OnMapReadyCallback {

    companion object {
        private val TAG = MapFragment::class.java.simpleName
        private const val MAP_VIEW_BUNDLE_KEY = "map_view_bundle_key"
    }

    private lateinit var viewModel: MapViewModel
    private var _binding: FragmentMapBinding? = null
    private val binding get() = _binding!!
    private var googleMap : GoogleMap? = null
    private var mMapView : MapView? = null

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentMapBinding.inflate(inflater, container, false)
        mMapView = binding.mapView
        return binding.root
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProvider(this).get(MapViewModel::class.java)
        val mapBundle = savedInstanceState?.getBundle(MAP_VIEW_BUNDLE_KEY)
        initMap(mapBundle)
    }

    private fun initMap(mapBundle: Bundle?) {
        mMapView?.onCreate(mapBundle)
        mMapView?.getMapAsync(this@MapFragment)
    }


    override fun onMapReady(gMap: GoogleMap?) {
       googleMap = gMap
    }


    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        var mapBundle = outState.getBundle(MAP_VIEW_BUNDLE_KEY)
        if (mapBundle == null){
            mapBundle = Bundle()
            outState.putBundle(MAP_VIEW_BUNDLE_KEY, mapBundle)
        }
        mMapView?.onSaveInstanceState(mapBundle)
    }

    override fun onResume() {
        super.onResume()
        mMapView?.onResume()
    }

    override fun onStart() {
        super.onStart()
        mMapView?.onStart()
    }

    override fun onStop() {
        super.onStop()
        mMapView?.onStop()
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
    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

  

}