package com.sss.hotfixdemo.util;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;

/**
 * ==============================================================
 * 项目: HotFixDemo
 * 包名: com.sss.hotfixdemo.util
 * 创建人: shuai
 * 创建时间: 2020/4/12 11:37
 * 类描述:
 * 更新人:
 * 更新时间: 2020/4/12 11:37
 * 更新说明:
 * 版本: v1.0
 * ================================================
 */
public class Utils {

    public static String getVersionName(Context context) {
        String versionName = "1.0.0";
        try {
            PackageManager pm = context.getPackageManager();
            PackageInfo    pi = pm.getPackageInfo(context.getPackageName(), 0);
            versionName = pi.versionName;
        } catch (PackageManager.NameNotFoundException e) {
            e.printStackTrace();
        }
        return versionName;
    }
}
