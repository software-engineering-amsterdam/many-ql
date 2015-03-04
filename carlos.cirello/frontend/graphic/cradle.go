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

	{{ .TabContainer }}
}
`

/*

TabView {
		width: 799
		height: 600
		Tab {
			title: "{{ .AppName }}"
			objectName: "{{ .AppName }}Tab"
			ScrollView {
				width: 798
				height: 600
				verticalScrollBarPolicy: Qt.ScrollBarAlwaysOn
				contentItem: ColumnLayout {
					Layout.fillHeight: true
					width: 797
					id: mainLayout
					objectName: "questions"
				}
			}
		}
	}
*/

func renderCradle(appName, tabContainer string) string {
	var b bytes.Buffer
	t := template.Must(template.New("cradle").Parse(cradleQMLTemplate))
	t.Execute(&b, struct {
		AppName      string
		TabContainer string
	}{appName, tabContainer})
	return b.String()
}
