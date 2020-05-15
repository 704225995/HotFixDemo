package com.sss.hotfixdemo.andfix;

import android.annotation.SuppressLint;
import android.app.Service;
import android.content.Intent;
import android.os.Handler;
import android.os.IBinder;
import android.os.Message;
import android.text.TextUtils;
import android.util.Log;

import java.io.File;
import java.util.Objects;

/**
 * ==============================================================
 * 项目: HotFixDemo
 * 包名: com.sss.hotfixdemo.andfix
 * 创建人: shuai
 * 创建时间: 2020/4/12 11:45
 * 类描述:
 * 更新人:
 * 更新时间: 2020/4/12 11:45
 * 更新说明:
 * 版本: v1.0
 * ================================================
 */
public class FixService extends Service {

    private static final String TAG            = FixService.class.getSimpleName();
    private              String mPatchDir;
    private              String mPatchFileName;
    private static final String PATCH_FILE_END = ".apatch";

    private static final int MSG_CHECK_UPDATE   = 0x01;
    private static final int MSG_DOWNLOAD_PATCH = 0x02;

    @SuppressLint("HandlerLeak") private Handler mHandler = new Handler() {
        @Override
        public void handleMessage(Message msg) {
            switch (msg.what) {
                case MSG_CHECK_UPDATE:
                    checkHasPatch();
                    break;
                case MSG_DOWNLOAD_PATCH:
                    downloadPatch();
                    break;
                default:
                    break;

            }
        }
    };

    private BasePatch mBasePatch;

    @Override
    public IBinder onBind(Intent intent) {
        throw null;
    }

    @Override
    public void onCreate() {
        super.onCreate();
        init();
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {

        mHandler.sendEmptyMessage(MSG_CHECK_UPDATE);

        //返回START_STICKY表示服务不会自动重启
        return START_STICKY;
    }

    private void init() {
        mPatchDir = Objects.requireNonNull(getExternalCacheDir()).getAbsolutePath() + "/patch/";
        File patchFile = new File(mPatchDir);
        if (!patchFile.exists()) {
            patchFile.mkdirs();
        }
    }

    private void checkHasPatch() {
        /*RequestCenter.requestPatchUpdateInfo(new DisposeDataListener() {
            @Override
            public void onSuccess(Object responseObj) {
                mBasePatch = (BasePatch) responseObj;
                if (!TextUtils.isEmpty(mBasePatch.data.downloadUrl)) {
                    Log.e(TAG, "onSuccess: " + "has new patch file");
                    mHandler.sendEmptyMessage(MSG_DOWNLOAD_PATCH);
                } else {
                    stopSelf();
                }
            }

            @Override
            public void onFailure(Object reasonObj) {
                Log.e(TAG, "onFailure: " + "has no patch file");
                stopSelf();
            }
        });*/
    }

    private void downloadPatch() {
        /*mPatchFileName = mPatchDir + System.currentTimeMillis() + PATCH_FILE_END;
        Log.e(TAG, "downloadPatch: " + mPatchFileName);
        RequestCenter.downloadFile(mBasePatch.data.downloadUrl, "mPatchFileName", new DisposeDownloadListener() {
            @Override
            public void onProgress(int progress) {
                Log.e(TAG, "onProgress: " + progress + "%");
            }

            @Override
            public void onSuccess(Object responseObj) {
                Log.e(TAG, "onSuccess: " + "正在更新");
                AndFixPatchManager.getInstance().addPatch(mPatchFileName);
            }

            @Override
            public void onFailure(Object reasonObj) {
                stopSelf();
            }
        });*/
    }
}