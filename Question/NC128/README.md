题目描述
给定一个整形数组arr，已知其中所有的值都是非负的，将这个数组看作一个容器，请返回容器能装多少水。
具体请参考样例解释
示例1
输入
复制

[3,1,2,5,2,4]

返回值
复制

5

说明

 

示例2
输入
复制

[4,5,1,3,2]

返回值
复制

2

方法 3：栈的应用

直观想法

我们可以不用像方法 2 那样存储最大高度，而是用栈来跟踪可能储水的最长的条形块。使用栈就可以在一次遍历内完成计算。

我们在遍历数组时维护一个栈。如果当前的条形块小于或等于栈顶的条形块，我们将条形块的索引入栈，意思是当前的条形块被栈中的前一个条形块界定。如果我们发现一个条形块长于栈顶，我们可以确定栈顶的条形块被当前条形块和栈的前一个条形块界定，因此我们可以弹出栈顶元素并且累加答案到 ans\text{ans}ans 。

算法

    使用栈来存储条形块的索引下标。
    遍历数组：
        当栈非空且 height[current]>height[st.top()]\text{height}[current]>\text{height}[st.top()]height[current]>height[st.top()]
            意味着栈中元素可以被弹出。弹出栈顶元素 top\text{top}top。
            计算当前元素和栈顶元素的距离，准备进行填充操作
            distance=current−st.top()−1\text{distance} = \text{current} - \text{st.top}() - 1distance=current−st.top()−1
            找出界定高度
            bounded_height=min⁡(height[current],height[st.top()])−height[top]\text{bounded\_height} = \min(\text{height[current]}, \text{height[st.top()]}) - \text{height[top]}bounded_height=min(height[current],height[st.top()])−height[top]
            往答案中累加积水量ans+=distance×bounded_height\text{ans} \mathrel{+}= \text{distance} \times \text{bounded\_height}ans+=distance×bounded_height
        将当前索引下标入栈
        将 current\text{current}current 移动到下个位置

作者：LeetCode
链接：https://leetcode-cn.com/problems/trapping-rain-water/solution/jie-yu-shui-by-leetcode/
来源：力扣（LeetCode）
著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。