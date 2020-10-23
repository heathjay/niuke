package main

/**
 *
 * @param data int整型一维数组
 * @param k int整型
 * @return int整型
 */
func GetNumberOfK(data []int, k int) int {
	// write code here
	left := 0
	right := len(data) - 1
	if data[0] > k && data[right] < k && right == -1 {
		return 0
	}
	count := 0
	found := 0
	for {
		mid := (right + left) / 2
		if right < left {
			break
		}
		if data[mid] < k {
			left = mid + 1
		} else if data[mid] > k {
			right = mid - 1
		} else {
			found = mid
			count = count + 1
			break
		}
	}
	for i := found; i >= 0 && data[i] == k; i-- {
		count++
	}
	for i := found; i <= len(data)-1; i++ {
		count++
	}
	return count
}
