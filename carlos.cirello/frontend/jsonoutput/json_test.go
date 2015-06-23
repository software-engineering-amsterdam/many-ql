package jsonoutput

import (
	"bytes"
	"testing"
	"text/scanner"

	"github.com/software-engineering-amsterdam/many-ql/carlos.cirello/interpreter/ast"
	"github.com/software-engineering-amsterdam/many-ql/carlos.cirello/plumbing"
)

const expectedJSON = `[{"label":"A question","question":"Q1","value":"No"}]
`

func TestJSONInputFrontend(t *testing.T) {
	pipes := plumbing.New()
	buf := new(bytes.Buffer)
	go fakeInterpreter(pipes)

	Write(pipes, buf)

	if got := buf.String(); got != expectedJSON {
		t.Error(
			"Error generating output JSON file. Expected "+expectedJSON+" rows. Got:",
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
