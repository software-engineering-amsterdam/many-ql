// Package graphic is the GUI interface for Frontend. It does not interact directly with VM. It is the vendored package of gopkg.in/qml.v1. All compilations constraints apply.
package graphic

//go:generate go get -u gopkg.in/qml.v1
import (
	"fmt"
	"log"
	"os"

	"gopkg.in/qml.v1"
)

// Render creates the craddle for GUI.
func GUI() {
	if err := qml.Run(func() error {
		appName := "someQlApp"
		newTextfieldName := "newQuestion"
		newTextfieldQuestion := "Is this a question?"

		craddle, newQuestion := startQMLengine(appName, newTextfieldName, newTextfieldQuestion)
		win := craddle.CreateWindow(nil)
		rows := win.Root().ObjectByName("questions")

		addNewQuestion(rows, newQuestion, newTextfieldName)

		win.Show()
		win.Wait()

		return nil
	}); err != nil {
		fmt.Fprintf(os.Stderr, "error: %v\n", err)
		os.Exit(1)
	}
}

func addNewQuestion(rows, newQuestion qml.Object, newTextfieldName string) {
	question := newQuestion.Create(nil)
	question.Set("parent", rows)
	textField := question.ObjectByName(renderNewQuestionTextfieldName(newTextfieldName))
	textField.On("editingFinished", func() {
		log.Println("finished editing, send to VM:", textField.String("text"))
	})
	// question.Destroy()
}
func startQMLengine(appName, newTextfieldName, newTextfieldQuestion string) (craddle, newQuestion qml.Object) {

	engine := qml.NewEngine()

	craddleQML := renderCraddle(appName)
	craddle, err := engine.LoadString("craddle.qml", craddleQML)
	if err != nil {
		log.Fatal("Fatal error while parsing craddle.qml:", err)
	}

	newQuestionQML := renderNewQuestion(newTextfieldName, newTextfieldQuestion)
	newQuestion, err = engine.LoadString("newQuestion.qml", newQuestionQML)
	if err != nil {
		log.Fatal("Fatal error while parsing newQuestion.qml:", err)
	}
	return craddle, newQuestion
}
