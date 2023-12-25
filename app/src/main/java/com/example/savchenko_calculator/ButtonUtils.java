package com.example.savchenko_calculator;

import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

public class ButtonUtils {

    public static int getButtonIdByButtonText(ViewGroup parentLayout, String buttonText) {
        int buttonId = View.NO_ID;

        for (int i = 0; i < parentLayout.getChildCount(); i++) {
            View view = parentLayout.getChildAt(i);

            if (view instanceof Button) {
                Button button = (Button) view;
                if (button.getText().toString().equals(buttonText)) {
                    buttonId = button.getId();
                    break;
                }
            }
        }

        return buttonId;
    }
}