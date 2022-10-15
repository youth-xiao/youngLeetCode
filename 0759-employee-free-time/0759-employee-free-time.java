/*
// Definition for an Interval.
class Interval {
    public int start;
    public int end;

    public Interval() {}

    public Interval(int _start, int _end) {
        start = _start;
        end = _end;
    }
};
*/

class Solution {
    public List<Interval> employeeFreeTime(List<List<Interval>> schedule) {
        List<Interval> result = new ArrayList<>();
        List<Interval> timeline = new ArrayList<>();
        schedule.forEach(e -> timeline.addAll(e));
        Collections.sort(timeline, ((a, b) -> a.start - b.start));
        
        Interval curr = timeline.get(0);
        for (Interval i : timeline) {
            if (curr.end < i.start) {
                result.add(new Interval(curr.end, i.start));
                curr = i;
            } else {
                if (curr.end < i.end) {
                    curr = i;
                }
            }
        }
        return result;
    }
}