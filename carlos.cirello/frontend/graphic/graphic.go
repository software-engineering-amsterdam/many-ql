// Package graphic is the GUI interface for Frontend. It does not interact directly with VM. It is the package gopkg.in/qml.v1. All compilations constraints apply.
package graphic

//go:generate go get -u gopkg.in/qml.v1
import (
	"log"
	"sync"

	"github.com/software-engineering-amsterdam/many-ql/carlos.cirello/ast"
	"github.com/software-engineering-amsterdam/many-ql/carlos.cirello/frontend"
	"gopkg.in/qml.v1"
)

type msg struct {
	Identifier string
	Label      string
	Content    string
}

// Gui holds the driver which is used by Frontend to execute the application
type Gui struct {
	msgChan chan msg
	appName string

	mu          sync.Mutex
	stack       []msg
	answerStack map[string]string
}

type answer struct {
	Identifier string
	Content    string
}

// GUI creates the driver for Frontend process.
func GUI(appName string) frontend.Inputer {
	driver := &Gui{
		msgChan:     make(chan msg),
		answerStack: make(map[string]string),
		appName:     appName,
	}
	return driver
}

// InputQuestion adds a new question into the GUI form stack
func (g *Gui) InputQuestion(q *ast.Question) {
	g.mu.Lock()
	defer g.mu.Unlock()

	m := &msg{
		q.Identifier,
		q.Label,
		"",
	}
	g.stack = append(g.stack, *m)
}

// Flush transfers form stack into the screen.
func (g *Gui) Flush() {
	g.mu.Lock()
	defer g.mu.Unlock()

	for _, v := range g.stack {
		g.msgChan <- v
	}
	g.stack = []msg{}
}

// FetchAnswers unloads the current captured answers from user to Frontend
// process and VM
func (g *Gui) FetchAnswers() map[string]string {
	g.mu.Lock()
	defer g.mu.Unlock()

	answerStack := g.answerStack
	g.answerStack = make(map[string]string)
	return answerStack
}

// Loop executes GUI main loop, which actually delegates the interface to the
// underlying library (go-qml).
func (g *Gui) Loop() {
	qml.Run(g.loop)
}

func (g *Gui) loop() error {
	win := startQMLengine(g.appName).CreateWindow(nil)
	rows := win.Root().ObjectByName("questions")
	win.Show()
	go g.addQuestionLoop(rows)
	win.Wait()
	return nil
}

func (g *Gui) addQuestionLoop(rows qml.Object) {
	for {
		select {
		case event := <-g.msgChan:
			g.addNewQuestion(
				rows,
				event.Identifier,
				event.Label,
			)
		}
	}
}

func (g *Gui) addNewQuestion(rows qml.Object, newTextfieldName, newTextfieldQuestion string) {
	engine := qml.NewEngine()
	newQuestionQML := renderNewQuestion(newTextfieldName,
		newTextfieldQuestion)
	newQuestion, err := engine.LoadString("newQuestion.qml", newQuestionQML)
	if err != nil {
		log.Fatal("Fatal error while parsing newQuestion.qml:", err, "Got:", newQuestionQML)
	}

	question := newQuestion.Create(nil)
	question.Set("parent", rows)
	textField := question.ObjectByName(newTextfieldName)
	textField.On("editingFinished", func() {
		g.mu.Lock()
		defer g.mu.Unlock()

		objectName := textField.String("objectName")
		content := textField.String("text")
		g.answerStack[objectName] = content
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
