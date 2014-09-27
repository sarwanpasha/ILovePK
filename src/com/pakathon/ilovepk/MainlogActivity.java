package com.pakathon.ilovepk;

import java.util.ArrayList;
import java.util.List;

//import com.example.dropdown.R;
import com.parse.FindCallback;
import com.parse.Parse;
import com.parse.ParseException;
import com.parse.ParseObject;
import com.parse.ParseQuery;

import android.R;
import android.app.Activity;
import android.content.Intent;
import android.content.DialogInterface.OnClickListener;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

public class MainlogActivity extends Activity {
	
	protected Button submit;
//	protected EditText from;
//	protected EditText to;
//	protected EditText budget;
//	protected EditText days;
	Spinner to;
	Spinner from;
	Spinner budget;
	Spinner days;
	protected ArrayList hotel=new ArrayList();
	protected ArrayList places=new ArrayList();


	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.mainlog);
		Parse.initialize(this, "SNznxX2NRqs24iqCgBuIW1fxHdU80odnJpmqdgkd","9FC1P0MtuzuDM5FoDfaz1T73LVgy08F0C9Pjt4Lp");		  
		submit = (Button) findViewById(R.id.btnsubmit);
		to=(Spinner) findViewById(R.id.spto);
		from=(Spinner) findViewById(R.id.spfrom);
		budget=(Spinner) findViewById(R.id.spbudget);
		days=(Spinner) findViewById(R.id.spdays);
//		from = (EditText) findViewById(R.id.etfrom);
//		to = (EditText) findViewById(R.id.etto);
//		days = (EditText) findViewById(R.id.etno);
//		budget= (EditText) findViewById(R.id.etbudget);
		String[] fromm = new String[]{"From", "Peshawar", "Swat","Lahore","Naraan"};
		String[] too = new String[]{"To", "Peshawar", "Swat","Lahore","Naraan"};
		String[] budgett = new String[]{"Budget", "1000-2000", "3000-4000","5000-6000","7000-8000"};
		String[] day = new String[]{"Days", "2", "3","4","5","6","7"};
		ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, fromm);
		from.setAdapter(adapter);
		ArrayAdapter<String> adapterto = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, too);
		to.setAdapter(adapterto);
		ArrayAdapter<String> adapterbudget = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, budgett);
		budget.setAdapter(adapterbudget);
		ArrayAdapter<String> adapterdays = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, day);
		days.setAdapter(adapterdays);
		submit.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				 Toast.makeText(MainlogActivity.this,"sarwan"+ String.valueOf(to.getSelectedItem()) +Toast.LENGTH_SHORT, 0).show();
				 Intent intent=new Intent(MainlogActivity.this,InfoActivity.class);
				// show.setText((CharSequence) dropdown.getSelectedItem());
			}
		});
		}
	

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.mainlog, menu);
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
