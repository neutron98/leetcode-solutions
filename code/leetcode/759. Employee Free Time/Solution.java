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
// Sweeping Line
// O(nlogn), O(n)
class Solution {
    public List<Interval> employeeFreeTime(List<List<Interval>> schedule) {
        List<Interval> all = new ArrayList<>();
        for (List<Interval> subList: schedule){
            for (Interval interval: subList){
                all.add(interval);
            }
        }
        Collections.sort(all, (a, b) -> Integer.compare(a.start, b.start));
        List<Interval> result = new ArrayList<>();
        int lastStart = all.get(0).start;
        int lastEnd = all.get(0).end;
        for (Interval interval: all){
            if (interval.start > lastEnd){ // not overlapping, add the gap
                result.add(new Interval(lastEnd, interval.start));
                lastStart = interval.start;
                lastEnd = interval.end;
            } else{ // overlapping, virtual merge
                lastEnd = Math.max(lastEnd, interval.end);
            }
            
        }
        return result;
    }
}
