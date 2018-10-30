package csci310.plshireus.org.kindler;

import android.content.ComponentName;
import android.content.Intent;
import android.support.test.espresso.intent.rule.IntentsTestRule;
import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import static android.support.test.InstrumentationRegistry.getTargetContext;
import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.action.ViewActions.closeSoftKeyboard;
import static android.support.test.espresso.action.ViewActions.typeText;
import static android.support.test.espresso.assertion.ViewAssertions.matches;

import static android.support.test.espresso.intent.Intents.intended;
import static android.support.test.espresso.intent.matcher.IntentMatchers.hasComponent;
import static android.support.test.espresso.matcher.ViewMatchers.*;


@RunWith(AndroidJUnit4.class)
public class LoginFunctionalTest {


//    @Rule
//    public ActivityTestRule<Login> mLogin =
//            new ActivityTestRule<>(Login.class);

    @Rule
    public IntentsTestRule<Login> mActivity = new IntentsTestRule<Login>(Login.class);

    @Test
    public void TestLoginSuccess() throws InterruptedException{
        // Type text and then press the button.
        onView(withId(R.id.email))
                .perform(typeText("a@a.com"), closeSoftKeyboard());
        onView(withId(R.id.password)).perform(typeText("abc123"), closeSoftKeyboard());
        onView(withId(R.id.email_sign_in_button)).perform(click());


        //wait for async postback
        Thread.sleep(3000);

        // Check that the activity was changed
        intended(hasComponent(new ComponentName(getTargetContext(), MainActivity.class)));

    }

    @Test
    public void TestLoginFailure() throws InterruptedException{
        // Type text and then press the button.
        onView(withId(R.id.email))
                .perform(typeText("fake@email.com"), closeSoftKeyboard());
        onView(withId(R.id.password)).perform(typeText("abc123"), closeSoftKeyboard());
        onView(withId(R.id.email_sign_in_button)).perform(click());


        //wait for async postback
        Thread.sleep(3000);

        // Check that we failed the login
        onView(withId(R.id.password)).check(matches(hasErrorText("This password is incorrect")));
    }

    @Test
    public void TestSignupActivityChange() throws InterruptedException{

        onView(withId(R.id.link_signup)).perform(click());

        // Check that the activity was changed
        intended(hasComponent(new ComponentName(getTargetContext(), Signup.class)));

    }
}