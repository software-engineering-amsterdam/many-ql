package ast

import "text/scanner"

// StringQuestion stores the answer of question which type is integer numeric
type StringQuestion struct {
	value string
	pos   scanner.Position
}

const StringQuestionType = "string"

// From takes the input from Frontend and stores locally - String
func (s *StringQuestion) From(str string) error {
	s.value = str
	return nil
}

// String prints in human form the content of the question - String
func (s StringQuestion) String() string {
	return s.value
}

// Type returns "string", therefore indicating this question type name.
func (s StringQuestion) Type() string {
	return StringQuestionType
}
