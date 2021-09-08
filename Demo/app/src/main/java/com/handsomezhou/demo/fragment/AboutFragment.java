package com.handsomezhou.demo.fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.android.commontools.util.AppUtil;
import com.android.commontools.util.ToastUtil;
import com.handsomezhou.demo.AppApplication;
import com.handsomezhou.demo.R;
import com.handsomezhou.demo.activity.ReferenceProjectActivity;
import com.handsomezhou.demo.activity.VersionInfoActivity;

import com.handsomezhou.demo.util.ShareUtil;
import com.handsomezhou.demo.view.NavigationBarLayout;


/**
 * Created by handsomezhou on 2021/9/8.
 */
public class AboutFragment extends BaseFragment implements NavigationBarLayout.OnNavigationBarLayout{
    private static final String TAG="AboutFragment";

    private NavigationBarLayout mNavigationBarLayout;
    private TextView mVersionInfoTv;
    private TextView mCheckNewVersionTv;
    private View mReferenceProjectLayout;
    private View mDeviceIdLayout;
    private TextView mDeviceIdTv;
    //private TextView mAdviceFeedbackTv;
    private String mTitle;
    private String mVersionInfo;
    private static long lastToastTimeMs=0;
    @Override
    public void onResume() {
        super.onResume();
        refreshView();
    }

    @Override
    public void onPause() {
        super.onPause();
    }

    @Override
    protected void initData() {
        setContext(getActivity());

        mTitle = getContext().getString(R.string.about);

        mVersionInfo = getContext().getString(R.string.version_info)
                + getContext().getString(R.string.colon)
                + AppUtil.getVersionName(getContext(), getContext()
                .getPackageName());
    }

    @Override
    protected View initView(LayoutInflater inflater, ViewGroup container) {
        View view = inflater.inflate(R.layout.fragment_about, container, false);
        mNavigationBarLayout = (NavigationBarLayout) view.findViewById(R.id.navigation_bar_layout);
        mNavigationBarLayout.setOnNavigationBarLayout(this);
        mNavigationBarLayout.setTitle(mTitle);

        mVersionInfoTv = (TextView) view.findViewById(R.id.version_info_text_view);
        mVersionInfoTv.setText(mVersionInfo);

        mVersionInfoTv.setTextColor(getContext().getResources().getColor(R.color.blue));
        mVersionInfoTv.setEnabled(true);

        mCheckNewVersionTv=(TextView)view.findViewById(R.id.check_new_version_text_view);

        mReferenceProjectLayout = view.findViewById(R.id.reference_project_layout);

        mDeviceIdLayout=view.findViewById(R.id.device_id_layout);
        mDeviceIdTv=(TextView) view.findViewById(R.id.device_id_text_view);

        //mAdviceFeedbackTv=(TextView) view.findViewById(R.id.advice_feedback_text_view);
        return view;
    }

    @Override
    protected void initListener() {

        mVersionInfoTv.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                VersionInfoActivity.launch(getContext());

            }
        });

        mCheckNewVersionTv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //checkNewVersion();
            }
        });

        mReferenceProjectLayout.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                viewReferenceProject();

            }
        });

        mDeviceIdLayout.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                shareDeviceId();

            }
        });

        mDeviceIdLayout.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                copyDeviceId();
                return true;
            }
        });
   /*     mAdviceFeedbackTv.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                enterAdviceFeedback();

            }
        });*/

        return;
    }

    /* Start: OnNavigationBarLayout */
    @Override
    public void onBack() {
        back();

    }

    /* End: OnNavigationBarLayout */

    private void refreshView() {
        refreshReferenceProjectLayout();
        refreshDeviceIdTv();
    }

    private void refreshReferenceProjectLayout(){

    }
    private void refreshDeviceIdTv(){
        mDeviceIdTv.setText(AppApplication.getInstance().getClientId());
    }

    private void back() {
        getActivity().finish();
    }

    /*
    private void checkNewVersion(){
        do{
            if(false== PermissionUtil.hasWriteAndReadExternalStoragePermission(getActivity())) {
                //if(SettingsHelper.getInstance().getReqWriteAndReadExternalStoragePermissionCount()>0){
                ToastUtil.toastLengthLong(AppApplication.getContext(),R.string.req_write_and_read_external_storage_permission_failed_tips);
                //}
                SettingsHelper.getInstance().setReqWriteAndReadExternalStoragePermissionCount(SettingsHelper.getInstance().getReqWriteAndReadExternalStoragePermissionCount()+1);
                PermissionUtil.reqWriteAndReadExternalStoragePermission(getActivity());
                break;
            }

            try {

                new PgyUpdateManager.Builder()
                        .setForced(true)                //设置是否强制提示更新,非自定义回调更新接口此方法有用
                        .setUserCanRetry(true)         //失败后是否提示重新下载，非自定义下载 apk 回调此方法有用
                        .setDeleteHistroyApk(false)     // 检查更新前是否删除本地历史 Apk， 默认为true
                        .setUpdateManagerListener(new UpdateManagerListener() {
                            @Override
                            public void onNoUpdateAvailable() {
                                //没有更新是回调此方法
                                Log.d("pgyer", "there is no new version");
                                ToastUtil.toastLengthshort(AppApplication.getContext(), R.string.there_is_no_new_version);
                            }

                            @Override
                            public void onUpdateAvailable(AppBean appBean) {
                                //有更新回调此方法
                                Log.d("pgyer", "there is new version can update"
                                        + "new versionCode is " + appBean.getVersionCode());
                                //调用以下方法，DownloadFileListener 才有效；
                                //如果完全使用自己的下载方法，不需要设置DownloadFileListener
                                PgyUpdateManager.downLoadApk(appBean.getDownloadURL());
                            }

                            @Override
                            public void checkUpdateFailed(Exception e) {
                                //更新检测失败回调
                                //更新拒绝（应用被下架，过期，不在安装有效期，下载次数用尽）以及无网络情况会调用此接口
                                Log.e("pgyer", "check update failed ", e);
                                ToastUtil.toastLengthshort(AppApplication.getContext(), R.string.check_update_failed);
                            }
                        })
                        //注意 ：
                        //下载方法调用 PgyUpdateManager.downLoadApk(appBean.getDownloadURL()); 此回调才有效
                        //此方法是方便用户自己实现下载进度和状态的 UI 提供的回调
                        //想要使用蒲公英的默认下载进度的UI则不设置此方法
                        .setDownloadFileListener(new DownloadFileListener() {
                            @Override
                            public void downloadFailed() {
                                //下载失败
                                Log.e("pgyer", "download apk failed");
                                ToastUtil.toastLengthshort(AppApplication.getContext(), R.string.download_app_failed);
                            }

                            @Override
                            public void downloadSuccessful(File file) {
                                Log.e("pgyer", "download apk success");
                                ToastUtil.toastLengthshort(AppApplication.getContext(), R.string.download_app_success);
                                // 使用蒲公英提供的安装方法提示用户 安装apk
                                PgyUpdateManager.installApk(file);
                            }

                            @Override
                            public void onProgressUpdate(Integer... integers) {
                                if (integers.length > 0) {
                                    Log.e("pgyer", "update download apk progress : " + integers[0]);
                                    if ((System.currentTimeMillis() - lastToastTimeMs) > TimeUtil.sec2ms(3)) {
                                        lastToastTimeMs = System.currentTimeMillis();
                                        String percentage = Constant.NULL_STRING + integers[0] + Constant.PERCENT_SIGN;
                                        String downloadProgress = getString(R.string.download_progress, percentage);
                                        ToastUtil.toastLengthshort(AppApplication.getContext(), downloadProgress);
                                    }


                                } else {
                                    Log.e("pgyer", "update download apk progress");
                                }

                            }
                        })
                        .register();

            }catch (Exception ex){
                LogUtil.i(TAG,"checkNewVersion "+ex.toString());
            }
        }while (false);

    }
    */

    private void viewReferenceProject() {
        ReferenceProjectActivity.launch(getContext());
    }


    private void shareDeviceId(){
        ShareUtil.shareTextToMore(getContext(),getString(R.string.share_device_id), AppApplication.getInstance().getClientId());
        return;
    }

    private void copyDeviceId(){
        ShareUtil.copyText(getContext(), AppApplication.getInstance().getClientId());
        ToastUtil.toastLengthshort(getContext(),R.string.copy_device_id_success);
    }
    /*private void enterAdviceFeedback(){
        AdviceFeedbackActivity.launch(getContext());
    }*/
}
