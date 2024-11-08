package main

func add(a, b int) (int, error) {
	return a + b, nil
}

func main() {
	println("Here We GO!")
	ans, err := add(3, 4)
	println(ans, err)
}
