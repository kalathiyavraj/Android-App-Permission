
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Build;

import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

public class PermissionClass {
    public static String[] all_permissions = {"android.permission.WRITE_EXTERNAL_STORAGE", "android.permission.READ_EXTERNAL_STORAGE", "android.permission.CAMERA"};
    public static String[] all_permissions_33 = {"android.permission.CAMERA", "android.permission.READ_MEDIA_IMAGES", "android.permission.READ_MEDIA_VIDEO","android.permission.POST_NOTIFICATIONS"};
    public static Activity mActivity;

    public PermissionClass(Activity activity) {
        mActivity = activity;
    }

    public static String[] permissions() {
        if (Build.VERSION.SDK_INT >= 33) {
            return all_permissions_33;
        }
        return all_permissions;
    }

    public static void RequestPermissions() {
        try {
            ActivityCompat.requestPermissions(mActivity, permissions(), 1);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static boolean HasPermission(Context context) {
        if (Build.VERSION.SDK_INT >= 33) {
            if (ContextCompat.checkSelfPermission(context, "android.permission.CAMERA") == 0 && ContextCompat.checkSelfPermission(context, "android.permission.READ_MEDIA_IMAGES") == 0 && ContextCompat.checkSelfPermission(context, "android.permission.READ_MEDIA_VIDEO") == 0) {
                return true;
            }
        } else if (ContextCompat.checkSelfPermission(context, "android.permission.WRITE_EXTERNAL_STORAGE") == 0 && ContextCompat.checkSelfPermission(context, "android.permission.READ_EXTERNAL_STORAGE") == 0 && ContextCompat.checkSelfPermission(context, "android.permission.CAMERA") == 0) {
            return true;
        }
        return false;
    }
    public static boolean checkRequestPermissionRationale() {
        if (Build.VERSION.SDK_INT >= 33) {
            if (!ActivityCompat.shouldShowRequestPermissionRationale(mActivity, "android.permission.CAMERA") && !ActivityCompat.shouldShowRequestPermissionRationale(mActivity, "android.permission.READ_MEDIA_IMAGES") && !ActivityCompat.shouldShowRequestPermissionRationale(mActivity, "android.permission.READ_MEDIA_VIDEO")) {
                return false;
            }
        } else if (!ActivityCompat.shouldShowRequestPermissionRationale(mActivity, "android.permission.CAMERA") && !ActivityCompat.shouldShowRequestPermissionRationale(mActivity, "android.permission.READ_EXTERNAL_STORAGE") && !ActivityCompat.shouldShowRequestPermissionRationale(mActivity, "android.permission.WRITE_EXTERNAL_STORAGE")) {
            return false;
        }
        return true;
    }

    public static void openSettingDialog() {
        Intent intent = new Intent("android.settings.APPLICATION_DETAILS_SETTINGS");
        intent.addFlags(268435456);
        intent.setData(Uri.fromParts("package", PermissionClass.mActivity.getPackageName(), null));
        PermissionClass.mActivity.startActivity(intent);
    }
}
