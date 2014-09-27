package com.pakathon.ilovepk;

import java.util.ArrayList;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.EditText;

public class InfoActivity extends Activity {
	//protected ArrayList ino=new ArrayList();

	//ArrayList<MainlogActivity> filelist=(ArrayList<MainlogActivity>)getIntent().getSerializableExtra("sarwan");
	protected EditText result;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		//String aio="";
		super.onCreate(savedInstanceState);
		setContentView(R.layout.info);
		result = (EditText) findViewById(R.id.ethotel);
		Bundle b=getIntent().getExtras();
		if (b!=null){
			 ArrayList<String> arr = (ArrayList<String>)b.getStringArrayList("array_list");
			 result.setText(arr.toString());
			 }
//		for(int i=0;i<=ino.size();i++){
//		//result.setText(ino.toString());
//		aio.concat(ino.get(i).toString());
//		}
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.info, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// Handle action bar item clicks here. The action bar will
		// automatically handle clicks on the Home/Up button, so long
		// as you specify a parent activity in AndroidManifest.xml.
		int id = item.getItemId();
		if (id == R.id.action_settings) {
			return true;
		}
		return super.onOptionsItemSelected(item);
	}
}
