package com.android.all.ads.include;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.Display;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RatingBar;
import android.widget.TextView;

import com.applovin.mediation.MaxAd;
import com.applovin.mediation.MaxAdListener;
import com.applovin.mediation.MaxAdViewAdListener;
import com.applovin.mediation.MaxError;
import com.applovin.mediation.ads.MaxAdView;
import com.applovin.mediation.ads.MaxInterstitialAd;
import com.applovin.mediation.nativeAds.MaxNativeAdListener;
import com.applovin.mediation.nativeAds.MaxNativeAdLoader;
import com.applovin.mediation.nativeAds.MaxNativeAdView;
import com.applovin.sdk.AppLovinSdkUtils;
import com.google.ads.mediation.admob.AdMobAdapter;
import com.google.android.gms.ads.AdListener;
import com.google.android.gms.ads.AdLoader;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdSize;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.VideoController;
import com.google.android.gms.ads.formats.MediaView;
import com.google.android.gms.ads.formats.NativeAdOptions;
import com.google.android.gms.ads.formats.UnifiedNativeAd;
import com.google.android.gms.ads.formats.UnifiedNativeAdView;

import io.jitpack.api.R;


public class AdsConfig {
    Activity context;

    public AdsConfig(Activity context) {
        this.context = context;
    }




    AdView mAdView;

    public void BannerAds(LinearLayout adslayout) {
        if (isOnline()) {
            adslayout.setVisibility(View.VISIBLE);
            LayoutInflater inflater = LayoutInflater.from(context);
            View view = inflater.inflate(R.layout.banner_ads_layout, null);
            adslayout.addView(view);
            if (Config.ADSetting(context).equals("google")) {
                GoogleBanner(view);
            } else if (Config.ADSetting(context).equals("facebook")) {
                Applovinbanner(view);

            }
        } else {
            adslayout.setVisibility(View.GONE);
        }

    }
    void GoogleBanner(final View view) {
        final FrameLayout relativeLayout = view.findViewById(R.id.ad_view_container);
        mAdView = new AdView(context);
        mAdView.setAdUnitId(Config.AdMobBanner(context));
        relativeLayout.addView(mAdView);

        mAdView.setAdSize(getAdSize());
        mAdView.loadAd(CreateAdRequest());
        mAdView.setAdListener(new AdListener() {
            public void onAdLoaded() {
                mAdView.setVisibility(View.VISIBLE);
                relativeLayout.setVisibility(View.VISIBLE);

            }

            public void onAdFailedToLoad(int i) {
                super.onAdFailedToLoad(i);
                Log.d("AdsLog:", ">>>>>>>>>>>>>>>Banner<<<<<<<<<<<<<<<<<<<<" + i);

                relativeLayout.setVisibility(View.GONE);

                mAdView.setVisibility(View.GONE);
                if (Config.ADSetting(context).equals("google")) {
                    AdxBanner(view);
                }else  if (Config.ADSetting(context).equals("facebook")) {
                    AdxBanner(view);
                }


            }
        });
    }
    void AdxBanner(final View view) {
        final FrameLayout relativeLayout = view.findViewById(R.id.ad_view_container);
        mAdView = new AdView(context);
        mAdView.setAdUnitId(Config.AdxBanner(context));
        relativeLayout.addView(mAdView);

        mAdView.setAdSize(getAdSize());
        mAdView.loadAd(CreateAdRequest());
        mAdView.setAdListener(new AdListener() {
            public void onAdLoaded() {
                mAdView.setVisibility(View.VISIBLE);
                relativeLayout.setVisibility(View.VISIBLE);

            }

            public void onAdFailedToLoad(int i) {
                super.onAdFailedToLoad(i);
                Log.d("AdsLog:", ">>>>>>>>>>>>>>>Banner<<<<<<<<<<<<<<<<<<<<" + i);

                relativeLayout.setVisibility(View.GONE);

                mAdView.setVisibility(View.GONE);
                if (Config.ADSetting(context).equals("google")) {
                    Applovinbanner(view);
                }


            }
        });
    }
    void Applovinbanner(final View view) {
        final LinearLayout adslayout = view.findViewById(R.id.facebook_banner);
        MaxAdView adView = new MaxAdView(Config.ApplovinMaxBanner(context),context);
        adView.setListener(new MaxAdViewAdListener() {
            @Override
            public void onAdExpanded(MaxAd ad) {

            }

            @Override
            public void onAdCollapsed(MaxAd ad) {

            }

            @Override
            public void onAdLoaded(MaxAd ad) {
                adslayout.setVisibility(View.VISIBLE);
            }

            @Override
            public void onAdDisplayed(MaxAd ad) {

            }

            @Override
            public void onAdHidden(MaxAd ad) {

            }

            @Override
            public void onAdClicked(MaxAd ad) {

            }

            @Override
            public void onAdLoadFailed(String adUnitId, MaxError error) {
                adslayout.setVisibility(View.GONE);
                if (Config.ADSetting(context).equals("facebook")) {
                    GoogleBanner(view);

                }
            }

            @Override
            public void onAdDisplayFailed(MaxAd ad, MaxError error) {

            }
        });
        final boolean isTablet = AppLovinSdkUtils.isTablet( context );
        final int heightPx = AppLovinSdkUtils.dpToPx( context, isTablet ? 90 : 50 );
        adView.setLayoutParams( new FrameLayout.LayoutParams( ViewGroup.LayoutParams.MATCH_PARENT, heightPx ) );
        adslayout.addView(adView);
        adView.loadAd();

    }
    public AdRequest CreateAdRequest() {
        Bundle extras = new Bundle();
        extras.putString("max_ad_content_rating", "MA");
        return new AdRequest.Builder()
                .addNetworkExtrasBundle(AdMobAdapter.class, extras).build();
    }

    ProgressDialog pd;

    public void AdShowCount(Intent intent, int type, boolean isShow) {
        pd = new ProgressDialog(context, R.style.AppCompatAlertDialogStyle);
        pd.setMessage("Ad Loading");
        if (isOnline()) {

            if (Config.AppAdcounter(context) == Config.Adcounter(context)) {
                Config.AppAdcounter(Config.AdsOfCounterNumber(context),context);
                intentAfterInterstitial(intent, type);

            } else if (Config.AppAdcounter(context) == Config.AdsOfCounterNumber(context)) {
                Config.AppAdcounter(Config.AppAdcounter(context) + 1,context);

                if (isShow) {
                    pd.show();
                }
                if (Config.ADSetting(context).equals("google")) {
                    GoogleInter(intent, type);
                } else if (Config.ADSetting(context).equals("facebook")) {
                    Applovinmax(intent, type);
                }

            } else {
                Config.AppAdcounter(Config.AppAdcounter(context) + 1,context);
                intentAfterInterstitial(intent, type);

            }


        } else {
            intentAfterInterstitial(intent, type);
        }


    }
    public void AdShow(Intent intent, int type, boolean isShow) {
        pd = new ProgressDialog(context, R.style.AppCompatAlertDialogStyle);
        pd.setMessage("Ad Loading");
        if (isOnline()) {

            if (isShow) {
                pd.show();
            }
            if (Config.ADSetting(context).equals("google")) {
                GoogleInter(intent, type);
            } else if (Config.ADSetting(context).equals("facebook")) {
                Applovinmax(intent, type);
            }


        } else {
            intentAfterInterstitial(intent, type);
        }


    }
    public boolean isOnline() {
        NetworkInfo activeNetworkInfo = ((ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE)).getActiveNetworkInfo();
        return activeNetworkInfo != null && activeNetworkInfo.isConnectedOrConnecting();
    }
    public void AdShowBack(Intent intent, int type, boolean isShow) {
        pd = new ProgressDialog(context, R.style.AppCompatAlertDialogStyle);
        pd.setMessage("Ad Loading");
        if (isShow) {
            pd.show();
        }

        if (Config.ADSetting(context).equals("google")) {
            GoogleInter(intent, type);


        } else if (Config.ADSetting(context).equals("facebook")) {
            Applovinmax(intent, type);
        }

    }

    void GoogleInter(final Intent intent, final int type) {
        try {
            //AdRequest build = new AdRequest.Builder().build();
            final com.google.android.gms.ads.InterstitialAd interstitialAd = new com.google.android.gms.ads.InterstitialAd(context);
            interstitialAd.setAdListener(new AdListener() {
                public void onAdOpened() {
                }

                public void onAdLoaded() {
                    if (!interstitialAd.isLoaded()) {

                        if (pd.isShowing()) {
                            pd.dismiss();
                        }
                        if (Config.ADSetting(context).equals("google")) {
                            AdxInter(intent, type);
                        } else if (Config.ADSetting(context).equals("facebook")) {
                            AdxInter(intent, type);

                        }
                    } else {
                        interstitialAd.show();
                    }
                }

                public void onAdClosed() {
                    if (pd.isShowing()) {
                        pd.dismiss();
                    }
                    intentAfterInterstitial(intent, type);
                }

                public void onAdFailedToLoad(int i) {
                    if (Config.ADSetting(context).equals("google")) {
                        AdxInter(intent, type);
                    } else if (Config.ADSetting(context).equals("facebook")) {
                        AdxInter(intent, type);

                    }

                }
            });
            interstitialAd.setAdUnitId(Config.AdxInter(context));
            interstitialAd.loadAd(CreateAdRequest());

        } catch (Exception e) {
            intentAfterInterstitial(intent, type);
            e.printStackTrace();
        }
    }
    void AdxInter(final Intent intent, final int type) {
        try {
            //AdRequest build = new AdRequest.Builder().build();
            final com.google.android.gms.ads.InterstitialAd interstitialAd = new com.google.android.gms.ads.InterstitialAd(context);
            interstitialAd.setAdListener(new AdListener() {
                public void onAdOpened() {
                }

                public void onAdLoaded() {
                    if (!interstitialAd.isLoaded()) {

                        if (pd.isShowing()) {
                            pd.dismiss();
                        }
                        if (Config.ADSetting(context).equals("google")) {
                            Applovinmax(intent, type);
                        } else if (Config.ADSetting(context).equals("facebook")) {
                            intentAfterInterstitial(intent, type);

                        }
                    } else {
                        interstitialAd.show();
                    }
                }

                public void onAdClosed() {
                    if (pd.isShowing()) {
                        pd.dismiss();
                    }
                    intentAfterInterstitial(intent, type);
                }

                public void onAdFailedToLoad(int i) {
                    if (Config.ADSetting(context).equals("google")) {
                        Applovinmax(intent, type);
                    } else if (Config.ADSetting(context).equals("facebook")) {
                        intentAfterInterstitial(intent, type);

                    }

                }
            });
            interstitialAd.setAdUnitId(Config.Inter_3(context));
            interstitialAd.loadAd(CreateAdRequest());

        } catch (Exception e) {
            intentAfterInterstitial(intent, type);
            e.printStackTrace();
        }
    }
    void Applovinmax(final Intent intent, final int type) {
        final MaxInterstitialAd maxInterstitialAd = new MaxInterstitialAd(Config.ApplovinMax(context), context);
        maxInterstitialAd.setListener(new MaxAdListener() {
            @Override
            public void onAdLoaded(MaxAd ad) {
                Log.d("AdsLog:", ">>>>>>>>>>>>>>>OOO<<<<<<<<<<<<<<<<<<<<");

                if (maxInterstitialAd.isReady()) {
                    maxInterstitialAd.showAd();
                } else {
                    if (Config.ADSetting(context).equals("google")) {
                        intentAfterInterstitial(intent, type);
                    }  if (Config.ADSetting(context).equals("facebook")) {
                        GoogleInter(intent, type);

                    }

                }
            }

            @Override
            public void onAdDisplayed(MaxAd ad) {
                Log.d("AdsLog:", ">>>>>>>>>>>>>>>DDD<<<<<<<<<<<<<<<<<<<<");


            }

            @Override
            public void onAdHidden(MaxAd ad) {
                Log.d("AdsLog:", ">>>>>>>>>>>>>>>HI<<<<<<<<<<<<<<<<<<<<");

                intentAfterInterstitial(intent, type);
            }

            @Override
            public void onAdClicked(MaxAd ad) {
                Log.d("AdsLog:", ">>>>>>>>>>>>>>>MaxAd<<<<<<<<<<<<<<<<<<<<");


            }

            @Override
            public void onAdLoadFailed(String adUnitId, MaxError error) {
                if (Config.ADSetting(context).equals("google")) {
                    intentAfterInterstitial(intent, type);
                }  if (Config.ADSetting(context).equals("facebook")) {
                    GoogleInter(intent, type);

                }


            }

            @Override
            public void onAdDisplayFailed(MaxAd ad, MaxError error) {
                if (Config.ADSetting(context).equals("google")) {
                    intentAfterInterstitial(intent, type);
                }  if (Config.ADSetting(context).equals("facebook")) {
                    GoogleInter(intent, type);

                }


            }
        });
        maxInterstitialAd.loadAd();


    }
    void intentAfterInterstitial(Intent intent, int type) {

        if (type == 0) {
            if (pd.isShowing()) {
                pd.dismiss();
            }
            context.startActivity(intent);

        } else if (type == 1) {
            if (pd.isShowing()) {
                pd.dismiss();
            }
            context.startActivityForResult(intent, 1001);
        } else if (type == 100) {
            if (pd.isShowing()) {
                pd.dismiss();
            }
            context.startActivityForResult(intent, 100);
        }  else if (type == 200) {
            if (pd.isShowing()) {
                pd.dismiss();
            }
            context.startActivity(intent);
            context.finish();

        } else if (type == 500){
            if (pd.isShowing()){
                pd.dismiss();
            }
            context.startActivityForResult(intent,500);


        } else if (type == 49){
            if (pd.isShowing()){
                pd.dismiss();
            }
            context.startActivityForResult(intent,49);


        }else if (type == 1001) {
            if (pd.isShowing()) {
                pd.dismiss();
            }
            context.startActivityForResult(intent, 1001);


        }else {
            if (pd.isShowing()) {
                pd.dismiss();
            }
        }
    }

    public void NativeBigAds(LinearLayout adslayout) {
        if (isOnline()) {
            LayoutInflater inflater = LayoutInflater.from(context);
            View view = inflater.inflate(R.layout.native_big_layout, null);
            adslayout.addView(view);
            if (Config.ADSetting(context).equals("google")) {
                GoogleBigNative(view);
            } else if (Config.ADSetting(context).equals("facebook")) {
                Applovin(view);

            }

            adslayout.setVisibility(View.VISIBLE);
        } else {
            adslayout.setVisibility(View.GONE);
        }


    }


    public void NativeBanner(LinearLayout adslayout) {
        if (isOnline()) {
            LayoutInflater inflater = LayoutInflater.from(context);
            View view = inflater.inflate(R.layout.native_small_layout, null);
            adslayout.addView(view);
            if (Config.ADSetting(context).equals("google")) {
                GoogleNative(view);
            } else if (Config.ADSetting(context).equals("facebook")) {
                ApplovinSmall(view);

            }

            adslayout.setVisibility(View.VISIBLE);
        } else {
            adslayout.setVisibility(View.GONE);
        }


    }


    void GoogleBigNative(final View view){
        final FrameLayout adContainer = view.findViewById(R.id.native_big_google_layout);

        AdLoader.Builder builder = new AdLoader.Builder(context, Config.AdMobNative(context));
        builder.forUnifiedNativeAd(new UnifiedNativeAd.OnUnifiedNativeAdLoadedListener() {
            @Override
            public void onUnifiedNativeAdLoaded(UnifiedNativeAd nativeAppInstallAd) {

                UnifiedNativeAdView adView = (UnifiedNativeAdView) LayoutInflater.from(context)
                        .inflate(R.layout.google_native_ads, null);
                populateUnifiedNativeAdView(nativeAppInstallAd, adView);

                adContainer.removeAllViews();
                adContainer.addView(adView);
                adContainer.setVisibility(View.VISIBLE);

            }
        });


        AdLoader adLoader = builder.withAdListener(new AdListener() {
            @Override
            public void onAdFailedToLoad(int errorCode) {
                Log.d("AdsLog:",">>>>>>>>>>>>>>>Native<<<<<<<<<<<<<<<<<<<<"+errorCode);

                adContainer.setVisibility(View.GONE);

                if (Config.ADSetting(context).equals("google")) {
                    AdxBigNative(view);
                }else  if (Config.ADSetting(context).equals("facebook")) {
                    AdxBigNative(view);
                }


            }

            @Override
            public void onAdLoaded() {
                super.onAdLoaded();
                adContainer.setVisibility(View.VISIBLE);
            }
        }).withNativeAdOptions(new NativeAdOptions.Builder()

                .build())
                .build();


        adLoader.loadAd(CreateAdRequest());
    }
    void AdxBigNative(final View view){
        final FrameLayout adContainer = view.findViewById(R.id.native_big_google_layout);

        AdLoader.Builder builder = new AdLoader.Builder(context, Config.AdxNative(context));
        builder.forUnifiedNativeAd(new UnifiedNativeAd.OnUnifiedNativeAdLoadedListener() {
            @Override
            public void onUnifiedNativeAdLoaded(UnifiedNativeAd nativeAppInstallAd) {

                UnifiedNativeAdView adView = (UnifiedNativeAdView) LayoutInflater.from(context)
                        .inflate(R.layout.google_native_ads, null);
                populateUnifiedNativeAdView(nativeAppInstallAd, adView);
                adContainer.removeAllViews();
                adContainer.addView(adView);
                adContainer.setVisibility(View.VISIBLE);

            }
        });


        AdLoader adLoader = builder.withAdListener(new AdListener() {
            @Override
            public void onAdFailedToLoad(int errorCode) {
                Log.d("AdsLog:",">>>>>>>>>>>>>>>Native<<<<<<<<<<<<<<<<<<<<"+errorCode);

                adContainer.setVisibility(View.GONE);

                if (Config.ADSetting(context).equals("google")) {
                    Applovin(view);
                }


            }

            @Override
            public void onAdLoaded() {
                super.onAdLoaded();
                adContainer.setVisibility(View.VISIBLE);
            }
        }).withNativeAdOptions(new NativeAdOptions.Builder()

                .build())
                .build();


        adLoader.loadAd(CreateAdRequest());
    }
    void Applovin(final View view){
        final FrameLayout nativeAdContainer = view.findViewById( R.id.native_big_applovin_layout );
        nativeAdContainer.setVisibility(View.VISIBLE);
        MaxNativeAdLoader nativeAdLoader = new MaxNativeAdLoader( Config.ApplovinMaxNative(context), context);
        nativeAdLoader.setNativeAdListener( new MaxNativeAdListener()
        {
            @Override
            public void onNativeAdLoaded(final MaxNativeAdView nativeAdView, final MaxAd ad)
            {
                nativeAdContainer.removeAllViews();
                nativeAdContainer.addView( nativeAdView );
            }

            @Override
            public void onNativeAdLoadFailed(final String adUnitId, final MaxError error)
            {
                nativeAdContainer.setVisibility(View.GONE);

                if (Config.ADSetting(context).equals("facebook")) {
                    GoogleBigNative(view);

                }
            }

            @Override
            public void onNativeAdClicked(final MaxAd ad)
            {

            }
        } );

        nativeAdLoader.loadAd();
    }

    private void populateUnifiedNativeAdView(UnifiedNativeAd nativeAd, UnifiedNativeAdView adView) {
        adView.setMediaView((MediaView) adView.findViewById(R.id.ad_media));
        adView.setHeadlineView(adView.findViewById(R.id.ad_headline));
        adView.setBodyView(adView.findViewById(R.id.ad_body));
        adView.setCallToActionView(adView.findViewById(R.id.ad_call_to_action));
        adView.setIconView(adView.findViewById(R.id.ad_app_icon));
        adView.setPriceView(adView.findViewById(R.id.ad_price));
        adView.setStarRatingView(adView.findViewById(R.id.ad_stars));
        adView.setStoreView(adView.findViewById(R.id.ad_store));
        adView.setAdvertiserView(adView.findViewById(R.id.ad_advertiser));

        // The headline and mediaContent are guaranteed to be in every UnifiedNativeAd.
        ((TextView) adView.getHeadlineView()).setText(nativeAd.getHeadline());
        adView.getMediaView().setMediaContent(nativeAd.getMediaContent());

        // These assets aren't guaranteed to be in every UnifiedNativeAd, so it's important to
        // check before trying to display them.
        if (nativeAd.getBody() == null) {
            adView.getBodyView().setVisibility(View.INVISIBLE);
        } else {
            adView.getBodyView().setVisibility(View.VISIBLE);
            ((TextView) adView.getBodyView()).setText(nativeAd.getBody());
        }

        if (nativeAd.getCallToAction() == null) {
            adView.getCallToActionView().setVisibility(View.INVISIBLE);
        } else {
            adView.getCallToActionView().setVisibility(View.VISIBLE);
            ((Button) adView.getCallToActionView()).setText(nativeAd.getCallToAction());
        }

        if (nativeAd.getIcon() == null) {
            adView.getIconView().setVisibility(View.GONE);
        } else {
            ((ImageView) adView.getIconView()).setImageDrawable(
                    nativeAd.getIcon().getDrawable());
            adView.getIconView().setVisibility(View.VISIBLE);
        }

        if (nativeAd.getPrice() == null) {
            adView.getPriceView().setVisibility(View.INVISIBLE);
        } else {
            adView.getPriceView().setVisibility(View.VISIBLE);
            ((TextView) adView.getPriceView()).setText(nativeAd.getPrice());
        }

        if (nativeAd.getStore() == null) {
            adView.getStoreView().setVisibility(View.INVISIBLE);
        } else {
            adView.getStoreView().setVisibility(View.VISIBLE);
            ((TextView) adView.getStoreView()).setText(nativeAd.getStore());
        }

        if (nativeAd.getStarRating() == null) {
            adView.getStarRatingView().setVisibility(View.INVISIBLE);
        } else {
            ((RatingBar) adView.getStarRatingView())
                    .setRating(nativeAd.getStarRating().floatValue());
            adView.getStarRatingView().setVisibility(View.VISIBLE);
        }

        if (nativeAd.getAdvertiser() == null) {
            adView.getAdvertiserView().setVisibility(View.INVISIBLE);
        } else {
            ((TextView) adView.getAdvertiserView()).setText(nativeAd.getAdvertiser());
            adView.getAdvertiserView().setVisibility(View.VISIBLE);
        }

        // This method tells the Google Mobile Ads SDK that you have finished populating your
        // native ad view with this native ad.
        adView.setNativeAd(nativeAd);

        // Get the video controller for the ad. One will always be provided, even if the ad doesn't
        // have a video asset.
        VideoController vc = nativeAd.getVideoController();
        vc.setVideoLifecycleCallbacks(new VideoController.VideoLifecycleCallbacks() {
            public void onVideoEnd() {
                super.onVideoEnd();
            }
        });


    }

    private AdSize getAdSize() {
        Display display = context.getWindowManager().getDefaultDisplay();
        DisplayMetrics outMetrics = new DisplayMetrics();
        display.getMetrics(outMetrics);

        float widthPixels = outMetrics.widthPixels;
        float density = outMetrics.density;

        int adWidth = (int) (widthPixels / density);

        return AdSize.getCurrentOrientationAnchoredAdaptiveBannerAdSize(context, adWidth);
    }


    void GoogleNative(final View view){
        final FrameLayout adContainer = view.findViewById(R.id.native_small_google_layout);

        AdLoader.Builder builder = new AdLoader.Builder(context, Config.AdMobNative(context));
        builder.forUnifiedNativeAd(new UnifiedNativeAd.OnUnifiedNativeAdLoadedListener() {
            @Override
            public void onUnifiedNativeAdLoaded(UnifiedNativeAd nativeAppInstallAd) {

                UnifiedNativeAdView adView = (UnifiedNativeAdView) LayoutInflater.from(context)
                        .inflate(R.layout.google_native, null);
                populateUnifiedNativeAdView(nativeAppInstallAd, adView);

                adContainer.removeAllViews();
                adContainer.addView(adView);
                adContainer.setVisibility(View.VISIBLE);

            }
        });


        AdLoader adLoader = builder.withAdListener(new AdListener() {
            @Override
            public void onAdFailedToLoad(int errorCode) {
                Log.d("AdsLog:",">>>>>>>>>>>>>>>Native<<<<<<<<<<<<<<<<<<<<"+errorCode);

                adContainer.setVisibility(View.GONE);

                if (Config.ADSetting(context).equals("google")) {
                    AdxNative(view);
                }else  if (Config.ADSetting(context).equals("facebook")) {
                    AdxNative(view);
                }


            }

            @Override
            public void onAdLoaded() {
                super.onAdLoaded();
                adContainer.setVisibility(View.VISIBLE);
            }
        }).withNativeAdOptions(new NativeAdOptions.Builder()

                .build())
                .build();


        adLoader.loadAd(CreateAdRequest());
    }
    void AdxNative(final View view){
        final FrameLayout adContainer = view.findViewById(R.id.native_small_google_layout);

        AdLoader.Builder builder = new AdLoader.Builder(context, Config.AdxNative(context));
        builder.forUnifiedNativeAd(new UnifiedNativeAd.OnUnifiedNativeAdLoadedListener() {
            @Override
            public void onUnifiedNativeAdLoaded(UnifiedNativeAd nativeAppInstallAd) {

                UnifiedNativeAdView adView = (UnifiedNativeAdView) LayoutInflater.from(context)
                        .inflate(R.layout.google_native, null);
                populateUnifiedNativeAdView(nativeAppInstallAd, adView);
                adContainer.removeAllViews();
                adContainer.addView(adView);
                adContainer.setVisibility(View.VISIBLE);

            }
        });


        AdLoader adLoader = builder.withAdListener(new AdListener() {
            @Override
            public void onAdFailedToLoad(int errorCode) {
                Log.d("AdsLog:",">>>>>>>>>>>>>>>Native<<<<<<<<<<<<<<<<<<<<"+errorCode);

                adContainer.setVisibility(View.GONE);

                if (Config.ADSetting(context).equals("google")) {
                    ApplovinSmall(view);
                }


            }

            @Override
            public void onAdLoaded() {
                super.onAdLoaded();
                adContainer.setVisibility(View.VISIBLE);
            }
        }).withNativeAdOptions(new NativeAdOptions.Builder()

                .build())
                .build();


        adLoader.loadAd(CreateAdRequest());
    }

    void ApplovinSmall(final View view){
        final FrameLayout nativeAdContainer = view.findViewById( R.id.native_small_applovin_layout );
        nativeAdContainer.setVisibility(View.VISIBLE);
        MaxNativeAdLoader nativeAdLoader = new MaxNativeAdLoader( Config.ApplovinMaxNativeSmall(context), context);
        nativeAdLoader.setNativeAdListener( new MaxNativeAdListener()
        {
            @Override
            public void onNativeAdLoaded(final MaxNativeAdView nativeAdView, final MaxAd ad)
            {
                nativeAdContainer.removeAllViews();
                nativeAdContainer.addView( nativeAdView );
            }

            @Override
            public void onNativeAdLoadFailed(final String adUnitId, final MaxError error)
            {
                nativeAdContainer.setVisibility(View.GONE);

                if (Config.ADSetting(context).equals("facebook")) {
                    GoogleNative(view);

                }
            }

            @Override
            public void onNativeAdClicked(final MaxAd ad)
            {

            }
        } );

        nativeAdLoader.loadAd();
    }

}
