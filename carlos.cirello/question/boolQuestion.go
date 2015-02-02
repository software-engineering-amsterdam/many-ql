package question

import "strconv"

type BoolQuestion bool

func (s *BoolQuestion) FromString(str string) error {
	val, err := strconv.Atoi(str)
	if val == 1 {
		*s = BoolQuestion(true)
	} else {
		*s = BoolQuestion(false)
	}
	return err
}

func (s BoolQuestion) String() string {
	if bool(s) {
		return "Yes"
	}
	return "No"
}
