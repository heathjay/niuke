package Solution

func find(target int, array [][]int) bool {

	m := len(array)
	if m == 0 {
		return false
	}
	n := len(array[0])
	if n == 0 {
		return false
	}
	r := 0
	c := n - 1
	for {
		if r > m-1 || c < 0 {
			break
		}
		if target == array[r][c] {
			return true
		} else if target > array[r][c] {
			r++
		} else if target < array[r][c] {
			c--
		}
	}
	return false

}
