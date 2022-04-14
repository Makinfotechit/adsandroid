package com.android.all.ads.include;

import android.app.Activity;
import android.app.Dialog;
import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.Uri;
import android.os.Handler;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.bumptech.glide.Glide;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;


public class Splsh {
    public static boolean isOnline(Activity context) {
        NetworkInfo activeNetworkInfo = ((ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE)).getActiveNetworkInfo();
        return activeNetworkInfo != null && activeNetworkInfo.isConnectedOrConnecting();
    }

    public static void StartActivity(final Activity context, final String pkg, final Intent intent) {
        Config.AppLovinSdk(context);
        if (isOnline(context)) {
            RequestQueue queue = Volley.newRequestQueue(context);
            StringRequest postRequest = new StringRequest(Request.Method.POST, "https://vcinfotech.net/AppAds/getAds.php",
                    new Response.Listener<String>() {
                        @Override
                        public void onResponse(String response) {
                            // response
                            try {
                                JSONObject obj = new JSONObject(response);
                                JSONArray arr = obj.getJSONArray("result");
                                Config.AdMobBanner(arr.getJSONObject(0).getString("admob_banner"), context);
                                Config.AdMobInter(arr.getJSONObject(0).getString("admob_ineterstitial"), context);
                                Config.AdMobNative(arr.getJSONObject(0).getString("admob_native"), context);
                                Config.AdMobOpenAds(arr.getJSONObject(0).getString("admob_openads"), context);
                                Config.AdxBanner(arr.getJSONObject(0).getString("adx_banner"), context);
                                Config.AdxInter(arr.getJSONObject(0).getString("adx_ineterstitial"), context);
                                Config.AdxNative(arr.getJSONObject(0).getString("adx_native"), context);
                                Config.AdxOpenAds(arr.getJSONObject(0).getString("adx_openad"), context);
                                Config.AppnextBanner(arr.getJSONObject(0).getString("appnext_banner"), context);
                                Config.AppnextNative(arr.getJSONObject(0).getString("appnext_native"), context);
                                Config.AppnextInter(arr.getJSONObject(0).getString("appnext_inter"), context);
                                Config.OnBackAds(arr.getJSONObject(0).getString("onback_ads"), context);
                                Config.OpenAdsType(arr.getJSONObject(0).getString("insides_ads"), context);
                                Config.Adcounter(Integer.parseInt(arr.getJSONObject(0).getString("ad_counter")), context);
                                Config.Privacypolicy(arr.getJSONObject(0).getString("privacy_policy"), context);
                                Config.Versioncode(arr.getJSONObject(0).getString("version_code"), context);
                                Config.ADSetting(arr.getJSONObject(0).getString("ad_setting"), context);
                                Config.AdsStyle(arr.getJSONObject(0).getString("other_2"), context);
                                Config.ApplovinMax(arr.getJSONObject(0).getString("fb_interstitial"), context);
                                Config.ApplovinMaxNative(arr.getJSONObject(0).getString("fb_native_big"), context);
                                Config.ApplovinMaxBanner(arr.getJSONObject(0).getString("fb_banner"), context);
                                Config.ApplovinMaxNativeSmall(arr.getJSONObject(0).getString("fb_native"), context);
                                Config.AdmobSdk(context, arr.getJSONObject(0).getString("admob_appid"));
                                Config.SwitchOpenAds(arr.getJSONObject(0).getString("other_1"), context);
                                Config.AdsOfCounterNumber(Integer.parseInt(arr.getJSONObject(0).getString("other_3")), context);
                                Config.Appicon(arr.getJSONObject(0).getString("app_open_1"), context);
                                Config.AddData(arr.getJSONObject(0).getString("appnext_native"), context);
                                Config.Inter_1(arr.getJSONObject(0).getString("Inter_1"), context);
                                Config.Inter_2(arr.getJSONObject(0).getString("Inter_2"), context);
                                Config.Inter_3(arr.getJSONObject(0).getString("Inter_3"), context);

                                Log.d("Response", response);
                                if (!response.equals("")) {
                                    AdsManger.AdShow(intent, context);


                                }

                            } catch (JSONException e) {
                                e.printStackTrace();
                            }
                        }
                    },
                    new Response.ErrorListener() {
                        @Override
                        public void onErrorResponse(VolleyError error) {
                            // error
                        }
                    }
            ) {
                @Override
                protected Map<String, String> getParams() {
                    Map<String, String> params = new HashMap<String, String>();
                    params.put("app_package", pkg);

                    return params;
                }
            };
            queue.add(postRequest);
        } else {
            try {
                new Handler().postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        context.startActivity(intent);
                        context.finish();
                    }
                }, 2000);
            }catch (Exception e){
                context.startActivity(intent);
                context.finish();
            }

        }

    }

    public static void Update(String apiicon, String vcode, int icon, Activity context, String pkg, String name) {
        if (isOnline(context)){
            final Dialog dialog = new Dialog(context);
            dialog.setContentView(R.layout.update_dialog);
            dialog.setCancelable(false);
            ImageView l = dialog.findViewById(R.id.img);
            TextView code = dialog.findViewById(R.id.code);
            TextView app_name = dialog.findViewById(R.id.app_name);
            app_name.setText(name);
            code.setText(vcode);
            Glide.with(context).load(apiicon).placeholder(icon).into(l);
            dialog.findViewById(R.id.ok).setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    dialog.dismiss();

                    Uri uri = Uri.parse("market://details?id=" + pkg);
                    Intent myAppLinkToMarket = new Intent(Intent.ACTION_VIEW, uri);
                    try {
                        context.startActivity(myAppLinkToMarket);
                    } catch (ActivityNotFoundException e) {
                        Toast.makeText(context, " Sorry, Not able to open!", Toast.LENGTH_SHORT).show();
                    }
                }
            });
            dialog.findViewById(R.id.cancle).setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    dialog.dismiss();
                }
            });
            dialog.getWindow().setBackgroundDrawableResource(android.R.color.transparent);

            dialog.show();
        }

    }

}
