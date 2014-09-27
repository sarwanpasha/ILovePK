package com.pakathon.ilovepk;

import android.app.Application;
import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.widget.Toast;

import com.parse.Parse;
import com.parse.ParseObject;

public class ILovePKApplication extends Application {

	@Override
	public void onCreate() {
		super.onCreate();
		if (isNetworkAvailable()) {
			Parse.initialize(this, "SNznxX2NRqs24iqCgBuIW1fxHdU80odnJpmqdgkd","9FC1P0MtuzuDM5FoDfaz1T73LVgy08F0C9Pjt4Lp");		  
		   //"WvGacP4lN3AL3CBbA2Ac5IajO2v3og11KZsMEQlS","kgbqaG2ZkJWGzuqAY58ru50uIXU2CANeKj3gkB8A"
		} else {
			Toast.makeText(this, "No Internet Connection", Toast.LENGTH_LONG)
					.show();
		}
	}

	private boolean isNetworkAvailable() {
		ConnectivityManager manager = (ConnectivityManager) getSystemService(Context.CONNECTIVITY_SERVICE);
		NetworkInfo networkInfo = manager.getActiveNetworkInfo();
		boolean isAvailable = false;
		if (networkInfo != null && networkInfo.isConnected()) {
			isAvailable = true;
		}
		return isAvailable;
	}
}
