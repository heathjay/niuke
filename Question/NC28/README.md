题目描述

给出两个字符串 SSS 和 T T T，要求在O(n) O(n) O(n)的时间复杂度内在 SSS 中找出最短的包含 T T T 中所有字符的子串。
例如：

S="XDOYEZODEYXNZ"S ="XDOYEZODEYXNZ"S="XDOYEZODEYXNZ"
T="XYZ"T ="XYZ"T="XYZ"
找出的最短子串为"YXNZ""YXNZ""YXNZ".

注意：
如果 SSS 中没有包含 T T T 中所有字符的子串，返回空字符串 “”；
满足条件的子串可能有很多，但是题目保证满足条件的最短的子串唯一。
示例1
输入
复制

"XDOYEZODEYXNZ","XYZ"

返回值
复制

"YXNZ"

