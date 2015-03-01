package graphic

import "gopkg.in/qml.v1"

func (g *Gui) renderNewBooleanQuestion(fieldName, caption string,
	content bool) (question qml.Object) {

	t, ok := g.widgetDefaults["bool"]
	if !ok {
		question = g.renderCheckbox(fieldName, caption, content)
	}

	if t == "radio" {
		question = g.renderRadio(fieldName, caption, content)
	} else if t == "switch" {
		question = g.renderSwitch(fieldName, caption, content)
	}

	return question
}

const boolQuestionQMLTemplateCheckbox = `
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

func (g *Gui) renderCheckbox(fieldName, caption string,
	content bool) (question qml.Object) {
	qml := renderTemplateQuestion(boolQuestionQMLTemplateCheckbox, fieldName,
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

	g.updateCallbacks[fieldName] = func(content string) {
		if content == "Yes" {
			newFieldPtr.Set("checked", true)
		} else {
			newFieldPtr.Set("checked", false)
		}
	}

	return question
}

const boolQuestionQMLTemplateRadio = `
import QtQuick 2.2
import QtQuick.Controls 1.1
import QtQuick.Layouts 1.0
import QtQuick.Controls.Styles 1.3

GroupBox {
	Layout.fillWidth: true
	visible: false

	RowLayout {
		anchors.fill: parent
		Label {
			objectName: "{{ .ObjectName }}"
			text: "{{ .QuestionName }}"
		}
		ExclusiveGroup { id: {{ .ObjectName }}Group }
		RadioButton {
			objectName: "{{ .ObjectName }}Yes"
			text: "Yes"
			exclusiveGroup: {{ .ObjectName }}Group
		}
		RadioButton {
			objectName: "{{ .ObjectName }}No"
			text: "No"
			exclusiveGroup: {{ .ObjectName }}Group
		}
	}
}
`

func (g *Gui) renderRadio(fieldName, caption string,
	content bool) (question qml.Object) {
	qml := renderTemplateQuestion(boolQuestionQMLTemplateRadio, fieldName,
		caption, "")
	question = renderAndInsertAt(qml, g.rows)

	newFieldPtrYes := question.ObjectByName(fieldName + "Yes")
	newFieldPtrNo := question.ObjectByName(fieldName + "No")

	if content {
		newFieldPtrYes.Set("checked", true)
	} else {
		newFieldPtrNo.Set("checked", true)
	}

	newFieldPtrYes.On("clicked", func() {
		g.mu.Lock()
		defer g.mu.Unlock()

		g.answerStack[fieldName] = "1"
	})

	newFieldPtrNo.On("clicked", func() {
		g.mu.Lock()
		defer g.mu.Unlock()

		g.answerStack[fieldName] = "0"
	})

	g.updateCallbacks[fieldName] = func(content string) {
		if content == "Yes" {
			newFieldPtrYes.Set("checked", true)
		} else {
			newFieldPtrNo.Set("checked", true)
		}
	}
	return question
}

const boolQuestionQMLTemplateSwitch = `
import QtQuick 2.2
import QtQuick.Controls 1.1
import QtQuick.Layouts 1.0
import QtQuick.Controls.Styles 1.3

GroupBox {
	Layout.fillWidth: true
	visible: false

	RowLayout {
		anchors.fill: parent
		Label {
			text: "{{ .QuestionName }}"
		}

		Switch {
			objectName: "{{ .ObjectName }}"
		}
	}
}
`

func (g *Gui) renderSwitch(fieldName, caption string,
	content bool) (question qml.Object) {
	qml := renderTemplateQuestion(boolQuestionQMLTemplateSwitch, fieldName,
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

	g.updateCallbacks[fieldName] = func(content string) {
		if content == "Yes" {
			newFieldPtr.Set("checked", true)
		} else {
			newFieldPtr.Set("checked", false)
		}
	}

	return question
}
