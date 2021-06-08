class Solution {
    public int computeArea(int ax1, int ay1, int ax2, int ay2, int bx1, int by1, int bx2, int by2) {
        if(ay1 > by2 || by1 > ay2 || bx1 > ax2 || ax1 > bx2 ) return (ax2-ax1)*(ay2-ay1) + (bx2-bx1) * (by2-by1);
        int y1 = Math.min(ay2, by2);
        int y2 = Math.max(ay1, by1);
        int x1= Math.min(ax2, bx2);
        int x2 = Math.max(ax1,bx1);
        return (ax2-ax1)*(ay2-ay1) + (bx2-bx1) * (by2-by1) - Math.abs(y1-y2) * Math.abs(x1-x2);
    }
}