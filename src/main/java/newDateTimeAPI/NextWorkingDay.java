package newDateTimeAPI;

import java.time.temporal.*;

/**
 * Created by jason-geng on 1/27/17.
 */
public class NextWorkingDay implements TemporalAdjuster {
    @Override
    public Temporal adjustInto(Temporal temporal) {
        int day = temporal.get(ChronoField.DAY_OF_WEEK);
        if (day < 5){
            return temporal.plus(1, ChronoUnit.DAYS);
        }
        int diff = 7 - day + 1;
            return temporal.plus(diff, ChronoUnit.DAYS);
    }
}
