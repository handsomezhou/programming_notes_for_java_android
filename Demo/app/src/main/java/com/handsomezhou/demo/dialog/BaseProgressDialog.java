
package com.handsomezhou.demo.dialog;

import android.app.ProgressDialog;
import android.content.Context;

import com.handsomezhou.demo.R;

/**
 * Created by handsomezhou on 2021/9/8.
 */
public class BaseProgressDialog extends ProgressDialog {
    public BaseProgressDialog(Context context) {
        super(context, R.style.progress_dialog);

        setCanceledOnTouchOutside(true);
    }

    public void show(String message) {
        this.setMessage(message);
        this.show();
    }

    public void hide() {
        this.dismiss();

    }

}
