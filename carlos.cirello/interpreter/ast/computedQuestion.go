package ast

import "text/scanner"

// ComputedQuestion stores the answer of question which type is integer numeric
type ComputedQuestion struct {
	expression Evaluatable
	pos        scanner.Position
}

// ComputedQuestionType constant used for type comparison internally in interpreter
// and frontend
const ComputedQuestionType = "computed"

const computedQuestionPrimitive = "string"

// NewComputedQuestion factory of ComputedQuestion struct
func NewComputedQuestion(expression Evaluatable, pos scanner.Position) *ComputedQuestion {
	return &ComputedQuestion{
		expression: expression,
		pos:        pos,
	}
}

// Type returns "computed", therefore indicating this question type name.
func (c ComputedQuestion) Type() string {
	return ComputedQuestionType
}

// Expression returns the stored expression
func (c ComputedQuestion) Expression() Evaluatable {
	return c.expression
}

func (c *ComputedQuestion) Primitive() string {
	return computedQuestionPrimitive
}

// Pos returns the token position of the question in the source file
func (c *ComputedQuestion) Pos() scanner.Position {
	return c.pos
}
