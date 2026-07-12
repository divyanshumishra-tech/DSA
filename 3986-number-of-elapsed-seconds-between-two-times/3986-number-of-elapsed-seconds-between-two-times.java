class Solution {
    public int secondsBetweenTimes(String startTime, String endTime) {
         String t1[]= startTime.split(":");
        String t2[]= endTime.split(":");
        int hour1=Integer.parseInt(t1[0])*3600+
                   Integer.parseInt(t1[1])*60+
                      Integer.parseInt(t1[2]);
        int hour2=Integer.parseInt(t2[0])*3600+
                    Integer.parseInt(t2[1])*60+
                       Integer.parseInt(t2[2]);
        //if(hour2<hour1) hour2+=24*3600;
        return hour2-hour1;
    }
}