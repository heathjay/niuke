package Solution

func Power(b float64, n int) float64 {
	if n == 0 {
		return 1.0
	}
	if n < 0 {
		b = 1 / b
		n = -n
	}
	res := Power(b, n/2)
	if n%2 == 1 {
		return res * res * b
	} else {
		return res * res
	}
}
