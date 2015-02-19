package ast

import (
	"strconv"
	"text/scanner"
)

// IntQuestion stores the answer of question which type is integer numeric
type IntQuestion struct {
	value int
	pos   scanner.Position
}

// IntQuestionType constant used for type comparison internally in interpreter
// and frontend
const IntQuestionType = "int"

// From takes the input from Frontend and stores locally - Int
func (s *IntQuestion) From(str string) error {
	val, err := strconv.Atoi(str)
	s.value = val
	return err
}

// String prints in human form the content of the question - Int
func (s IntQuestion) String() string {
	return strconv.Itoa(s.value)
}

// Type returns "int", therefore indicating this question type name.
func (s IntQuestion) Type() string {
	return IntQuestionType
}

// Value converts underlying int into primitive int
func (s IntQuestion) Value() int {
	return s.value
}
