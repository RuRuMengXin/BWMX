package com.bwmx.tool.Units;

import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;

import com.bwmx.tool.Main;

//获取QQ的版本号信息
public class HostInfo {
    private static String Version;
    private static int Version_Code;
    public static void Init(){
        try {
            //获取普通apk版本信息
            PackageManager pm = Main.AppContext.getPackageManager();
            PackageInfo mSelfInfo = pm.getPackageInfo("com.tencent.mobileqq",0);
            String Version_1 = mSelfInfo.versionName;

            //获取QQ小版本信息
            ApplicationInfo sAppInfo = pm.getApplicationInfo("com.tencent.mobileqq",PackageManager.GET_META_DATA);
            String UUID = sAppInfo.metaData.getString("com.tencent.rdm.uuid");

            Version = Version_1;
            Version_Code = Integer.parseInt(UUID.substring(0,UUID.indexOf("_")));


        } catch (Throwable e) {
            FileUnits.writelog("HostInfo"+e);
        }
    }
    public static int getVerCode(){
        return Version_Code;
    }
    public static String getVersion(){return Version;}

    public static class QQVersion
    {
//        public static int QQ8_8_68 = 8000;
        public static int QQ8_8_90 = 8120;
        public static int QQ8_9_5 = 8845;
        public static int QQ8_9_8 = 8995;
        public static int QQ8_9_10 = 9135;
        public static int QQ8_9_13 = 9280;
        public static int QQ8_9_15 = 9425;
        public static int QQ8_9_18 = 9570;
        public static int QQ8_9_19 = 9580;
        public static int QQ8_9_20 = 9715;
    }

}