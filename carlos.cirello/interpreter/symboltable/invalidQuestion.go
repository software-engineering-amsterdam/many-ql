package symboltable

// InvalidQuestion stores the answer of question which type is invalid or
// unknown
type InvalidQuestion struct {
	primitive string
}

// InvalidQuestionType constant used for type comparison internally in interpreter
// and frontend
const InvalidQuestionType = "invalid"

// NewInvalidQuestion is the constructor method for InvalidQuestion
func NewInvalidQuestion(primitive string) *InvalidQuestion {
	return &InvalidQuestion{primitive}
}

// From takes the input from Frontend and stores locally - Numeric
func (s *InvalidQuestion) From(str string) error {
	return nil
}

// String prints in human form the content of the question - Numeric
func (s InvalidQuestion) String() string {
	return ""
}

// Value returns the invalid primitive type
func (s InvalidQuestion) Value() interface{} {
	return s.primitive
}
