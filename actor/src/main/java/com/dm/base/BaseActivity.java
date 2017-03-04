package com.dm.base;

import android.annotation.TargetApi;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.Window;
import android.view.WindowManager;

import com.dm.R;
import com.dm.theme.Theme;
import com.dm.utils.PreUtils;

/**
 * Created by m on 2017/3/4.
 * ${describe}
 */

public class BaseActivity extends AppCompatActivity {

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        onPreCreated();
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {//api大于等于19
            setTranslucentStatus(true);
        }
    }

    private void onPreCreated() {
        Theme theme = PreUtils.getCurrentTheme(this);
        switch (theme) {
            case Blue:
                setTheme(R.style.BlueTheme);
                break;
            case BlueGrey:
                setTheme(R.style.BlueGreyTheme);
                break;
            case Brown:
                setTheme(R.style.BrownTheme);
                break;
            case Cyan:
                setTheme(R.style.CyanTheme);
                break;
            case DeepOrange:
                setTheme(R.style.DeepOrangeTheme);
                break;
            case DeepPurple:
                setTheme(R.style.DeepPurpleTheme);
                break;
            case Green:
                setTheme(R.style.GreenTheme);
                break;
            case Indigo:
                setTheme(R.style.IndigoTheme);
                break;
            case LightGreen:
                setTheme(R.style.LightGreenTheme);
                break;
            case Lime:
                setTheme(R.style.LimeTheme);
                break;
            case Orange:
                setTheme(R.style.OrangeTheme);
                break;
            case Pink:
                setTheme(R.style.PinkTheme);
                break;
            case Purple:
                setTheme(R.style.PurpleTheme);
                break;
            case Red:
                setTheme(R.style.RedTheme);
                break;
            case Teal:
                setTheme(R.style.TealTheme);
                break;
        }
    }

    @SuppressWarnings("unused")
    protected String getName() {
        return BaseActivity.class.getName();
    }

    @TargetApi(Build.VERSION_CODES.KITKAT)
    private void setTranslucentStatus(boolean on) {
        Window win = getWindow();
        WindowManager.LayoutParams winParams = win.getAttributes();
        final int bits = WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS;
        if (on) {
            winParams.flags |= bits;
        } else {
            winParams.flags &= ~bits;
        }
        win.setAttributes(winParams);
    }
}
