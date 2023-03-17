package cwt;

import cwt.models.TripDetail;
import org.junit.Test;

import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

public class ReminderNotificationTest {
    private List<Integer> checkpointHours = Arrays.asList(2,5,10);

    private ReminderNotification reminderNotification;

    @Test
    public void testExecTimeAt1700Hour() {
        ZonedDateTime currentTime = ZonedDateTime.of(2023, 3, 17, 17, 0, 0, 123, ZoneId.of("UTC"));
        reminderNotification = new ReminderNotification(generateTestData(), currentTime);

        List<String> expectedTripsAt2Hr = Arrays.asList("trip3", "trip4");
        List<TripDetail> actualTripsAt2Hr = reminderNotification.getTripsDueForReminder(2);
        assertThat(actualTripsAt2Hr.size(), is(2));
        actualTripsAt2Hr.forEach(
                tripDetail -> assertThat(expectedTripsAt2Hr.contains(tripDetail.getTripName()), is(true))
        );

        List<String> expectedTripsAt5Hr = Arrays.asList("trip5");
        List<TripDetail> actualTripsAt5Hr = reminderNotification.getTripsDueForReminder(5);
        assertThat(actualTripsAt5Hr.size(), is(1));
        actualTripsAt5Hr.forEach(
                tripDetail -> assertThat(expectedTripsAt5Hr.contains(tripDetail.getTripName()), is(true))
        );

        List<String> expectedTripsAt10Hr = Arrays.asList("trip6", "trip7");
        List<TripDetail> actualTripsAt10Hr = reminderNotification.getTripsDueForReminder(10);
        assertThat(actualTripsAt10Hr.size(), is(2));
        actualTripsAt10Hr.forEach(
                tripDetail -> assertThat(expectedTripsAt10Hr.contains(tripDetail.getTripName()), is(true))
        );
    }

    @Test
    public void testExecTimeAt1900Hour() {
        ZonedDateTime currentTime = ZonedDateTime.of(2023, 3, 17, 19, 0, 0, 123, ZoneId.of("UTC"));
        reminderNotification = new ReminderNotification(generateTestData(), currentTime);

        List<String> expectedTripsAt2Hr = Arrays.asList("trip2", "trip3", "trip4");
        List<TripDetail> actualTripsAt2Hr = reminderNotification.getTripsDueForReminder(2);
        assertThat(actualTripsAt2Hr.size(), is(3));
        actualTripsAt2Hr.forEach(
                tripDetail -> assertThat(expectedTripsAt2Hr.contains(tripDetail.getTripName()), is(true))
        );

        List<String> expectedTripsAt5Hr = Arrays.asList("trip3", "trip5");
        List<TripDetail> actualTripsAt5Hr = reminderNotification.getTripsDueForReminder(5);
        assertThat(actualTripsAt5Hr.size(), is(2));
        actualTripsAt5Hr.forEach(
                tripDetail -> assertThat(expectedTripsAt5Hr.contains(tripDetail.getTripName()), is(true))
        );

        List<String> expectedTripsAt10Hr = Arrays.asList("trip1", "trip6", "trip7");
        List<TripDetail> actualTripsAt10Hr = reminderNotification.getTripsDueForReminder(10);
        assertThat(actualTripsAt10Hr.size(), is(3));
        actualTripsAt10Hr.forEach(
                tripDetail -> assertThat(expectedTripsAt10Hr.contains(tripDetail.getTripName()), is(true))
        );
    }

    private List<TripDetail> generateTestData() {
        TripDetail trip1 = new TripDetail();
        trip1.setTripName("trip1");
        trip1.setFirstNotificationDate(ZonedDateTime.of(2023, 3, 17, 9, 0, 0, 123, ZoneId.of("UTC")));
        trip1.setLastNotificationDate(ZonedDateTime.of(2023, 3, 17, 14, 0, 0, 123, ZoneId.of("UTC")));

        TripDetail trip2 = new TripDetail();
        trip2.setTripName("trip2");
        trip2.setFirstNotificationDate(ZonedDateTime.of(2023, 3, 17, 16, 0, 0, 123, ZoneId.of("UTC")));
        trip2.setLastNotificationDate(ZonedDateTime.of(2023, 3, 17, 16, 0, 0, 123, ZoneId.of("UTC")));

        TripDetail trip3 = new TripDetail();
        trip3.setTripName("trip3");
        trip3.setFirstNotificationDate(ZonedDateTime.of(2023, 3, 17, 14, 0, 0, 123, ZoneId.of("UTC")));
        trip3.setLastNotificationDate(ZonedDateTime.of(2023, 3, 17, 14, 0, 0, 123, ZoneId.of("UTC")));

        TripDetail trip4 = new TripDetail();
        trip4.setTripName("trip4");
        trip4.setFirstNotificationDate(ZonedDateTime.of(2023, 3, 17, 15, 0, 0, 123, ZoneId.of("UTC")));
        trip4.setLastNotificationDate(ZonedDateTime.of(2023, 3, 17, 15, 0, 0, 123, ZoneId.of("UTC")));

        TripDetail trip5 = new TripDetail();
        trip5.setTripName("trip5");
        trip5.setFirstNotificationDate(ZonedDateTime.of(2023, 3, 17, 11, 0, 0, 123, ZoneId.of("UTC")));
        trip5.setLastNotificationDate(ZonedDateTime.of(2023, 3, 17, 13, 0, 0, 123, ZoneId.of("UTC")));

        TripDetail trip6 = new TripDetail();
        trip6.setTripName("trip6");
        trip6.setFirstNotificationDate(ZonedDateTime.of(2023, 3, 17, 7, 0, 0, 123, ZoneId.of("UTC")));
        trip6.setLastNotificationDate(ZonedDateTime.of(2023, 3, 17, 12, 0, 0, 123, ZoneId.of("UTC")));

        TripDetail trip7 = new TripDetail();
        trip7.setTripName("trip7");
        trip7.setFirstNotificationDate(ZonedDateTime.of(2023, 3, 17, 5, 0, 0, 123, ZoneId.of("UTC")));
        trip7.setLastNotificationDate(ZonedDateTime.of(2023, 3, 17, 10, 0, 0, 123, ZoneId.of("UTC")));

        List<TripDetail> trips = new ArrayList<>();
        trips.add(trip1);
        trips.add(trip2);
        trips.add(trip3);
        trips.add(trip4);
        trips.add(trip5);
        trips.add(trip6);
        trips.add(trip7);
        return trips;
    }
}
