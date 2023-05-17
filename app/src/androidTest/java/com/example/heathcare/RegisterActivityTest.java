package com.example.heathcare;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.action.ViewActions.closeSoftKeyboard;
import static androidx.test.espresso.action.ViewActions.typeText;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.intent.Intents.intended;
import static androidx.test.espresso.intent.matcher.IntentMatchers.hasComponent;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static androidx.test.espresso.matcher.ViewMatchers.withText;

import androidx.test.espresso.intent.Intents;
import androidx.test.espresso.intent.matcher.IntentMatchers;

import android.app.Activity;
import android.app.Instrumentation;
import android.content.Context;
import android.content.Intent;
import android.util.Log;

import androidx.test.core.app.ActivityScenario;
import androidx.test.filters.LargeTest;
import androidx.test.platform.app.InstrumentationRegistry;
import androidx.test.ext.junit.runners.AndroidJUnit4;

import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import static org.junit.Assert.*;
@RunWith(AndroidJUnit4.class)
@LargeTest
public class RegisterActivityTest{
    private ActivityScenario<RegisterActivity> activityScenario;


    @Before
    public void setUp() throws Exception {
        activityScenario = ActivityScenario.launch(RegisterActivity.class);
    }

 /*   @Test
    public void testActivity() {
        onView(withId(R.id.button_Register)).perform(click());
        onView(withId(R.id.textView_Register)).check(matches(withText("Register")));
    }

    @Test
    public void useAppContext() {
        // Context of the app under test.
        Context appContext = InstrumentationRegistry.getInstrumentation().getTargetContext();
        assertEquals("com.example.heathcare", appContext.getPackageName());
    }
*/
    @Test
    public void testIntent() {
        // Create the Intent

/*
        Intent intent = new Intent( InstrumentationRegistry.getInstrumentation().getTargetContext(), LoginActivity.class);
        // intent.putExtra("my_param", "hello");

        // Launch the activity with the Intent
        activityScenario.onActivity(activity -> {
            activity.startActivity(intent);
        });

        // Verify that the activity was launched
        intended(hasComponent(LoginActivity.class.getName()));
        //  intended(hasExtra("my_param", "hello"));*/


        Intent intent = new Intent( InstrumentationRegistry.getInstrumentation().getTargetContext(), LoginActivity.class);
        Intents.init();
        Intents.intending(IntentMatchers.hasComponent(LoginActivity.class.getName())).respondWith(new Instrumentation.ActivityResult(Activity.RESULT_OK, intent));

        onView(withId(R.id.editTextUsername)).perform(typeText("ana")).perform(closeSoftKeyboard());
        onView(withId(R.id.editTextUserEmail)).perform(typeText("ana@gmail.com")).perform(closeSoftKeyboard());
        onView(withId(R.id.editTextPassword)).perform(typeText("ana!1234")).perform(closeSoftKeyboard());
        onView(withId(R.id.editTextConfirmPassword)).perform(typeText("ana!1234")).perform(closeSoftKeyboard());

        // Perform an action that should trigger the Intent
        onView(withId(R.id.button_Register)).perform(click());
        // Verify that the Intent was registered
        Intents.intended(IntentMatchers.hasComponent(LoginActivity.class.getName()));
     //   Intents.release();
    }


    @After
    public void tearDown() throws Exception {
        activityScenario.close();
    }
}
    