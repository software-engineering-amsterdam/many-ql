package ast

// StringQuestion stores the answer of question which type is integer numeric
type StringQuestion string

// FromString takes the input from Frontend and stores locally - String
func (s *StringQuestion) FromString(str string) error {
	*s = StringQuestion(str)
	return nil
}

// String prints in human form the content of the question - String
func (s StringQuestion) String() string {
	return string(s)
}
