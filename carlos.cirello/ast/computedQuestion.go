package ast

// ComputedQuestion stores the answer of question which type is integer numeric
type ComputedQuestion struct {
	Expression Evaluatable
	result     string
}

const ComputedQuestionType = "computed"

// From takes the input from Frontend and stores locally - Computed
func (c *ComputedQuestion) From(str string) error {
	c.result = str
	return nil
}

// String prints in human form the content of the question - Computed
func (c ComputedQuestion) String() string {
	return c.result
}

// Type returns "compputed", therefore indicating this question type name.
func (c ComputedQuestion) Type() string {
	return ComputedQuestionType
}

// Value returns the stored Expression
func (c ComputedQuestion) Value() Evaluatable {
	return c.Expression
}
