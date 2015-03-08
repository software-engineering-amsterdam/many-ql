package graphic

import (
	"log"
	"strconv"

	"gopkg.in/qml.v1"
)

func (g *Gui) renderNewNumericQuestion(fieldName, caption string,
	content float32) qml.Object {

	var question qml.Object
	page, err := g.findPageForField(fieldName)
	if err != nil {
		question := g.renderTextboxNumericQuestion(fieldName, caption, content)
		return question
	}

	widgetDefaults := page.Defaults()
	t, ok := widgetDefaults["numeric"]
	if !ok {
		question = g.renderTextboxNumericQuestion(fieldName, caption, content)
	}

	if t == "spinbox" {
		question = g.renderSpinboxNumericQuestion(fieldName, caption, content)
	} else if t == "slider" {
		question = g.renderTextboxNumericQuestion(fieldName, caption, content)
	} else {
		question = g.renderTextboxNumericQuestion(fieldName, caption, content)
	}

	return question
}

const textBoxNumericQuestionQMLTemplate = `
import QtQuick 2.2
import QtQuick.Controls 1.1
import QtQuick.Layouts 1.0

GroupBox {
	title: "{{ .QuestionName }}"
	Layout.fillWidth: true
	visible: false

	RowLayout {
		anchors.fill: parent
		TextField {
			{{ .Validator }}
			objectName: "{{ .ObjectName }}"
			Layout.fillWidth: true
		}
	}
}
`

func (g *Gui) renderTextboxNumericQuestion(fieldName, caption string,
	content float32) (question qml.Object) {

	validator := `validator: IntValidator {}`
	qml := renderTemplateQuestion(textBoxNumericQuestionQMLTemplate, fieldName,
		caption, validator)
	question = renderAndInsertAt(qml, g.targetContainer)

	newFieldPtr := question.ObjectByName(fieldName)
	newFieldPtr.Set("text", content)
	newFieldPtr.On("editingFinished", func() {
		g.mu.Lock()
		defer g.mu.Unlock()

		objectName := newFieldPtr.String("objectName")
		content := newFieldPtr.String("text")
		g.answerStack[objectName] = content
	})

	g.updateCallbacks[fieldName] = func(content string) {
		newFieldPtr.Set("text", content)
	}

	return question
}

const spinboxQuestionQMLTemplate = `
import QtQuick 2.2
import QtQuick.Controls 1.1
import QtQuick.Layouts 1.0

GroupBox {
	title: "{{ .QuestionName }}"
	Layout.fillWidth: true
	visible: false

	RowLayout {
		anchors.fill: parent
		SpinBox {
			objectName: "{{ .ObjectName }}"
			decimals: 0
		}
	}
}
`

func (g *Gui) renderSpinboxNumericQuestion(fieldName, caption string,
	content float32) (question qml.Object) {

	qml := renderTemplateQuestion(spinboxQuestionQMLTemplate, fieldName,
		caption, "")
	question = renderAndInsertAt(qml, g.targetContainer)

	newFieldPtr := question.ObjectByName(fieldName)

	newFieldPtr.Set("value", content)
	newFieldPtr.On("editingFinished", func() {
		g.mu.Lock()
		defer g.mu.Unlock()

		objectName := newFieldPtr.String("objectName")
		g.answerStack[objectName] = strconv.FormatFloat(
			newFieldPtr.Float64("value"), 'f', 0, 32)
	})

	g.updateCallbacks[fieldName] = func(content string) {
		value, err := strconv.ParseFloat(content, 32)
		if err != nil {
			log.Println("Error reading content for ", fieldName, ": ", content)
		}
		newFieldPtr.Set("value", float32(value))
	}

	return question
}
