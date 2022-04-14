package com.android.all.ads.include;

import android.app.Activity;
import android.content.Intent;
import android.view.View;
import android.widget.LinearLayout;


public class AdsManger {



    public static void NativeBigAds(LinearLayout adslayout, Activity context){
        adslayout.setVisibility(View.VISIBLE);
        try {
            if (Config.AdsStyle(context).equals("0")){
                AdsConfig adsConfig = new AdsConfig(context);
                adsConfig.NativeBigAds(adslayout);
            }else {
                adslayout.setVisibility(View.GONE);
            }
        }catch (Exception e){
            adslayout.setVisibility(View.GONE);

        }

    }


    public static void NativebannerAds(LinearLayout adslayout, Activity context){
        adslayout.setVisibility(View.VISIBLE);
        try {
            if (Config.AdsStyle(context).equals("0")){
                AdsConfig adsConfig = new AdsConfig(context);
                adsConfig.NativeBanner(adslayout);
            }else {
                adslayout.setVisibility(View.GONE);
            }
        }catch (Exception e){
            adslayout.setVisibility(View.GONE);

        }

    }


  public static  void BannerAds(LinearLayout adslayout, Activity context){
      adslayout.setVisibility(View.VISIBLE);
      try {
          if (Config.AdsStyle(context).equals("0")){
              AdsConfig adsConfig = new AdsConfig(context);
              adsConfig.BannerAds(adslayout);
          }else {
              adslayout.setVisibility(View.GONE);
          }
      }catch (Exception e){
          adslayout.setVisibility(View.GONE);

      }
    }

   public static void AdShowCount(Intent intent, int type, boolean isShow, Activity context){
       if (Config.AdsStyle(context).equals("0")){
           AdsConfig adsConfig = new AdsConfig(context);
           adsConfig.AdShowCount(intent,type,isShow);
       }else {
           if (type == 0) {

               context.startActivity(intent);

           } else if (type == 1) {

               context.startActivityForResult(intent, 1001);
           } else if (type == 100) {

               context.startActivityForResult(intent, 100);
           }  else if (type == 200) {

               context.startActivity(intent);
               context.finish();

           } else if (type == 500){

               context.startActivityForResult(intent,500);


           } else if (type == 49){

               context.startActivityForResult(intent,49);


           }
           else {

           }
       }

    }

    public static void AdShow(Intent intent, int type, boolean isShow, Activity context){
        if (Config.AdsStyle(context).equals("0")){
            AdsConfig adsConfig = new AdsConfig(context);
            adsConfig.AdShow(intent,type,isShow);
        }else {
            if (type == 0) {

                context.startActivity(intent);

            } else if (type == 1) {

                context.startActivityForResult(intent, 1001);
            } else if (type == 100) {

                context.startActivityForResult(intent, 100);
            }  else if (type == 200) {

                context.startActivity(intent);
                context.finish();

            } else if (type == 500){

                context.startActivityForResult(intent,500);


            } else if (type == 1001){

                context.startActivityForResult(intent,1001);


            }
            else {

            }
        }
    }

    public static void AdShow(Intent intent, Activity context){

        if (Config.AdsStyle(context).equals("0")){
            SplshConfig adsConfig = new SplshConfig(context);
            adsConfig.AdShow(intent);
        }else {
            context.startActivity(intent);
            context.finish();
        }
    }

    public static void AdShowBack(Intent intent, Activity context){

        if (Config.AdsStyle(context).equals("0")){
            AdsInterOnBack adsConfig = new AdsInterOnBack(context);
            adsConfig.AdShow(intent);
        }else {
            context.startActivity(intent);
        }
    }

    public static void AdShow(Activity context){

        if (Config.AdsStyle(context).equals("0")){
            AdsInter adsConfig = new AdsInter(context);
            adsConfig.AdShow();
        }else {

        }
    }

}
