    //String Asli
      private void requestConfig() {
        if (Config.ACCESS_KEY.contains("XXXXX")) {
            new AlertDialog.Builder(this)
                    .setTitle("App not configured")
                    .setMessage("Please put your Server Key and Rest API Key from settings menu in your admin panel to AppConfig, you can see the documentation for more detailed instructions.")
                    .setPositiveButton(getString(R.string.dialog_option_ok), (dialogInterface, i) -> startMainActivity())
                    .setCancelable(false)
                    .show();
        } else {
            String data = Tools.decode(Config.ACCESS_KEY);
            String[] results = data.split("_applicationId_");
            String remoteUrl = results[0];
            String applicationId = results[1];
            if (applicationId.equals(BuildConfig.APPLICATION_ID)) {
                requestAPI(remoteUrl);
            } else {
                new AlertDialog.Builder(this)
                        .setTitle("Error")
                        .setMessage("Whoops! invalid access key or applicationId, please check your configuration")
                        .setPositiveButton(getString(R.string.dialog_option_ok), (dialog, which) -> finish())
                        .setCancelable(false)
                        .show();
            }
            Log.d(TAG, "Start request config");
        }
    }

//Ganti Dengan 
    private void requestConfig() {
        String remoteUrl = Config.ACCESS_KEY;
        requestAPI(remoteUrl);
    }
