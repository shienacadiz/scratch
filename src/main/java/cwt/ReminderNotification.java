package cwt;

import cwt.models.TripDetail;

import java.time.Duration;
import java.time.ZonedDateTime;
import java.time.temporal.ChronoUnit;
import java.util.List;
import java.util.stream.Collectors;

/*

 */
public class ReminderNotification {

    private List<TripDetail> tripDetails;
    private ZonedDateTime timeOfExecution;

    public ReminderNotification(List<TripDetail> trips, ZonedDateTime time) {
        this.tripDetails = trips;
        this.timeOfExecution = time;
    }

    public List<TripDetail> getTripsDueForReminder(Integer reminderHour) {
        ZonedDateTime forecast = timeOfExecution.minusHours(reminderHour);
        return tripDetails.stream()
                .filter(trip -> ((trip.getFirstNotificationDate().isBefore(forecast) || trip.getFirstNotificationDate().isEqual(forecast)) &&
                        (ChronoUnit.HOURS.between(trip.getFirstNotificationDate(), trip.getLastNotificationDate()) < reminderHour)))
                .collect(Collectors.toList());
    }
}
