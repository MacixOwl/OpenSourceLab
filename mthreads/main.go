package main

import (
	"fmt"
	"runtime"
	"sync"
)

var wg sync.WaitGroup

func worker(id int) {
	defer wg.Done() // 告诉WaitGroup工作已经完成
	fmt.Printf("Worker %d starting\n", id)
	// 模拟工作
	for i := 0; i < 10; i++ {
		fmt.Printf("Worker %d: %d\n", id, i)
	}
}

func main() {
	// 设置Go程最大并发数，不设置则默认为CPU核心数
	runtime.GOMAXPROCS(runtime.NumCPU())

	// 添加等待的工作数量
	wg.Add(2)

	// 创建goroutine
	go worker(1)
	go worker(2)

	// 等待所有工作完成
	wg.Wait()
}
