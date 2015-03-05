package graphic

import (
	"bytes"
	"text/template"

	"github.com/software-engineering-amsterdam/many-ql/carlos.cirello/stylelang"
)

const tabsTemplate = `
	Tab {
		title: "{{ .Name }}"
		objectName: "{{ .Name }}Tab"
		width: 798
		height: 600
		Layout.fillHeight: true
		{{ .NestedPages }}
	}
`

func drawTab(name, nestedPages string) string {
	var b bytes.Buffer
	t := template.Must(template.New("tab").Parse(tabsTemplate))
	t.Execute(&b, struct {
		Name        string
		NestedPages string
	}{name, nestedPages})
	ret := b.String()
	return ret
}

const tabsViewTemplate = `
TabView {
	width: 799
	height: 600
	objectName: "{{ .TabName }}"

	{{ .Tabs }}
}
`

func drawTabBlock(page *stylelang.Page) string {
	qml := ""

	pages := page.Pages()
	if len(pages) > 0 {
		for _, p := range pages {
			nestedPages := ""
			if len(p.Pages()) > 0 {
				nestedPages = drawTabBlock(p)
			}
			tmp := qml + drawTab(p.Name(), nestedPages)
			qml = tmp
		}
	} else {
		qml = drawTab(page.Name(), "")
	}

	var b bytes.Buffer
	t := template.Must(template.New("tabView").Parse(tabsViewTemplate))
	t.Execute(&b, struct {
		TabName string
		Tabs    string
	}{page.Name(), qml})
	ret := b.String()
	return ret
}
