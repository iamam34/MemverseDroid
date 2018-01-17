package com.memverse.apiclient;

import com.memverse.apiclient.model.Memverse;

import org.hamcrest.BaseMatcher;
import org.hamcrest.Description;
import org.hamcrest.Matcher;

import java.util.Date;

import static org.hamcrest.CoreMatchers.allOf;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.not;
import static org.hamcrest.CoreMatchers.notNullValue;

/**
 * Created by amy on 17/01/18.
 */

public class CustomMatchers {

    public static Matcher<Date> isWithinASecondOf(final Date expectedDate) {
        final long oneSecond = 1000L;
        return new TimeDeltaMatcher(expectedDate, oneSecond);
    }

    private static class TimeDeltaMatcher extends BaseMatcher<Date> {
        private final Date expectedDate;
        private final long deltaMillis;

        TimeDeltaMatcher(Date expectedDate, long deltaMillis) {
            this.expectedDate = expectedDate;
            this.deltaMillis = deltaMillis;
        }

        @Override
        public boolean matches(Object actual) {
            Date actualDate = (Date) actual;
            return Math.abs(actualDate.getTime() - expectedDate.getTime()) < deltaMillis;
        }

        @Override
        public void describeTo(Description description) {
            description.appendValue(expectedDate);
        }
    }


    public static Matcher<String> isNotNullOrEmptyString() {
        return allOf(notNullValue(), not(equalTo("")));
    }

    public static Matcher<Memverse> hasId(final Long memverseId) {
        return new BaseMatcher<Memverse>() {

            private final Matcher<Long> idMatcher = equalTo(memverseId);

            @Override
            public boolean matches(Object item) {
                return idMatcher.matches(((Memverse) item).getId());
            }

            @Override
            public void describeTo(Description description) {
                description.appendText("memverse id ");
                description.appendDescriptionOf(idMatcher);
            }
        };
    }
}
