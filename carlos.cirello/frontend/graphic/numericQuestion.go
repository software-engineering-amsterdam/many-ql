package graphic

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

func renderNewNumericQuestion(fieldName, question string) string {
	validator := `validator: IntValidator {}`
	return renderTemplateQuestion(numericQuestionQMLTemplate, fieldName, question, validator)
}
