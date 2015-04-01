package com.handsomezhou.customobjectpassed.activity;

import android.app.Activity;
import android.os.Bundle;
import android.widget.TextView;

import com.handsomezhou.customobjectpassed.R;
import com.handsomezhou.customobjectpassed.model.Student;

public class StudentActivity extends Activity {
	private final static String TAG="StudentActivity";
	public final static String STUDENT_OBJECT="STUDENT";
	private Student mStudent;
	private TextView mStudentTv;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_student);
		
		initData();
		initView();
		initListener();
	}
	
	private void initData(){
		mStudent=(Student) getIntent().getSerializableExtra(STUDENT_OBJECT);
		return;
	}
	
	private void initView(){
		mStudentTv=(TextView) findViewById(R.id.student_text_view);
		mStudentTv.setText(mStudent.getId()+"\n"+mStudent.getName()+"\n"+mStudent.getAge());
		return;
	}
	
	private void initListener(){
		
		return;
	}

}
