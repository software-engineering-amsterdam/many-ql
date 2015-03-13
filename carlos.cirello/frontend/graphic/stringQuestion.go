package graphic

import "gopkg.in/qml.v1"

const stringFieldQML = `
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
			objectName: "{{ .ObjectName }}"
			Layout.fillWidth: true
		}
	}
}
`

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
		g.answerStack[objectName] = content
	})

	g.updateCallbacks[fieldName] = func(newValue string) {
		newFieldPtr.Set("text", newValue)
	}
	return question
}
