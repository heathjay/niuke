题目描述

有一个整数数组，请你根据快速排序的思路，找出数组中第K大的数。

给定一个整数数组a,同时给定它的大小n和要找的K(K在1到n之间)，请返回第K大的数，保证答案存在。
示例1
输入
复制

[1,3,5,2,2],5,3

返回值
复制

2

一、二分查找是利用快速排序的二分特点
利用快排在排序时，把数组分成两部分，一部分小于一个值，另一部分大于这个值的特点
将数组用快排从大到小排序，取temp值为数组的第一个数a[start],那么经过一轮调整之后，数组左边的所有值大于或等于temp，数组右边的所有值都小于或等于temp，假设此时temp是数组第i个数。
如果i正好等于K，那么temp就是第K大值
如果i大于K，那么说明第K大值在数组左边，则继续在左边查找
如果i小于K，那么说明第K大值在数组的右边，继续在右边查找
每一轮排序都重复上述步骤，直到找到第K大值。



二、堆查找是利用堆排序的特点
比较直接，堆排序时，如果是从小到大排序则是先建立一个大顶堆，然后依次从大到小排列各值
第K个排到的值就是第K大值