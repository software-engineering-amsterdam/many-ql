package graphic

import (
	"github.com/software-engineering-amsterdam/many-ql/carlos.cirello/qlang/interpreter/ast"
	"gopkg.in/qml.v1"
)

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
