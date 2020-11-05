package main

/**
 *
 * @param number int整型
 * @return int整型
 */
func jumpFloor(number int) int {
	// write code here

	if number <= 2 {
		return number
	}
	pre := 1
	sum := 2
	for i := 3; i <= number; i++ {
		sum = pre + sum
		pre = sum - pre
	}
	return sum
}

func main() {}
