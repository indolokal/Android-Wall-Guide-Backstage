    

private void requestAPI(String remoteUrl) {
        if (remoteUrl.startsWith("http://") || remoteUrl.startsWith("https://")) {
            if (remoteUrl.contains("https://drive.google.com")) {
                String driveUrl = remoteUrl.replace("https://", "").replace("http://", "");
                List<String> data = Arrays.asList(driveUrl.split("/"));
                String googleDriveFileId = data.get(3);
                callbackConfigCall = RestAdapter.createApi().getDriveJsonFileId(googleDriveFileId);
            } else {
                callbackConfigCall = RestAdapter.createApi().getJsonUrl(remoteUrl);
            }
        } else {
            callbackConfigCall = RestAdapter.createApi().getDriveJsonFileId(remoteUrl);
        }
        callbackConfigCall.enqueue(new Callback<CallbackConfig>() {
            public void onResponse(@NonNull Call<CallbackConfig> call, @NonNull Response<CallbackConfig> response) {
                CallbackConfig resp = response.body();
                if (resp != null) {
                    notification = resp.notification;
                    FirebaseMessaging.getInstance().subscribeToTopic(notification.fcm_notification_topic);
                    OneSignal.setAppId(notification.onesignal_app_id);
                    Log.d(TAG, "FCM Subscribe topic : " + notification.fcm_notification_topic);
                    Log.d(TAG, "OneSignal App ID : " + notification.onesignal_app_id);
                }
            }

            public void onFailure(@NonNull Call<CallbackConfig> call, @NonNull Throwable th) {
                Log.e(TAG, "initialize failed : " + th.getMessage());
            }
        });
    }
