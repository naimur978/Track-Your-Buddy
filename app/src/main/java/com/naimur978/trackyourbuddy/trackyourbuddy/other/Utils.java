package com.naimur978.trackyourbuddy.trackyourbuddy.other;

import com.google.firebase.database.FirebaseDatabase;



public class Utils {
    private static FirebaseDatabase mDatabase;

    public static FirebaseDatabase getDatabase() {
        if (mDatabase == null) {
            mDatabase = FirebaseDatabase.getInstance();
            mDatabase.setPersistenceEnabled(true);
        }
        return mDatabase;
    }
}
