package com.example.android.teatime;

import android.app.Activity;
import android.app.Instrumentation;
import android.content.Intent;

import androidx.test.espresso.intent.rule.IntentsTestRule;
import androidx.test.ext.junit.runners.AndroidJUnit4;
import static androidx.test.espresso.intent.Intents.intending;
import static androidx.test.espresso.intent.Intents.intended;
import static androidx.test.espresso.intent.matcher.IntentMatchers.isInternal;
import static androidx.test.espresso.intent.matcher.IntentMatchers.hasAction;
import static androidx.test.espresso.intent.matcher.IntentMatchers.hasExtra;
import static org.hamcrest.core.AllOf.allOf;
import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static org.hamcrest.core.IsNot.not;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

@RunWith(AndroidJUnit4.class)
public class OrderSummaryActivityTest {
    private static final String emailMessage="I just ordered a delicious tea from TeaTime. Next time you are craving a tea, check them out!";
    @Rule
    public IntentsTestRule<OrderSummaryActivity> mActivityRule=new IntentsTestRule<>(OrderSummaryActivity.class);
    @Before
    public void stubExternalIntents() {
        intending(not(isInternal())).respondWith(new Instrumentation.ActivityResult(Activity.RESULT_OK, null));
    }
    @Test
    public void clickSendEmailButton_SendsEmail(){
        onView(withId(R.id.send_email_button)).perform(click());
        intended(allOf(hasAction(Intent.ACTION_SENDTO),
               hasExtra(Intent.EXTRA_TEXT,emailMessage)));
        }

}
