package main

var stack1 []int
var stack2 []int

func Push(node int) {
	stack1.append(node)
}

func Pop() int {
	if len(stack2) == 0 {
		stack2.append(stack1[len(stack1)-1])
		stack1 = stack1[:len(stack1)-1]
	}
	res := stack2[0]
	stack2 = stack2[1:]
	return res
}
func main() {}
