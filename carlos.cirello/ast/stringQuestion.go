package ast

import "text/scanner"

// StringQuestion stores the answer of question which type is integer numeric
type StringQuestion struct {
	pos scanner.Position
}

// StringQuestionType constant used for type comparison internally in
// interpreter and frontend
const StringQuestionType = "string"

func (s StringQuestion) Type() string {
	return StringQuestionType
}
