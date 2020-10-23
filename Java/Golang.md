- string.Split(str, " ")
- string []byte互换
    string 不能直接和byte数组转换
    string可以和byte的切片转换
    1,string 转为[]byte
    var str string = "test"
    var data []byte = []byte(str)
     2,byte转为string
    var data [10]byte 
    byte[0] = 'T'
    byte[1] = 'E'
    var str string = string(data[:])

- string 和 byte 的拼接
    - var res bytes.Buffer 用来处理缓冲的结构和方法
    - res.Write([]byte(str))
- 数组复制
    	s1:=arr[2:5:9] //max:9  low：2  high;5  len:5-2(len=high-low)  cap:9-2(cap=max-low)
- 结构体
    1.先创建一个结构体
    type Test struct{
            name  string  //给结构体绑定一个字段，用以说明结构体和结构体指针绑定函数的区别
    }
    2.给结构体绑定函数
    func (test Test) function(){
        test.name = "结构体"
    }
    3.给结构体指针绑定函数
    func(test *Test) pointFunction(){
        test.name = "结构体指针"
    }
    type Cat struct {
        Color string
        Name  string
    }
    func NewCatByName(name string) *Cat {
        return &Cat{
            Name: name,
        }
    }
    func NewCatByColor(color string) *Cat {
        return &Cat{
            Color: color,
        }
    }