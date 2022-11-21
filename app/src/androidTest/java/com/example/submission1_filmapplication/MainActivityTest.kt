package com.example.submission1_filmapplication

import androidx.recyclerview.widget.RecyclerView
import androidx.test.core.app.ActivityScenario
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.IdlingRegistry
import androidx.test.espresso.action.ViewActions.click
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.contrib.RecyclerViewActions
import androidx.test.espresso.matcher.ViewMatchers.*
import androidx.test.ext.junit.rules.ActivityScenarioRule
import com.example.submission1_filmapplication.`object`.Dummy
import com.example.submission1_filmapplication.`object`.Idling
import org.junit.After
import org.junit.Before
import org.junit.Rule
import org.junit.Test

class MainActivityTest {

    private val dataMov = Dummy.dataMov()
    private val dataTVshow = Dummy.dataTvshow()

    @get:Rule
    var ar = ActivityScenarioRule(MainActivity::class.java)

    @Before
    fun setUp() {
        ActivityScenario.launch(MainActivity::class.java)
        IdlingRegistry.getInstance().register(Idling.idling)
    }

    @After
    fun setUp1() {
        IdlingRegistry.getInstance().unregister(Idling.idling)
    }

    @Test
    fun loadDataMov() {

        onView(withId(R.id.fragment_movie)).check(matches(isDisplayed()))
        onView(withId(R.id.fragment_movie)).perform(
            RecyclerViewActions.scrollToPosition<RecyclerView.ViewHolder>(
                dataMov.size
            )
        )
    }

    @Test
    fun loadDataDetailMov() {
        onView(withId(R.id.fragment_movie)).perform(
            RecyclerViewActions.actionOnItemAtPosition<RecyclerView.ViewHolder>(
                0, click()
            )
        )
        onView(withId(R.id.tv_detail_title)).check(matches(isDisplayed()))
        onView(withId(R.id.tv_detail_desc)).check(matches(isDisplayed()))
        onView(withId(R.id.tv_detail_rating)).check(matches(isDisplayed()))
        onView(withId(R.id.iv_detail_img)).check(matches(isDisplayed()))
        onView(withId(R.id.fav_border)).perform(click())
        onView(withId(R.id.fav_border)).perform(click())
    }


    @Test
    fun loadDataTvshow() {
        onView(withText("TV SHOW")).perform(click())
        onView(withId(R.id.fragment_tvshow)).check(matches(isDisplayed()))
        onView(withId(R.id.fragment_tvshow)).perform(
            RecyclerViewActions.scrollToPosition<RecyclerView.ViewHolder>(
                dataTVshow.size
            )
        )
    }

    @Test
    fun loadDataDetailTvshow() {
        onView(withText("TV SHOW")).perform(click())
        onView(withId(R.id.fragment_tvshow)).perform(
            RecyclerViewActions.actionOnItemAtPosition<RecyclerView.ViewHolder>(
                0, click()
            )
        )
        onView(withId(R.id.tv_detail_title)).check(matches(isDisplayed()))
        onView(withId(R.id.tv_detail_desc)).check(matches(isDisplayed()))
        onView(withId(R.id.tv_detail_rating)).check(matches(isDisplayed()))
        onView(withId(R.id.iv_detail_img)).check(matches(isDisplayed()))
        onView(withId(R.id.fav_border)).perform(click())
        onView(withId(R.id.fav_border)).perform(click())

    }


}