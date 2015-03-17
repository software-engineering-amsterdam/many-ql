package graphic

import (
	"bytes"
	"text/template"
)

func renderCradle(appName string) string {
	var b bytes.Buffer
	t := template.Must(template.New("cradle").Parse(cradleQML))
	t.Execute(&b, struct {
		AppName  string
		RootNode string
	}{appName, rootNode})
	return b.String()
}
