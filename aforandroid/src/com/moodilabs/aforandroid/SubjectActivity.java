package com.moodilabs.aforandroid;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

public class SubjectActivity extends Activity {

	protected static final String TAG = "SUBJECT ACTIVITY";
	private final String[] subjects = new String[] { "Lessons", "Videos",
			"Images", "Tests"

	};
	private ListView listView;
	private TextView textView;
	private String subject ;

	private OnItemClickListener listClickListener;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		//Reusing the same layout file. This is powerful, isn't it?
		setContentView(R.layout.activity_main);
		
		//Getting the string from the previous screen
		subject=getIntent().getExtras().getString("subject");
		textView = (TextView) findViewById(R.id.textView1);
		textView.setText(subject);

		listView = (ListView) findViewById(R.id.listView1);
		listView.setAdapter(new ArrayAdapter<String>(this,
				android.R.layout.simple_list_item_1, subjects));
		listClickListener = new OnItemClickListener() {

			@Override
			public void onItemClick(AdapterView<?> arg0, View arg1, int arg2,
					long arg3) {

				Log.d(TAG, (String) listView.getItemAtPosition(arg2));
				String selectedOption =  (String) listView.getItemAtPosition(arg2);
				Intent i = new Intent(getApplicationContext(),WebViewActivity.class);
				//Adding the selected option to the subject
				//^Just to show how useless comments can be in a self-explaining code.
				//And to show how important naming variables properly is.
				i.putExtra("urlKey", subject+selectedOption);
				startActivity(i);
			}
		};
		listView.setOnItemClickListener(listClickListener);
	}

	@Override
	protected void onResume() {
		super.onResume();
	}
}