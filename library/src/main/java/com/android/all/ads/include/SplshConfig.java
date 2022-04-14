package com.android.all.ads.include;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Bundle;
import android.util.Log;

import com.applovin.mediation.MaxAd;
import com.applovin.mediation.MaxAdListener;
import com.applovin.mediation.MaxError;
import com.applovin.mediation.ads.MaxInterstitialAd;
import com.google.ads.mediation.admob.AdMobAdapter;
import com.google.android.gms.ads.AdListener;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.FullScreenContentCallback;
import com.google.android.gms.ads.LoadAdError;
import com.google.android.gms.ads.appopen.AppOpenAd;


public class SplshConfig {
    Activity context;

    public SplshConfig(Activity context) {
        this.context = context;
    }


    public AdRequest CreateAdRequest(){
        Bundle extras = new Bundle();
        extras.putString("max_ad_content_rating", "MA");
        return  new AdRequest.Builder()
                .addNetworkExtrasBundle(AdMobAdapter.class, extras).build();
    }

    public void AdShow(Intent intent){
        if (isOnline()){
            if (Config.ADSetting(context).equals("google")){
                if (Config.OpenAdsType(context).equals("open")){
                    GoogleOpenAds(intent);
                }else {
                    GoogleInter(intent);
                }
            }else if (Config.ADSetting(context).equals("facebook")){
                Applovinmax(intent);
            }
        }else {
            intentAfterInterstitial(intent);
        }


    }


    public boolean isOnline() {
        NetworkInfo activeNetworkInfo = ((ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE)).getActiveNetworkInfo();
        return activeNetworkInfo != null && activeNetworkInfo.isConnectedOrConnecting();
    }






    void intentAfterInterstitial(Intent intent) {
        context.startActivity(intent);
        context.finish();


    }







    void Applovinmax(final Intent intent){
        final MaxInterstitialAd maxInterstitialAd  = new MaxInterstitialAd(Config.ApplovinMax(context), context );
        maxInterstitialAd.setListener(new MaxAdListener() {
            @Override
            public void onAdLoaded(MaxAd ad) {
                Log.d("AdsLog:",">>>>>>>>>>>>>>>OOO<<<<<<<<<<<<<<<<<<<<");

                if ( maxInterstitialAd.isReady() )
                {
                    maxInterstitialAd.showAd();
                }else {
                    if (Config.ADSetting(context).equals("google")){
                        intentAfterInterstitial(intent);
                    }else if (Config.ADSetting(context).equals("facebook")){
                        if (Config.OpenAdsType(context).equals("open")){
                            GoogleOpenAds(intent);
                        }else {
                            GoogleInter(intent);
                        }
                    }

                }
            }

            @Override
            public void onAdDisplayed(MaxAd ad) {
                Log.d("AdsLog:",">>>>>>>>>>>>>>>DDD<<<<<<<<<<<<<<<<<<<<");


            }

            @Override
            public void onAdHidden(MaxAd ad) {
                Log.d("AdsLog:",">>>>>>>>>>>>>>>HI<<<<<<<<<<<<<<<<<<<<");

                intentAfterInterstitial(intent);
            }

            @Override
            public void onAdClicked(MaxAd ad) {
                Log.d("AdsLog:",">>>>>>>>>>>>>>>MaxAd<<<<<<<<<<<<<<<<<<<<");


            }

            @Override
            public void onAdLoadFailed(String adUnitId, MaxError error) {
                if (Config.ADSetting(context).equals("google")){
                    intentAfterInterstitial(intent);
                }else if (Config.ADSetting(context).equals("facebook")){
                    if (Config.OpenAdsType(context).equals("open")){
                        GoogleOpenAds(intent);
                    }else {
                        GoogleInter(intent);
                    }
                }
            }

            @Override
            public void onAdDisplayFailed(MaxAd ad, MaxError error) {
                if (Config.ADSetting(context).equals("google")){
                    intentAfterInterstitial(intent);
                }else if (Config.ADSetting(context).equals("facebook")){
                    if (Config.OpenAdsType(context).equals("open")){
                        GoogleOpenAds(intent);
                    }else {
                        GoogleInter(intent);
                    }
                }
            }
        });
        maxInterstitialAd.loadAd();


    }


    void GoogleInter(final Intent intent) {
        try {
            //AdRequest build = new AdRequest.Builder().build();
            final com.google.android.gms.ads.InterstitialAd interstitialAd = new com.google.android.gms.ads.InterstitialAd(context);
            interstitialAd.setAdListener(new AdListener() {
                public void onAdOpened() {
                }

                public void onAdLoaded() {
                    if (!interstitialAd.isLoaded()) {

                        if (Config.ADSetting(context).equals("google")){

                            AdxInter(intent);
                        }else if (Config.ADSetting(context).equals("facebook")){
                            AdxInter(intent);

                        }

                    } else {
                        interstitialAd.show();
                    }
                }

                public void onAdClosed() {

                    intentAfterInterstitial(intent);
                }

                public void onAdFailedToLoad(int i) {
                    if (Config.ADSetting(context).equals("google")){

                        AdxInter(intent);
                    }else if (Config.ADSetting(context).equals("facebook")){
                        AdxInter(intent);

                    }



                }
            });
            interstitialAd.setAdUnitId(Config.AdMobInter(context));
            interstitialAd.loadAd(CreateAdRequest());

        } catch (Exception e) {
            intentAfterInterstitial(intent);
            e.printStackTrace();
        }
    }

    void AdxInter(final Intent intent) {
        try {
            //AdRequest build = new AdRequest.Builder().build();
            final com.google.android.gms.ads.InterstitialAd interstitialAd = new com.google.android.gms.ads.InterstitialAd(context);
            interstitialAd.setAdListener(new AdListener() {
                public void onAdOpened() {
                }

                public void onAdLoaded() {
                    if (!interstitialAd.isLoaded()) {

                        if (Config.ADSetting(context).equals("google")){

                            Applovinmax(intent);
                        }else if (Config.ADSetting(context).equals("facebook")){
                            intentAfterInterstitial(intent);

                        }

                    } else {
                        interstitialAd.show();
                    }
                }

                public void onAdClosed() {

                    intentAfterInterstitial(intent);
                }

                public void onAdFailedToLoad(int i) {
                    if (Config.ADSetting(context).equals("google")){

                        Applovinmax(intent);
                    }else if (Config.ADSetting(context).equals("facebook")){
                        intentAfterInterstitial(intent);

                    }



                }
            });
            interstitialAd.setAdUnitId(Config.Inter_1(context));
            interstitialAd.loadAd(CreateAdRequest());

        } catch (Exception e) {
            intentAfterInterstitial(intent);
            e.printStackTrace();
        }
    }


    void GoogleOpenAds(final Intent intent){
        try {
            AppOpenAd.load(context, Config.AdMobOpenAds(context), CreateAdRequest(), 1, new AppOpenAd.AppOpenAdLoadCallback() {
                public void onAdLoaded(AppOpenAd appOpenAd) {
                    super.onAdLoaded(appOpenAd);
                    appOpenAd.show(context);
                    appOpenAd.setFullScreenContentCallback(new FullScreenContentCallback() {

                        @Override
                        public void onAdFailedToShowFullScreenContent(com.google.android.gms.ads.AdError adError) {
                            super.onAdFailedToShowFullScreenContent(adError);
                            if (Config.ADSetting(context).equals("google")){

                                Applovinmax(intent);
                            }else if (Config.ADSetting(context).equals("facebook")){
                                intentAfterInterstitial(intent);

                            }


                        }

                        @Override // com.google.android.gms.ads.FullScreenContentCallback
                        public void onAdDismissedFullScreenContent() {
                            super.onAdDismissedFullScreenContent();
                            intentAfterInterstitial(intent);


                        }
                    });
                }

                @Override
                public void onAdFailedToLoad(LoadAdError loadAdError) {
                    super.onAdFailedToLoad(loadAdError);
                    if (Config.ADSetting(context).equals("google")){

                        Applovinmax(intent);
                    }else if (Config.ADSetting(context).equals("facebook")){
                        intentAfterInterstitial(intent);

                    }


                }
            });
        }catch (Exception e){
            intentAfterInterstitial(intent);
        }

    }

}
