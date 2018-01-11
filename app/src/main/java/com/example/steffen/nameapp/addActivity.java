package com.example.steffen.nameapp;

import android.content.Context;
import android.content.pm.PackageManager;

/**
 * Created by Steffen on 11.01.2018.
 */

public class addActivity {

    /** Sjekke om det er kamera på enheten */
    private boolean checkCameraHardware(Context context) {
        if (context.getPackageManager().hasSystemFeature(PackageManager.FEATURE_CAMERA)){
            // Enheten har kamera
            return true;
        } else {
            // Enheten har ikke kamera
            return false;
        }
    }

} //class
