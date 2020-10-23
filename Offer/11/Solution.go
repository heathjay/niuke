package Solution

func NumberOf1(n int) int {
	count := 0
	for {
		if n == 0 {
			break
		}
		count++
		n = n & (n - 1)
	}
	return n
}
