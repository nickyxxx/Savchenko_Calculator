package com.example.savchenko_calculator;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static androidx.test.espresso.matcher.ViewMatchers.withText;
import static org.hamcrest.Matchers.allOf;

import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import androidx.test.ext.junit.rules.ActivityScenarioRule;
import androidx.test.ext.junit.runners.AndroidJUnit4;
import androidx.test.filters.LargeTest;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

@LargeTest
@RunWith(AndroidJUnit4.class)
public class CheckAdditionButtonActivity {

    @Rule
    public ActivityScenarioRule<MainActivity> mActivityScenarioRule =
            new ActivityScenarioRule<>(MainActivity.class);

    @Test
    public void checkAddition() {
        enterDigit("7");

        clickButton(R.id.button_plus);

        enterDigit("4");
        enterDigit("2");

        checkTextView(R.id.solution_tv, "7+42");

        checkTextView(R.id.result_tv, "49");

        clickButton(R.id.button_equals);

        checkTextView(R.id.solution_tv, "49");

        clickButton(R.id.button_plus);

        enterDigit("1");
        enterDigit("0");

        enterDigit("2");

        clickButton(R.id.button_equals);

        checkTextView(R.id.result_tv, "151");

        checkTextView(R.id.solution_tv, "151");
    }

    private void enterDigit(String digit) {
        clickButton(getButtonIdByButtonText(digit));
    }


    private void clickButton(int buttonId) {
        onView(withId(buttonId)).perform(click());
    }

    private void checkTextView(int textViewId, String expectedText) {
        onView(withId(textViewId)).check(matches(withText(expectedText)));
    }

    private int getButtonIdByButtonText(String buttonText) {
        final int[] buttonId = {-1};

        mActivityScenarioRule.getScenario().onActivity(activity -> {
            View rootView = activity.getWindow().getDecorView();
            traverseViewTree(rootView, buttonText, (view, text) -> {
                if (view instanceof Button && ((Button) view).getText().toString().equals(text)) {
                    buttonId[0] = view.getId();
                }
            });
        });

        return buttonId[0];
    }

    private void traverseViewTree(View view, String text, CheckSubtractionButtonActivity.OnViewFoundListener listener) {
        if (view instanceof ViewGroup) {
            ViewGroup viewGroup = (ViewGroup) view;
            for (int i = 0; i < viewGroup.getChildCount(); i++) {
                traverseViewTree(viewGroup.getChildAt(i), text, listener);
            }
        } else {
            listener.onViewFound(view, text);
        }
    }
    }

