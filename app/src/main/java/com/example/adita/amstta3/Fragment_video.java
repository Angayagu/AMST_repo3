package com.example.adita.amstta3;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.MediaController;
import android.widget.VideoView;

import com.github.mikephil.charting.charts.LineChart;

public class Fragment_video extends Fragment {
    private LineChart mChart;
    public Fragment_video() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view =  inflater.inflate(R.layout.activity_fragment_video, container, false);
        mChart = (LineChart) view.findViewById(R.id.linechart);
        mChart.setTouchEnabled(true);
        mChart.setPinchZoom(true);

        creacionVideo(view);
        // Inflate the layout for this fragment
        return view;
    }
    VideoView videoyoutube;

    public void creacionVideo(View vi) {
        Uri uri = Uri.parse("rtsp://r4---sn-q4fl6nlr.googlevideo.com/Cj0LENy73wIaNAlahqGbPHCHuBMYDSANFC1LpAZdMOCoAUIASARg6If39aTb84xaigELUG5hLXM2N080bW8M/9E44583B98D8B7A75E0CD2E4E2E4B8873F99EEE2.7E9B712D6ADDE137CC8282D9B39109C9DF5323F1/yt8/1/video.3gp");
        videoyoutube.setMediaController(new MediaController(getContext()));
        videoyoutube.setVideoURI(uri);
        videoyoutube.requestFocus();
        videoyoutube.start();

    }
}
