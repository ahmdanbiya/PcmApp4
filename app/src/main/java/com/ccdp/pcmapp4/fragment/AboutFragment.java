package com.ccdp.pcmapp4.fragment;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.ccdp.pcmapp4.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class AboutFragment extends Fragment {


    public AboutFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_about,
                container, false);
       /* WebView view = (WebView) rootView.findViewById(R.id.about1);
        String text = "<p align=\"justify\"><br>" +
                "<br>Jangan sia – siakan air jika anda ingin hidup lebih lama. Rata-rata, tubuh akan kehilangan 2-3 liter air per hari. Bahkan jika kita tidak melakukan kegiatan apapun, tubuh akan tetap kehilangan cairan.<br>" +
                "<br><b>SUMBER AIR</b><br>";
        view.loadDataWithBaseURL("file:///android_asset/", text, "text/html", "utf-8", null);
        */return rootView;
    }
}
