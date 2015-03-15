package csvoutput

import (
	"bytes"
	"testing"
	"text/scanner"

	"github.com/software-engineering-amsterdam/many-ql/carlos.cirello/interpreter/ast"
	"github.com/software-engineering-amsterdam/many-ql/carlos.cirello/plumbing"
)

const expectedCsv = `Q1,A question,No
`

func TestCsvInputFrontend(t *testing.T) {
	pipes := plumbing.New()
	buf := new(bytes.Buffer)
	go fakeInterpreter(pipes)

	csvoutput := New(pipes, buf)
	csvoutput.Write()

	if got := buf.String(); got != expectedCsv {
		t.Error(
			"Error generating output CSV file. Expected Q1,A question,No rows. Got:",
			got,
		)
	}
}

func fakeInterpreter(pipes *plumbing.Pipes) {
	receive := pipes.FromInterpreter()
	send := pipes.ToInterpreter()

	<-send

	q := *ast.NewQuestionNode("A question", "Q1", new(ast.ScalarQuestion),
		*new(scanner.Position))
	receive <- &plumbing.Frontend{
		Type:       plumbing.UpdateQuestion,
		Identifier: q.Identifier(),
		Label:      q.Label(),
		FieldType:  q.Type(),
		Value:      "No",
	}
	receive <- &plumbing.Frontend{
		Type: plumbing.Flush,
	}
}
