package output

import (
	"encoding/csv"
	"io"

	"github.com/software-engineering-amsterdam/many-ql/carlos.cirello/ast"
)

// Output holds an io.Writer which is used to store the responses of the form
// (either into a file, or some other medium).
type Output struct {
	stream io.Writer
}

// New takes in a writer stream, and prepare an object to be consumed later.
func New(stream io.Writer) *Output {
	return &Output{stream}
}

// Write reads all questions from the form and writes to output stream.
func (o *Output) Write(q *ast.QuestionaireNode) {
	csv := csv.NewWriter(o.stream)
	for _, action := range q.Stack {
		v := action.QuestionNode
		csv.Write([]string{v.Identifier, v.Label, v.Content.String()})
	}
	csv.Flush()
}
