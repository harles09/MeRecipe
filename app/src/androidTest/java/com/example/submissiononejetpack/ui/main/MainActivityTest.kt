package com.example.submissiononejetpack.ui.main

import androidx.recyclerview.widget.RecyclerView
import androidx.test.core.app.ActivityScenario
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.IdlingRegistry
import androidx.test.espresso.action.ViewActions
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.contrib.RecyclerViewActions
import androidx.test.espresso.matcher.ViewMatchers.*
import androidx.test.ext.junit.rules.ActivityScenarioRule
import com.example.submissiononejetpack.R
import com.example.submissiononejetpack.utils.EspressoIdlingResource
import com.example.submissiononejetpack.utils.MovieData
import org.junit.After
import org.junit.Before
import org.junit.Rule
import org.junit.Test


class MainActivityTest {
    private val generateMovie = MovieData.generateMovieData()
    private val generateTvShow = MovieData.generateTvShow()

    @Before
    fun setUp() {
        ActivityScenario.launch(MainActivity::class.java)
        IdlingRegistry.getInstance().register(EspressoIdlingResource.idlingResource)
    }

    @After
    fun tearDown() {
        IdlingRegistry.getInstance().unregister(EspressoIdlingResource.idlingResource)
    }

    @get:Rule
    var activityRule = ActivityScenarioRule(MainActivity::class.java)

    @Test
    fun loadMovie() {
        onView(withId(R.id.rv_movie))
            .check(matches(isDisplayed()))
        onView(withId(R.id.rv_movie))
            .perform(RecyclerViewActions.scrollToPosition<RecyclerView.ViewHolder>(generateMovie.size))
    }

    @Test
    fun loadDetailMovie() {
        onView(withId(R.id.rv_movie))
            .perform(RecyclerViewActions.actionOnItemAtPosition<RecyclerView.ViewHolder>(0,
                ViewActions.click()
            ))
        onView(withId(R.id.tv_title))
            .check(matches(isDisplayed()))
        onView(withId(R.id.tv_title))
            .check(matches(withText(generateMovie[0].movieTitle)))
        onView(withId(R.id.tv_genre))
            .check(matches(isDisplayed()))
        onView(withId(R.id.tv_genre))
            .check(matches(withText(generateMovie[0].movieGenre)))
        onView(withId(R.id.rv_releasedate))
            .check(matches(isDisplayed()))
        onView(withId(R.id.rv_releasedate))
            .check(matches(withText(generateMovie[0].releaseDate)))
        onView(withId(R.id.pg_rating))
            .check(matches(isDisplayed()))
        onView(withId(R.id.pg_rating))
            .check(matches(withText(generateMovie[0].moviePG)))
        onView(withId(R.id.tv_rating))
            .check(matches(isDisplayed()))
        onView(withId(R.id.tv_rating))
            .check(matches(withText(generateMovie[0].movieRating)))
        onView(withId(R.id.tv_desc))
            .check(matches(isDisplayed()))
        onView(withId(R.id.tv_desc))
            .check(matches(withText(generateMovie[0].movieDesc)))
        onView(withId(R.id.floatingActionButton)).perform(ViewActions.click())
    }

    @Test
    fun loadTvShow() {
        onView(withText("Tv Show")).perform(ViewActions.click())
        onView(withId(R.id.rv_tvshow))
            .check(matches(isDisplayed()))
        onView(withId(R.id.rv_tvshow))
            .perform(RecyclerViewActions.scrollToPosition<RecyclerView.ViewHolder>(generateTvShow.size))
    }

    @Test
    fun loadDetailTvShow() {
        onView(withText("Tv Show")).perform(ViewActions.click())
        onView(withId(R.id.rv_tvshow))
            .perform(RecyclerViewActions.actionOnItemAtPosition<RecyclerView.ViewHolder>(0,
                ViewActions.click()
            ))
        onView(withId(R.id.tv_title))
            .check(matches(isDisplayed()))
        onView(withId(R.id.tv_title))
            .check(matches(withText(generateTvShow[0].tvShowTitle)))
        onView(withId(R.id.tv_genre))
            .check(matches(isDisplayed()))
        onView(withId(R.id.tv_genre))
            .check(matches(withText(generateTvShow[0].tvShowGenre)))
        onView(withId(R.id.rv_releasedate))
            .check(matches(isDisplayed()))
        onView(withId(R.id.rv_releasedate))
            .check(matches(withText(generateTvShow[0].releaseDate)))
        onView(withId(R.id.pg_rating))
            .check(matches(isDisplayed()))
        onView(withId(R.id.pg_rating))
            .check(matches(withText(generateTvShow[0].tvShowPG)))
        onView(withId(R.id.tv_rating))
            .check(matches(isDisplayed()))
        onView(withId(R.id.tv_rating))
            .check(matches(withText(generateTvShow[0].tvShowRating)))
        onView(withId(R.id.tv_desc))
            .check(matches(isDisplayed()))
        onView(withId(R.id.tv_desc))
            .check(matches(withText(generateTvShow[0].tvShowDesc)))
        onView(withId(R.id.floatingActionButton)).perform(ViewActions.click())
    }

}