package com.handsomezhou.bottomtab.view;

import java.util.ArrayList;
import java.util.List;

import com.handsomezhou.bottomtab.model.IconButtonData;
import com.handsomezhou.bottomtab.model.IconButtonValue;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.Button;
import android.widget.LinearLayout;

public class BottomTabView extends LinearLayout {
    private static final int PADDING_DEFAULT=0;
    private static final int PADDING_LEFT_DEFAULT=0;
    private static final int PADDING_TOP_DEFAULT=0;
    private static final int PADDING_RIGHT_DEFAULT=0;
    private static final int PADDING_BOTTOM_DEFAULT=0;
    
    private static final int MARGIN_DEFAULT=0;
    private static final int MARGIN_LEFT_DEFAULT=0;
    private static final int MARGIN_TOP_DEFAULT=0;
    private static final int MARGIN_RIGHT_DEFAULT=0;
    private static final int MARGIN_BOTTOM_DEFAULT=0;
 
   
    private Context mContext;
	private List<IconButtonData> mIconButtonData;//data
	

	public BottomTabView(Context context, AttributeSet attrs) {
		super(context, attrs);
		mContext=context;
		initData();
		initView();
		initListener();		
	}
	
	private void initData(){
	    mIconButtonData=new ArrayList<IconButtonData>();
	    
	    return;
	}
	
	@SuppressWarnings("static-access")
    private void initView(){
	  /*  Button button=new Button(mContext);
	    button.setText("button");
	
	    LinearLayout.LayoutParams lp= new LinearLayout.LayoutParams(LayoutParams.MATCH_PARENT, LayoutParams.WRAP_CONTENT, 1.0f);
	    lp.setMargins(MARGIN_LEFT_DEFAULT, MARGIN_TOP_DEFAULT, MARGIN_RIGHT_DEFAULT, MARGIN_BOTTOM_DEFAULT);
	    button.setLayoutParams(lp);
	    this.addView(button);
	    
	    Button button2=new Button(mContext);
        button2.setText("button2");
	    this.addView(button2, lp);*/
	  
	    this.setOrientation(this.HORIZONTAL);
	    this.setPadding(PADDING_LEFT_DEFAULT, PADDING_TOP_DEFAULT, PADDING_RIGHT_DEFAULT, PADDING_BOTTOM_DEFAULT);
	       LinearLayout.LayoutParams lp= new LinearLayout.LayoutParams(LayoutParams.MATCH_PARENT, LayoutParams.WRAP_CONTENT, 1.0f);
	        lp.setMargins(MARGIN_LEFT_DEFAULT, MARGIN_TOP_DEFAULT, MARGIN_RIGHT_DEFAULT, MARGIN_BOTTOM_DEFAULT);
	           
	    this.setLayoutParams(lp);
	   
	    return;
	}
	
	private void initListener(){
	    
	    return;
	}
	
	public void addIconButtonData(IconButtonData iconButtonData){
	    
	    if(null==mIconButtonData){
	        mIconButtonData=new ArrayList<IconButtonData>();
	    }
	    
	    mIconButtonData.add(iconButtonData);
	    addIconButtonView(mIconButtonData.get(mIconButtonData.size()-1).getIconButtonView());
	    
	    return;
	}
	
	public void removeIconButtonData(IconButtonData iconButtonData){
	    
	}
	
	private void addIconButtonView(IconButtonView iconButtonView){
	    if(null==iconButtonView){
	        return;
	    }
	    LinearLayout.LayoutParams lp= new LinearLayout.LayoutParams(LayoutParams.MATCH_PARENT, LayoutParams.WRAP_CONTENT, 1.0f);
        lp.setMargins(MARGIN_LEFT_DEFAULT, MARGIN_TOP_DEFAULT, MARGIN_RIGHT_DEFAULT, MARGIN_BOTTOM_DEFAULT);
        iconButtonView.setLayoutParams(lp);
        this.addView(iconButtonView);
	}

}
