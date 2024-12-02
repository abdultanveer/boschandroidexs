package com.example.bosch

import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions.click
import androidx.test.espresso.action.ViewActions.closeSoftKeyboard
import androidx.test.espresso.action.ViewActions.typeText
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.ViewMatchers.withId
import androidx.test.espresso.matcher.ViewMatchers.withText
import androidx.test.ext.junit.rules.ActivityScenarioRule
import androidx.test.ext.junit.runners.AndroidJUnit4
import androidx.test.filters.LargeTest
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith


@LargeTest
@RunWith(AndroidJUnit4::class)
class MainActivityUiTest {


    @Rule
    @JvmField
    var mActivityScenarioRule = ActivityScenarioRule(MainActivity::class.java)


    @Test
    fun loginTest() {
        //enter abdul android in etphone
        onView(withId(R.id.etPhone))
            .perform(typeText("abdul android"), closeSoftKeyboard());
        //click btnAlarm
        onView(withId(R.id.btnAlarm)).perform(click());
        //check if tvMain has abdul android
        onView(withId(R.id.tvMain))
            .check(matches(withText("abdul android")));
    }
}