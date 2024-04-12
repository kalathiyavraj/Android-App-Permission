//Add Menifest You Need
    <uses-permission android:name="android.permission.INTERNET" />
    <uses-permission android:name="android.permission.WRITE_EXTERNAL_STORAGE" />
    <uses-permission android:name="android.permission.READ_EXTERNAL_STORAGE" />
    <uses-permission android:name="android.permission.NOTIFICATION" />
    <uses-permission android:name="android.permission.CAMERA" />
    <uses-permission android:name="com.google.android.gms.permission.AD_ID" />
    <uses-permission android:name="android.permission.ACCESS_NETWORK_STATE" />
    <uses-permission android:name="android.permission.READ_MEDIA_IMAGES" />
    <uses-permission android:name="android.permission.READ_MEDIA_AUDIO" />
    <uses-permission android:name="android.permission.READ_MEDIA_VIDEO" />
    <uses-permission android:name="android.permission.RECORD_AUDIO" />

//Call Class When You Need Permission
if (PermissionClass.HasPermission(SplashActivity.this)) {
                                            Intent next_home_activity = new Intent(SplashActivity.this, HomeActivity.class);
                                            startActivity(next_home_activity);
                                            finish();
                                        } else {
                                            Intent next_home_activity = new Intent(SplashActivity.this, PermissionActivity.class);
                                            startActivity(next_home_activity);
                                            finish();
                                        }

