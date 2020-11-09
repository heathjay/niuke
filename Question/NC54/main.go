package main

import "sort"

/**
 *
 * @param num int整型一维数组
 * @return int整型二维数组
 */
func threeSum(num []int) [][]int {
	// write code here
	n := len(num)
	sort.Ints(num)

	ans := make([][]int, 0)

	for first := 0; first < n; first++ {
		//需要与上次的不同
		if first > 0 && num[first] == num[first-1] {
			continue
		}

		third := n - 1
		target := -1 * num[first]

		for second := first + 1; second < n; second++ {
			if second > first+1 && num[second] == num[second-1] {
				continue
			}

			for second < third && num[second]+num[third] > target {
				third--
			}

			if second == first {
				break
			}

			if num[second]+num[third] == target {
				ans = append(ans, []int{num[first], num[second], num[third]})
			}
		}
	}
	return ans

}

func main() {}
