
题目描述
写一个函数，求两个整数之和，要求在函数体内不得使用+、-、*、/四则运算符号。
在位运算中，我们用“<<”表示向左移动一位，也就是“进位”。那么我们就可以得到如下的表达式:

    ( x & y ) << 1 

拥有了两个基本表达式：

    执行加法 x ^ y
    进位操作 ( x & y ) << 1 