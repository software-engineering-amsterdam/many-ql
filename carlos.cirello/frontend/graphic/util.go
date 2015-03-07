package graphic

import (
	"bytes"
	"log"
	"text/template"

	"github.com/software-engineering-amsterdam/many-ql/carlos.cirello/qlang/interpreter/ast"
	"gopkg.in/qml.v1"
)

func (g *Gui) addNewQuestion(newFieldType, newFieldName,
	newFieldCaption string, invisible bool) {

	var question qml.Object
	switch newFieldType {
	default:
		question = g.renderNewStringQuestion(newFieldName, newFieldCaption, "")
	case ast.BoolQuestionType:
		question = g.renderNewBooleanQuestion(newFieldName, newFieldCaption, false)
	case ast.NumericQuestionType:
		question = g.renderNewNumericQuestion(newFieldName, newFieldCaption, 0)
	}

	if !invisible {
		question.Set("visible", true)
	}

	g.symbolTable[newFieldName] = question
}

func (g *Gui) updateQuestion(fieldName, fieldType string, content interface{}) {
	if question, ok := g.symbolTable[fieldName]; ok {
		question.Set("visible", true)

		fieldPtr := question.ObjectByName(fieldName)

		if fieldPtr.Bool("activeFocus") {
			// Don't let regular update loop to overwrite current
			// user edit in the focused field.
			return
		}

		g.updateCallbacks[fieldName](content.(string))
	}
}

func (g *Gui) hideQuestion(fieldName string) {
	g.symbolTable[fieldName].Set("visible", "false")
}

func startQMLengine(appName, tabContainer string) qml.Object {
	engine := qml.NewEngine()
	cradleQML := renderCradle(appName, tabContainer)
	cradle, err := engine.LoadString("cradle.qml", cradleQML)
	if err != nil {
		log.Fatal("Fatal error while parsing cradle.qml:", err)
	}
	return cradle
}

func renderTemplateQuestion(qml, fieldName, question, validator string) string {
	var b bytes.Buffer
	t := template.Must(template.New("newQuestion").Parse(qml))
	t.Execute(&b, struct {
		ObjectName   string
		QuestionName string
		Validator    string
	}{fieldName, question, validator})
	return b.String()
}

func renderAndInsertAt(newQuestionQML string, rows qml.Object) qml.Object {
	engine := qml.NewEngine()
	newQuestion, err := engine.LoadString("newQuestion.qml", newQuestionQML)
	if err != nil {
		log.Fatal("Fatal error while parsing newQuestion.qml:", err,
			"Got:", newQuestionQML)
	}

	question := newQuestion.Create(nil)
	question.Set("parent", rows)

	return question
}
