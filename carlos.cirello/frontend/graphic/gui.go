package graphic

import (
	"github.com/software-engineering-amsterdam/many-ql/carlos.cirello/qlang/interpreter/ast"
	"gopkg.in/qml.v1"
)

func (g *Gui) addNewQuestion(newFieldType, newFieldName,
	newFieldCaption string, invisible bool) {

	var question qml.Object
	switch newFieldType {
	default:
		question = g.newStringQuestion(newFieldName, newFieldCaption, "")
	case ast.BoolQuestionType:
		question = g.newBooleanQuestion(newFieldName, newFieldCaption, false)
	case ast.NumericQuestionType:
		question = g.newNumericQuestion(newFieldName, newFieldCaption, 0)
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

func (g *Gui) createQuestionQML(template, fieldName, caption string) qml.Object {
	tmpl := renderTemplateQuestion(template, fieldName, caption)
	return renderAndInsertAt(tmpl, g.root)
}
