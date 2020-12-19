StringBuffer：
    - 增删改
    : 从0开始的数组
    - 多线程安全，
    - 主要是insert 和 append
    - sb.length()
    - sb.insert(offset,x)
    - sb.append()
    - passed to source then it will be shared
    - capcity 自动增
    - nullpointerExpection
    - sb.charAt(i)

ArrayList:
    - size, isEmpty, get, set, iterator, and listIterator operations run in constant time. 
    -  is not synchronized.非多线程
    - add(int index, E element)
    - addAll(int index, Collection<? extends E> c)

数组复制:
    - Arrays.copyOfRange(pre, 0,i+1)  [0,i)
# 二叉树
前： 根 -> 左子树 -> 右子树
    public void preOrderTraverse1(TreeNode root) {
		if (root != null) {
			System.out.print(root.val+"  ");
			preOrderTraverse1(root.left);
			preOrderTraverse1(root.right);
		}
	}
        public void preOrderTraverse2(TreeNode root) {
    		LinkedList<TreeNode> stack = new LinkedList<>();
    		TreeNode pNode = root;
    		while (pNode != null || !stack.isEmpty()) {
    			if (pNode != null) {
    				System.out.print(pNode.val+"  ");
    				stack.push(pNode);
    				pNode = pNode.left;
    			} else { //pNode == null && !stack.isEmpty()
    				TreeNode node = stack.pop();
    				pNode = node.right;
    			}
    		}
    	}
中： 左 -> 根 -> 右
        public void inOrderTraverse1(TreeNode root) {
    		if (root != null) {
    			inOrderTraverse1(root.left);
    			System.out.print(root.val+"  ");
    			inOrderTraverse1(root.right);
    		}
    	}
        public void inOrderTraverse2(TreeNode root) {
    		LinkedList<TreeNode> stack = new LinkedList<>();
    		TreeNode pNode = root;
    		while (pNode != null || !stack.isEmpty()) {
    			if (pNode != null) {
    				stack.push(pNode);
    				pNode = pNode.left;
    			} else { //pNode == null && !stack.isEmpty()
    				TreeNode node = stack.pop();
    				System.out.print(node.val+"  ");
    				pNode = node.right;
    			}
    		}
    	}
后： 左 -> 右 -> 根
        public void postOrderTraverse1(TreeNode root) {
    		if (root != null) {
    			postOrderTraverse1(root.left);
    			postOrderTraverse1(root.right);
    			System.out.print(root.val+"  ");
    		}
    	}
            public void levelTraverse(TreeNode root) {
    		if (root == null) {
    			return;
    		}
    		LinkedList<TreeNode> queue = new LinkedList<>();
    		queue.offer(root);
    		while (!queue.isEmpty()) {
    			TreeNode node = queue.poll();
    			System.out.print(node.val+"  ");
    			if (node.left != null) {
    				queue.offer(node.left);
    			}
    			if (node.right != null) {
    				queue.offer(node.right);
    			}
    		}
    	}
层次：
        public void levelTraverse(TreeNode root) {
    		if (root == null) {
    			return;
    		}
    		LinkedList<TreeNode> queue = new LinkedList<>();
    		queue.offer(root);
    		while (!queue.isEmpty()) {
    			TreeNode node = queue.poll();
    			System.out.print(node.val+"  ");
    			if (node.left != null) {
    				queue.offer(node.left);
    			}
    			if (node.right != null) {
    				queue.offer(node.right);
    			}
    		}
    	}
深度：
        public void depthOrderTraverse(TreeNode root) {
    		if (root == null) {
    			return;
    		}
    		LinkedList<TreeNode> stack = new LinkedList<>();
    		stack.push(root);
    		while (!stack.isEmpty()) {
    			TreeNode node = stack.pop();
    			System.out.print(node.val+"  ");
    			if (node.right != null) {
    				stack.push(node.right);
    			}
    			if (node.left != null) {
    				stack.push(node.left);
    			}
    		}
    	}
### 字符串变成数组
char[] array = str.toCharArray();
# 快慢指针
- 倒数第k个
# 深度遍历


# 排列
1. 字典序列全排
	1. 例如12345，变成54321
	2. 从右往，单调递减否，a[j],
	3. 右边a[k]比a[j]大一号，
	4. 交换a[j] 和a[k]，
	5. a[j]之后倒序添上

2. 邻位互换
	- 定义数据结构，为每个字符增加方向属性，向左或向右。如果当前字符指向的字符比他小，那么称它是可移动的，其余情况皆不可移动。
	1、将给定序列初始化为字典序最小。每个字符的方向初始化为向左
	2、找出最大的可移动字符c，并移动它
	3、对于比c大的字符，将它们的方向调转
	重复2、3直到所有字符均不可移动。
	规定排列中每一个元素都有一个（可移动的）方向，可以设想在每个元素上有一个箭头，箭头的指向就是元素的（可移动的）方向。如果一个元素的箭头所指的相邻的元素比该元素小时，称该元素处于活动状态。当一个元素在排列的左端，其方向向左，或一个元素在排列的右端，其方向向右，该元素就不处在活动状态，1总是处在不活动的状态。

	第一步：初始化n个元素的排列为123……n，并规定其元素的方向都是向左的，元素的方向用一个数组b来表示，当b[i]=0，表示第i个元素的方向向左，当b[i]=1时表示地i个元素的方向向右。

	第二步：在排列中找出排列中所有处于活动状态的元素中最大的一个，

	第三步：将它与它所指向相邻元素交换。
3. 递归
4. 非递归

## 字符串转数字
Integer.valueOf
int + ""

## 字符串的截取
public String substring​(int beginIndex)
Returns a string that is a substring of this string. The substring begins with the character at the specified index and extends to the end of this string. 


# TreeSet
Note that the ordering maintained by a set (whether or not an explicit comparator is provided) must be consistent with equals if it is to correctly implement the Set interface. (See Comparable or Comparator for a precise definition of consistent with equals.) This is so because the Set interface is defined in terms of the equals operation, but a TreeSet instance performs all element comparisons using its compareTo (or compare) method, so two elements that are deemed equal by this method are, from the standpoint of the set, equal. The behavior of a set is well-defined even if its ordering is inconsistent with equals; it just fails to obey the general contract of the Set interface. 



## BigInteger
java.math.BigInteger
BigInteger nFactorial = BigInteger.ONE;


## Map iterator
    public boolean check(){
        Iterator iter = ori.entrySet().iterator();
        while(iter.hasNext()){
            Map.Entry entry = (Map.Entry) iter.next();
            Character key = (Character) entry.getKey();
            Integer val = (Integer) entry.getValue();
            if(cnt.getOrDefault(key,0) < val){
                return false;
            } 
        }
        return true;
    }

# 在软件维护工作中，如果对软件的修改只限制在原需求说明书的范围之内，这种维护是属于(  )。纠正性维护