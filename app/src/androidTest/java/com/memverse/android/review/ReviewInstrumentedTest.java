package com.memverse.android.review;

import android.support.test.espresso.UiController;
import android.support.test.espresso.ViewAction;
import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;
import android.view.View;
import android.widget.Checkable;

import com.memverse.android.MainActivity;
import com.memverse.android.R;

import org.hamcrest.Matcher;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.action.ViewActions.typeText;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.contrib.DrawerActions.open;
import static android.support.test.espresso.contrib.NavigationViewActions.navigateTo;
import static android.support.test.espresso.matcher.ViewMatchers.hasFocus;
import static android.support.test.espresso.matcher.ViewMatchers.isChecked;
import static android.support.test.espresso.matcher.ViewMatchers.isDisplayed;
import static android.support.test.espresso.matcher.ViewMatchers.isNotChecked;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static android.support.test.espresso.matcher.ViewMatchers.withText;
import static org.hamcrest.CoreMatchers.allOf;
import static org.hamcrest.CoreMatchers.anyOf;
import static org.hamcrest.CoreMatchers.not;

/**
 * Instrumentation test, which will execute on an Android device.
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
@RunWith(AndroidJUnit4.class)
public class ReviewInstrumentedTest {

    @Rule
    public final ActivityTestRule<MainActivity> mActivityRule = new ActivityTestRule<>(MainActivity.class);

    @Before
    public void setUp() {
        onView(withId(R.id.drawer_layout)).perform(open());
        onView(withId(R.id.nav_view)).perform(navigateTo(R.id.menu_item_nav_review));
    }

    @Test
    public void initialState() {
        onView(withId(R.id.switch_show_full_text)).check(matches(isNotChecked()));
        onView(withId(R.id.editText_guess)).check(matches(allOf(withText(""), isDisplayed(), hasFocus())));
        onView(withId(R.id.textView_fullText)).check(matches(allOf(not(withText("")), not(isDisplayed()))));
        onView(withId(R.id.ratingBar)).check(matches(isDisplayed()));
    }

    @Test
    public void switchShowFullTextOn_showsFullText() {
        onView(withId(R.id.switch_show_full_text)).perform(setChecked(true));

        onView(withId(R.id.switch_show_full_text)).check(matches(isChecked()));
        onView(withId(R.id.editText_guess)).check(matches(not(isDisplayed())));
        onView(withId(R.id.textView_fullText)).check(matches(isDisplayed()));
    }

    @Test
    public void switchShowFullTextOff_showsGuessWithExistingText() {
        onView(withId(R.id.editText_guess)).perform(typeText("This is my guess"));
        onView(withId(R.id.switch_show_full_text)).perform(setChecked(true));
        onView(withId(R.id.switch_show_full_text)).perform(setChecked(false));

        onView(withId(R.id.switch_show_full_text)).check(matches(isNotChecked()));
        onView(withId(R.id.editText_guess)).check(matches(allOf(isDisplayed(), withText("This is my guess"))));
        onView(withId(R.id.textView_fullText)).check(matches(not(isDisplayed())));
    }

    private static ViewAction setChecked(final boolean checked) {
        return new ViewAction() {
            @Override
            public Matcher<View> getConstraints() {
                return anyOf(isChecked(), isNotChecked());
            }

            @Override
            public String getDescription() {
                return "set checked";
            }

            @Override
            public void perform(UiController uiController, View view) {
                Checkable checkableView = (Checkable) view;
                checkableView.setChecked(checked);
            }
        };
    }
}
