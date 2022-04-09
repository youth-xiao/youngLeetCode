class Solution {
    public int numberOfRounds(String loginTime, String logoutTime) {
        String[] logins = loginTime.split(":");
        int loginHour = Integer.parseInt(logins[0]);
        int loginMin = Integer.parseInt(logins[1]);
        int loginInMinutes = loginHour * 60 + loginMin;
        
        String[] logouts = logoutTime.split(":");
        int logoutHour = Integer.parseInt(logouts[0]);
        int logoutMin = Integer.parseInt(logouts[1]);
        int logoutInMinutes = logoutHour * 60 + logoutMin;
        
        int round = 0;
        
        int newLoginInMinutes = loginInMinutes;
        int newLogoutInMinutes = logoutInMinutes;
        
        int loginRemainder = loginInMinutes % 15;
        if (loginRemainder != 0) {
            newLoginInMinutes = loginInMinutes / 15 * 15 + 15;
        }
        int logoutRemainder = logoutInMinutes % 15;
        if (logoutRemainder != 0) {
            newLogoutInMinutes = logoutInMinutes / 15 * 15;
        }
        
        if (loginInMinutes <= logoutInMinutes) { // same day
            int diff = newLogoutInMinutes - newLoginInMinutes;
            round = diff / 15;
        } else { // across two days
            int roundFirstDay = ((24 * 60) - loginInMinutes) / 15;
            int roundSecondDay = logoutInMinutes / 15;
            round = roundFirstDay + roundSecondDay;
        }
        
        return round < 0 ? 0 : round;
    }
}