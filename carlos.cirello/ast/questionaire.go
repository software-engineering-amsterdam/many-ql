package ast

import (
	"bytes"
	"encoding/json"
	"os"
)

// Questionaire holds all questions for a particular form
type Questionaire struct {
	Label     string
	Questions []*Question
}

// PrettyPrintJSON utility function to inspect current state of questionaire
func (q *Questionaire) PrettyPrintJSON() {
	buf, _ := json.Marshal(q)
	var out bytes.Buffer
	json.Indent(&out, buf, "", "\t")
	out.WriteTo(os.Stdout)
}
