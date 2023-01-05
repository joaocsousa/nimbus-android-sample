package com.adsbynimbus.android.sample

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.adsbynimbus.android.sample.common.SampleAppAdapter
import com.adsbynimbus.android.sample.databinding.FragmentMainBinding
import com.adsbynimbus.android.sample.common.Describable

class MainFragment : Fragment() {

    enum class Item(
        override val description: String
    ) : Describable {
        SHOW_AD_DEMO("Show Ad Demo"),
        MEDIATION_PLATFORMS("Mediation Platforms"),
        LOCK_SCREEN("Lock Screen"),
        TEST_RENDER("Test Render"),
        SETTINGS("Settings"),
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View = FragmentMainBinding.inflate(inflater, container, false).apply {
        recyclerView.adapter = SampleAppAdapter("main", enumValues<Item>()) { item ->
            val action = when (item) {
                Item.SHOW_AD_DEMO -> R.id.to_adDemoFragment
                Item.MEDIATION_PLATFORMS -> R.id.to_mediationPlatformsFragment
                Item.LOCK_SCREEN -> R.id.to_lockScreen
                Item.TEST_RENDER -> R.id.to_testRenderFragment
                Item.SETTINGS -> R.id.to_settingsFragment
            }
            findNavController().navigate(action)
        }
        recyclerView.layoutManager = LinearLayoutManager(context)
    }.root
}
