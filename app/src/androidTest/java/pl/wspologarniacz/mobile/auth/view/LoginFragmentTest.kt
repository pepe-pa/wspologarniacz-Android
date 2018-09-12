package pl.wspologarniacz.mobile.auth.view

import androidx.navigation.Navigation
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions.click
import androidx.test.espresso.assertion.ViewAssertions.doesNotExist
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.ViewMatchers.*
import androidx.test.rule.ActivityTestRule
import androidx.test.runner.AndroidJUnit4
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import pl.wspologarniacz.mobile.R

@RunWith(AndroidJUnit4::class)
class LoginFragmentTest {

    @Rule
    @JvmField
    val activityRule = ActivityTestRule<AuthActivity>(AuthActivity::class.java)

    @Before
    fun setup() {
        Navigation.findNavController(activityRule.activity, R.id.nav_host_fragment).navigate(R.id.action_registerFragment_to_loginFragment)
    }

    @Test
    fun testResetPasswordDisplayed() {
        onView(withId(R.id.reset_password)).check(matches(isDisplayed()))
    }

    @Test
    fun testNavigateToRegisterFragment() {
        onView(withId(R.id.action_chooser)).perform(click())

        onView(withId(R.id.header)).check(matches(withText(R.string.sign_up_text)))
        onView(withId(R.id.action)).check(matches(withText(R.string.sign_up_text)))

        onView(withId(R.id.confirmPassword)).check(matches(isDisplayed()))
        onView(withId(R.id.username)).check(matches(isDisplayed()))
        onView(withId(R.id.password)).check(matches(isDisplayed()))
        onView(withId(R.id.email)).check(matches(isDisplayed()))

        /*clean up*/
        Navigation.findNavController(activityRule.activity, R.id.nav_host_fragment).navigate(R.id.action_registerFragment_to_loginFragment)
    }

    @Test
    fun testNavigateToResetPasswordFragment() {
        onView(withId(R.id.reset_password)).perform(click())
        onView(withId(R.id.header)).check(matches(withText(R.string.reset_password_text)))
        onView(withId(R.id.action)).check(matches(withText(R.string.reset_password_text)))
        onView(withId(R.id.password)).check(doesNotExist())
        onView(withId(R.id.reset_password)).check(doesNotExist())

        /*clean up*/
        Navigation.findNavController(activityRule.activity, R.id.nav_host_fragment).navigate(R.id.action_resetPasswordFragment_to_loginFragment)
    }


}