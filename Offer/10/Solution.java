public class Solution {
    public int RectCover(int target) {
    if (target <= 2) return target;
    int a = 1, b =2;
    for (int i=3; i<=target; ++i) {
        b = b + a;
        a = b - a;
    }
    return b;
    }
}