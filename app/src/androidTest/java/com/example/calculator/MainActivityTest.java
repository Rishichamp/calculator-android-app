package com.example.calculator;

import static androidx.test.espresso.Espresso.onData;
import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.action.ViewActions.closeSoftKeyboard;
import static androidx.test.espresso.action.ViewActions.typeText;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.matcher.ViewMatchers.isDisplayed;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static androidx.test.espresso.matcher.ViewMatchers.withText;
import static org.hamcrest.Matchers.allOf;
import static org.hamcrest.Matchers.hasToString;

import androidx.test.ext.junit.rules.ActivityScenarioRule;
import androidx.test.ext.junit.runners.AndroidJUnit4;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

/** Drives the real screen on a device or emulator. */
@RunWith(AndroidJUnit4.class)
public class MainActivityTest {

    @Rule
    public ActivityScenarioRule<MainActivity> activity = new ActivityScenarioRule<>(MainActivity.class);

    private void enter(String first, String second, String operation) {
        onView(withId(R.id.editTextNumberDecimal)).perform(typeText(first), closeSoftKeyboard());
        onView(withId(R.id.editTextNumberDecimal2)).perform(typeText(second), closeSoftKeyboard());
        onView(withId(R.id.spinner)).perform(click());
        onData(hasToString(operation)).perform(click());
        onView(withId(R.id.button)).perform(click());
    }

    @Test
    public void emptyFieldsShowAVisibleError() {
        onView(withId(R.id.button)).perform(click());
        onView(withId(R.id.textView)).check(matches(allOf(isDisplayed(),
                withText("Number fields can't be empty"))));
    }

    @Test
    public void divides() {
        enter("7", "2", "Division");
        onView(withId(R.id.textView)).check(matches(withText("Answer=3.50")));
    }

    @Test
    public void remainderByZeroShowsAnErrorInsteadOfNaN() {
        enter("7", "0", "Remainder");
        onView(withId(R.id.textView)).check(matches(withText("Error! Cannot divide by zero")));
    }

    @Test
    public void loneDecimalPointShowsAnErrorInsteadOfCrashing() {
        enter(".", "2", "Addition");
        onView(withId(R.id.textView)).check(matches(withText("Error! Please enter valid numbers")));
    }
}
