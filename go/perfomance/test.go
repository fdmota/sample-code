// https://www.youtube.com/watch?v=C8LgvuEBraI
package main

import (
	"fmt"
	"math"
)

func main() {
	array := make(map[int]float64)
	array[100100] = 16
	array[10100100] = 650
	for i := 0; i < 1100100100; i++ {
		element := array[i]
		if element > 0  {
			fmt.Println(math.Sqrt(element))
		}
	}
}