package com.minhphu.basemodule.ads

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import android.widget.RelativeLayout
import android.widget.TextView
import com.facebook.ads.*
import com.google.android.gms.ads.AdRequest
import com.google.android.gms.ads.AdSize
import com.google.android.gms.ads.AdView
import com.minhphu.basemodule.R
import java.util.*

object AdUtil {
    fun showNativeAdsFbSmallInList(
        context: Context,
        nativeAdContainer: ViewGroup,
        idFbAds: String,
        idGgAd: String
    ) {
        val nativeAd = NativeBannerAd(context, idFbAds)
        nativeAd.loadAd()
        nativeAd.setAdListener(object : AdListener, NativeAdListener {
            override fun onMediaDownloaded(p0: Ad?) {}

            override fun onError(ad: Ad, error: AdError) {
                showNativeAdGgSmall(context, nativeAdContainer, idGgAd)
            }

            override fun onAdLoaded(ad: Ad) {
                val inflater = LayoutInflater.from(context)
                val adView = inflater.inflate(
                    R.layout.custom_layout_ads_fb_small,
                    nativeAdContainer,
                    false
                ) as LinearLayout
                nativeAdContainer.removeAllViews()
                nativeAdContainer.addView(adView)
                nativeAdContainer.visibility = View.VISIBLE

                nativeAd.unregisterView()
                val adChoicesContainer =
                    adView.findViewById<RelativeLayout>(R.id.ad_choices_container)
                val adChoicesView = AdChoicesView(context, nativeAd, true)
                adChoicesContainer.addView(adChoicesView, 0)

                val nativeAdIcon = adView.findViewById<AdIconView>(R.id.native_ad_icon)
                val nativeAdTitle = adView.findViewById<TextView>(R.id.native_ad_title)
                val nativeAdSocialContext =
                    adView.findViewById<TextView>(R.id.native_ad_social_context)
                val sponsoredLabel = adView.findViewById<TextView>(R.id.native_ad_sponsored_label)
                val nativeAdCallToAction =
                    adView.findViewById<TextView>(R.id.native_ad_call_to_action)

                nativeAdTitle.text = nativeAd.advertiserName
                nativeAdSocialContext.text = nativeAd.adSocialContext
                nativeAdCallToAction.visibility =
                    if (nativeAd.hasCallToAction()) View.VISIBLE else View.INVISIBLE
                nativeAdCallToAction.text = nativeAd.adCallToAction
                sponsoredLabel.text = nativeAd.sponsoredTranslation

                val clickableViews = ArrayList<View>()
                clickableViews.add(nativeAdContainer)
                clickableViews.add(nativeAdIcon)
                clickableViews.add(nativeAdTitle)
                clickableViews.add(nativeAdCallToAction)

                nativeAd.registerViewForInteraction(
                    adView,
                    nativeAdIcon,
                    clickableViews
                )

            }

            override fun onAdClicked(ad: Ad) {
            }

            override fun onLoggingImpression(ad: Ad) {}
        })
    }

    fun showNativeAdFbSmall(
        context: Context,
        nativeAdContainer: ViewGroup,
        idFbAds: String,
        idGgAd: String
    ) {
        val mNativeBannerAd = NativeBannerAd(context, idFbAds)
        mNativeBannerAd.setAdListener(object : AdListener, NativeAdListener {
            override fun onMediaDownloaded(p0: Ad?) {
            }

            override fun onError(ad: Ad, error: AdError) {
                showNativeAdGgSmall(context, nativeAdContainer, idGgAd)
            }

            override fun onAdLoaded(ad: Ad) {

                val adView = NativeBannerAdView.render(
                    context,
                    mNativeBannerAd,
                    NativeBannerAdView.Type.HEIGHT_100
                )
                nativeAdContainer.removeAllViews()
                nativeAdContainer.addView(adView)
                nativeAdContainer.visibility = View.VISIBLE
            }

            override fun onAdClicked(ad: Ad) {

            }

            override fun onLoggingImpression(ad: Ad) {

            }

        })
        mNativeBannerAd.loadAd()
    }

    fun showNativeAdFbLarge(
        context: Context,
        nativeAdContainer: ViewGroup,
        idFbAds: Int,
        idGgAd: String
    ) {
        val nativeAd = NativeAd(context, context.getString(idFbAds))
        nativeAd.setAdListener(object : AdListener, NativeAdListener {
            override fun onMediaDownloaded(p0: Ad?) {

            }

            override fun onError(ad: Ad, error: AdError) {
                showNativeAdGgLarge(context, nativeAdContainer, idGgAd)
            }

            override fun onAdLoaded(ad: Ad) {

                nativeAdContainer.visibility = View.VISIBLE
                val inflater = LayoutInflater.from(context)
                val adView = inflater.inflate(
                    R.layout.custom_native_ad_fb,
                    nativeAdContainer,
                    false
                ) as LinearLayout
                nativeAdContainer.removeAllViews()
                nativeAdContainer.addView(adView)

                val nativeAdIcon = adView.findViewById<AdIconView>(R.id.native_ad_icon)
                val nativeAdTitle = adView.findViewById<TextView>(R.id.native_ad_title)
                val nativeAdMedia = adView.findViewById<MediaView>(R.id.native_ad_media)
                val nativeAdSocialContext =
                    adView.findViewById<TextView>(R.id.native_ad_social_context)
                val nativeAdBody = adView.findViewById<TextView>(R.id.native_ad_body)
                val nativeAdCallToAction =
                    adView.findViewById<TextView>(R.id.native_ad_call_to_action)

                nativeAdTitle.text = nativeAd.advertiserName
                nativeAdSocialContext.text = nativeAd.adSocialContext
                nativeAdBody.text = nativeAd.adBodyText
                nativeAdCallToAction.text = nativeAd.adCallToAction

                val adChoicesContainer =
                    adView.findViewById<View>(R.id.ad_choices_container) as LinearLayout
                val adChoicesView = AdChoicesView(context, nativeAd, true)
                adChoicesContainer.addView(adChoicesView)

                val clickableViews = ArrayList<View>()
                clickableViews.add(nativeAdTitle)
                clickableViews.add(nativeAdCallToAction)
                nativeAd.registerViewForInteraction(
                    nativeAdContainer,
                    nativeAdMedia,
                    nativeAdIcon,
                    clickableViews
                )
            }

            override fun onAdClicked(ad: Ad) {}

            override fun onLoggingImpression(ad: Ad) {
            }
        })
        nativeAd.loadAd()
    }


    fun showNativeAdGgLarge(context: Context, nativeAdContainer: ViewGroup, idGgAd: String) {
        val adView = AdView(context)
        adView.adSize = AdSize.MEDIUM_RECTANGLE
        adView.adUnitId = idGgAd
        val adRequest = AdRequest.Builder().build()
        adView.loadAd(adRequest)
        adView.adListener = object : com.google.android.gms.ads.AdListener() {
            override fun onAdLoaded() {
                nativeAdContainer.removeAllViews()
                nativeAdContainer.addView(adView)
                nativeAdContainer.visibility = View.VISIBLE
            }
        }
    }

    private fun showNativeAdGgSmall(
        context: Context,
        nativeAdContainer: ViewGroup,
        idGgAd: String
    ) {
        val adView = AdView(context)
        adView.adSize = AdSize.LARGE_BANNER
        adView.adUnitId = idGgAd
        val adRequest = AdRequest.Builder().build()
        adView.loadAd(adRequest)
        adView.adListener = object : com.google.android.gms.ads.AdListener() {
            override fun onAdLoaded() {
                nativeAdContainer.removeAllViews()
                nativeAdContainer.addView(adView)
                nativeAdContainer.visibility = View.VISIBLE
            }
        }
    }
}
