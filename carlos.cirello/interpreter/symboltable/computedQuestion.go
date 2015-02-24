package symboltable

import "github.com/software-engineering-amsterdam/many-ql/carlos.cirello/ast"

// ComputedQuestion stores the answer of question which type is integer numeric
type ComputedQuestion struct {
	result string
}

// ComputedQuestionType constant used for type comparison internally in interpreter
// and frontend
const ComputedQuestionType = "computed"

// NewComputedQuestion factory of ComputedQuestion struct
func NewComputedQuestion(expression ast.Evaluatable) *ComputedQuestion {
	return new(ComputedQuestion)
}

// From takes the input from Frontend and stores locally - Computed
func (c *ComputedQuestion) From(str string) error {
	c.result = str
	return nil
}

// String prints in human form the content of the question - Computed
func (c ComputedQuestion) String() string {
	return c.result
}
