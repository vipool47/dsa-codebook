package math;

public class AngleBetweenHandsOfClock {
    public double angleClock(int hour, int minutes) {
        double ans = 0;

        // Calculate the angle of the hour hand
        // Each hour represents 30 degrees (360 degrees / 12 hours)
        // Each minute represents 0.5 degrees (30 degrees / 60 minutes)
        ans = Math.abs( (30 * hour) - (5.5 * minutes) );

        // If the angle is greater than 180 degrees, return the smaller angle
        // since the hands of the clock can form two angles, we want the smaller one
        if(ans > 180){
            return 360 - ans;
        }

        return ans;
    }
}
