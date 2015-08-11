package com.vergelmercado.application.exception;

import android.content.Context;
import android.content.Intent;
import android.util.Log;
import com.vergelmercado.application.activities.ForceCloseActivity;

import java.io.PrintWriter;
import java.io.StringWriter;

public class ExceptionHandler implements
		Thread.UncaughtExceptionHandler {

	Context c;

	public ExceptionHandler(Context _c) {
		this.c = _c;
	}

	@Override
	public void uncaughtException(Thread thread, Throwable exception) {
		// TODO Auto-generated method stub
		StringWriter stackTrace = new StringWriter();
		exception.printStackTrace(new PrintWriter(stackTrace));
		StringBuilder errorReport = new StringBuilder();
		errorReport.append("************ CAUSE OF ERROR ************\n\n");
		errorReport.append(stackTrace.toString());

		errorReport.append("\n");

		Intent intent = new Intent(c, ForceCloseActivity.class);
		intent.putExtra("error", errorReport.toString());
		c.startActivity(intent);

		Log.d("ERROR:", errorReport + "");

		android.os.Process.killProcess(android.os.Process.myPid());
		System.exit(10);

	}

}
