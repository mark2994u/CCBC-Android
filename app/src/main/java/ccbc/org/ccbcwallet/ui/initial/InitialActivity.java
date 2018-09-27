package ccbc.org.ccbcwallet.ui.initial;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import ccbc.org.ccbcwallet.CcbcApplication;
import ccbc.org.ccbcwallet.ui.splash_activity.SplashActivity;
import ccbc.org.ccbcwallet.ui.wallet_activity.WalletActivity;
import ccbc.org.ccbcwallet.utils.AppConf;

/**
 * Created by furszy on 8/19/17.
 */

public class InitialActivity extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        CcbcApplication ccbcApplication = CcbcApplication.getInstance();
        AppConf appConf = ccbcApplication.getAppConf();
        // show report dialog if something happen with the previous process
        Intent intent;
        if (!appConf.isAppInit() || appConf.isSplashSoundEnabled()){
            intent = new Intent(this, SplashActivity.class);
        }else {
            intent = new Intent(this, WalletActivity.class);
        }
        startActivity(intent);
        finish();
    }
}
