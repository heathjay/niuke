package main

/**
 *
 * @param s string字符串
 * @return bool布尔型
 */
func isValid(s string) bool {
	// write code here
	m := make(map[string]string, 0)
	m["("] = ")"
	m["{"] = "}"
	m["["] = "]"
	st := []string{}
	for i := 0; i < len(s); i++ {
		if len(st) > 0 && string(s[i]) == m[st[len(st)-1]] {
			st = st[:len(st)-1]
		} else {
			st = append(st, string(s[i]))
		}
	}
	if len(st) > 0 {
		return false
	}
	return true
}
func main() {}
