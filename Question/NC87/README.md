 一座大楼有层，地面算作第0层，最高的一层为第 层。已知棋子从第0层掉落肯定不会摔碎，从第层掉落可能会摔碎，也可能不会摔碎。给定整数作为楼层数，再给定整数作为棋子数，返回如果想找到棋子不会摔碎的最高层数，即使在最差的情况下扔的最小次数。一次只能扔一个棋子。

示例1
输入
复制

10,1

返回值
复制

10

说明

因为只有1棵棋子，所以不得不从第1层开始一直试到第10层，在最差的情况下，即第10层是不会摔坏的最高层，最少也要扔10次 

示例2
输入
复制

3,2

返回值
复制

2

说明

先在2层扔1棵棋子，如果碎了，试第1层，如果没碎，试第3层 

示例3
输入
复制

105,2

返回值
复制

14

说明

第一个棋子先在14层扔，碎了则用仅存的一个棋子试1~13层
若没碎，第一个棋子继续在27层扔，碎了则用仅存的一个棋子试15~26层
若没碎，第一个棋子继续在39层扔，碎了则用仅存的一个棋子试28~38层
若没碎，第一个棋子继续在50层扔，碎了则用仅存的一个棋子试40~49层
若没碎，第一个棋子继续在60层扔，碎了则用仅存的一个棋子试51~59层
若没碎，第一个棋子继续在69层扔，碎了则用仅存的一个棋子试61~68层
若没碎，第一个棋子继续在77层扔，碎了则用仅存的一个棋子试70~76层
若没碎，第一个棋子继续在84层扔，碎了则用仅存的一个棋子试78~83层
若没碎，第一个棋子继续在90层扔，碎了则用仅存的一个棋子试85~89层
若没碎，第一个棋子继续在95层扔，碎了则用仅存的一个棋子试91~94层
若没碎，第一个棋子继续在99层扔，碎了则用仅存的一个棋子试96~98层
若没碎，第一个棋子继续在102层扔，碎了则用仅存的一个棋子试100、101层
若没碎，第一个棋子继续在104层扔，碎了则用仅存的一个棋子试103层
若没碎，第一个棋子继续在105层扔，若到这一步还没碎，那么105便是结果 

