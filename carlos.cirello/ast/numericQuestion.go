package ast

import "text/scanner"

// NumericQuestion stores the answer of question which type is integer numeric
type NumericQuestion struct {
	pos scanner.Position
}

// NumericQuestionType constant used for type comparison internally in interpreter
// and frontend
const NumericQuestionType = "numeric"

func (s NumericQuestion) Type() string {
	return NumericQuestionType
}
