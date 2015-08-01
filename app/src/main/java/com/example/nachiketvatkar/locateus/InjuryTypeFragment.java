package com.example.nachiketvatkar.locateus;

import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.provider.MediaStore;
import android.os.Bundle;
import android.content.pm.PackageInfo;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android. view.ViewGroup;
import android.widget.Toast;





public class InjuryTypeFragment extends StudentFlow.PlaceholderFragment {
    static final int REQUEST_IMAGE_CAPTURE = 1;
   // static final int RESULT_OK= 1;
    ImageView OnlyImage;


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        Toast.makeText(getActivity().getApplicationContext(), "On Create View", Toast.LENGTH_LONG).show();

        View view = inflater.inflate(R.layout.fragment_injury_type, container, false);
        return view;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        Toast.makeText(getActivity().getApplicationContext(), "On View created", Toast.LENGTH_LONG).show();

        Button ImageInjury = (Button) getView().findViewById(R.id.ImageInjury);
        OnlyImage = (ImageView) getView().findViewById(R.id.OnlyImage);
//        Disable button if the user has no camera
        if (!hasCamera()) {
            ImageInjury.setEnabled(false);
        }

    }

    //Checks if user has a camera
    private boolean hasCamera() {
        Toast.makeText(getActivity().getApplicationContext(), "Has Camera", Toast.LENGTH_LONG).show();
        boolean b=true;
        PackageManager pm = getActivity().getApplicationContext().getPackageManager();
        b = pm.hasSystemFeature(PackageManager.FEATURE_CAMERA_ANY);
        return b;
    }

    public void launchCamera(View view){
        Intent intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
        //Take picture and pass results to onActivityResults
        startActivityForResult(intent, REQUEST_IMAGE_CAPTURE);
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        if(requestCode == REQUEST_IMAGE_CAPTURE ){
            //Get the photo
            Bundle extras = data.getExtras();
            Bitmap photo = (Bitmap) extras.get("data");
            OnlyImage.setImageBitmap(photo);
        }
    }

}