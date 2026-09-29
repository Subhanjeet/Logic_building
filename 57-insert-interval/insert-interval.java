class Solution {
    public int[][] insert(int[][] intervals, int[] newInterval) {

        List<int[]> result = new ArrayList<>();

        int newStart = newInterval[0];
        int newEnd = newInterval[1];

        for (int i = 0; i < intervals.length; i++) {

            if (intervals[i][1] < newStart) {
                result.add(intervals[i]);
            }

            else if (intervals[i][0] > newEnd) {
                result.add(new int[]{newStart, newEnd});
                result.add(intervals[i]);

                for (int j = i + 1; j < intervals.length; j++) {
                    result.add(intervals[j]);
                }
                return result.toArray(new int[result.size()][]);
            }
            else {
                newStart = Math.min(newStart, intervals[i][0]);
                newEnd = Math.max(newEnd, intervals[i][1]);
            }
        }

        result.add(new int[]{newStart, newEnd});
        return result.toArray(new int[result.size()][]);
    }
}

//create result list
//store newInterval start and end 
//loop through intervals
//we have 3 cases
//case 1 -> current interval is before new interval 
//case 2 -> current interval is after new interval
//than add all remaining interval and return 
//case 3 -> interval overlap 
//than add new interval at end 
//return   