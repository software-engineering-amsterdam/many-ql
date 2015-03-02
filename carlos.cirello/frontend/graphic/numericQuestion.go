package graphic

import "gopkg.in/qml.v1"

const numericQuestionQMLTemplate = `
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

func (g *Gui) renderNewNumericQuestion(fieldName, caption string,
	content float32) (question qml.Object) {

	validator := `validator: IntValidator {}`
	qml := renderTemplateQuestion(numericQuestionQMLTemplate, fieldName,
		caption, validator)
	question = renderAndInsertAt(qml, g.rows)

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
