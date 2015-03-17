// Package graphic is the GUI interface for Frontend. It does not interact
// directly with Interpreter. It is the package gopkg.in/qml.v1. All
// compilations constraints apply.
package graphic

//go:generate go get -u gopkg.in/qml.v1
import (
	"sync"

	"github.com/software-engineering-amsterdam/many-ql/carlos.cirello/frontend"
	"github.com/software-engineering-amsterdam/many-ql/carlos.cirello/interpreter/ast"
	"github.com/software-engineering-amsterdam/many-ql/carlos.cirello/plumbing"
	"gopkg.in/qml.v1"
)

type renderAction int

type render struct {
	action     renderAction
	identifier string
	label      string
	fieldType  string
	content    interface{}
	invisible  bool
}

// Gui holds the driver which is used by Frontend to execute the application.
type Gui struct {
	renderplumbing chan render
	appName        string

	mu              sync.Mutex
	drawStack       []render
	renderStack     []render
	answerStack     map[string]string
	sweepStack      map[string]bool
	symbolTable     map[string]qml.Object
	root            qml.Object
	updateCallbacks map[string]func(v string)
}

// GUI creates the driver for Frontend process.
func GUI(appName string) frontend.Inputer {
	driver := &Gui{
		appName: appName,

		renderplumbing:  make(chan render),
		answerStack:     make(map[string]string),
		sweepStack:      make(map[string]bool),
		symbolTable:     make(map[string]qml.Object),
		updateCallbacks: make(map[string]func(v string)),
	}
	return driver
}

// DrawQuestion adds a new question into the GUI form stack.
func (g *Gui) DrawQuestion(
	identifier,
	label,
	typ string,
	visible plumbing.Visibility,
) {
	g.mu.Lock()
	defer g.mu.Unlock()

	invisible := false
	if visible == plumbing.Hidden {
		invisible = true
	}
	m := &render{
		action:     drawQuestion,
		identifier: identifier,
		label:      label,
		fieldType:  typ,
		invisible:  invisible,
	}
	g.drawStack = append(g.drawStack, *m)
	g.sweepStack[identifier] = true
}

// UpdateQuestion updates an existing question in the GUI form stack.
func (g *Gui) UpdateQuestion(identifier string, content interface{}) {
	g.mu.Lock()
	defer g.mu.Unlock()

	m := &render{
		action:     updateQuestion,
		identifier: identifier,
		content:    content,
	}
	g.renderStack = append(g.renderStack, *m)
	g.sweepStack[identifier] = true
}

// Flush transfers form stack into the screen.
func (g *Gui) Flush() {
	g.mu.Lock()
	defer g.mu.Unlock()

	allRender := append(g.drawStack, g.renderStack...)
	for _, v := range allRender {
		g.renderplumbing <- v
	}

	g.drawStack = []render{}
	g.renderStack = []render{}

	for k, v := range g.sweepStack {
		if !v {
			nukeplumbing := &render{
				action:     nukeQuestion,
				identifier: k,
			}
			g.renderplumbing <- *nukeplumbing
			delete(g.sweepStack, k)
		} else {
			g.sweepStack[k] = false
		}
	}
}

// FetchAnswers unloads the current captured answers from user to Frontend
// process and Interpreter.
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
	g.root = win.Root().ObjectByName(rootNode)
	win.Show()
	go g.renderLoop()
	win.Wait()
	return nil
}

func (g *Gui) renderLoop() {
	for {
		select {
		case plumbing := <-g.renderplumbing:
			switch plumbing.action {
			case drawQuestion:
				qml.Lock()
				g.addNewQuestion(
					plumbing.fieldType,
					plumbing.identifier,
					plumbing.label,
					plumbing.invisible,
				)
				qml.Unlock()
			case updateQuestion:
				qml.Lock()
				g.updateQuestion(
					plumbing.identifier,
					plumbing.content,
				)
				qml.Unlock()
			case nukeQuestion:
				qml.Lock()
				g.hideQuestion(plumbing.identifier)
				qml.Unlock()
			}
		}
	}
}

func (g *Gui) addNewQuestion(typ, name, caption string, invisible bool) {
	var question qml.Object
	switch typ {
	default:
		question = g.newStringQuestion(name, caption, "")
	case ast.ScalarBoolPrimitive:
		question = g.newBooleanQuestion(name, caption, false)
	case ast.ScalarNumericPrimitive:
		question = g.newNumericQuestion(name, caption, 0)
	}

	if !invisible {
		question.Set("visible", true)
	}

	g.symbolTable[name] = question
}

func (g *Gui) updateQuestion(fieldName string, content interface{}) {
	if question, ok := g.symbolTable[fieldName]; ok {
		question.Set("visible", true)

		fieldPtr := question.ObjectByName(fieldName)

		g.updateIfUnfocused(fieldPtr, fieldName, content.(string))
	}
}

func (g *Gui) updateIfUnfocused(fieldPtr qml.Object, fieldName,
	content string) {
	if fieldPtr.Bool("activeFocus") {
		return
	}

	g.updateCallbacks[fieldName](content)
}

func (g *Gui) hideQuestion(fieldName string) {
	g.symbolTable[fieldName].Set("visible", "false")
}

func (g *Gui) createQuestionQML(template, fieldName, caption string) qml.Object {
	tmpl := renderTemplateQuestion(template, fieldName, caption)
	return renderAndInsertAt(tmpl, g.root)
}
