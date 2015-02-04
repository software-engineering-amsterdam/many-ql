// Package graphic is the GUI interface for Frontend. It does not interact directly with VM. It is the vendored package of gopkg.in/qml.v1. All compilations constraints apply.
package graphic

import (
	"fmt"
	"os"

	"gopkg.in/qml.v1"
)

const BASE = `
import QtQuick 2.2
import QtQuick.Controls 1.1
import QtQuick.Layouts 1.0

ApplicationWindow {
    id: app
    visible: true
    title: "QL"
    property int margin: 11
    width: mainLayout.implicitWidth + 2 * margin
    height: mainLayout.implicitHeight + 2 * margin
    minimumWidth: mainLayout.Layout.minimumWidth + 2 * margin
    minimumHeight: mainLayout.Layout.minimumHeight + 2 * margin

    ColumnLayout {
        id: mainLayout
        objectName: "rows"
        anchors.fill: parent
        anchors.margins: margin
        GroupBox {
            objectName: "rowBox"
            id: rowBox
            title: "Row layout"
            Layout.fillWidth: true

            RowLayout {
                id: rowLayout
                anchors.fill: parent
                TextField {
                    placeholderText: "This wants to grow horizontally"
                    Layout.fillWidth: true
                }
                Button {
                    text: "Button"
                }
            }
        }
        GroupBox {
            id: rowBoxa
            title: "Row layouta"
            Layout.fillWidth: true

            RowLayout {
                id: rowLayouta
                anchors.fill: parent
                TextField {
                    placeholderText: "This wants to grow horizontally"
                    Layout.fillWidth: true
                }
                Button {
                    text: "Button"
                }
            }
        }
    }
}
`

const NEW_LINE = `
import QtQuick 2.2
import QtQuick.Controls 1.1
import QtQuick.Layouts 1.0

GroupBox {
objectName: "rowsa"
id: rowBoxb
            title: "Row layout ADDED DYNAMICALLY"
            Layout.fillWidth: true

            RowLayout {
                id: rowLayoutb
                anchors.fill: parent
                TextField {
                    placeholderText: "This wants to grow horizontally"
                    Layout.fillWidth: true
                }
                Button {
                    text: "Button"
                }
            }
}
`

// Render creates the craddle for GUI.
func Render() {
	if err := qml.Run(run); err != nil {
		fmt.Fprintf(os.Stderr, "error: %v\n", err)
		os.Exit(1)
	}
}

func run() error {
	engine := qml.NewEngine()

	base, err := engine.LoadString("base.qml", BASE)
	if err != nil {
		return err
	}

	newLine, err := engine.LoadString("newLine.qml", NEW_LINE)
	if err != nil {
		return err
	}

	nl := newLine.Create(nil)

	win := base.CreateWindow(nil)
	rows := win.Root().ObjectByName("rows")

	nl.Set("parent", rows)
	// nl.Destroy();

	win.Show()
	win.Wait()

	return nil
}
