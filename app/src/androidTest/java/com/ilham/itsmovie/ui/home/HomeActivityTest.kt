package com.ilham.itsmovie.ui.home

import androidx.recyclerview.widget.RecyclerView
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions.click
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.contrib.RecyclerViewActions
import androidx.test.espresso.matcher.ViewMatchers.*
import androidx.test.ext.junit.rules.ActivityScenarioRule
import com.ilham.itsmovie.R
import com.ilham.itsmovie.utils.DataDummy
import org.junit.Rule
import org.junit.Test

class HomeActivityTest {

    private val dummyMovie = DataDummy.generateDummyMovies()
    private val dummyTvShow = DataDummy.generateDummyTvShow()

    @get:Rule
    var activityRule = ActivityScenarioRule(HomeActivity::class.java)

    @Test
    fun loadMovies() {
        onView(withId(R.id.rv_movie)).check(matches(isDisplayed()))
        onView(withId(R.id.rv_movie)).perform(RecyclerViewActions.scrollToPosition<RecyclerView.ViewHolder>(dummyMovie.size))
    }

    @Test
    fun loadDetailMovie() {
        onView(withId(R.id.rv_movie)).perform(RecyclerViewActions.actionOnItemAtPosition<RecyclerView.ViewHolder>(0, click()))
        onView(withId(R.id.text_title)).check(matches(isDisplayed()))
        onView(withId(R.id.text_title)).check(matches(withText(dummyMovie[0].title)))
        onView(withId(R.id.text_year)).check(matches(isDisplayed()))
        onView(withId(R.id.text_year)).check(matches(withText("${dummyMovie[0].releaseDate.substring(6, 10)} |")))
        onView(withId(R.id.text_user_score)).check(matches(isDisplayed()))
        onView(withId(R.id.text_user_score)).check(matches(withText("${dummyMovie[0].userScore} %")))
        var genreText = ""
        for ((i, genre) in dummyMovie[0].genres!!.withIndex()) {
            genreText += if (i == dummyMovie[0].genres!!.size - 1 || dummyMovie[0].genres!!.size == 1) {
                genre.genre!!
            } else {
                genre.genre!! + " - "
            }
        }
        onView(withId(R.id.text_genres)).check(matches(isDisplayed()))
        onView(withId(R.id.text_genres)).check(matches(withText(genreText)))
        onView(withId(R.id.text_review)).check(matches(isDisplayed()))
        onView(withId(R.id.text_review)).check(matches(withText(dummyMovie[0].review)))
        onView(withId(R.id.text_director)).check(matches(isDisplayed()))
        onView(withId(R.id.text_director)).check(matches(withText("Director: \n${dummyMovie[0].director}")))
        onView(withId(R.id.text_release)).check(matches(isDisplayed()))
        onView(withId(R.id.text_release)).check(matches(withText("Release: \n${dummyMovie[0].releaseDate}")))
        onView(withId(R.id.text_time)).check(matches(isDisplayed()))
        onView(withId(R.id.text_time)).check(matches(withText("| ${dummyMovie[0].time}")))
    }

    @Test
    fun loadTvShows() {
        onView(withText("Tv Shows")).perform(click())
        onView(withId(R.id.rv_tv_show)).check(matches(isDisplayed()))
        onView(withId(R.id.rv_tv_show)).perform(RecyclerViewActions.scrollToPosition<RecyclerView.ViewHolder>(dummyTvShow.size))
    }

    @Test
    fun loadDetailTvShow() {
        onView(withText("Tv Shows")).perform(click())
        onView(withId(R.id.rv_tv_show)).check(matches(isDisplayed()))
        onView(withId(R.id.rv_tv_show)).perform(RecyclerViewActions.actionOnItemAtPosition<RecyclerView.ViewHolder>(0, click()))
        onView(withId(R.id.text_title)).check(matches(isDisplayed()))
        onView(withId(R.id.text_title)).check(matches(withText(dummyTvShow[0].title)))
        onView(withId(R.id.text_year)).check(matches(isDisplayed()))
        onView(withId(R.id.text_year)).check(matches(withText("${dummyTvShow[0].year} |")))
        onView(withId(R.id.text_user_score)).check(matches(isDisplayed()))
        onView(withId(R.id.text_user_score)).check(matches(withText("${dummyTvShow[0].userScore} %")))
        var genreText = ""
        for ((i, genre) in dummyTvShow[0].genres!!.withIndex()) {
            genreText += if (i == dummyTvShow[0].genres!!.size - 1 || dummyTvShow[0].genres!!.size == 1) {
                genre.genre!!
            } else {
                genre.genre!! + " - "
            }
        }
        onView(withId(R.id.text_genres)).check(matches(isDisplayed()))
        onView(withId(R.id.text_genres)).check(matches(withText(genreText)))
        onView(withId(R.id.text_review)).check(matches(isDisplayed()))
        onView(withId(R.id.text_review)).check(matches(withText(dummyTvShow[0].review)))
        onView(withId(R.id.text_creator)).check(matches(isDisplayed()))
        onView(withId(R.id.text_creator)).check(matches(withText("Creator: \n${dummyTvShow[0].creator}")))
        onView(withId(R.id.text_episode_count)).check(matches(isDisplayed()))
        onView(withId(R.id.text_episode_count)).check(matches(withText("Episode Count: \n${dummyTvShow[0].episodeCount} Episode")))
        onView(withId(R.id.text_time)).check(matches(isDisplayed()))
        onView(withId(R.id.text_time)).check(matches(withText("| ${dummyTvShow[0].time}")))
    }
}