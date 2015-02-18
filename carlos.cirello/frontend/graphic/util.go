package graphic

import (
	"bytes"
	"log"
	"text/template"

	"github.com/software-engineering-amsterdam/many-ql/carlos.cirello/ast"
	"gopkg.in/qml.v1"
)

func (g *Gui) addNewQuestion(rows qml.Object, newFieldType, newFieldName,
	newFieldCaption string, content interface{}, invisible bool) {

	var questionQMLtemplate string
	switch newFieldType {
	default:
		questionQMLtemplate = renderNewStringQuestion(newFieldName, newFieldCaption)
	case ast.BoolQuestionType:
		questionQMLtemplate = renderNewBooleanQuestion(newFieldName, newFieldCaption)
	case ast.IntQuestionType:
		questionQMLtemplate = renderNewNumericQuestion(newFieldName, newFieldCaption)
	}

	question := renderAndInsertAt(questionQMLtemplate, rows)

	if !invisible {
		question.Set("visible", true)
	}

	g.symbolTable[newFieldName] = question

	newFieldPtr := question.ObjectByName(newFieldName)
	// todo(carlos) improve readability
	switch newFieldType {
	case ast.BoolQuestionType:
		if content.(*ast.BoolQuestion).String() == "Yes" {
			newFieldPtr.Set("checked", true)
		}
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
	default:
		newFieldPtr.Set("text", content.(ast.Parser).String())
		newFieldPtr.On("editingFinished", func() {
			g.mu.Lock()
			defer g.mu.Unlock()

			objectName := newFieldPtr.String("objectName")
			content := newFieldPtr.String("text")
			g.answerStack[objectName] = content
		})
	}
}

func (g *Gui) updateQuestion(newFieldName string) {
	if question, ok := g.symbolTable[newFieldName]; ok {
		question.Set("visible", true)
	}
}

func (g *Gui) hideQuestion(rows qml.Object, fieldName string) {
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
