package com.handsomezhou.customobjectpassed.activity;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.handsomezhou.customobjectpassed.R;
import com.handsomezhou.customobjectpassed.model.Student;
import com.handsomezhou.customobjectpassed.model.Teacher;

public class MainActivity extends Activity {
	private Context mContext;
	private Button mSerializableBtn;
	private Button mParcelableBtn;
	private Student mStudent;
	private Teacher mTeacher;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		initData();
		initView();
		initListener();
	}

	private void initData() {
		mContext = this;
		
		mStudent=new Student();
		mStudent.setId("000000");
		mStudent.setName("student");
		mStudent.setAge(18);
		
		mTeacher=new Teacher();
		mTeacher.setName("teacher");
		mTeacher.setAge(36);
		mTeacher.setCourse("math");
		
		return;
	}

	private void initView() {
		mSerializableBtn = (Button) findViewById(R.id.serializable_btn);
		mParcelableBtn = (Button) findViewById(R.id.parcelable_btn);

		return;
	}

	private void initListener() {
		mSerializableBtn.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				/*Toast.makeText(mContext, "mSerializableBtn", Toast.LENGTH_SHORT)
						.show();*/
				passObjectSerializable();
				
			}
		});

		mParcelableBtn.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Toast.makeText(mContext, "mParcelableBtn", Toast.LENGTH_SHORT)
						.show();
				passObjectParcelable();
			}
		});
	}
	
	private void passObjectSerializable(){
		Intent intent=new Intent(MainActivity.this,StudentActivity.class);
		intent.putExtra(StudentActivity.STUDENT_OBJECT, mStudent);
		startActivity(intent);
		return;
	}
	
	private void passObjectParcelable(){
		Intent intent=new Intent(MainActivity.this,TeacherActivity.class);
		intent.putExtra(TeacherActivity.TEACHER_OBJECT, mTeacher);
		startActivity(intent);
		return;

	}
}
