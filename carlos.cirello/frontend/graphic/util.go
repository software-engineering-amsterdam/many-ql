package graphic

import (
	"bytes"
	"log"
	"text/template"

	"github.com/software-engineering-amsterdam/many-ql/carlos.cirello/ast"
	"gopkg.in/qml.v1"
)

func (g *Gui) addNewQuestion(newFieldType, newFieldName,
	newFieldCaption string, content interface{}, invisible bool) {

	var question qml.Object
	switch newFieldType {
	default:
		question = g.renderNewStringQuestion(newFieldName, newFieldCaption, content)
	case ast.BoolQuestionType:
		question = g.renderNewBooleanQuestion(newFieldName, newFieldCaption, content)
	case ast.IntQuestionType:
		question = g.renderNewNumericQuestion(newFieldName, newFieldCaption, content)
	}

	if !invisible {
		question.Set("visible", true)
	}

	g.symbolTable[newFieldName] = question
}

func (g *Gui) updateQuestion(newFieldName string) {
	if question, ok := g.symbolTable[newFieldName]; ok {
		question.Set("visible", true)
	}
}

func (g *Gui) hideQuestion(fieldName string) {
	g.symbolTable[fieldName].Set("visible", "false")
}

func startQMLengine(appName string) qml.Object {
	engine := qml.NewEngine()
	cradleQML := renderCradle(appName)
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
