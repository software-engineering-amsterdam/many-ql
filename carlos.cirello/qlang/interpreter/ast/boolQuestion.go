package ast

import "text/scanner"

// todo(carlos) refactor QL AST to no longer need [*]Question.go

// BoolQuestion stores the answer of question which type is integer numeric
type BoolQuestion struct {
	pos scanner.Position
}

// BoolQuestionType constant used for type comparison internally in interpreter
// and frontend
const BoolQuestionType = "bool"

// Type returns the string which represents the boolean question types
func (s BoolQuestion) Type() string {
	return BoolQuestionType
}
