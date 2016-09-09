package com.littlebobbytables.helloworldv2;

import android.app.Activity;
import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;
import android.widget.EditText;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.content.Context;

/**
 * A placeholder fragment containing a simple view.
 */
public class MainActivityFragment extends Fragment implements Button.OnClickListener, TextWatcher{

    Button enterButton;
    EditText et;
    String TAG = "MyFragment";
    private FragmentListener fragListener;

    public MainActivityFragment() {
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        //Creating the view
        View view = inflater.inflate(R.layout.fragment_main, container, false);

        //Creating the editText listener
        et = (EditText) view.findViewById(R.id.editText);
        et.addTextChangedListener(this);

        //Creating the button listener
        enterButton = (Button)  view.findViewById(R.id.button);
        enterButton.setOnClickListener(this);

        return view;
    }

    public void onTextChanged (CharSequence s, int start, int before, int count) {
        //Don't need
        }


    public void beforeTextChanged( CharSequence s, int start, int count, int after) {
        //Don't need
    }
    public void afterTextChanged(Editable s) {
        //Don't need
    }

    public void onClick(View v) {
       if (v == enterButton) {
           //When they press the button, tell them hello! :)
           Toast.makeText(getActivity(), "Hello, " + et.getText().toString(), Toast.LENGTH_LONG).show();
           Log.d(TAG, et.getText().toString()); //Logging user's name
           fragListener.onFragmentInteraction(1, et.getText().toString()); //Sending name information to MainActivity
       }
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        Activity activity = getActivity();
        fragListener = (FragmentListener) activity;
    }

    @Override
    public void onDetach() {
        super.onDetach();
        fragListener = null;
    }


    public interface FragmentListener {
        public void onFragmentInteraction(Integer code, String name);
    }
}
