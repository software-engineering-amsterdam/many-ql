package questionaire

import (
	"bytes"
	"encoding/json"
	"os"
)

type Questionaire struct {
	Label     string
	Questions []*Question
}

func (q *Questionaire) PrettyPrintJson() {
	buf, _ := json.Marshal(q)
	var out bytes.Buffer
	json.Indent(&out, buf, "", "\t")
	out.WriteTo(os.Stdout)
}
