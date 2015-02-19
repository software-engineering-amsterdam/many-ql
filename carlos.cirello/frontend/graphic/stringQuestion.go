package graphic

import (
	"github.com/software-engineering-amsterdam/many-ql/carlos.cirello/ast"
	"gopkg.in/qml.v1"
)

const stringQuestionQMLTemplate = `
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

func (g *Gui) renderNewStringQuestion(fieldName, caption string,
	content interface{}) (question qml.Object) {

	qml := renderTemplateQuestion(stringQuestionQMLTemplate, fieldName,
		caption, "")
	question = renderAndInsertAt(qml, g.rows)

	newFieldPtr := question.ObjectByName(fieldName)
	newFieldPtr.Set("text", content.(ast.Parser).String())
	newFieldPtr.On("editingFinished", func() {
		g.mu.Lock()
		defer g.mu.Unlock()

		objectName := newFieldPtr.String("objectName")
		content := newFieldPtr.String("text")
		g.answerStack[objectName] = content
	})

	return question
}
