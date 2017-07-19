package com.johnnyeric.androidfcmsetup;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import com.google.firebase.messaging.FirebaseMessaging;

import org.json.JSONObject;

public class MainActivity extends AppCompatActivity {
    String TAG = "MainActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        setNotificationMessage(getIntent());

        FirebaseMessaging.getInstance().subscribeToTopic("notification-topic");
    }

    @Override
    protected void onResume() {
        super.onResume();

        setNotificationMessage(getIntent());
    }

    private void setNotificationMessage(Intent intent) {
        String message = intent.getStringExtra("message");
        Log.d(TAG, "message: " + message);

        TextView notification = (TextView) findViewById(R.id.notification);
        if (message != null)
            notification.setText("Alerta: "+ message);

    }
}
