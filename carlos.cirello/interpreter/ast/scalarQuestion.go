package ast

import "text/scanner"

// ScalarQuestion stores the answer of question which type is integer numeric.
type ScalarQuestion struct {
	primitive string
	pos       scanner.Position
}

const (
	// ScalarQuestionType constant used for type comparison internally in
	// interpreter and frontend.
	ScalarQuestionType = "scalar"

	// ScalarStringPrimitive is the constant which define "string" question
	// type.
	ScalarStringPrimitive = "string"
	// ScalarNumericPrimitive is the constant which define "numeric"
	// question type.
	ScalarNumericPrimitive = "numeric"
	// ScalarBoolPrimitive is the constant which define "bool" question
	// type.
	ScalarBoolPrimitive = "bool"
	// ScalarDatePrimitive is the constant which define "date" question
	// type.
	ScalarDatePrimitive = "date"
)

// NewScalarQuestion factory of ScalarQuestion struct.
func NewScalarQuestion(primitive string, pos scanner.Position) *ScalarQuestion {
	return &ScalarQuestion{
		primitive: primitive,
		pos:       pos,
	}
}

// Type returns the string which represents the string question types.
func (s ScalarQuestion) Type() string {
	return ScalarQuestionType
}

// Primitive returns the stored primitive.
func (s ScalarQuestion) Primitive() string {
	return s.primitive
}

// Pos getter method for lexer injected information about filename, line and
// column position of the node.
func (s ScalarQuestion) Pos() scanner.Position {
	return s.pos
}
