package com.example.diabapp;

import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;
import android.widget.DatePicker; 
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.TimePicker;

public class AddValue extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_add_value);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.add_value, menu);
		return true;
	}

}
