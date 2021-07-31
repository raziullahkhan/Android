package com.example.android.teatime;

import androidx.test.ext.junit.rules.ActivityScenarioRule;
import androidx.test.ext.junit.runners.AndroidJUnit4;
import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.matcher.ViewMatchers.withText;
import static androidx.test.espresso.Espresso.onData;
import static org.hamcrest.Matchers.anything;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

@RunWith(AndroidJUnit4.class)
public class MenuActivityScreenTest {
    public static final String TEA_NAME="Green Tea";
    @Rule
    public ActivityScenarioRule<MenuActivity> mActivityTestRule
            =new ActivityScenarioRule<MenuActivity>(MenuActivity.class);
    @Test
    public void clickGridViewItem_OpensOrderActivity(){
        onData(anything()).inAdapterView(withId(R.id.tea_grid_view)).atPosition(1).perform(click());
        onView(withId(R.id.tea_name_text_view)).check(matches(withText(TEA_NAME)));
    }
}
