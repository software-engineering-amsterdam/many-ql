// Package graphic is the GUI interface for Frontend. It does not interact directly with VM. It is the package gopkg.in/qml.v1. All compilations constraints apply.
package graphic

//go:generate go get -u gopkg.in/qml.v1
import (
	"fmt"
	"log"
	"os"

	"gopkg.in/qml.v1"
)

type msg struct {
	Name    string
	Label   string
	Content string
}

// Render creates the craddle for GUI.
func GUI(appName string) {
	var msgChan chan msg
	msgChan = make(chan msg)
	go func() {
		newQuestion := &msg{
			Name:    "newQuestion",
			Label:   "Is this a question from a message?",
			Content: "",
		}
		msgChan <- *newQuestion

		newQuestion2 := &msg{
			Name:    "newQuestion2",
			Label:   "Is this a second question from a message?",
			Content: "",
		}
		msgChan <- *newQuestion2
	}()
	if err := qml.Run(func() error {
		win := startQMLengine(appName).CreateWindow(nil)
		rows := win.Root().ObjectByName("questions")
		win.Show()

		for {
			select {
			case event := <-msgChan:
				addNewQuestion(
					rows,
					event.Name,
					event.Label,
				)
			}
		}

		win.Wait()

		return nil
	}); err != nil {
		fmt.Fprintf(os.Stderr, "error: %v\n", err)
		os.Exit(1)
	}
}

func addNewQuestion(rows qml.Object, newTextfieldName, newTextfieldQuestion string) {
	engine := qml.NewEngine()
	newQuestionQML := renderNewQuestion(newTextfieldName,
		newTextfieldQuestion)
	newQuestion, err := engine.LoadString("newQuestion.qml", newQuestionQML)
	if err != nil {
		log.Fatal("Fatal error while parsing newQuestion.qml:", err)
	}

	question := newQuestion.Create(nil)
	question.Set("parent", rows)
	textField := question.ObjectByName(
		renderNewQuestionTextfieldName(newTextfieldName))
	textField.On("editingFinished", func() {
		log.Println("finished editing, send to VM:",
			textField.String("text"))
	})
	// question.Destroy()
}

func startQMLengine(appName string) qml.Object {
	engine := qml.NewEngine()
	craddleQML := renderCraddle(appName)
	craddle, err := engine.LoadString("craddle.qml", craddleQML)
	if err != nil {
		log.Fatal("Fatal error while parsing craddle.qml:", err)
	}

	return craddle
}
