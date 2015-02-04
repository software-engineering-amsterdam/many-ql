//Package questionaire describes one form, comprising several questions, conditions and expressions.
package questionaire

import (
	"bytes"
	"encoding/json"
	"os"

	"github.com/software-engineering-amsterdam/many-ql/carlos.cirello/question"
)

// Questionaire holds all questions for a particular form
type Questionaire struct {
	Label     string
	Questions []*question.Question
}

// PrettyPrintJSON utility function to inspect current state of questionaire
func (q *Questionaire) PrettyPrintJSON() {
	buf, _ := json.Marshal(q)
	var out bytes.Buffer
	json.Indent(&out, buf, "", "\t")
	out.WriteTo(os.Stdout)
}
