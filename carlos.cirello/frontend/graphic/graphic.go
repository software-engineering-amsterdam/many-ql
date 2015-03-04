// Package graphic is the GUI interface for Frontend. It does not interact directly
// with VM. It is the package gopkg.in/qml.v1. All compilations constraints apply.
package graphic

//go:generate go get -u gopkg.in/qml.v1
import (
	"bytes"
	"sync"
	"text/template"

	"github.com/software-engineering-amsterdam/many-ql/carlos.cirello/frontend"
	"github.com/software-engineering-amsterdam/many-ql/carlos.cirello/qlang/interpreter/event"
	"github.com/software-engineering-amsterdam/many-ql/carlos.cirello/stylelang/ast"
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

	mu              sync.Mutex
	drawStack       []render
	renderStack     []render
	answerStack     map[string]string
	sweepStack      map[string]bool
	symbolTable     map[string]qml.Object
	rows            qml.Object
	updateCallbacks map[string]func(v string)

	pages map[string]*ast.Page
}

// GUI creates the driver for Frontend process.
func GUI(appName string, pages map[string]*ast.Page) frontend.Inputer {
	driver := &Gui{
		appName: appName,

		renderEvent:     make(chan render),
		answerStack:     make(map[string]string),
		sweepStack:      make(map[string]bool),
		symbolTable:     make(map[string]qml.Object),
		updateCallbacks: make(map[string]func(v string)),

		pages: pages,
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
	// spew.Dump(g.pages["root"])
	// fmt.Println(drawTab(g.pages["root"]))
	win := startQMLengine(g.appName, drawTab(g.pages["root"])).CreateWindow(nil)
	// g.rows = win.Root().ObjectByName("questions")
	win.Show()
	// go g.renderLoop()
	win.Wait()
	// os.Exit(0)
	return nil
}

const tabsViewTemplate = `
TabView {
	width: 799
	height: 600
	objectName: "{{ .TabName }}"

	{{ .Tabs }}
}
`
const tabsTemplate = `
	Tab {
		title: "{{ .Name }}"
		objectName: "{{ .Name }}Tab"
		ScrollView {
			width: 798
			height: 600
			verticalScrollBarPolicy: Qt.ScrollBarAlwaysOn
			contentItem: ColumnLayout {
				Layout.fillHeight: true
				width: 797
				id: mainLayout
				objectName: "{{ .Name }}Questions"

				{{ .NestedPages }}
			}
		}
	}
`

// func drawTab(win *qml.Window, page *ast.Page) string {
func drawTab(page *ast.Page) string {
	nestedPages := page.Pages()

	npgs := ""
	for _, nestedPage := range nestedPages {
		npgs = npgs + drawTab(nestedPage)
	}
	var tabs string
	{
		var b bytes.Buffer
		t := template.Must(template.New("tab").Parse(tabsTemplate))
		t.Execute(&b, struct {
			Name        string
			NestedPages string
		}{page.Name(), npgs})
		tabs = b.String()
	}

	var b bytes.Buffer
	t := template.Must(template.New("tabView").Parse(tabsViewTemplate))
	t.Execute(&b, struct {
		TabName string
		Tabs    string
	}{page.Name(), tabs})
	// fmt.Println(b.String())
	return b.String()
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
