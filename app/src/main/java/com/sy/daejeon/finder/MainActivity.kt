package com.sy.daejeon.finder

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.google.android.gms.ads.*
import com.sy.daejeon.finder.databinding.ActivityMainBinding
import com.sy.daejeon.finder.item.Item

class MainActivity : AppCompatActivity(), OnItemClick{

    val binding by lazy { ActivityMainBinding.inflate(layoutInflater)}
    val listFragment by lazy { ListFragment() }
    //val detailFragment by lazy { DetailFragment() }
    //val viewModel by lazy { ViewModelProvider(this).get(FindPhoneListViewModel::class.java) }
    var _item: Item? = null
    lateinit var mAdView : AdView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        setFragment()

        // 1. 모바일광고 SDK 초기화
        MobileAds.initialize(this) {}

        // 2. 광고 띄우기
        mAdView = binding.adViewBanner
        val adRequest = AdRequest.Builder().build()
        mAdView.loadAd(adRequest)

        mAdView.adListener = object: AdListener() {
            override fun onAdLoaded() {
                // Code to be executed when an ad finishes loading.
            }

            override fun onAdFailedToLoad(adError : LoadAdError) {
                // Code to be executed when an ad request fails.
            }

            override fun onAdOpened() {
                // Code to be executed when an ad opens an overlay that
                // covers the screen.
            }

            override fun onAdClicked() {
                // Code to be executed when the user clicks on an ad.
            }

            override fun onAdClosed() {
                // Code to be executed when the user is about to return
                // to the app after tapping on an ad.
            }
        }


    }

    fun goDetail(item:Item) {
        _item = item
        val detailFragment = DetailFragment()
        val transaction = supportFragmentManager.beginTransaction()
        transaction.add(R.id.framelayout, detailFragment)
        transaction.addToBackStack("detail")
        transaction.commit()
    }

    fun goBack() {
        onBackPressed()
    }

    fun setFragment() {
        val transaction = supportFragmentManager.beginTransaction()
        transaction.add(R.id.framelayout, listFragment)
        transaction.commit()
    }

    override fun onClick(item: Item?) {
        if (item != null) {
            goDetail(item)
        }
    }
}
