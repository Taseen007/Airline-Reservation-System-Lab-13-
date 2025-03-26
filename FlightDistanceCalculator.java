public class FlightDistanceCalculator {
    public static String[] calculateDistance(double lat1, double lon1, double lat2, double lon2) {
        double theta = lon1 - lon2;
        double distanceMiles = Math.sin(degreeToRadian(lat1)) * Math.sin(degreeToRadian(lat2)) + Math.cos(degreeToRadian(lat1)) * Math.cos(degreeToRadian(lat2)) * Math.cos(degreeToRadian(theta));
        distanceMiles = Math.acos(distanceMiles);
        distanceMiles = radianToDegree(distanceMiles);
        distanceMiles = distanceMiles * 60 * 1.1515;
        double distanceKm = distanceMiles * 1.609344;
        return new String[]{String.format("%.2f", distanceMiles), String.format("%.2f", distanceKm)};
    }

    private static double degreeToRadian(double deg) {
        return (deg * Math.PI / 180.0);
    }

    private static double radianToDegree(double rad) {
        return (rad * 180.0 / Math.PI);
    }
}