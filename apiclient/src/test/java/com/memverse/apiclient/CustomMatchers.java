package com.memverse.apiclient;

import org.hamcrest.BaseMatcher;
import org.hamcrest.Description;

import java.util.Date;

/**
 * Created by amy on 17/01/18.
 */

public class CustomMatchers {

    public static BaseMatcher<Date> isWithinASecondOf(final Date expectedDate) {
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
}
