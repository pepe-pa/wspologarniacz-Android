package pl.wspologarniacz.mobile.auth.view

import androidx.navigation.Navigation
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions
import androidx.test.espresso.assertion.ViewAssertions.doesNotExist
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.ViewMatchers
import androidx.test.espresso.matcher.ViewMatchers.isDisplayed
import androidx.test.espresso.matcher.ViewMatchers.withId
import androidx.test.rule.ActivityTestRule
import androidx.test.runner.AndroidJUnit4
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import pl.wspologarniacz.mobile.R

@RunWith(AndroidJUnit4::class)
class RegisterFragmentTest {

    @Rule
    @JvmField
    val activityRule = ActivityTestRule<AuthActivity>(AuthActivity::class.java)

    @Test
    fun testNavigateToLoginFragment() {
        onView(withId(R.id.action_chooser)).perform(ViewActions.click())
        onView(withId(R.id.header)).check(matches(ViewMatchers.withText(R.string.sign_in_text)))
        onView(withId(R.id.action)).check(matches(ViewMatchers.withText(R.string.sign_in_text)))

        onView(withId(R.id.confirmPassword)).check(doesNotExist())
        onView(withId(R.id.username)).check(doesNotExist())
        onView(withId(R.id.reset_password)).check(matches(isDisplayed()))
        onView(withId(R.id.password)).check(matches(isDisplayed()))
        onView(withId(R.id.email)).check(matches(isDisplayed()))

        /*clean up*/
        Navigation.findNavController(activityRule.activity, R.id.nav_host_fragment).navigate(R.id.action_loginFragment_to_registerFragment)
    }

}