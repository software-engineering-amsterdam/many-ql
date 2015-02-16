package graphic

import (
	"bytes"
	"text/template"
)

const craddleQMLTemplate = `
import QtQuick 2.2
import QtQuick.Controls 1.1
import QtQuick.Layouts 1.0

ApplicationWindow {
	title: "{{ .AppName }}"
	visible: true
	property int margin: 11
	width: mainLayout.implicitWidth + 2 * margin
	height: mainLayout.implicitHeight + 2 * margin
	minimumWidth: mainLayout.Layout.minimumWidth + 2 * margin
	minimumHeight: mainLayout.Layout.minimumHeight + 2 * margin

	ColumnLayout {
		id: mainLayout
		objectName: "questions"
		anchors.fill: parent
		anchors.margins: margin
	}
}
`

func renderCraddle(appName string) string {
	var b bytes.Buffer
	t := template.Must(template.New("craddle").Parse(craddleQMLTemplate))
	t.Execute(&b, struct {
		AppName string
	}{appName})
	return b.String()
}
