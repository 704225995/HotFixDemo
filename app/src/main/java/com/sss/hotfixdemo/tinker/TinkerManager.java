package com.sss.hotfixdemo.tinker;

import android.content.Context;

import com.tencent.tinker.lib.tinker.Tinker;
import com.tencent.tinker.lib.tinker.TinkerInstaller;
import com.tencent.tinker.loader.app.ApplicationLike;

import java.util.List;

/**
 * ==============================================================
 * 项目: HotFixDemo
 * 包名: com.sss.hotfixdemo.tinker
 * 创建人: shuai
 * 创建时间: 2020/4/14 13:57
 * 类描述: 对Tinker所有的API做统一封装
 * 更新人:
 * 更新时间: 2020/4/14 13:57
 * 更新说明:
 * 版本: v1.0
 * ================================================
 */
public class TinkerManager {
    private static boolean         isInstalled = false;
    private static ApplicationLike mAppLike;

    /**
     * 完成Tinker初始化
     *
     * @param applicationLike
     */
    public static void installTinker(ApplicationLike applicationLike) {
        mAppLike = applicationLike;
        if (isInstalled) {
            return;
        }
        //完成Tinker初始化
        TinkerInstaller.install(applicationLike);
        isInstalled = true;
    }

    /**
     * 完成patch文件的加载
     * @param path
     */
    public static void loadPatch(String path) {
        if (Tinker.isTinkerInstalled()) {
            TinkerInstaller.onReceiveUpgradePatch(getAppLikeContext(), path);
        }
    }

    /**
     * 通过ApplicationLike获取Context对象
     * @return
     */
    public static Context getAppLikeContext() {
        if (mAppLike != null) {
            mAppLike.getApplication().getApplicationContext();
        }
        return null;
    }


}
