// Package graphic is the GUI interface for Frontend. It does not interact directly with VM. It is the package gopkg.in/qml.v1. All compilations constraints apply.
package graphic

//go:generate go get -u gopkg.in/qml.v1
import (
	"sync"

	"github.com/software-engineering-amsterdam/many-ql/carlos.cirello/interpreter/event"
	"github.com/software-engineering-amsterdam/many-ql/carlos.cirello/qlang/frontend"
	"gopkg.in/qml.v1"
)

type renderAction int

const (
	drawQuestion renderAction = iota
	updateQuestion
	nukeQuestion
)

type render struct {
	action     renderAction
	identifier string
	label      string
	fieldType  string
	content    interface{}
	invisible  bool
}

// Gui holds the driver which is used by Frontend to execute the application
type Gui struct {
	renderEvent chan render
	appName     string

	mu          sync.Mutex
	drawStack   []render
	renderStack []render
	answerStack map[string]string
	sweepStack  map[string]bool
	symbolTable map[string]qml.Object
	rows        qml.Object
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

// DrawQuestion adds a new question into the GUI form stack
func (g *Gui) DrawQuestion(
	identifier,
	label,
	typ string,
	visible event.Visibility,
) {
	g.mu.Lock()
	defer g.mu.Unlock()

	invisible := false
	if visible == event.Hidden {
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

// UpdateQuestion updates an existing question in the GUI form stack
func (g *Gui) UpdateQuestion(
	identifier,
	fieldType string,
	content interface{},
) {
	g.mu.Lock()
	defer g.mu.Unlock()

	m := &render{
		action:     updateQuestion,
		identifier: identifier,
		fieldType:  fieldType,
		content:    content,
	}
	g.renderStack = append(g.renderStack, *m)
	g.sweepStack[identifier] = true
}

// Flush transfers form stack into the screen.
func (g *Gui) Flush() {
	g.mu.Lock()
	defer g.mu.Unlock()

	for _, v := range g.drawStack {
		g.renderEvent <- v
	}
	g.drawStack = []render{}

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
	g.rows = win.Root().ObjectByName("questions")
	win.Show()
	go g.renderLoop()
	win.Wait()
	return nil
}

func (g *Gui) renderLoop() {
	for {
		select {
		case event := <-g.renderEvent:
			switch event.action {
			case drawQuestion:
				qml.Lock()
				g.addNewQuestion(
					event.fieldType,
					event.identifier,
					event.label,
					event.invisible,
				)
				qml.Unlock()
			case updateQuestion:
				qml.Lock()
				g.updateQuestion(event.identifier, event.fieldType, event.content)
				qml.Unlock()
			case nukeQuestion:
				qml.Lock()
				g.hideQuestion(event.identifier)
				qml.Unlock()
			}
		}
	}
}
