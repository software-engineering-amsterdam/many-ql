package graphic

import (
	"bytes"
	"text/template"
)

// todo(carlos) extends the template for the several kind of questions
const questionStringQMLTemplate = `
import QtQuick 2.2
import QtQuick.Controls 1.1
import QtQuick.Layouts 1.0

GroupBox {
	title: "{{ .QuestionName }}"
	Layout.fillWidth: true
	// visible: false

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

const questionBoolQMLTemplate = `
import QtQuick 2.2
import QtQuick.Controls 1.1
import QtQuick.Layouts 1.0
import QtQuick.Controls.Styles 1.3

GroupBox {
	Layout.fillWidth: true
	// visible: false

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

func renderNewQuestion(typ, fieldName, question string) string {
	qml := questionStringQMLTemplate
	if "bool" == typ {
		qml = questionBoolQMLTemplate
	}
	validator := ""
	if "int" == typ {
		validator = `validator: IntValidator {}`
	}

	var b bytes.Buffer
	t := template.Must(template.New("newQuestion").Parse(qml))
	t.Execute(&b, struct {
		ObjectName   string
		QuestionName string
		Validator    string
	}{fieldName, question, validator})
	return b.String()
}
