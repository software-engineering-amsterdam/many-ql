package graphic

import (
	"bytes"
	"log"
	"text/template"
	"time"

	"gopkg.in/qml.v1"
)

func startQMLengine(appName string) qml.Object {
	engine := qml.NewEngine()
	cradleQML := renderCradle(appName)
	cradle, err := engine.LoadString("cradle.qml", cradleQML)
	if err != nil {
		log.Panic("Fatal error while parsing cradle.qml:", err)
	}
	return cradle
}

func renderTemplateQuestion(qml, fieldName, question string) string {
	var b bytes.Buffer
	t := template.Must(template.New("newQuestion").Parse(qml))
	t.Execute(&b, struct {
		ObjectName   string
		QuestionName string
	}{fieldName, question})
	return b.String()
}

func renderAndInsertAt(newQuestionQML string, rows qml.Object) qml.Object {
	engine := qml.NewEngine()
	newQuestion, err := engine.LoadString("newQuestion.qml", newQuestionQML)
	if err != nil {
		log.Panic("Fatal error while parsing newQuestion.qml:", err,
			"Got:", newQuestionQML)
	}

	question := newQuestion.Create(nil)
	question.Set("parent", rows)

	return question
}

func isValidDate(date string) bool {
	_, err := time.Parse("02/01/2006", date)
	return err == nil
}
