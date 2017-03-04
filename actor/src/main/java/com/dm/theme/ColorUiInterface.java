package com.dm.theme;

import android.content.res.Resources;
import android.view.View;

/**
 * Created by m on 2017/3/4.
 * ${describe}
 */

public interface ColorUiInterface {

    View getView();

    void setTheme(Resources.Theme themeId);
}
