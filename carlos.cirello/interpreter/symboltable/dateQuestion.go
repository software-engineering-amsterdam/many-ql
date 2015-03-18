package symboltable

// DateQuestion stores the answer of question which type is integer numeric.
type DateQuestion struct {
	value string
}

// DateQuestionType constant used for type comparison internally in
// interpreter and frontend.
const DateQuestionType = "date"

// From takes the input from Frontend and stores locally - Numeric.
func (s *DateQuestion) From(str string) error {
	s.value = str
	return nil
}

// String prints in human form the content of the question - Numeric.
func (s DateQuestion) String() string {
	return s.value
}

// Value converts underlying int into primitive int.
func (s DateQuestion) Value() interface{} {
	return s.value
}
