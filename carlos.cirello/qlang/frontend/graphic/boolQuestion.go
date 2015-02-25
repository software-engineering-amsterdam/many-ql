package graphic

import "gopkg.in/qml.v1"

const boolQuestionQMLTemplate = `
import QtQuick 2.2
import QtQuick.Controls 1.1
import QtQuick.Layouts 1.0
import QtQuick.Controls.Styles 1.3

GroupBox {
	Layout.fillWidth: true
	visible: false

	RowLayout {
		anchors.fill: parent
		CheckBox {
			objectName: "{{ .ObjectName }}"
			text: "{{ .QuestionName }}"
			style: CheckBoxStyle {
				indicator: Rectangle {
					implicitWidth: 16
					implicitHeight: 16
					radius: 3
					border.color: control.activeFocus ? "darkblue" : "gray"
					border.width: 1
					Rectangle {
						visible: control.checked
						color: "#555"
						border.color: "#333"
						radius: 1
						anchors.margins: 4
						anchors.fill: parent
					}
				}
			}
		}
	}
}
`

func (g *Gui) renderNewBooleanQuestion(fieldName, caption string,
	content bool) (question qml.Object) {
	qml := renderTemplateQuestion(boolQuestionQMLTemplate, fieldName,
		caption, "")
	question = renderAndInsertAt(qml, g.rows)

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

	return question
}
