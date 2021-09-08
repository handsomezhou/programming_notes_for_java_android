package com.handsomezhou.demo.model;



import com.android.commontools.util.CommonUtil;

import java.util.Comparator;
/**
 * Created by handsomezhou on 2021/9/8.
 */
public class VersionInfo implements Cloneable{
	public static String KEY_ID="id";
	public static String KEY_VERSION_CODE="versionCode";
	public static String KEY_VERSION_NAME="versionName";
	public static String KEY_UPGRADE_INFO="upgradeInfo";
	public static String KEY_REMARK="remark";
	private long id;
	private String versionCode;
	private String versionName;
	private String upgradeInfo;
	private String remark;

	public VersionInfo() {
		super();

	}



	@Override
	protected Object clone() throws CloneNotSupportedException {

		return super.clone();
	}
	
	public static Comparator<VersionInfo> mSortByIdAsc = new Comparator<VersionInfo>() {

		@Override
		public int compare(VersionInfo lhs, VersionInfo rhs) {
			if((null==lhs)||(null==rhs)){
				return 0;
			}
			
			long compareResult = lhs.getId() - rhs.getId();
			
			return CommonUtil.compare(compareResult);
			
		}
	};
	
	public static Comparator<VersionInfo> mSortByIdDes = new Comparator<VersionInfo>() {

		@Override
		public int compare(VersionInfo lhs, VersionInfo rhs) {
			if((null==lhs)||(null==rhs)){
				return 0;
			}
			
			long compareResult=rhs.getId()-lhs.getId();
			return CommonUtil.compare(compareResult);
		}
	};

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getVersionCode() {
		return versionCode;
	}

	public void setVersionCode(String versionCode) {
		this.versionCode = versionCode;
	}

	public String getVersionName() {
		return versionName;
	}

	public void setVersionName(String versionName) {
		this.versionName = versionName;
	}

	public String getUpgradeInfo() {
		return upgradeInfo;
	}

	public void setUpgradeInfo(String upgradeInfo) {
		this.upgradeInfo = upgradeInfo;
	}

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}
}
