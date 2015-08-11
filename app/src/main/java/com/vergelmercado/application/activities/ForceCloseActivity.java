package com.vergelmercado.application.activities;


import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;


import com.vergelmercado.application.R;
import com.vergelmercado.application.interfaces.ExecuteAsyncTask;

import org.apache.http.NameValuePair;

import java.util.List;

public class ForceCloseActivity extends Activity implements ExecuteAsyncTask {

	String errorreport;
	EditText errormessage;
	ProgressDialog prog;

	@Override
	protected void onCreate(Bundle b) {
		super.onCreate(b);
		setContentView(R.layout.activity_forceclose);

		errormessage = (EditText) findViewById(R.id.errormessage);

		prog = new ProgressDialog(this);

		if (this.getIntent().getStringExtra("error") != null) {
			errorreport = this.getIntent().getStringExtra("error");
		}

	}

	public void SubmitButton(View v) {

//		new AsyncSaveErrorException(ForceCloseActivity.this, errorreport,
//				errormessage.getText().toString(), false).execute();


	}

	@Override
	public void onBackPressed() {
		super.onBackPressed();
		Intent homeIntent = new Intent(Intent.ACTION_MAIN);
		homeIntent.addCategory(Intent.CATEGORY_HOME);
		homeIntent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
		startActivity(homeIntent);
		android.os.Process.killProcess(android.os.Process.myPid());
		System.exit(10);

	}

	@Override
	public List<NameValuePair> Parameters(String title) {
		return null;
	}

	@Override
	public void getJsonResult(String result, String title, boolean IsError, TextView txtview) {

	}
}
