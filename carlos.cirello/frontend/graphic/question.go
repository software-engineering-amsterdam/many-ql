package graphic

import (
	"bytes"
	"text/template"
)

// todo(carlos) extends the template for the several kind of questions
const questionQMLTemplate = `
import QtQuick 2.2
import QtQuick.Controls 1.1
import QtQuick.Layouts 1.0

GroupBox {
	objectName: "{{ .ObjectName }}GroupBox"
	title: "{{ .QuestionName }}"
	Layout.fillWidth: true

	RowLayout {
		anchors.fill: parent
		TextField {
			objectName: "{{ .ObjectName }}"
			Layout.fillWidth: true
		}
	}
}
`

func renderNewQuestion(fieldName, question string) string {
	var b bytes.Buffer
	t := template.Must(template.New("newQuestion").Parse(questionQMLTemplate))
	t.Execute(&b, struct {
		ObjectName   string
		QuestionName string
	}{fieldName, question})
	return b.String()
}
