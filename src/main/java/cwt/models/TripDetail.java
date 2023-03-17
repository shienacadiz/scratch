package cwt.models;

import java.time.ZonedDateTime;

public class TripDetail {

    private String tripName;
    private ZonedDateTime firstNotificationDate;
    private ZonedDateTime lastNotificationDate;

    public String getTripName() {
        return tripName;
    }

    public void setTripName(String tripName) {
        this.tripName = tripName;
    }

    public ZonedDateTime getFirstNotificationDate() {
        return firstNotificationDate;
    }

    public void setFirstNotificationDate(ZonedDateTime firstNotificationDate) {
        this.firstNotificationDate = firstNotificationDate;
    }

    public ZonedDateTime getLastNotificationDate() {
        return lastNotificationDate;
    }

    public void setLastNotificationDate(ZonedDateTime lastNotificationDate) {
        this.lastNotificationDate = lastNotificationDate;
    }
}
