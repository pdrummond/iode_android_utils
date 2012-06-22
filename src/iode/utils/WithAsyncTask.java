package iode.utils;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Context;
import android.os.AsyncTask;

public class WithAsyncTask {

	public static void doInBackground(final BackgroundFn backgroundFn) {
		new AsyncTask<Void, Void, Void>() {
			@Override
			protected Void doInBackground(Void... params) {
				backgroundFn.doInBackground();
				return null;
			}				
		}.execute((Void)null);
	}
	
	public static void doInBackgroundWithBusy(final Activity activity, final BackgroundFn backgroundFn) {
		new AsyncTask<Void, Void, Void>() {
			
			
			@Override
			protected void onPreExecute() {
				activity.setProgressBarIndeterminateVisibility(true);
			}

			@Override
			protected Void doInBackground(Void... params) {
				backgroundFn.doInBackground();
				return null;
			}
			
			@Override
			protected void onPostExecute(Void result) {
				activity.setProgressBarIndeterminateVisibility(false);
			}
		}.execute((Void)null);
	}

	public static void doInBackgroundWithBusy(final Activity activity, final BackgroundFn2 backgroundFn) {
		new AsyncTask<Void, Void, Void>() {
			@Override
			protected void onPreExecute() {
				activity.setProgressBarIndeterminateVisibility(true);
			}

			@Override
			protected Void doInBackground(Void... params) {
				backgroundFn.doInBackground();
				return null;
			}
			
			@Override
			protected void onPostExecute(Void result) {
				backgroundFn.onPostExecute();
				activity.setProgressBarIndeterminateVisibility(false);
			}
		}.execute((Void)null);
	}
	
	public static void doInBackgroundWithDlg(Context ctx, String msg, final BackgroundFn2 backgroundFn) {
		final ProgressDialog progressDialog;
		progressDialog = new ProgressDialog(ctx);
		progressDialog.setProgressStyle(ProgressDialog.STYLE_SPINNER);
		progressDialog.setMessage(msg);
		progressDialog.setCancelable(false);
		
		new AsyncTask<Void, Void, Void>() {
			@Override
			protected void onPreExecute() {
				progressDialog.show();
			}

			@Override
			protected Void doInBackground(Void... params) {
				backgroundFn.doInBackground();
				return null;
			}
			
			@Override
			protected void onPostExecute(Void result) {
				progressDialog.dismiss();
				backgroundFn.onPostExecute();
			}
		}.execute((Void)null);
	}
}
