// https://www.youtube.com/watch?v=C8LgvuEBraI
package main

import (
	"fmt"
	"errors"
	"math"
)

type person struct {
	name string
	age int
}

func main() {
	x := 10
	var y int = 7
	var sum = x + y
	fmt.Println("Hello Filipe")
	fmt.Println(x, y, sum)
	if x > 10 {
		fmt.Println("more than 10")
	} else {
		fmt.Println("less than 10")
	}

	var a [5]int
	a[2]= 7
	a[4]= 97
	fmt.Println(a)

	b := [5]int{5, 4, 3, 2, 1}
	fmt.Println(b)

	c := []int{10, 11, 12, 13, 14}
	c = append(c, 16)
	fmt.Println(c)

	vertices := make(map[string]int)
	vertices["triangle"] = 2
	vertices["square"] = 3
	fmt.Println(vertices)
	fmt.Println(vertices["square"])

	delete(vertices, "square")
	fmt.Println(vertices)

	fmt.Println("For loop")
	for i := 0; i < 10; i++ {
		fmt.Println(i)
	}

	fmt.Println("While loop")
	i := 0
	for i < 10 {
		fmt.Println(i)
		i++
	}

	arr := []string{"a", "b", "c"}
	for index, value := range arr {
		fmt.Println("index", index, "value", value)
	}

	m := make(map[string]string)
	m["a"] = "alpha"
	m["b"] = "beta"
	m["c"] = "gamma"

	for key, value := range m {
		fmt.Println("key", key, "value", value)
	}

	result := sumFn(3, 5)
	fmt.Println(result)

	result2, err := sqrt(-63)
	if err != nil {
		fmt.Println(err)
	} else {
		fmt.Println(result2)
	}

	p := person{name: "Filipe", age: 40}
	fmt.Println(p, p.age)

	kk := 7
	fmt.Println(kk, &kk)
	inc(&kk)
	fmt.Println(kk, &kk)
}

func sumFn(x int, y int) int {
	return x + y
}

func sqrt(x float64) (float64, error) {
	if x < 0 {
		return 0, errors.New("Undefined for negative numbers")
	}
	return math.Sqrt(x), nil
}

func inc (x *int) {
	*x++
}