package pl.wspologarniacz.mobile.auth.view

import androidx.navigation.Navigation
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions.click
import androidx.test.espresso.assertion.ViewAssertions
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.ViewMatchers
import androidx.test.espresso.matcher.ViewMatchers.withId
import androidx.test.rule.ActivityTestRule
import androidx.test.runner.AndroidJUnit4
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import pl.wspologarniacz.mobile.R

@RunWith(AndroidJUnit4::class)
class ResetPasswordFragmentTest {

    @Rule
    @JvmField
    val activityRule = ActivityTestRule<AuthActivity>(AuthActivity::class.java)

    @Before
    fun setup() {
        openResetPasswordFromRegisterFragment()
    }


    @Test
    fun testNavigationToRegisterFragment() {
        onView(withId(R.id.action_chooser)).perform(click())

        onView(withId(R.id.header)).check(matches(ViewMatchers.withText(R.string.sign_up_text)))
        onView(withId(R.id.action)).check(matches(ViewMatchers.withText(R.string.sign_up_text)))

        onView(withId(R.id.confirmPassword)).check(matches(ViewMatchers.isDisplayed()))
        onView(withId(R.id.username)).check(matches(ViewMatchers.isDisplayed()))
        onView(withId(R.id.password)).check(matches(ViewMatchers.isDisplayed()))
        onView(withId(R.id.email)).check(matches(ViewMatchers.isDisplayed()))

        //clean up
        openResetPasswordFromRegisterFragment()
    }

    @Test
    fun testNavigationToLoginFragment() {
        Navigation.findNavController(activityRule.activity, R.id.nav_host_fragment).navigateUp()

        onView(withId(R.id.header)).check(matches(ViewMatchers.withText(R.string.sign_in_text)))
        onView(withId(R.id.action)).check(matches(ViewMatchers.withText(R.string.sign_in_text)))

        onView(withId(R.id.confirmPassword)).check(ViewAssertions.doesNotExist())
        onView(withId(R.id.username)).check(ViewAssertions.doesNotExist())
        onView(withId(R.id.reset_password)).check(matches(ViewMatchers.isDisplayed()))
        onView(withId(R.id.password)).check(matches(ViewMatchers.isDisplayed()))
        onView(withId(R.id.email)).check(matches(ViewMatchers.isDisplayed()))

        //clean up
        Navigation.findNavController(activityRule.activity, R.id.nav_host_fragment).navigate(R.id.action_loginFragment_to_resetPasswordFragment)

    }

    private fun openResetPasswordFromRegisterFragment() {
        onView(withId(R.id.action_chooser)).perform(click())
        onView(withId(R.id.reset_password)).perform(click())
    }

}