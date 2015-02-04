package main

import (
	//Vendored from http://github.com/andlabs/ui/
	"github.com/software-engineering-amsterdam/many-ql/carlos.cirello/frontend/graphic/ui"
)

var window ui.Window

func main() {
	go ui.Do(func() {
		name := ui.NewTextField()
		button := ui.NewButton("Greet")
		greeting := ui.NewLabel("")
		stack := ui.NewVerticalStack(
			ui.NewLabel("Enter your name:"),
			name,
			button,
			greeting)
		window = ui.NewWindow("Hello", 200, 100, stack)
		button.OnClicked(func() {
			greeting.SetText("Hello, " + name.Text() + "!")
		})
		window.OnClosing(func() bool {
			ui.Stop()
			return true
		})
		window.Show()
	})
	err := ui.Go()
	if err != nil {
		panic(err)
	}
}
