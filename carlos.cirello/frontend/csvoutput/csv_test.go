package csvoutput

import (
	"bytes"
	"testing"
	"text/scanner"

	"github.com/software-engineering-amsterdam/many-ql/carlos.cirello/qlang/interpreter/ast"
	"github.com/software-engineering-amsterdam/many-ql/carlos.cirello/qlang/interpreter/event"
)

const expectedCsv = `Q1,A question,No
`

func TestCsvInputFrontend(t *testing.T) {
	receive := make(chan *event.Frontend)
	send := make(chan *event.Frontend)
	buf := new(bytes.Buffer)
	go fakeInterpreter(receive, send)

	csvoutput := New(receive, send, buf)
	csvoutput.Write()

	if got := buf.String(); got != expectedCsv {
		t.Error("Error generating output CSV file. Expected Q1,A question,No rows. Got:", got)
	}
}

func fakeInterpreter(receive, send chan *event.Frontend) {
	<-send

	q := *ast.NewQuestionNode("A question", "Q1", new(ast.BoolQuestion), *new(scanner.Position))
	receive <- &event.Frontend{
		Type:       event.UpdateQuestion,
		Identifier: q.Identifier(),
		Label:      q.Label(),
		FieldType:  q.Type(),
		Value:      "No",
	}
	receive <- &event.Frontend{
		Type: event.Flush,
	}
}
