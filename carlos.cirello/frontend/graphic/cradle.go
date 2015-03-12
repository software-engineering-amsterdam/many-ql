package graphic

import (
	"bytes"
	"text/template"
)

const cradleQMLTemplate = `
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
			objectName: "questions"
		}
	}
}
`

func renderCradle(appName string) string {
	var b bytes.Buffer
	t := template.Must(template.New("cradle").Parse(cradleQMLTemplate))
	t.Execute(&b, struct {
		AppName string
	}{appName})
	return b.String()
}
