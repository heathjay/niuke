package Solution

func Fibonacci(n int) int {
	if n == 0 {
		return 0
	} else if n == 1 {
		return 1
	}
	sum := 1
	one := 0
	for i := 2; i <= n; i++ {
		sum = one + sum
		one = sum - one
	}
	return sum
}
