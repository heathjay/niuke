class Solution {
    /**
     *  Divide-and-conquer algorithm to solve skyline problem, 
     *  which is similar with the merge sort algorithm.
     */
    public List<List<Integer>> getSkyline(int[][] buildings) {
        int n = buildings.length;
        List<List<Integer>> output = new ArrayList<>();
        if(n == 0) return output;
        if(n == 1){
            int xStart = buildings[0][0];
            int xEnd = buildings[0][1];
            int y = buildings[0][2];

            output.add(new ArrayList<Integer>(){{add(xStart); add(y);}});
            output.add(new ArrayList<Integer>(){{add(xEnd); add(0);}});
            return output;
        }


    }
}