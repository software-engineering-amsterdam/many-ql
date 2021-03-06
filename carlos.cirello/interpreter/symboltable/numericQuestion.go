package symboltable

import "strconv"

// NumericQuestion stores the answer of question which type is integer numeric.
type NumericQuestion struct {
	value float32
}

// NumericQuestionType constant used for type comparison internally in
// interpreter and frontend.
const NumericQuestionType = "numeric"

// From takes the input from Frontend and stores locally - Numeric.
func (s *NumericQuestion) From(str string) error {
	val, err := strconv.ParseFloat(str, 32)
	s.value = float32(val)
	return err
}

// String prints in human form the content of the question - Numeric.
func (s NumericQuestion) String() string {
	return strconv.FormatFloat(float64(s.value), 'f', -1, 32)
}

// Value converts underlying int into primitive int.
func (s NumericQuestion) Value() interface{} {
	return s.value
}
