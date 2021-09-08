package com.handsomezhou.demo.util;

import android.annotation.TargetApi;
import android.content.ClipData;
import android.content.ClipboardManager;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageInfo;
import android.net.Uri;
import android.os.Build;
import android.widget.Toast;

import com.android.commontools.constant.Constant;
import com.android.commontools.util.AppUtil;
import com.android.commontools.util.CommonUtil;
import com.android.commontools.util.ToastUtil;
import com.handsomezhou.demo.R;
import com.handsomezhou.demo.constant.AppPackageName;


import java.io.File;
import java.util.ArrayList;
import java.util.List;


@TargetApi(Build.VERSION_CODES.HONEYCOMB)
public class ShareUtil {
	public static final int SHARE_SUCCESS = 0;
	public static final int SHARE_FAILED_APP_NOT_INSTALLED = 1;
	public static final int SHARE_FAILED_UNKNOW_REASON = 2;


	/**
	 * open qq
	 * @param context
	 * @return
	 */
	public static boolean enterQq(Context context){
		boolean startApp=false;
		do{
			if(null==context){
				startApp=false;
				break;
			}
			startApp= AppUtil.startApp(context, AppPackageName.PACKAGE_NAME_QQ);
			if(false==startApp){
				startApp= AppUtil.startApp(context, AppPackageName.PACKAGE_NAME_QQLITE);
		
				if(false==startApp){
					startApp= AppUtil.startApp(context, AppPackageName.PACKAGE_NAME_QQI);
			
					if(false==startApp){
						startApp= AppUtil.startApp(context, AppPackageName.PACKAGE_NAME_QQMINIHD);
						
						if(false==startApp){
							ToastUtil.toast(context, R.string.qq_not_installed,Toast.LENGTH_SHORT);
						}
					}
				}
				
			}
		}while(false);
	
		return startApp;
	}
	
	/**
	 * open wechat
	 * @param context
	 * @return
	 */
	public static boolean enterWechat(Context context){
		boolean startApp=false;
		do{
			if(null==context){
				startApp=false;
				break;
			}
			
			startApp= AppUtil.startApp(context, AppPackageName.PACKAGE_NAME_WECHAT);
			
			if(false==startApp){
				ToastUtil.toast(context,R.string.wechat_not_installed,
						Toast.LENGTH_SHORT);
			}
		}while(false);
		
		return startApp;
	}
	
	/**
	 * open weibo
	 * @param context
	 * @return
	 */
	public static boolean enterWeibo(Context context){
		boolean startApp=false;
		do{
			if(null==context){
				startApp=false;
				break;
			}
			startApp= AppUtil.startApp(context, AppPackageName.PACKAGE_NAME_SINA_WEIBO);
			if(false==startApp){
				startApp= AppUtil.startApp(context, AppPackageName.PACKAGE_NAME_SINA_WEIBOG3);
		
				if(false==startApp){
					startApp= AppUtil.startApp(context, AppPackageName.PACKAGE_NAME_SINA_WEIBOHD);
			
					if(false==startApp){
						startApp= AppUtil.startApp(context, AppPackageName.PACKAGE_NAME_SINA_WEIBOPRO);
						
						if(false==startApp){
							ToastUtil.toast(context,R.string.sina_micro_bo_not_installed,Toast.LENGTH_SHORT);
						}
					}
				}
				
			}
		}while(false);
	
		return startApp;
	}
	/**
	 * 微信分享文字信息
	 * 
	 * @param context
	 * @param textContent
	 */
	public static void shareTextToWechat(Context context, String textContent) {
		int ret=shareToApp(context, textContent,AppPackageName.PACKAGE_NAME_WECHAT);
		if(SHARE_FAILED_APP_NOT_INSTALLED==ret){
			ToastUtil.toast(context,R.string.wechat_not_installed,
					Toast.LENGTH_SHORT);
		}
	}

	/**
	 * QQ分享文字信息
	 * 
	 * @param context
	 * @param textContent
	 */
	public static void shareTextToQq(Context context, String textContent) {
		int ret=shareToApp(context, textContent,AppPackageName.PACKAGE_NAME_QQ);
		if(SHARE_FAILED_APP_NOT_INSTALLED==ret){
			ret=shareToApp(context, textContent,AppPackageName.PACKAGE_NAME_QQLITE);
			if(SHARE_FAILED_APP_NOT_INSTALLED==ret){
				ret=shareToApp(context, textContent,AppPackageName.PACKAGE_NAME_QQI);
				if(SHARE_FAILED_APP_NOT_INSTALLED==ret){
					ret=shareToApp(context, textContent,AppPackageName.PACKAGE_NAME_QQMINIHD);
					if(SHARE_FAILED_APP_NOT_INSTALLED==ret){
						ToastUtil.toast(context,R.string.qq_not_installed,Toast.LENGTH_SHORT);
					}
				}
			}
			
		}
	}

	/**
	 * 腾讯微博分享文字信息
	 * 
	 * @param context
	 * @param textContent
	 */
	public static void shareTextToTencentWeibo(Context context, String textContent) {
		int ret=shareToApp(context, textContent,AppPackageName.PACKAGE_NAME_TENCENT_WEIBO);
		if(SHARE_FAILED_APP_NOT_INSTALLED==ret){
			ToastUtil.toast(context,R.string.tencent_micro_bo_not_installed,
					Toast.LENGTH_SHORT);
		}
	}

	/**
	 * 新浪微博分享文字信息
	 * 
	 * @param context
	 * @param textContent
	 */
	public static void shareTextToSinaWeibo(Context context, String textContent) {
		int ret=shareToApp(context, textContent,AppPackageName.PACKAGE_NAME_SINA_WEIBO);
		if(SHARE_FAILED_APP_NOT_INSTALLED==ret){
			ret=shareToApp(context, textContent, AppPackageName.PACKAGE_NAME_SINA_WEIBOG3);
			if(SHARE_FAILED_APP_NOT_INSTALLED==ret){
				ret=shareToApp(context, textContent, AppPackageName.PACKAGE_NAME_SINA_WEIBOHD);
					if(SHARE_FAILED_APP_NOT_INSTALLED==ret){
						ret=shareToApp(context, textContent, AppPackageName.PACKAGE_NAME_SINA_WEIBOHD);
						if(SHARE_FAILED_APP_NOT_INSTALLED==ret){
							ToastUtil.toast(context,R.string.sina_micro_bo_not_installed,
									Toast.LENGTH_SHORT);
						}
							
						
					}
				
				
			}
		}
	}

	/**
	 * 短信分享文字信息
	 * 
	 * @param context
	 * @param RecipientsPhoneNumber
	 *            用于接收联系人号码格式为"phoneNumber1;phoneNumber2;..."
	 * @param textContent
	 *            发送文字内容
	 */
	public static void shareTextToSms(Context context,
			String RecipientsPhoneNumber, String textContent) {
		Intent share = new Intent(Intent.ACTION_VIEW);

		share.putExtra("address", RecipientsPhoneNumber);
		share.putExtra("sms_body", textContent);
		share.setType("vnd.android-dir/mms-sms");

		context.startActivity(share);
	}

	/**
	 * 邮件分享文字信息
	 * 
	 * @param context
	 * @param subject
	 *            邮件主题
	 * @param textContent
	 *            邮件文字内容
	 */
	public static void shareTextToEmail(Context context, String subject,
			String textContent) {

		Intent share = new Intent(Intent.ACTION_SEND);
		share.setType("message/rfc822");
		// share.putExtra(Intent.EXTRA_TITLE, "TITLE");
		share.putExtra(Intent.EXTRA_SUBJECT, subject);
		share.putExtra(Intent.EXTRA_TEXT, textContent);

		context.startActivity(share);
	}

	/**
	 * 更多分享文字信息
	 * @param context
	 * @param title  
	 * 			标题选择
	 * @param textContent
	 *			分享文字内容
	 */
	public static void shareTextToMore(Context context,String title, String textContent){
		Intent share = new Intent(Intent.ACTION_SEND);
		share.setType("text/plain");
		share.putExtra(Intent.EXTRA_TEXT, textContent);

		context.startActivity(Intent.createChooser(share,title));
		
		return;
	}

	public static void shareInstalledApp(Context context,String packageName){
		do{
			if(null==context){
				break;
			}

			if(CommonUtil.isEmpty(packageName)){
				break;
			}

			PackageInfo packageInfo= AppUtil.getPackageInfo(context,packageName);
			if(null==packageInfo){
				break;
			}
			Intent shareApkIntent = new Intent();
			shareApkIntent.setAction(Intent.ACTION_SEND);
			shareApkIntent.putExtra(Intent.EXTRA_STREAM, Uri.fromFile(new File(packageInfo.applicationInfo.sourceDir)));
			shareApkIntent.setType("application/vnd.android.package-archive");

			context.startActivity(Intent.createChooser(shareApkIntent, packageInfo.applicationInfo.name));

		}while (false);
	}
	
	private static int shareToApp(Context context, String textContent, String packageName) {
		if (!AppUtil.isAppExist(context, packageName)) {
			return SHARE_FAILED_APP_NOT_INSTALLED;
		}

		Intent share = new Intent(Intent.ACTION_SEND);
		share.setType("text/plain");
		share.setPackage(packageName);
		share.putExtra(Intent.EXTRA_TEXT, textContent);
		context.startActivity(Intent.createChooser(share, context
				.getResources().getText(R.string.please_select)));

		return SHARE_SUCCESS;

	}
	
	/**
	 * share text by sms
	 * 
	 * @param context
	 * @param RecipientsPhoneNumber	phoneNumberformat:"phoneNumber1;phoneNumber2;..."
	 * @param textContent
	 *          
	 */
	public static void shareTextBySms(Context context,
			String RecipientsPhoneNumber, String textContent) {
		Intent share = new Intent(Intent.ACTION_VIEW);

		share.putExtra("address", RecipientsPhoneNumber);
		share.putExtra("sms_body", textContent);
		share.setType("vnd.android-dir/mms-sms");

		context.startActivity(share);
	}


	/**
	 * copy text
	 * @param context
	 * @param content
	 */
	public static void copyText( Context context,String content){
		ClipboardManager clipboardManager = (ClipboardManager)context.getSystemService(Context.CLIPBOARD_SERVICE);  
		ClipData clipData = ClipData.newPlainText("text", content);
		clipboardManager.setPrimaryClip(clipData);
	}

	/**
	 * copy text with tips
	 * @param context
	 * @param content
	 */
	public static void copyTextWithTips( Context context,String content){
		copyText(context,content);
		ToastUtil.toastLengthshort(context,context.getString(R.string.copy_content_success,content));
	}
	/**
	 * paste text
	 * @param context
	 * @return the string of paste text
	 */
	public static String pasteText(Context context){
		String text= Constant.NULL_STRING;
		ClipboardManager clipboardManager = (ClipboardManager)context.getSystemService(Context.CLIPBOARD_SERVICE);
		ClipData clipData=clipboardManager.getPrimaryClip();

		if (clipData != null && clipData.getItemCount() > 0) {
			// 从数据集中获取（粘贴）第一条文本数据
			text= clipData.getItemAt(0).getText().toString();
		}

		return text;
	}
}
