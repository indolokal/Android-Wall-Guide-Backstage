# Blogspot Backend Json Panel
Blogspot Github App


//    private void requestConfig() {
//        if (!Config.ACCESS_KEY.contains("XXXXX")) {
//            String data = Tools.decode(Config.ACCESS_KEY);
//            String[] results = data.split("_applicationId_");
//            String remoteUrl = results[0];
//            requestAPI(remoteUrl);
//        }
//    }

    private void requestConfig() {
        String remoteUrl = Config.ACCESS_KEY;
        requestAPI(remoteUrl);
    }
