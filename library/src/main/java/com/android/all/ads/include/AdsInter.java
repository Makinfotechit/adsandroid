package com.android.all.ads.include;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Context;
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

import io.jitpack.api.R;

public class AdsInter {
    Activity context;
    public AdsInter(Activity context) {
        this.context = context;
    }
    ProgressDialog pd;
    void GoogleInter() {
        try {

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
                            AdxInter();
                        } else if (Config.ADSetting(context).equals("facebook")) {
                            AdxInter();


                        }
                    } else {
                        interstitialAd.show();
                    }
                }

                public void onAdClosed() {
                    if (pd.isShowing()) {
                        pd.dismiss();
                    }
                    intentAfterInterstitial();
                }

                public void onAdFailedToLoad(int i) {
                    if (pd.isShowing()) {
                        pd.dismiss();
                    }
                    if (Config.ADSetting(context).equals("google")) {
                        AdxInter();
                    } else if (Config.ADSetting(context).equals("facebook")) {
                        AdxInter();


                    }


                }
            });
            interstitialAd.setAdUnitId(Config.AdxInter(context));
            interstitialAd.loadAd(CreateAdRequest());

        } catch (Exception e) {
            intentAfterInterstitial();
            e.printStackTrace();
        }
    }
    void AdxInter() {
        try {

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
                            Applovinmax();
                        } else if (Config.ADSetting(context).equals("facebook")) {
                            intentAfterInterstitial();

                        }
                    } else {
                        interstitialAd.show();
                    }
                }

                public void onAdClosed() {
                    if (pd.isShowing()) {
                        pd.dismiss();
                    }
                    intentAfterInterstitial();
                }

                public void onAdFailedToLoad(int i) {
                    if (pd.isShowing()) {
                        pd.dismiss();
                    }
                    if (Config.ADSetting(context).equals("google")) {
                        Applovinmax();
                    } else if (Config.ADSetting(context).equals("facebook")) {
                        intentAfterInterstitial();

                    }


                }
            });
            interstitialAd.setAdUnitId(Config.Inter_2(context));
            interstitialAd.loadAd(CreateAdRequest());

        } catch (Exception e) {
            intentAfterInterstitial();
            e.printStackTrace();
        }
    }

    void Applovinmax() {
        final MaxInterstitialAd maxInterstitialAd = new MaxInterstitialAd(Config.ApplovinMax(context), context);
        maxInterstitialAd.setListener(new MaxAdListener() {
            @Override
            public void onAdLoaded(MaxAd ad) {
                Log.d("AdsLog:", ">>>>>>>>>>>>>>>OOO<<<<<<<<<<<<<<<<<<<<");

                if (maxInterstitialAd.isReady()) {
                    maxInterstitialAd.showAd();
                } else {
                    if (Config.ADSetting(context).equals("google")) {
                        intentAfterInterstitial();
                    } else if (Config.ADSetting(context).equals("facebook")) {
                        GoogleInter();

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

                intentAfterInterstitial();
            }

            @Override
            public void onAdClicked(MaxAd ad) {


            }

            @Override
            public void onAdLoadFailed(String adUnitId, MaxError error) {
                if (Config.ADSetting(context).equals("google")) {
                    intentAfterInterstitial();
                } else if (Config.ADSetting(context).equals("facebook")) {
                    GoogleInter();

                }


            }

            @Override
            public void onAdDisplayFailed(MaxAd ad, MaxError error) {
                if (Config.ADSetting(context).equals("google")) {
                    intentAfterInterstitial();
                } else if (Config.ADSetting(context).equals("facebook")) {
                    GoogleInter();

                }


            }
        });
        maxInterstitialAd.loadAd();


    }


    void intentAfterInterstitial() {
        if (pd.isShowing()) {
            pd.dismiss();
        }
    }
    public AdRequest CreateAdRequest() {
        Bundle extras = new Bundle();
        extras.putString("max_ad_content_rating", "MA");
        return new AdRequest.Builder()
                .addNetworkExtrasBundle(AdMobAdapter.class, extras).build();
    }

    public void AdShow() {
        pd = new ProgressDialog(context, R.style.AppCompatAlertDialogStyle);
        pd.setMessage("Ad Loading");
        if (isOnline()){
            if (Config.AppAdcounter(context) == Config.Adcounter(context)) {
                Config.AppAdcounter(Config.AdsOfCounterNumber(context),context);

            } else if (Config.AppAdcounter(context) == Config.AdsOfCounterNumber(context)) {
                Config.AppAdcounter(Config.AppAdcounter(context) + 1,context);
                pd.show();

                if (Config.ADSetting(context).equals("google")) {
                    GoogleInter();
                } else if (Config.ADSetting(context).equals("facebook")) {
                    Applovinmax();
                }

            } else {
                Config.AppAdcounter(Config.AppAdcounter(context) + 1,context);
                intentAfterInterstitial();

            }
        }else {
            intentAfterInterstitial();

        }


    }


    public boolean isOnline() {
        NetworkInfo activeNetworkInfo = ((ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE)).getActiveNetworkInfo();
        return activeNetworkInfo != null && activeNetworkInfo.isConnectedOrConnecting();
    }

}
