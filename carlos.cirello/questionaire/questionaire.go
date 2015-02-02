package questionaire

import (
	"bytes"
	"encoding/json"
	"os"

	"github.com/software-engineering-amsterdam/many-ql/carlos.cirello/question"
)

type Questionaire struct {
	Label     string
	Questions []*question.Question
}

func (q *Questionaire) PrettyPrintJson() {
	buf, _ := json.Marshal(q)
	var out bytes.Buffer
	json.Indent(&out, buf, "", "\t")
	out.WriteTo(os.Stdout)
}
