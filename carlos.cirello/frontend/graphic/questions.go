package graphic

import (
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

	g.updateCallbacks[fieldName] = func(newValue string) {
		v := false
		if newValue == symboltable.AnswerYes {
			v = true
		}
		newFieldPtr.Set("checked", v)
	}

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

	g.updateCallbacks[fieldName] = func(newValue string) {
		newFieldPtr.Set("text", newValue)
	}

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

	g.updateCallbacks[fieldName] = func(newValue string) {
		newFieldPtr.Set("text", newValue)
	}
	return question
}
