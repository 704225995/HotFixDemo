package com.sss.hotfixdemo.andfix;

import android.content.Context;

import com.alipay.euler.andfix.patch.PatchManager;
import com.sss.hotfixdemo.util.Utils;

import java.security.KeyStore;

/**
 * ==============================================================
 * 项目: HotFixDemo
 * 包名: com.sss.hotfixdemo.andfix
 * 创建人: shuai
 * 创建时间: 2020/4/12 11:31
 * 类描述: 管理AndFix的所有API
 * 更新人:
 * 更新时间: 2020/4/12 11:31
 * 更新说明:
 * 版本: v1.0
 * ================================================
 */
public class AndFixPatchManager {

    private static AndFixPatchManager mInstance = null;

    private PatchManager mPatchManager = null;

    private AndFixPatchManager() {
    }

    public static AndFixPatchManager getInstance() {
        if (mInstance == null) {

            synchronized (AndFixPatchManager.class) {
                if (mInstance == null) {
                    mInstance = new AndFixPatchManager();
                }
            }
        }
        return mInstance;
    }

    public void initPatch(Context context) {
        mPatchManager = new PatchManager(context);
        mPatchManager.init(Utils.getVersionName(context));
        mPatchManager.loadPatch();
    }

    public void addPatch(String path) {
        try {
            if (mPatchManager != null)
                mPatchManager.addPatch(path);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
