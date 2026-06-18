class Solution {
    public double angleClock(int hour, int minutes) {
        double result = 0;
        double hourHand = 0.5 * (hour * 60 + minutes);
        double minuteHand = 6 * minutes;
        result = Math.abs(hourHand - minuteHand);
        result = Math.min(360 - result, result);
        return result;        
    }
}