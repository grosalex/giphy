package com.grosalex.giphy

import android.content.Intent
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions.click
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.ViewMatchers.*
import androidx.test.filters.LargeTest
import androidx.test.rule.ActivityTestRule
import androidx.test.runner.AndroidJUnit4
import com.grosalex.giphy.activity.MainActivity
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
@LargeTest
class MainActivityTest {

    @get:Rule
    var activityTest: ActivityTestRule<MainActivity> = ActivityTestRule<MainActivity>(MainActivity::class.java)
    @Before
    fun startIntent() {
        val startIntent = Intent()
        activityTest.launchActivity(startIntent)
    }

    @Test
    fun checkIconSearchClick(){
        onView(withId(R.id.iv_gif)).check(matches(withEffectiveVisibility(Visibility.VISIBLE)))
        onView(withId(R.id.menu_icon_search)).perform(click())
        onView(withId(R.id.rv_gif)).check(matches(withEffectiveVisibility(Visibility.VISIBLE)))
        onView(withId(R.id.et_search)).check(matches(withEffectiveVisibility(Visibility.VISIBLE)))
        onView(withId(R.id.iv_gif)).check(matches(withEffectiveVisibility(Visibility.GONE)))

    }

}