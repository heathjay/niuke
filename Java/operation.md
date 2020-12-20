#  影响外排序的时间因素主要是内存与外设交换信息的总次数()
对
外排序一般采用的排序方法是k路归并排序。k越大，越能减少读取外存的次数，提高效率。但k的增大，使得k路归并排序的时间复杂度也上升(O(n*k*logn),n为每路个数)。所以外排序的时候，要好好衡量k的取值，并不是与外设交换次数越少越好。


#  下面（）排序算法在输入数据逆序情况下排序速度最快。
归并排序

# 下面程序段的时间复杂度是（）
i = k = 0;
while( k < n ){
   i ++ ;
k += i ;
}
 加是开根号，乘是取对数 
  设q为一共要执行的次数
1           2               3    ....   q
k=0+1; k=1+1    k=2+1 ... 1+2+3+...+q=n ==>q(1+q)/2=n==>q^2+q=2n

q^2+q+1/4=2n+1/4
(q+1/2)=(2n+1/4)^1/2
q=(2n+1/4)^1/2-1/2
所以 T(n)=O(n^1/2)
# 确定模块的功能和模块的接口是在软件设计的那个阶段完成的?概要设计
# 下列排序方法中，最坏情况下比较次数最少的是（  ）。