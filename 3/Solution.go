package Solution

func lengthOfLongestSubstring(s string) int {
	m := make(map[byte]int)
	length := len(s)
	if length == 0 {
		return 0
	}
	lp, ans := 0, 0
	for i := 0; i < length; i++ {
		if _, ok := m[s[i]]; ok {
			lp = max(lp, m[s[i]]+1)
		}
		m[s[i]] = i
		ans = max(ans, i-lp+1)
	}
	return ans
}
func max(a int, b int) int {
	if a > b {
		return a
	} else {
		return b
	}
}
