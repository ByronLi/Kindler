package csci310.plshireus.org.kindler;

import android.content.ComponentName;
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
import static android.support.test.espresso.matcher.ViewMatchers.hasFocus;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static android.support.test.espresso.matcher.ViewMatchers.withText;


@RunWith(AndroidJUnit4.class)
public class LoginFunctionalTest {


    @Rule
    public ActivityTestRule<Login> mActivityRule =
            new ActivityTestRule<>(Login.class);

    @Test
    public void TestLoginSuccess() throws InterruptedException{
        // Type text and then press the button.
        onView(withId(R.id.email))
                .perform(typeText("a@a.com"), closeSoftKeyboard());
        onView(withId(R.id.login)).perform(click());


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
        onView(withId(R.id.login)).perform(click());


        //wait for async postback
        Thread.sleep(3000);

        // Check that the activity was changed
        onView(withId(R.id.email))
                .check(matches(hasFocus()));
    }
}