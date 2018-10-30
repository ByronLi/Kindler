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
import static android.support.test.espresso.matcher.ViewMatchers.isDisplayed;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static android.support.test.espresso.matcher.ViewMatchers.withText;


@RunWith(AndroidJUnit4.class)
public class CreateBookTest {


    @Rule
    public ActivityTestRule<Login> mActivityRule =
            new ActivityTestRule<>(Login.class);

    @Test
    public void TestCreateBookSuccessOne() {
        onView(withId(R.id.title)).perform(typeText("Harry Potter 2"), closeSoftKeyboard());
        onView(withText("Harry Potter 2")).check(matches(isDisplayed()));
        onView(withId(R.id.authorName)).perform(typeText("JK Rowling"), closeSoftKeyboard());
        onView(withText("JK Rowling")).check(matches(isDisplayed()));
        onView(withId(R.id.spinnerGenres)).perform(typeText("Fiction"), closeSoftKeyboard());
        onView(withText("Fiction")).check(matches(isDisplayed()));
        onView(withId(R.id.bookPrice)).perform(typeText("10"), closeSoftKeyboard());
        onView(withText("10")).check(matches(isDisplayed()));
    }

    @Test
    public void TestCreateBookSuccessTwo() {
        onView(withId(R.id.title)).perform(typeText(""), closeSoftKeyboard());
        onView(withText("")).check(matches(isDisplayed()));
        onView(withId(R.id.authorName)).perform(typeText("JK Rowling"), closeSoftKeyboard());
        onView(withText("JK Rowling")).check(matches(isDisplayed()));
        onView(withId(R.id.spinnerGenres)).perform(typeText("Fiction"), closeSoftKeyboard());
        onView(withText("Fiction")).check(matches(isDisplayed()));
        onView(withId(R.id.bookPrice)).perform(typeText("10"), closeSoftKeyboard());
        onView(withText("10")).check(matches(isDisplayed()));
    }

    @Test
    public void TestCreateBookSuccessThree() {
        onView(withId(R.id.title)).perform(typeText("Harry Potter 2"), closeSoftKeyboard());
        onView(withText("Harry Potter 2")).check(matches(isDisplayed()));
        onView(withId(R.id.authorName)).perform(typeText(""), closeSoftKeyboard());
        onView(withText("")).check(matches(isDisplayed()));
        onView(withId(R.id.spinnerGenres)).perform(typeText("Fiction"), closeSoftKeyboard());
        onView(withText("Fiction")).check(matches(isDisplayed()));
        onView(withId(R.id.bookPrice)).perform(typeText("10"), closeSoftKeyboard());
        onView(withText("10")).check(matches(isDisplayed()));
    }

    @Test
    public void TestCreateBookSuccessFour() {
        onView(withId(R.id.title)).perform(typeText(""), closeSoftKeyboard());
        onView(withText("")).check(matches(isDisplayed()));
        onView(withId(R.id.authorName)).perform(typeText(""), closeSoftKeyboard());
        onView(withText("")).check(matches(isDisplayed()));
        onView(withId(R.id.spinnerGenres)).perform(typeText("Fiction"), closeSoftKeyboard());
        onView(withText("Fiction")).check(matches(isDisplayed()));
        onView(withId(R.id.bookPrice)).perform(typeText("10"), closeSoftKeyboard());
        onView(withText("10")).check(matches(isDisplayed()));
    }
}