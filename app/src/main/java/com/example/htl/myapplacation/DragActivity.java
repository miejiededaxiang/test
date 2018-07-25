package com.example.htl.myapplacation;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

public class DragActivity extends AppCompatActivity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_drag);
	}

	public void onClick(View view) {
		Toast.makeText(this, "========", Toast.LENGTH_SHORT).show();
	}

	public void onClick1(View view) {
		Toast.makeText(this, "22222", Toast.LENGTH_SHORT).show();
	}
}
