package graphic

import (
	"bytes"
	"text/template"
)

const questionQMLTemplate = `
import QtQuick 2.2
import QtQuick.Controls 1.1
import QtQuick.Layouts 1.0

GroupBox {
	objectName: "{{ .ObjectName }}"
	title: "{{ .QuestionName }}"
	Layout.fillWidth: true

	RowLayout {
		anchors.fill: parent
		TextField {
			objectName: "{{ .ObjectNameTextField }}"
			Layout.fillWidth: true
		}
	}
}
`

func renderNewQuestion(fieldName, question string) string {
	var b bytes.Buffer
	t := template.Must(template.New("newQuestion").Parse(questionQMLTemplate))
	t.Execute(&b, struct {
		ObjectName          string
		QuestionName        string
		ObjectNameTextField string
	}{fieldName, question, renderNewQuestionTextfieldName(fieldName)})
	return b.String()
}

func renderNewQuestionTextfieldName(fieldName string) string {
	return fieldName + "TextField"
}
