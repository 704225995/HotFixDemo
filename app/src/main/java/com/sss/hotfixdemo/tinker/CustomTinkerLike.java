package com.sss.hotfixdemo.tinker;

import android.app.Application;
import android.app.SharedElementCallback;
import android.content.Context;
import android.content.Intent;

import androidx.multidex.MultiDex;

import com.tencent.tinker.anno.DefaultLifeCycle;
import com.tencent.tinker.loader.app.ApplicationLike;
import com.tencent.tinker.loader.shareutil.ShareConstants;

/**
 * ==============================================================
 * 项目: HotFixDemo
 * 包名: com.sss.hotfixdemo.tinker
 * 创建人: shuai
 * 创建时间: 2020/4/14 15:06
 * 类描述:
 * 更新人:
 * 更新时间: 2020/4/14 15:06
 * 更新说明:
 * 版本: v1.0
 * ================================================
 */

@DefaultLifeCycle(application = ".myTinkerApplication",
        flags = ShareConstants.TINKER_ENABLE_ALL,
        loadVerifyFlag = false)
public class CustomTinkerLike extends ApplicationLike {


    public CustomTinkerLike(Application application, int tinkerFlags,
                            boolean tinkerLoadVerifyFlag,
                            long applicationStartElapsedTime,
                            long applicationStartMillisTime,
                            Intent tinkerResultIntent) {
        super(application, tinkerFlags, tinkerLoadVerifyFlag,
                applicationStartElapsedTime, applicationStartMillisTime,
                tinkerResultIntent);
    }

    @Override
    public void onBaseContextAttached(Context base) {
        super.onBaseContextAttached(base);
        //使应用支持分包
        MultiDex.install(base);

        TinkerManager.installTinker(this);
    }

}
