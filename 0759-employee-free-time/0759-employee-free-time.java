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
            if (curr.end < i.start) { // 完全不重合
                result.add(new Interval(curr.end, i.start));
                curr = i; // update pointer to the next valid interval
            } else { // curr.end >= i.start 重合了
                if (curr.end < i.end) { // 特殊情况:当前interval结束得比下一个interval早
                    curr = i; // 仍然需要更新interval(向右找最晚结束的时间点)
                }
            }
        }
        return result;
    }
}