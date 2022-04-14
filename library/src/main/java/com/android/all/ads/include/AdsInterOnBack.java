package com.android.all.ads.include;

import android.app.Activity;
import android.app.ProgressDialog;
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

import io.jitpack.api.R;

public class AdsInterOnBack {
    Activity context;
    public AdsInterOnBack(Activity context) {
        this.context = context;
    }
    ProgressDialog pd;
    void GoogleInter(final Intent intent) {
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
                            AdxInter(intent);
                        } else if (Config.ADSetting(context).equals("facebook")) {
                            AdxInter(intent);


                        }
                    } else {
                        interstitialAd.show();
                    }
                }

                public void onAdClosed() {
                    if (pd.isShowing()) {
                        pd.dismiss();
                    }
                    intentAfterInterstitial(intent);
                }

                public void onAdFailedToLoad(int i) {
                    if (pd.isShowing()) {
                        pd.dismiss();
                    }
                    if (Config.ADSetting(context).equals("google")) {
                        AdxInter(intent);
                    } else if (Config.ADSetting(context).equals("facebook")) {
                        AdxInter(intent);


                    }


                }
            });
            interstitialAd.setAdUnitId(Config.AppnextInter(context));
            interstitialAd.loadAd(CreateAdRequest());

        } catch (Exception e) {
            intentAfterInterstitial(intent);
            e.printStackTrace();
        }
    }
    void AdxInter(final Intent intent) {
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
                            Applovinmax(intent);
                        } else if (Config.ADSetting(context).equals("facebook")) {
                            intentAfterInterstitial(intent);

                        }
                    } else {
                        interstitialAd.show();
                    }
                }

                public void onAdClosed() {
                    if (pd.isShowing()) {
                        pd.dismiss();
                    }
                    intentAfterInterstitial(intent);
                }

                public void onAdFailedToLoad(int i) {
                    if (pd.isShowing()) {
                        pd.dismiss();
                    }
                    if (Config.ADSetting(context).equals("google")) {
                        Applovinmax(intent);
                    } else if (Config.ADSetting(context).equals("facebook")) {
                        intentAfterInterstitial(intent);

                    }


                }
            });
            interstitialAd.setAdUnitId(Config.Inter_3(context));
            interstitialAd.loadAd(CreateAdRequest());

        } catch (Exception e) {
            intentAfterInterstitial(intent);
            e.printStackTrace();
        }
    }

    void Applovinmax(final Intent intent) {
        final MaxInterstitialAd maxInterstitialAd = new MaxInterstitialAd(Config.ApplovinMax(context), context);
        maxInterstitialAd.setListener(new MaxAdListener() {
            @Override
            public void onAdLoaded(MaxAd ad) {
                Log.d("AdsLog:", ">>>>>>>>>>>>>>>OOO<<<<<<<<<<<<<<<<<<<<");

                if (maxInterstitialAd.isReady()) {
                    maxInterstitialAd.showAd();
                } else {
                    if (Config.ADSetting(context).equals("google")) {
                        intentAfterInterstitial(intent);
                    } else if (Config.ADSetting(context).equals("facebook")) {
                        GoogleInter(intent);

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

                intentAfterInterstitial(intent);
            }

            @Override
            public void onAdClicked(MaxAd ad) {


            }

            @Override
            public void onAdLoadFailed(String adUnitId, MaxError error) {
                if (Config.ADSetting(context).equals("google")) {
                    intentAfterInterstitial(intent);
                } else if (Config.ADSetting(context).equals("facebook")) {
                    GoogleInter(intent);

                }


            }

            @Override
            public void onAdDisplayFailed(MaxAd ad, MaxError error) {
                if (Config.ADSetting(context).equals("google")) {
                    intentAfterInterstitial(intent);
                } else if (Config.ADSetting(context).equals("facebook")) {
                    GoogleInter(intent);

                }


            }
        });
        maxInterstitialAd.loadAd();


    }


    void intentAfterInterstitial(Intent intent) {
        if (pd.isShowing()) {
            pd.dismiss();
        }
        context.startActivity(intent);
    }
    public AdRequest CreateAdRequest() {
        Bundle extras = new Bundle();
        extras.putString("max_ad_content_rating", "MA");
        return new AdRequest.Builder()
                .addNetworkExtrasBundle(AdMobAdapter.class, extras).build();
    }

    public void AdShow(Intent intent) {
        pd = new ProgressDialog(context, R.style.AppCompatAlertDialogStyle);
        pd.setMessage("Ad Loading");
        if (isOnline()){
            if (Config.AppAdcounter(context) == Config.Adcounter(context)) {
                Config.AppAdcounter(Config.AdsOfCounterNumber(context),context);

            } else if (Config.AppAdcounter(context) == Config.AdsOfCounterNumber(context)) {
                Config.AppAdcounter(Config.AppAdcounter(context) + 1,context);
                pd.show();

                if (Config.ADSetting(context).equals("google")) {
                    GoogleInter(intent);
                } else if (Config.ADSetting(context).equals("facebook")) {
                    Applovinmax(intent);
                }

            } else {
                Config.AppAdcounter(Config.AppAdcounter(context) + 1,context);
                intentAfterInterstitial(intent);

            }
        }else {
            intentAfterInterstitial(intent);

        }


    }


    public boolean isOnline() {
        NetworkInfo activeNetworkInfo = ((ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE)).getActiveNetworkInfo();
        return activeNetworkInfo != null && activeNetworkInfo.isConnectedOrConnecting();
    }

}
