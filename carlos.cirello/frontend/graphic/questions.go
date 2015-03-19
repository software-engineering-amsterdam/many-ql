package graphic

import (
	"time"

	"github.com/software-engineering-amsterdam/many-ql/carlos.cirello/interpreter/symboltable"
	"gopkg.in/qml.v1"
)

func (g *Gui) newBooleanQuestion(fieldName, caption string,
	content bool) qml.Object {

	question := g.createQuestionQML(checkboxQML, fieldName, caption)

	newFieldPtr := question.ObjectByName(fieldName)
	if content {
		newFieldPtr.Set("checked", true)
	}
	newFieldPtr.On("clicked", func() {
		g.mu.Lock()
		defer g.mu.Unlock()

		objectName := newFieldPtr.String("objectName")
		content := newFieldPtr.Bool("checked")

		g.stacks.pushAnswer(objectName, "0")
		if content {
			g.stacks.pushAnswer(objectName, "1")
		}
	})

	g.objectTable.setUpdate(fieldName, func(newValue string) {
		v := false
		if newValue == symboltable.AnswerYes {
			v = true
		}
		newFieldPtr.Set("checked", v)
	})

	return question
}

func (g *Gui) newNumericQuestion(fieldName, caption string,
	content float32) qml.Object {

	question := g.createQuestionQML(numericFieldQML, fieldName, caption)

	newFieldPtr := question.ObjectByName(fieldName)
	newFieldPtr.Set("text", content)
	newFieldPtr.On("editingFinished", func() {
		g.mu.Lock()
		defer g.mu.Unlock()

		objectName := newFieldPtr.String("objectName")
		content := newFieldPtr.String("text")
		g.stacks.pushAnswer(objectName, content)
	})

	g.objectTable.setUpdate(fieldName, func(newValue string) {
		newFieldPtr.Set("text", newValue)
	})

	return question
}

func (g *Gui) newStringQuestion(fieldName, caption string,
	content string) (question qml.Object) {

	question = g.createQuestionQML(stringFieldQML, fieldName, caption)

	newFieldPtr := question.ObjectByName(fieldName)
	newFieldPtr.Set("text", content)
	newFieldPtr.On("editingFinished", func() {
		g.mu.Lock()
		defer g.mu.Unlock()

		objectName := newFieldPtr.String("objectName")
		content := newFieldPtr.String("text")
		g.stacks.pushAnswer(objectName, content)
	})

	g.objectTable.setUpdate(fieldName, func(newValue string) {
		newFieldPtr.Set("text", newValue)
	})

	return question
}

func (g *Gui) newDateQuestion(fieldName, caption string,
	content string) (question qml.Object) {

	question = g.createQuestionQML(dateFieldQML, fieldName, caption)

	newFieldPtr := question.ObjectByName(fieldName)
	newFieldPtrWarning := question.ObjectByName(fieldName + "Warning")
	newFieldPtr.Set("text", content)
	newFieldPtr.On("editingFinished", func() {
		g.mu.Lock()
		defer g.mu.Unlock()

		objectName := newFieldPtr.String("objectName")
		content := newFieldPtr.String("text")

		_, err := time.Parse("02/01/2006", content)
		if err == nil {
			g.stacks.pushAnswer(objectName, content)
			newFieldPtrWarning.Set("visible", false)
			return
		}
		newFieldPtrWarning.Set("visible", true)
		newFieldPtr.Set("text", "")
	})

	g.objectTable.setUpdate(fieldName, func(newValue string) {
		newFieldPtr.Set("text", newValue)
	})

	return question
}
