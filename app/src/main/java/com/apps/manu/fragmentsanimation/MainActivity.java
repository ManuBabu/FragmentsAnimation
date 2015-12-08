package com.apps.manu.fragmentsanimation;

import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.Button;

public class MainActivity extends AppCompatActivity implements Frag_signup_login.OnFragmentInteractionListener,Frag_SignUp.OnFragmentInteractionListener, Frag_login.OnFragmentInteractionListener {

    Button login;
    Button signup;

    FragmentManager manager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        manager = getFragmentManager();
        signup = (Button) findViewById(R.id.button);

        addDefault();


    }


    public void addDefault() {
        Frag_signup_login a = new Frag_signup_login();
        FragmentTransaction transaction = manager.beginTransaction();
        transaction.add(R.id.fragment_layout, a, "A");
        transaction.commit();
        Log.d("try", "adding fragment A");
    }


    public void removeDefault() {
        Frag_signup_login a = (Frag_signup_login) manager.findFragmentByTag("A");
        FragmentTransaction transaction = manager.beginTransaction();
        transaction.remove(a);
        transaction.commit();
        Log.d("try", "removing fragment A");
    }

    public void addLogin() {

        Frag_login l = new Frag_login();
        FragmentTransaction transaction = manager.beginTransaction();
        transaction.add(R.id.fragment_layout, l, "L");
        transaction.commit();
        Log.d("try", "adding fragment L");
    }

    public void removeLogin() {
        Frag_login l = (Frag_login) manager.findFragmentByTag("L");
        FragmentTransaction transaction = manager.beginTransaction();
        // transaction.setCustomAnimations(R.anim.scalein,R.anim.scaleout);
        transaction.remove(l);
        transaction.commit();
        Log.d("try", "removing fragment L");
    }

    public void addSignUp() {

        Frag_SignUp s = new Frag_SignUp();
        FragmentTransaction transaction = manager.beginTransaction();
        transaction.add(R.id.fragment_layout, s, "S");
        transaction.commit();
        Log.d("try", "adding fragment S");
    }

    public void removeSignUp() {
        Frag_SignUp s = (Frag_SignUp) manager.findFragmentByTag("S");
        FragmentTransaction transaction = manager.beginTransaction();
        transaction.remove(s);
        transaction.commit();
        Log.d("try", "removing fragment L");
    }

    @Override
    public void onFragmentInteraction(Uri uri) {

    }

    @Override
    public void loginonFragmentInteraction(Uri uri) {

    }

    @Override
    public void SignuponFragmentInteraction(Uri uri) {

    }
}
