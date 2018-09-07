package pl.wspologarniacz.mobile.auth.view

import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions.*
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.ViewMatchers.withId
import androidx.test.espresso.matcher.ViewMatchers.withText
import androidx.test.rule.ActivityTestRule
import androidx.test.runner.AndroidJUnit4
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import pl.wspologarniacz.mobile.R

@RunWith(AndroidJUnit4::class)
class AuthActivityTest {

    @Rule
    @JvmField
    val activityRule = ActivityTestRule<AuthActivity>(AuthActivity::class.java)

    @Test
    fun testInputFields() {
        val password = "secret"
        val email = "test@test.test"
        val username = "test"

        onView(withId(R.id.email_input)).perform(typeText(email), closeSoftKeyboard()).check(matches(withText(email)))
        onView(withId(R.id.username_input)).perform(typeText(username), closeSoftKeyboard()).check(matches(withText(username)))
        onView(withId(R.id.password_input)).perform(typeText(password), closeSoftKeyboard()).check(matches(withText(password)))
        onView(withId(R.id.confirmPassword_input)).perform(typeText(password), closeSoftKeyboard()).check(matches(withText(password)))
    }

    @Test
    fun testProperlyActionDisplayedDuringSignUp() {
        onView(withId(R.id.header)).check(matches(withText(R.string.sign_up_text)))
        onView(withId(R.id.action_chooser_text)).check(matches(withText(R.string.sign_in_chooser_text)))
        onView(withId(R.id.action_chooser)).check(matches(withText(R.string.sign_in_text)))
        onView(withId(R.id.action)).check(matches(withText(R.string.sign_up_text)))
    }

    @Test
    fun testActionChooserTextChange() {
        onView(withId(R.id.action_chooser_text)).check(matches(withText(R.string.sign_in_chooser_text)))
        onView(withId(R.id.action_chooser)).check(matches(withText(R.string.sign_in_text)))

        onView(withId(R.id.action_chooser)).perform(click())

        onView(withId(R.id.action_chooser)).check(matches(withText(R.string.sign_up_text)))
        onView(withId(R.id.action_chooser_text)).check(matches(withText(R.string.sign_up_chooser_text)))

        onView(withId(R.id.action_chooser)).perform(click())

        onView(withId(R.id.action_chooser_text)).check(matches(withText(R.string.sign_in_chooser_text)))
        onView(withId(R.id.action_chooser)).check(matches(withText(R.string.sign_in_text)))
    }

    @Test
    fun testNavigation() {

    }
}