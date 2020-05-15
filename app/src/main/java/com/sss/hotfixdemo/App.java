package com.sss.hotfixdemo;

import android.app.Application;
import android.content.Intent;

import com.sss.hotfixdemo.andfix.AndFixPatchManager;
import com.sss.hotfixdemo.andfix.FixService;

/**
 * ==============================================================
 * 项目: HotFixDemo
 * 包名: com.sss.hotfixdemo
 * 创建人: shuai
 * 创建时间: 2020/4/12 11:30
 * 类描述:
 * 更新人:
 * 更新时间: 2020/4/12 11:30
 * 更新说明:
 * 版本: v1.0
 * ================================================
 */
public class App  {

    /*@Override
    public void onCreate() {
        super.onCreate();
        AndFixPatchManager.getInstance().initPatch(this);

        Intent fixIntent = new Intent(this, FixService.class);
        startService(fixIntent);

    }*/
}
