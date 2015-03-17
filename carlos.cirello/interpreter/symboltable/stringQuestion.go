package symboltable

// StringQuestion stores the answer of question which type is integer numeric.
type StringQuestion struct {
	value string
}

// StringQuestionType constant used for type comparison internally in
// interpreter and frontend.
const StringQuestionType = "string"

// From takes the input from Frontend and stores locally - String.
func (s *StringQuestion) From(str string) error {
	s.value = str
	return nil
}

// String prints in human form the content of the question - String.
func (s StringQuestion) String() string {
	return s.value
}

// Value converts underlying string into primitive string.
func (s StringQuestion) Value() interface{} {
	return s.String()
}
