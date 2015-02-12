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

type renderAction int

const (
	renderQuestion renderAction = iota
	nukeQuestion
)

type render struct {
	action     renderAction
	identifier string
	label      string
	fieldType  string
}

// Gui holds the driver which is used by Frontend to execute the application
type Gui struct {
	renderEvent chan render
	appName     string

	mu          sync.Mutex
	renderStack []render
	answerStack map[string]string
	sweepStack  map[string]bool
	symbolTable map[string]qml.Object
}

// GUI creates the driver for Frontend process.
func GUI(appName string) frontend.Inputer {
	driver := &Gui{
		appName: appName,

		renderEvent: make(chan render),
		answerStack: make(map[string]string),
		sweepStack:  make(map[string]bool),
		symbolTable: make(map[string]qml.Object),
	}
	return driver
}

// InputQuestion adds a new question into the GUI form stack
func (g *Gui) InputQuestion(q *ast.QuestionNode) {
	g.mu.Lock()
	defer g.mu.Unlock()

	if _, ok := g.sweepStack[q.Identifier]; !ok {
		m := &render{
			renderQuestion,
			q.Identifier,
			q.Label,
			q.Type(),
		}
		g.renderStack = append(g.renderStack, *m)
	}
	g.sweepStack[q.Identifier] = true
}

// Flush transfers form stack into the screen.
func (g *Gui) Flush() {
	g.mu.Lock()
	defer g.mu.Unlock()

	for _, v := range g.renderStack {
		g.renderEvent <- v
	}
	g.renderStack = []render{}

	for k, v := range g.sweepStack {
		if !v {
			nukeEvent := &render{
				action:     nukeQuestion,
				identifier: k,
			}
			g.renderEvent <- *nukeEvent
			delete(g.sweepStack, k)
		} else {
			g.sweepStack[k] = false
		}
	}
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
		case event := <-g.renderEvent:
			if renderQuestion == event.action {
				qml.Lock()
				g.addNewQuestion(
					rows,
					event.fieldType,
					event.identifier,
					event.label,
				)
				qml.Unlock()
			} else if nukeQuestion == event.action {
				qml.Lock()
				g.deleteNewQuestion(rows, event.identifier)
				qml.Unlock()
			}
		}
	}
}

func (g *Gui) addNewQuestion(rows qml.Object, newFieldType, newFieldName,
	newFieldCaption string) {

	engine := qml.NewEngine()
	newQuestionQML := renderNewQuestion(newFieldType, newFieldName,
		newFieldCaption)
	newQuestion, err := engine.LoadString("newQuestion.qml", newQuestionQML)
	if err != nil {
		log.Fatal("Fatal error while parsing newQuestion.qml:", err,
			"Got:", newQuestionQML)
	}

	question := newQuestion.Create(nil)
	question.Set("parent", rows)

	g.symbolTable[newFieldName] = question

	newFieldPtr := question.ObjectByName(newFieldName)
	// todo(carlos) improve readability
	if "bool" == newFieldType {
		newFieldPtr.On("clicked", func() {
			g.mu.Lock()
			defer g.mu.Unlock()

			objectName := newFieldPtr.String("objectName")
			content := newFieldPtr.Bool("checked")

			g.answerStack[objectName] = "0"
			if content {
				g.answerStack[objectName] = "1"
			}
		})
	} else {
		newFieldPtr.On("editingFinished", func() {
			g.mu.Lock()
			defer g.mu.Unlock()

			objectName := newFieldPtr.String("objectName")
			content := newFieldPtr.String("text")
			g.answerStack[objectName] = content
		})
	}
}

func (g *Gui) deleteNewQuestion(rows qml.Object, fieldName string) {
	g.symbolTable[fieldName].Destroy()
	delete(g.symbolTable, fieldName)
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
