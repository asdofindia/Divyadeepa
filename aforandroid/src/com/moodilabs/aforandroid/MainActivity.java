//The package name with which the app will be listed in the Play store

package com.moodilabs.aforandroid;

//Similar to include files in C/C++
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


//The first Activity(An activity is unique for every screen presented to the user)
//which is derived from the Activity base class
public class MainActivity extends Activity {

	//A unique tag used to differentiate the source of messages/errors in Logcat output
	//Logcat is something like the console you get in C/C++ programs, for lack of a better explanation.
	private static final String TAG = "MAIN ACTIVITY";
	
	private final String[] subjects = new String[]{ "English",
													"Kannada",
													"Science",
													"Mathematics"
	};
	private ListView listView;
	private TextView textView;
	private OnItemClickListener listClickListener ;
    
	//Refer http://developer.android.com/guide/components/activities.html for Android Lifecycle explanation
	@Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        //Set the layout for the screen
        //Check the activity_main.xml file in layout sub-folder in res folder.
        setContentView(R.layout.activity_main);
        
        //Link the TextView in the code to the TextView in the layout.
        //Do the same for the ListView.
        textView = (TextView) findViewById(R.id.textView1);
        textView.setText("Welcome to Divyadeepa's eLearning App");
        listView= (ListView) findViewById(R.id.listView1);
        
        
        //We need to adapt the array of strings into the list view.
        //For that we create an Array adapter which does the same and set it to the list view object we have.
        //I've used a shortcut here, where I have not declared a variable and initialized it.
        //Instead I create a new one without a name and set it directly to the list view.
        listView.setAdapter(new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, subjects));
        
        //We need an OnItemClickListener to detect clicks on each item of the list view.
        listClickListener= new OnItemClickListener() {
			
        	//On clicking an item on the listview, this method gets called.
        	//We get the parent view as arg0 (not needed), the view that's clicked as arg1 (again, not relevant)
        	//the position from top as arg2 (relevant), the view id as arg3(not relevant now)
        	//NOTE: the position is numbered starting from 0 corresponding to the topmost element
			@Override
			public void onItemClick(AdapterView<?> arg0, View arg1, int arg2,
					long arg3) {

				//This prints out the clicked element by getting the item at position arg2 and casting it to a string
				
				String selectedSubject =  (String) listView.getItemAtPosition(arg2);
				
				Log.d(TAG, selectedSubject);
				
				//Intent is a way communicating within Android
				//Here, we create an intent to start a new activity, i.e. to move to a new screen
				Intent i = new Intent(getApplicationContext(),SubjectActivity.class);
				//Passing the selected subject to the next screen, so that the next screen can act appropriately.
				i.putExtra("subject", selectedSubject);
				startActivity(i);
			}
		};

		//Linking the OnItemClickListener we have just created to the list view we have.
		listView.setOnItemClickListener(listClickListener);
    }

    @Override
    protected void onResume() {
    	super.onResume();
    }
}