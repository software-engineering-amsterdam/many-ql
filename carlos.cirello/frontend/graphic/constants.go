package graphic

const rootNode = `questions`

const (
	drawQuestion renderAction = iota
	updateQuestion
	nukeQuestion
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

const cradleQML = `
import QtQuick 2.2
import QtQuick.Controls 1.1
import QtQuick.Layouts 1.0

ApplicationWindow {
	title: "{{ .AppName }}"
	visible: true
	property int margin: 11
	width: 800
	height: 600

	ScrollView {
		objectName: "scroll"
		width: 798
		height: 599
		verticalScrollBarPolicy: Qt.ScrollBarAlwaysOn
		contentItem: ColumnLayout {
			Layout.fillHeight: true
			width: 797
			objectName: "{{ .RootNode }}"
		}
	}
}
`

const numericFieldQML = `
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
			validator: IntValidator {}
			objectName: "{{ .ObjectName }}"
			Layout.fillWidth: true
		}
	}
}
`

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

const dateFieldQML = `
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
			inputMask: "99/99/9999"
			objectName: "{{ .ObjectName }}"
			Layout.fillWidth: true
		}
		Text {
			objectName: "{{ .ObjectName }}Warning"
			text: "Wrong date. Please use DD/MM/YYYY"
			visible: false
		}
	}
}
`
