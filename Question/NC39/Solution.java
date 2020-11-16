import java.util.ArrayList;
public class Interval {
         int start;
         int end;
         Interval() { start = 0; end = 0; }
         Interval(int s, int e) { start = s; end = e; }
     }

   public class Solution {
       public ArrayList<Interval> merge(ArrayList<Interval> intervals) {
           if(intervals.size() == 0 || intervals == null) return new ArrayList<Interval>(10);

           intervals.sort((a,b) -> (a.start - b.start));
           ArrayList<Interval> res = new ArrayList<>();
           int start = intervals.get(0).start;
           int end = intervals.get(0).end;
           for(int i = 1; i < intervals.size(); i++){
               if(end < intervals.get(i).start){
                   res.add(new Interval(start, end));
                   start = intervals.get(i).start;
               }
               end = Math.max(end,intervals.get(i).end);
           }
           res.add(new Interval(start, end));
           return res;
       }
   }