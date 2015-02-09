package output

import (
	"encoding/csv"
	"io"

	"github.com/software-engineering-amsterdam/many-ql/carlos.cirello/ast"
)

type Output struct {
	stream io.Writer
}

func New(stream io.Writer) *Output {
	return &Output{stream}
}

func (o *Output) Write(q *ast.Questionaire) {
	csv := csv.NewWriter(o.stream)
	for _, v := range q.Questions {
		csv.Write([]string{v.Identifier, v.Label, v.Content.String()})
	}
	csv.Flush()
}
