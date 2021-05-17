import java.util.Arrays;

public class PlaneGate {
    //please modify the following function
    public int minMeetingRooms(int[][] intervals) {
        if (intervals == null || intervals.length == 0) return 0;
        int[] start = new int[intervals.length];
        int[] end = new int[intervals.length];
        for (int i = 0; i < intervals.length; i++) {
            start[i] = intervals[i][0];
            end[i] = intervals[i][1];
        }
        Arrays.sort(start);
        Arrays.sort(end);
        int p1 = 0, p2 = 0;
        int rooms = 0;
        while (p1 < start.length) {
            if (start[p1] < end[p2]) { //give room and move p1
                rooms++;
                p1++;
            } else {// still use this room and move p1, p2
                p2++;
                p1++;
            }
        }
        return rooms;
    }

    public static int minGates(int[] landingT, int[] takeOffT, int maxWaitinTime, int initialPlanes) {
        if (takeOffT.length == 0) return landingT.length + initialPlanes;
        int p1 = 0, p2 = 0;
        int gates = 0 + initialPlanes;
        while (p1 < landingT.length) {
            int checkTime = landingT[p1] + maxWaitinTime;

            if (landingT[p1] + maxWaitinTime < takeOffT[p2]) { //give room and move p1
                gates++;
                p1++;
            } else {// still use this room and move p1, p2
                p2++;
                p1++;
            }
        }


        return gates;
    }

//    public static void main(String[] args) {
//        int[] l = new int[]{340, 1240, 1250, 1600, 1715, 1832, 2204};
//        int[] t = new int[]{1144,1305, 1318, 1612, 1801, 2141, 2300};
//
//        int ans = minGates(l, t, 15, 0);
//        System.out.println(ans);
//    }
}