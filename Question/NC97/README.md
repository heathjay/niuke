题目描述
给定String类型的数组strArr，再给定整数k，请严格按照排名顺序打印 出次数前k名的字符串。
[要求]
如果strArr长度为N，时间复杂度请达到O(Nlog⁡K)O(N \log K)O(NlogK)

输出K行，每行有一个字符串和一个整数（字符串表示）。
你需要按照出现出现次数由大到小输出，若出现次数相同时字符串字典序较小的优先输出

示例1
输入
复制

["1","2","3","4"],2

返回值
复制

[["1","1"],["2","1"]]

示例2
输入
复制

["1","1","2","3"],2

返回值
复制

[["1","2"],["2","1"]]

备注:

1≤N≤1051 \leq N \leq 10^51≤N≤10



Assignment●Prerequisites●Ensure that you have git installed●Write, compile and run a simple `hello world` program in Go●Ensure that `docker run hello-world` works●Complete the Docker Compose getting started tutorial●Afterwards:●https://se-gitlab.inf.tu-dresden.de/se2/se2-w-2019/se2-w-2019-assignment1/blob/master/README.rst