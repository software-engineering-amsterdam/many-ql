package ast

import "text/scanner"

// BoolQuestion stores the answer of question which type is integer numeric
type BoolQuestion struct {
	pos scanner.Position
}

// BoolQuestionType constant used for type comparison internally in interpreter
// and frontend
const BoolQuestionType = "bool"

func (s BoolQuestion) Type() string {
	return BoolQuestionType
}
