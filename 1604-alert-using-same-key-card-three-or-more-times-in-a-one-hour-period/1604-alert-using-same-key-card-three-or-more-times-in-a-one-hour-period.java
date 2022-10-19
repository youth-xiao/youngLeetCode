 class Solution {
    public List<String> alertNames(String[] keyName, String[] keyTime) {
        // we use TreeSet here because we want to maintain the order of insertion
        Map<String, TreeSet<Integer>> map = new HashMap<>();
        for (int i = 0; i < keyName.length; i++) {
            int time = parseTime(keyTime[i]);
            map.computeIfAbsent(keyName[i], s -> new TreeSet<>()).add(time);
        }
        // we use TreeSet for string because it sorts the key alphabetically naturally
        TreeSet<String> names = new TreeSet<>();
        for (Map.Entry<String, TreeSet<Integer>> e : map.entrySet()) {
            List<Integer> list = new ArrayList<>(e.getValue()); // we have to convert the tree set to list first in order to use get().
            if (list.size() >= 3) {
                for (int i = 2; i < list.size(); i++) { // no need to start from 0 or 1, because even the previous two times are very close, it doesn't break the rule. We just need to compare the first one and the last one within a frame containing three time points
                    if (list.get(i) - list.get(i - 2) <= 60) {
                        names.add(e.getKey());
                        break; // when we find one exception, we don't need to see if there are other invalid entried afterwards for this employee
                    }
                }  
            }
        }
        return new ArrayList<>(names); // same here, we need to return a list not a tree set
    }
     
    private int parseTime(String s) {
        String[] times = s.split(":");
        int h = Integer.parseInt(times[0]);
        int min = Integer.parseInt(times[1]);
        return (h*60 + min);
    }
 }

//  class Solution {
//     public List<String> alertNames(String[] keyName, String[] keyTime) {
//         Map<String, TreeSet<Integer>> map = new HashMap<>();
//         for (int i = 0; i < keyName.length; i++) {
//             int time = parseTime(keyTime[i]);
//             map.computeIfAbsent(keyName[i], s -> new TreeSet<>()).add(time);
//         }
//         TreeSet<String> names = new TreeSet<>();
//         for (Map.Entry<String, TreeSet<Integer>> e : map.entrySet()) {
//             Deque<Integer> dq = new ArrayDeque<>();
//             for (int time : e.getValue()) {
//                 dq.offer(time);
//                 if (dq.peekLast() - dq.peek() > 60) {
//                     dq.poll();
//                 }
//                 if (dq.size() >= 3) {
//                     names.add(e.getKey());
//                     break;
//                 }
//             }
//         }
//         return new ArrayList<>(names);
//     }
     
//     private int parseTime(String s) {
//         String[] times = s.split(":");
//         int h = Integer.parseInt(times[0]);
//         int min = Integer.parseInt(times[1]);
//         return (h*60 + min);
//     }
//  }

// class Solution { // my own version, TLE
//     public List<String> alertNames(String[] keyName, String[] keyTime) {
//         List<String> res = new ArrayList<>();
//         int left = 0;
//         int right = 1;
//         while (right < keyName.length) {
//             String name = keyName[left];
//             String startTime = keyTime[left];

//             while (keyName[right] == name) {
//                 right++;
//                 if (right - left + 1 >= 3) {
//                     String endTime = keyTime[right];
//                     int duration = calculateTimeDiff(startTime, endTime);
//                     if (duration <= 60) {
//                         res.add(name);
//                         break;
//                     }
//                 }
//                 left += (right - left + 1);
//             }
//         }
        
//         Collections.sort(res);
//         return res;
//     }
    
//     private int calculateTimeDiff(String startTime, String endTime) {
//         String[] startTimes = startTime.split(":");
//         int hStart = Integer.parseInt(startTimes[0]);
//         int minStart = Integer.parseInt(startTimes[1]);
        
//         String[] endTimes = endTime.split(":");
//         int hEnd = Integer.parseInt(endTimes[0]);
//         int minEnd = Integer.parseInt(endTimes[1]);
        
//         int diff = (hEnd*60 + minEnd) - (hStart*60 + minStart);
//         if (diff < 0) {
//             diff += (24 * 60);
//         }
//         return diff;
//     }
// }
        
// class Time {
//     int hour;
//     int min;
    
//     Time(int hours, int min) {
//         this.hour = hour;
//         this.min = min;
//     }
// }

// class Solution {
//     public List<String> alertNames(String[] keyName, String[] keyTime) {
//         List<String> res = new ArrayList<>();
//         Map<String, List<Time>> map = new HashMap<>();
//         for (int i = 0; i < keyName.length; i++) {
//             String name = keyName[i];
//             String time = keyTime[i];
//             Time t = parseTime(time);
//             map.putIfAbsent(name, new ArrayList<>());
//             map.get(name).add(t);
//         }
        
        
//         return res;
//     }
    
//     private Time parseTime(String s) {
//         String[] times = s.split(":");
//         int h = Integer.parseInt(times[0]);
//         int mi = Integer.parseInt(times[1]);
//         return new Time(h, mi);
//     }
    
//     private int calculateTimeDuration(Time t1, Time t2) {
        
//     }
// }