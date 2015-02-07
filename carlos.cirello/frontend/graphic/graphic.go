// Package graphic is the GUI interface for Frontend. It does not interact directly with VM. It is the package gopkg.in/qml.v1. All compilations constraints apply.
package graphic

//go:generate go get -u gopkg.in/qml.v1
import (
	"fmt"
	"log"
	"os"
	"strings"

	"github.com/software-engineering-amsterdam/many-ql/carlos.cirello/ast"
	"github.com/software-engineering-amsterdam/many-ql/carlos.cirello/frontend"
	"gopkg.in/qml.v1"
)

type msg struct {
	Name    string
	Label   string
	Content string
}

type gui struct {
	msgChan chan msg
	appName string
}

// GUI creates the driver for Frontend process.
func GUI(appName string) frontend.Inputer {
	driver := &gui{
		make(chan msg),
		appName,
	}
	return driver
}

// InputQuestion adds a new question into the GUI form
func (g *gui) InputQuestion(q *ast.Question) {
	label := q.Label
	//todo(carlos) strip quotes in lexer maybe?
	label = strings.Replace(label, `"`, "", -1)
	m := &msg{
		strings.Replace(label, " ", "", -1),
		label,
		"",
	}
	g.msgChan <- *m
}

// Loop executes GUI main loop, which actually delegates interface to the
// underlying library (go-qml).
func (g *gui) Loop() {
	// todo(carlos) Improve readibility
	if err := qml.Run(func() error {
		win := startQMLengine(g.appName).CreateWindow(nil)
		rows := win.Root().ObjectByName("questions")
		win.Show()
		go g.addQuestionLoop(rows)
		win.Wait()
		return nil
	}); err != nil {
		fmt.Fprintf(os.Stderr, "error: %v\n", err)
		os.Exit(1)
	}
}

func (g *gui) addQuestionLoop(rows qml.Object) {
	for {
		select {
		case event := <-g.msgChan:
			addNewQuestion(
				rows,
				event.Name,
				event.Label,
			)
		}
	}
}

func addNewQuestion(rows qml.Object, newTextfieldName, newTextfieldQuestion string) {
	engine := qml.NewEngine()
	newQuestionQML := renderNewQuestion(newTextfieldName,
		newTextfieldQuestion)
	newQuestion, err := engine.LoadString("newQuestion.qml", newQuestionQML)
	if err != nil {
		log.Fatal("Fatal error while parsing newQuestion.qml:", err, "Got:", newQuestionQML)
	}

	question := newQuestion.Create(nil)
	question.Set("parent", rows)
	textField := question.ObjectByName(
		renderNewQuestionTextfieldName(newTextfieldName))
	textField.On("editingFinished", func() {
		log.Println("finished editing, send to VM:",
			textField.String("text"))
	})
	// todo(carlos) Use this command to disappear with the question
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
