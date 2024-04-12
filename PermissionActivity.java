
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.IntentSender;
import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.google.android.play.core.appupdate.AppUpdateInfo;
import com.google.android.play.core.appupdate.AppUpdateManager;
import com.google.android.play.core.appupdate.AppUpdateManagerFactory;
import com.google.android.play.core.install.InstallStateUpdatedListener;
import com.google.android.play.core.install.model.AppUpdateType;
import com.google.android.play.core.install.model.InstallStatus;
import com.google.android.play.core.install.model.UpdateAvailability;
import com.google.firebase.analytics.FirebaseAnalytics;

import photocreation.camera.blurcamera.Activity.HomeActivity;
import photocreation.camera.blurcamera.R;
import photocreation.camera.blurcamera.Utils.Tools;

public class PermissionActivity extends AppCompatActivity {
    LinearLayout btn_permission;
    public PermissionClass permissionClass = new PermissionClass(this);
    private FirebaseAnalytics mFirebaseAnalytics;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_permission);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
       




        btn_permission = findViewById(R.id.start_permission);




        btn_permission.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                PermissionClass permissionClass = PermissionActivity.this.permissionClass;
                PermissionClass.RequestPermissions();

            }
        });
    }


    @Override
    public void onRequestPermissionsResult(int i, String[] strArr, int[] iArr) {
        super.onRequestPermissionsResult(i, strArr, iArr);
        if (PermissionClass.HasPermission(PermissionActivity.this)) {

            Intent intent = new Intent(PermissionActivity.this, HomeActivity.class);
            startActivity(intent);
            finish();
        } else if (!PermissionClass.checkRequestPermissionRationale()) {
            PermissionClass.openSettingDialog();
        }
    }
}
