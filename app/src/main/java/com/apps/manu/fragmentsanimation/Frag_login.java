package com.apps.manu.fragmentsanimation;

import android.app.Activity;
import android.app.Fragment;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.ScaleAnimation;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;


/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link Frag_login.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link Frag_login#newInstance} factory method to
 * create an instance of this fragment.
 */
public class Frag_login extends Fragment {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    Button cancle;
    Button login,fgt_pass;
    EditText email,pass;

    ScaleAnimation scaleout;


    private OnFragmentInteractionListener mListener;

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment Frag_login.
     */
    // TODO: Rename and change types and number of parameters
    public static Frag_login newInstance(String param1, String param2) {
        Frag_login fragment = new Frag_login();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    public Frag_login() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view= inflater.inflate(R.layout.fragment_frag_login, container, false);
       AlphaAnimation alphain = new AlphaAnimation(1,0);
        alphain.setDuration(1000);


        ScaleAnimation scale = new ScaleAnimation(0.3f,1.0f,0.3f,1.0f, Animation.RELATIVE_TO_SELF, 0.5f, Animation.RELATIVE_TO_SELF, 0.0f);
        scale.setDuration(100);



    //    ScaleAnimation scale = new ScaleAnimation()
        login = (Button) view.findViewById(R.id.btn_login_done);
        login.setVisibility(View.INVISIBLE);
        login.setAnimation(scale);
        login.setVisibility(View.VISIBLE);


        cancle = (Button) view.findViewById(R.id.btn_login_cancle);
        cancle.setVisibility(View.INVISIBLE);
        cancle.setAnimation(scale);
        cancle.setVisibility(View.VISIBLE);

        email = (EditText) view.findViewById(R.id.email_login);
        scale.setDuration(100);
        email.setAnimation(scale);

        pass = (EditText) view.findViewById(R.id.pass_login);
        scale.setDuration(200);
        pass.setAnimation(scale);

        fgt_pass = (Button) view.findViewById(R.id.forgot_Pass);
        scale.setDuration(500);
        fgt_pass.setAnimation(scale);



        cancle.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ((MainActivity) getActivity()).removeLogin();
                ((MainActivity) getActivity()).addDefault();
            }
        });

        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getActivity(), "clicked Login", Toast.LENGTH_LONG).show();
            }
        });

        return  view;
    }

    // TODO: Rename method, update argument and hook method into UI event
    public void onButtonPressed(Uri uri) {
        if (mListener != null) {
            mListener.loginonFragmentInteraction(uri);
        }
    }

    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        try {

            mListener = (OnFragmentInteractionListener) activity;
        } catch (ClassCastException e) {
            throw new ClassCastException(activity.toString()
                    + " must implement OnFragmentInteractionListener");
        }
    }

    @Override
    public void onDestroyView() {
        Log.d("detach","On detach is called");
        login.setAnimation(scaleout);
        cancle.setAnimation(scaleout);
        Log.d("anim","animation is executing");
        email.setAnimation(scaleout);
        pass.setAnimation(scaleout);
        fgt_pass.setAnimation(scaleout);
        super.onDestroyView();
    }

    @Override
    public void onDetach() {



        super.onDetach();
        mListener = null;
    }

    /**
     * This interface must be implemented by activities that contain this
     * fragment to allow an interaction in this fragment to be communicated
     * to the activity and potentially other fragments contained in that
     * activity.
     * <p/>
     * See the Android Training lesson <a href=
     * "http://developer.android.com/training/basics/fragments/communicating.html"
     * >Communicating with Other Fragments</a> for more information.
     */
    public interface OnFragmentInteractionListener {
        // TODO: Update argument type and name
        public void loginonFragmentInteraction(Uri uri);
    }

}
