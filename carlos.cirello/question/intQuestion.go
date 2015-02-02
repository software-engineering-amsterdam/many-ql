package question

import "strconv"

type IntQuestion int

func (s *IntQuestion) FromString(str string) error {
	val, err := strconv.Atoi(str)
	*s = IntQuestion(val)
	return err
}

func (s IntQuestion) String() string {
	return strconv.Itoa(int(s))
}
