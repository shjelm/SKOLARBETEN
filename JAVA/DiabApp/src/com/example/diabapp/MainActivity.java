package com.example.diabapp;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends Activity {
	Button addBtn;
	Button viewVBtn;
	Button viewGBtn;
	
	//EditText editT;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        
        addBtn = (Button)findViewById(R.id.Add);
        viewVBtn = (Button)findViewById(R.id.ViewV);
        viewGBtn = (Button)findViewById(R.id.ViewG);
        
        
        addBtn.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
            	
            	Intent intent = new Intent(MainActivity.this, AddValue.class );
            	startActivity(intent);
            }
        });
        viewVBtn.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
            	Intent intent = new Intent(MainActivity.this, ViewValues.class );
            	startActivity(intent);
                
            }
        });
        viewGBtn.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                
            	Intent intent = new Intent(MainActivity.this, ViewGraphs.class );
            	startActivity(intent);
            	
  //          	editT = (EditText)findViewById(R.id.editText);
//            	editT.setBackgroundColor(0xfff000ff);
            }
        });
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }
    
}
