package com.cosmo.arquitecturamvpbase;

import android.app.Application;
import android.content.Intent;
import android.util.Log;

import com.cosmo.arquitecturamvpbase.views.activities.DashBoardActivity;
import com.onesignal.OSNotification;
import com.onesignal.OSNotificationAction;
import com.onesignal.OSNotificationOpenResult;
import com.onesignal.OneSignal;

import org.json.JSONObject;

/**
 * Created by Lisandro Gómez on 11/7/17.
 */

public class App extends Application {

    @Override
    public void onCreate() {
        super.onCreate();
        settingOneSignal();

    }

    private void settingOneSignal(){
        OneSignal.startInit(this)
            .autoPromptLocation(false)
            .setNotificationReceivedHandler(new NotificationReciverHandler())
            .setNotificationOpenedHandler(new NotificationOpenedHandler())
            .inFocusDisplaying(OneSignal.OSInFocusDisplayOption.Notification)
            .unsubscribeWhenNotificationsAreDisabled(true)
            .init();
    }

    private class NotificationReciverHandler implements OneSignal.NotificationReceivedHandler{

        @Override
        public void notificationReceived(OSNotification notification) {
            JSONObject data = notification.payload.additionalData;
            String notificationID = notification.payload.notificationID;
            String title = notification.payload.title;

            Log.i("ONESIGNAL", "notificationID::" + notificationID);

            if (data != null) {
                String customKey = data.optString("ccustomkey", null);
                if (customKey != null) {
                    Log.i("ONESIGNAL", "token customkey::" + customKey);
                }
            }

        }
    }


    private class NotificationOpenedHandler implements OneSignal.NotificationOpenedHandler{

        @Override
        public void notificationOpened(OSNotificationOpenResult result) {
            OSNotificationAction.ActionType actionType = result.action.type;
            if (actionType == OSNotificationAction.ActionType.ActionTaken){
                Log.i("ONESIGNAL", ":OSNotificationAction:");
                Intent intent = new Intent(getApplicationContext(), DashBoardActivity.class);
                startActivity(intent);
            }
        }
    }


}
