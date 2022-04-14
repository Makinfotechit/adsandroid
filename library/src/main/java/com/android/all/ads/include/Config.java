
package com.android.all.ads.include;

import android.app.Activity;
import android.app.Application;
import android.content.Context;
import android.content.SharedPreferences;

import com.applovin.sdk.AppLovinSdk;
import com.applovin.sdk.AppLovinSdkConfiguration;
import com.facebook.ads.AudienceNetworkAds;
import com.google.android.gms.ads.MobileAds;


public class Config {


    public final static String PREFS_NAME = "appname_prefs";

















    // admob



    public static void AdMobInter(String id, Context context) {
        SharedPreferences prefs = context.getSharedPreferences(PREFS_NAME,0);
        SharedPreferences.Editor editor = prefs.edit();
        editor.putString("AdMobInter", id).commit();
        editor.apply();


    }

    public static String AdMobInter(Context context) {
        SharedPreferences prefs = context.getSharedPreferences(PREFS_NAME, 0);
        return prefs.getString("AdMobInter", "ca-app-pub-3940256099942544/1033173712");
    }


    public static void AdMobBanner(String id, Context context) {
        SharedPreferences prefs = context.getSharedPreferences(PREFS_NAME,0);
        SharedPreferences.Editor editor = prefs.edit();
        editor.putString("AdMobBanner", id).commit();
        editor.apply();

    }

    public static String AdMobBanner(Context context) {
        SharedPreferences sharedPreferences = context.getSharedPreferences(PREFS_NAME, 0);

        return sharedPreferences.getString("AdMobBanner", "ca-app-pub-3940256099942544/6300978111");
    }

    public static void AdMobNative(String id, Context context) {
        SharedPreferences prefs = context.getSharedPreferences(PREFS_NAME,0);
        SharedPreferences.Editor editor = prefs.edit();
        editor.putString("AdMobNative", id).commit();
        editor.apply();

    }

    public static String AdMobNative(Context context) {
        SharedPreferences sharedPreferences = context.getSharedPreferences(PREFS_NAME, 0);

        return sharedPreferences.getString("AdMobNative", "ca-app-pub-3940256099942544/2247696110");
    }

    public static void AdMobOpenAds(String id, Context context) {
        SharedPreferences prefs = context.getSharedPreferences(PREFS_NAME,0);
        SharedPreferences.Editor editor = prefs.edit();
        editor.putString("AdMobOpenAds", id).commit();
        editor.apply();

    }

    public static String AdMobOpenAds(Context context) {
        SharedPreferences sharedPreferences = context.getSharedPreferences(PREFS_NAME, 0);

        return sharedPreferences.getString("AdMobOpenAds", "/22405025169,22503969207/com.calculatorlock.applock.secretphotoalbum.calculatorvault.privatevault.gallerylock.AppOpen");
    }


    public static void AdMobReword(String id, Context context) {
        SharedPreferences prefs = context.getSharedPreferences(PREFS_NAME,0);
        SharedPreferences.Editor editor = prefs.edit();
        editor.putString("AdMobReword", id).commit();
        editor.apply();

    }

    public static String AdMobReword(Context context) {
        SharedPreferences sharedPreferences = context.getSharedPreferences(PREFS_NAME, 0);

        return sharedPreferences.getString("AdMobReword", "ca-app-pub-3940256099942544/5224354917");
    }


    // adx






    public static void AdxInter(String id, Context context) {
        SharedPreferences prefs = context.getSharedPreferences(PREFS_NAME,0);
        SharedPreferences.Editor editor = prefs.edit();
        editor.putString("AdxInter", id).commit();
        editor.apply();

    }

    public static String AdxInter(Context context) {
        SharedPreferences sharedPreferences = context.getSharedPreferences(PREFS_NAME, 0);

        return sharedPreferences.getString("AdxInter", "ca-app-pub-3940256099942544/1033173712");
    }


    public static void AdxBanner(String id, Context context) {
        SharedPreferences prefs = context.getSharedPreferences(PREFS_NAME,0);
        SharedPreferences.Editor editor = prefs.edit();
        editor.putString("AdxBanner", id).commit();
        editor.apply();

    }

    public static String AdxBanner(Context context) {
        SharedPreferences sharedPreferences = context.getSharedPreferences(PREFS_NAME, 0);

        return sharedPreferences.getString("AdxBanner", "ca-app-pub-3940256099942544/6300978111");
    }

    public static void AdxNative(String id, Context context) {
        SharedPreferences prefs = context.getSharedPreferences(PREFS_NAME,0);
        SharedPreferences.Editor editor = prefs.edit();
        editor.putString("AdxNative", id).commit();
        editor.apply();

    }

    public static String AdxNative(Context context) {
        SharedPreferences sharedPreferences = context.getSharedPreferences(PREFS_NAME, 0);

        return sharedPreferences.getString("AdxNative", "ca-app-pub-3940256099942544/2247696110");
    }

    public static void AdxOpenAds(String id, Context context) {
        SharedPreferences prefs = context.getSharedPreferences(PREFS_NAME,0);
        SharedPreferences.Editor editor = prefs.edit();
        editor.putString("AdxOpenAds", id).commit();
        editor.apply();

    }

    public static String AdxOpenAds(Context context) {
        SharedPreferences sharedPreferences = context.getSharedPreferences(PREFS_NAME, 0);

        return sharedPreferences.getString("AdxOpenAds", "");
    }

    public static void AdxReword(String id, Context context) {
        SharedPreferences prefs = context.getSharedPreferences(PREFS_NAME,0);
        SharedPreferences.Editor editor = prefs.edit();
        editor.putString("AdxReword", id).commit();
        editor.apply();

    }

    public static String AdxReword(Context context) {
        SharedPreferences sharedPreferences = context.getSharedPreferences(PREFS_NAME, 0);

        return sharedPreferences.getString("AdxReword", "ca-app-pub-3940256099942544/5224354917");
    }




// Facebook

    public static void FBInter(String id, Context context) {
        SharedPreferences prefs = context.getSharedPreferences(PREFS_NAME,0);
        SharedPreferences.Editor editor = prefs.edit();
        editor.putString("FBInter", id).commit();
        editor.apply();

    }

    public static String FBInter(Context context) {
        SharedPreferences sharedPreferences = context.getSharedPreferences(PREFS_NAME, 0);

        return sharedPreferences.getString("FBInter", "VID_HD_9_16_39S_APP_INSTALL#YOUR_PLACEMENT_ID");
    }

    public static void FBBanner(String id, Context context) {
        SharedPreferences prefs = context.getSharedPreferences(PREFS_NAME,0);
        SharedPreferences.Editor editor = prefs.edit();
        editor.putString("FBBanner", id).commit();
        editor.apply();

    }

    public static String FBBanner(Context context) {
        SharedPreferences sharedPreferences = context.getSharedPreferences(PREFS_NAME, 0);

        return sharedPreferences.getString("FBBanner", "VID_HD_9_16_39S_APP_INSTALL#YOUR_PLACEMENT_ID");
    }

    public static void FBNative(String id, Context context) {
        SharedPreferences prefs = context.getSharedPreferences(PREFS_NAME,0);
        SharedPreferences.Editor editor = prefs.edit();
        editor.putString("FBNative", id).commit();
        editor.apply();

    }

    public static String FBNative(Context context) {
        SharedPreferences sharedPreferences = context.getSharedPreferences(PREFS_NAME, 0);

        return sharedPreferences.getString("FBNative", "VID_HD_9_16_39S_APP_INSTALL#YOUR_PLACEMENT_ID");
    }

    public static void FBNativeBig(String id, Context context) {
        SharedPreferences prefs = context.getSharedPreferences(PREFS_NAME,0);
        SharedPreferences.Editor editor = prefs.edit();
        editor.putString("FBNativeBig", id).commit();
        editor.apply();

    }

    public static String FBNativeBig(Context context) {
        SharedPreferences sharedPreferences = context.getSharedPreferences(PREFS_NAME, 0);

        return sharedPreferences.getString("FBNativeBig", "VID_HD_9_16_39S_APP_INSTALL#YOUR_PLACEMENT_ID");
    }



    // Appnext



    public static void AppnextInter(String id, Context context) {
        SharedPreferences prefs = context.getSharedPreferences(PREFS_NAME,0);
        SharedPreferences.Editor editor = prefs.edit();
        editor.putString("AppnextInter", id).commit();
        editor.apply();

    }

    public static String AppnextInter(Context context) {
        SharedPreferences sharedPreferences = context.getSharedPreferences(PREFS_NAME, 0);

        return sharedPreferences.getString("AppnextInter", "VID_HD_9_16_39S_APP_INSTALL#YOUR_PLACEMENT_ID");
    }

    public static void AppnextBanner(String id, Context context) {
        SharedPreferences prefs = context.getSharedPreferences(PREFS_NAME,0);
        SharedPreferences.Editor editor = prefs.edit();
        editor.putString("AppnextBanner", id).commit();
        editor.apply();

    }

    public static String AppnextBanner(Context context) {
        SharedPreferences sharedPreferences = context.getSharedPreferences(PREFS_NAME, 0);

        return sharedPreferences.getString("AppnextBanner", "VID_HD_9_16_39S_APP_INSTALL#YOUR_PLACEMENT_ID");
    }

    public static void AppnextNative(String id, Context context) {
        SharedPreferences prefs = context.getSharedPreferences(PREFS_NAME,0);
        SharedPreferences.Editor editor = prefs.edit();
        editor.putString("AppnextNative", id).commit();
        editor.apply();

    }

    public static String AppnextNative(Context context) {
        SharedPreferences sharedPreferences = context.getSharedPreferences(PREFS_NAME, 0);

        return sharedPreferences.getString("AppnextNative", "VID_HD_9_16_39S_APP_INSTALL#YOUR_PLACEMENT_ID");
    }




    // Other

    public static String ADSetting(Context context) {
        SharedPreferences sharedPreferences = context.getSharedPreferences(PREFS_NAME, 0);

        return sharedPreferences.getString("ADSetting", "facebook");
    }

    public static void ADSetting(String id, Context context) {
        SharedPreferences prefs = context.getSharedPreferences(PREFS_NAME,0);
        SharedPreferences.Editor editor = prefs.edit();
        editor.putString("ADSetting", id).commit();
        editor.apply();

    }


    public static String Inter_1(Context context) {
        SharedPreferences sharedPreferences = context.getSharedPreferences(PREFS_NAME, 0);

        return sharedPreferences.getString("Inter_1", "ca-app-pub-3940256099942544/1033173712");
    }

    public static void Inter_1(String id, Context context) {
        SharedPreferences prefs = context.getSharedPreferences(PREFS_NAME,0);
        SharedPreferences.Editor editor = prefs.edit();
        editor.putString("Inter_1", id).commit();
        editor.apply();

    }

    public static String Inter_2(Context context) {
        SharedPreferences sharedPreferences = context.getSharedPreferences(PREFS_NAME, 0);

        return sharedPreferences.getString("Inter_2", "ca-app-pub-3940256099942544/1033173712");
    }

    public static void Inter_2(String id, Context context) {
        SharedPreferences prefs = context.getSharedPreferences(PREFS_NAME,0);
        SharedPreferences.Editor editor = prefs.edit();
        editor.putString("Inter_2", id).commit();
        editor.apply();

    }
    public static String Inter_3(Context context) {
        SharedPreferences sharedPreferences = context.getSharedPreferences(PREFS_NAME, 0);

        return sharedPreferences.getString("Inter_3", "ca-app-pub-3940256099942544/1033173712");
    }

    public static void Inter_3(String id, Context context) {
        SharedPreferences prefs = context.getSharedPreferences(PREFS_NAME,0);
        SharedPreferences.Editor editor = prefs.edit();
        editor.putString("Inter_3", id).commit();
        editor.apply();

    }



    public static String OnBackAds(Context context) {
        SharedPreferences sharedPreferences = context.getSharedPreferences(PREFS_NAME, 0);

        return sharedPreferences.getString("onback_ads", "0");
    }

    public static void OnBackAds(String id, Context context) {
        SharedPreferences prefs = context.getSharedPreferences(PREFS_NAME,0);
        SharedPreferences.Editor editor = prefs.edit();
        editor.putString("onback_ads", id).commit();
        editor.apply();

    }

    public static int Adcounter(Context context) {
        SharedPreferences sharedPreferences = context.getSharedPreferences(PREFS_NAME, 0);

        return sharedPreferences.getInt("ad_counter", 5);
    }

    public static void Adcounter(int id, Context context) {
        SharedPreferences prefs = context.getSharedPreferences(PREFS_NAME,0);
        SharedPreferences.Editor editor = prefs.edit();
        editor.putInt("ad_counter", id).commit();
        editor.apply();

    }
    public static int AppAdcounter(Context context) {
        SharedPreferences sharedPreferences = context.getSharedPreferences(PREFS_NAME, 0);

        return sharedPreferences.getInt("AppAdcounter", 0);
    }

    public static void AppAdcounter(int id, Context context) {
        SharedPreferences prefs = context.getSharedPreferences(PREFS_NAME,0);
        SharedPreferences.Editor editor = prefs.edit();
        editor.putInt("AppAdcounter", id).commit();
        editor.apply();

    }



    public static String InsidesAds(Context context) {
        SharedPreferences sharedPreferences = context.getSharedPreferences(PREFS_NAME, 0);

        return sharedPreferences.getString("insides_ads", "0");
    }

    public static void InsidesAds(String id, Context context) {
        SharedPreferences prefs = context.getSharedPreferences(PREFS_NAME,0);
        SharedPreferences.Editor editor = prefs.edit();
        editor.putString("insides_ads", id).commit();
        editor.apply();

    }






    public static int getAdsCount(Context context) {
        SharedPreferences sharedPreferences = context.getSharedPreferences(PREFS_NAME, 0);

        return sharedPreferences.getInt("AdCount", 0);
    }

    public static void setAdCount(int data, Context context) {
        SharedPreferences prefs = context.getSharedPreferences(PREFS_NAME,0);
        SharedPreferences.Editor editor = prefs.edit();
        editor.putInt("AdCount", data).commit();
        editor.apply();

    }



    public static int getSetUpCount(Context context) {
        SharedPreferences sharedPreferences = context.getSharedPreferences(PREFS_NAME, 0);

        return sharedPreferences.getInt("SetUp", 5);
    }

    public static void setSetupCount(int data, Context context) {
        SharedPreferences prefs = context.getSharedPreferences(PREFS_NAME,0);
        SharedPreferences.Editor editor = prefs.edit();
        editor.putInt("SetUp", data).commit();
        editor.apply();

    }



    public static void AdsStyle(String id, Context context) {
        SharedPreferences prefs = context.getSharedPreferences(PREFS_NAME,0);
        SharedPreferences.Editor editor = prefs.edit();
        editor.putString("AdsStyle", id).commit();
        editor.apply();

    }

    public static String AdsStyle(Context context) {
        SharedPreferences sharedPreferences = context.getSharedPreferences(PREFS_NAME, 0);

        return sharedPreferences.getString("AdsStyle", "1");
    }

    public static void OpenAdsType(String id, Context context) {
        SharedPreferences prefs = context.getSharedPreferences(PREFS_NAME,0);
        SharedPreferences.Editor editor = prefs.edit();
        editor.putString("OpenAdsType", id).commit();
        editor.apply();


    }

    public static String OpenAdsType(Context context) {
        SharedPreferences sharedPreferences = context.getSharedPreferences(PREFS_NAME, 0);

        return sharedPreferences.getString("OpenAdsType", "open");
    }

    public static void SwitchOpenAds(String id, Context context) {
        SharedPreferences prefs = context.getSharedPreferences(PREFS_NAME,0);
        SharedPreferences.Editor editor = prefs.edit();
        editor.putString("SwitchOpenAds", id).commit();
        editor.apply();

    }



     public static String SwitchOpenAds(Context context) {
        SharedPreferences sharedPreferences = context.getSharedPreferences(PREFS_NAME, 0);

        return sharedPreferences.getString("SwitchOpenAds", "on");
    }


    public static void ApplovinMax(String id, Context context) {
        SharedPreferences prefs = context.getSharedPreferences(PREFS_NAME,0);
        SharedPreferences.Editor editor = prefs.edit();
        editor.putString("ApplovinMax", id).commit();
        editor.apply();

    }




    public static String ApplovinMax(Context context) {
        SharedPreferences sharedPreferences = context.getSharedPreferences(PREFS_NAME, 0);

        return sharedPreferences.getString("ApplovinMax", "2df41ccaef22b27f");
    }


    public static void ApplovinMaxNative(String id, Context context) {
        SharedPreferences prefs = context.getSharedPreferences(PREFS_NAME,0);
        SharedPreferences.Editor editor = prefs.edit();
        editor.putString("ApplovinMaxNative", id).commit();
        editor.apply();

    }




    public static String ApplovinMaxNative(Context context) {
        SharedPreferences sharedPreferences = context.getSharedPreferences(PREFS_NAME, 0);
        return sharedPreferences.getString("ApplovinMaxNative", "6722473a5f621443");
    }


    public static void ApplovinMaxNativeSmall(String id, Context context) {
        SharedPreferences prefs = context.getSharedPreferences(PREFS_NAME,0);
        SharedPreferences.Editor editor = prefs.edit();
        editor.putString("ApplovinMaxNativeSmall", id).commit();
        editor.apply();

    }




    public static String ApplovinMaxNativeSmall(Context context) {
        SharedPreferences sharedPreferences = context.getSharedPreferences(PREFS_NAME, 0);
        return sharedPreferences.getString("ApplovinMaxNativeSmall", "79b76383a2b9ff46");
    }





    public static void ApplovinMaxBanner(String id, Context context) {
        SharedPreferences prefs = context.getSharedPreferences(PREFS_NAME,0);
        SharedPreferences.Editor editor = prefs.edit();
        editor.putString("ApplovinMaxBanner", id).commit();
        editor.apply();

    }




    public static String ApplovinMaxBanner(Context context) {
        SharedPreferences sharedPreferences = context.getSharedPreferences(PREFS_NAME, 0);
        return sharedPreferences.getString("ApplovinMaxBanner", "91306e3c3258851c");
    }

    public static void AppLovinSdk(Activity activity){
        AudienceNetworkAds.initialize(activity);
        AppLovinSdk.getInstance(activity).setMediationProvider("max");
        AppLovinSdk.initializeSdk(activity, new AppLovinSdk.SdkInitializationListener() {
            @Override
            public void onSdkInitialized(final AppLovinSdkConfiguration configuration) {

            }
        });
    }

    public static void AdmobSdk(Activity activity, String Appid){
        MobileAds.initialize(activity, Appid);

    }

    public static void AppOpenCall(Application application){
        AppManager appManager = new AppManager.Builder(application, Config.AdxOpenAds(application.getApplicationContext())).setShowAdAutomatically(true).build();

    }


    public static String Versioncode(Context context) {
        SharedPreferences sharedPreferences = context.getSharedPreferences(PREFS_NAME, 0);
        return sharedPreferences.getString("version_code", "0");
    }

    public static void Versioncode(String id, Context context) {
        SharedPreferences prefs = context.getSharedPreferences(PREFS_NAME,0);
        SharedPreferences.Editor editor = prefs.edit();
        editor.putString("version_code", id).commit();
        editor.apply();

    }

    public static String Privacypolicy(Context context) {
        SharedPreferences sharedPreferences = context.getSharedPreferences(PREFS_NAME, 0);

        return sharedPreferences.getString("privacy_policy", "google");
    }

    public static void Privacypolicy(String id, Context context) {
        SharedPreferences prefs = context.getSharedPreferences(PREFS_NAME,0);
        SharedPreferences.Editor editor = prefs.edit();
        editor.putString("privacy_policy", id).commit();
        editor.apply();

    }
    public static int AdsOfCounterNumber(Context context) {
        SharedPreferences sharedPreferences = context.getSharedPreferences(PREFS_NAME, 0);

        return sharedPreferences.getInt("AdsOfCounterNumber", 1);
    }

    public static void AdsOfCounterNumber(int id, Context context) {
        SharedPreferences prefs = context.getSharedPreferences(PREFS_NAME,0);
        SharedPreferences.Editor editor = prefs.edit();
        editor.putInt("AdsOfCounterNumber", id).commit();
        editor.apply();

    }

    public static String getData(Context context) {
        SharedPreferences sharedPreferences = context.getSharedPreferences(PREFS_NAME, 0);

        return sharedPreferences.getString("Data", "https://makinfotech.net/");
    }

    public static void AddData(String id, Context context) {
        SharedPreferences prefs = context.getSharedPreferences(PREFS_NAME,0);
        SharedPreferences.Editor editor = prefs.edit();
        editor.putString("Data", id).commit();
        editor.apply();

    }

    public static String Appicon(Context context) {
        SharedPreferences sharedPreferences = context.getSharedPreferences(PREFS_NAME, 0);

        return sharedPreferences.getString("Appicon", "");
    }

    public static void Appicon(String id, Context context) {
        SharedPreferences prefs = context.getSharedPreferences(PREFS_NAME,0);
        SharedPreferences.Editor editor = prefs.edit();
        editor.putString("Appicon", id).commit();
        editor.apply();

    }

}