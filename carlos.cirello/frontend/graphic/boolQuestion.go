package graphic

import (
	"github.com/software-engineering-amsterdam/many-ql/carlos.cirello/interpreter/symboltable"
	"gopkg.in/qml.v1"
)

const checkboxQML = `
import QtQuick 2.2
import QtQuick.Controls 1.1
import QtQuick.Layouts 1.0

GroupBox {
	Layout.fillWidth: true
	visible: false

	RowLayout {
		anchors.fill: parent
		CheckBox {
			objectName: "{{ .ObjectName }}"
			text: "{{ .QuestionName }}"
		}
	}
}
`

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

		g.answerStack[objectName] = "0"
		if content {
			g.answerStack[objectName] = "1"
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
