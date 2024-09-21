package com.example.np.presto.Fragment;

import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.app.AlertDialog;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.MediaController;
import android.widget.Toast;
import android.widget.VideoView;

import com.example.np.presto.Activity.MainActivity;
import com.example.np.presto.R;

import static android.content.Context.LAYOUT_INFLATER_SERVICE;
import static android.support.v4.content.ContextCompat.getSystemService;

public class HomeFragment extends Fragment {

    private VideoView videoView;
    private MediaController mediaController;
    private ImageView imgOne, imgTwo, imgThree;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.home_layout,container,false);
        imgOne = view.findViewById(R.id.imageOne);
        imgOne.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getContext(), R.string.seebook, Toast.LENGTH_LONG).show();
            }
        });
        imgTwo = view.findViewById(R.id.imageTwo);
        imgTwo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getContext(), R.string.seeinstr, Toast.LENGTH_LONG).show();
            }
        });
        imgThree = view.findViewById(R.id.imageThree);
        imgThree.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getContext(), R.string.seebook, Toast.LENGTH_LONG).show();
            }
        });
        videoView = view.findViewById(R.id.videoView);
        mediaController = new MediaController(getContext());
        String videoPath = "android.resource://" + getActivity().getPackageName()+ "/" + R.raw.piano;
        Uri uri = Uri.parse(videoPath);
        videoView.setVideoURI(uri);
        videoView.setMediaController(mediaController);
        mediaController.setAnchorView(videoView);
        return view;
    }


}
