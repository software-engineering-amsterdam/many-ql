package ast

import "strconv"

// BoolQuestion stores the answer of question which type is integer numeric
type BoolQuestion bool

// From takes the input from Frontend and stores locally - Boolean
func (s *BoolQuestion) From(str string) error {
	val, err := strconv.Atoi(str)
	if val == 1 {
		*s = BoolQuestion(true)
	} else {
		*s = BoolQuestion(false)
	}
	return err
}

// String prints in human form the content of the question - Boolean
func (s BoolQuestion) String() string {
	if bool(s) {
		return "Yes"
	}
	return "No"
}
