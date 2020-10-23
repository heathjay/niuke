package Solution

import (
	"bytes"
	"strings"
)

func replaceString(str string) string {
	s := strings.Split(str, " ")
	ex := "%20"
	var res bytes.Buffer
	for i := 0; i < len(s)-1; i++ {
		res.Write([]byte(s[i]))
		res.Write([]byte(ex))
	}
	res.Write([]byte(s[len(s)-1]))
	return res.String()
}
