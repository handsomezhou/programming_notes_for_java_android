package com.handsomezhou.customobjectpassed.activity;

import android.app.Activity;
import android.os.Bundle;
import android.widget.TextView;

import com.handsomezhou.customobjectpassed.R;
import com.handsomezhou.customobjectpassed.model.Teacher;

public class TeacherActivity extends Activity{
	private final static String TAG="StudentActivity";
	public final static String TEACHER_OBJECT="TEACHER";
	private Teacher mTeacher;
	private TextView mTeacherTv;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_teacher);
		
		initData();
		initView();
		initListener();
	}
	
	private void initData(){
		mTeacher=(Teacher) getIntent().getParcelableExtra(TEACHER_OBJECT);
		return;
	}
	
	private void initView(){
		mTeacherTv=(TextView) findViewById(R.id.teacher_text_view);
		mTeacherTv.setText(mTeacher.getName()+"\n"+mTeacher.getAge()+"\n"+mTeacher.getCourse());
		return;
	}
	
	private void initListener(){
		
		return;
	}
}
