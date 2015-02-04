// Package graphic is the GUI interface for Frontend. It does not interact directly with VM. It is the vendored package of https://github.com/andlabs/ui (3a742b136a2c5d468e9f75ac4d192fc2e81eae62). All compilations constraints apply.
package graphic

import (
	//Vendored from http://github.com/andlabs/ui/
	"github.com/software-engineering-amsterdam/many-ql/carlos.cirello/frontend/graphic/ui"
)

var window ui.Window

func Draw() {
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
