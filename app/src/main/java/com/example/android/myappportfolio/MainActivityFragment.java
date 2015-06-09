package com.example.android.myappportfolio;

import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static android.widget.Toast.*;

/**
 * A placeholder fragment containing a simple view.
 */
public class MainActivityFragment extends Fragment
{
    private ArrayAdapter<String> mAppListAdapter;

    //As suggested by the code reviewer, the toast is modified
    //to eliminate the delay when tapping on the list in short
    //amount of time.

    //Declare as class variable
    private Toast mAppToast;


    public MainActivityFragment()
    {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState)
    {


        /*
        Once the root view for the Fragment has been created, it's time to create
        the ListView with some dummy data.
         */

        String[] appsArray = {
                "Spotify Streamer",
                "Football SCores",
                "Library App",
                "Build it bigger",
                "XYZ Reader",
                "Capstone"
        };

        List<String> appList = new ArrayList<String>(Arrays.asList(appsArray));

        /*
        The dummy data is ready.
        Creating an ArrayAdapter that takes the data from a source(in this
        case the dummy data) to use it to populate the ListView it's attached to.
         */

        mAppListAdapter = new ArrayAdapter<String>(
                //The current context (this fragment's parent
                //activity)
                getActivity(),
                //ID of list item layout
                R.layout.list_item_appbutton,
                //ID of text to populate
                R.id.list_item_app_button,
                //Dummy data
                appList
        );


        View rootView = inflater.inflate(R.layout.fragment_main, container, false);
        final ListView listView = (ListView) rootView.findViewById(
                R.id.listview_apps);
        listView.setAdapter(mAppListAdapter);
        Log.d("********", "   test");
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener()
        {

            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long l)
            {
                String appname = mAppListAdapter.getItem(position);

                //Stop any previous toasts
                if(mAppToast !=null){
                    mAppToast.cancel();
                }

                //Make and display new toast
                mAppToast = Toast.makeText(getActivity(),appname,Toast.LENGTH_SHORT);
                mAppToast.show();


                //Log.d("**********", view.getParent().toString());
                //Toast.makeText(getActivity(), appname, Toast.LENGTH_SHORT).show();
            }
        });


        return rootView;
    }
}
