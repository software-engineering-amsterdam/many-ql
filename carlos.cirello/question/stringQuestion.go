package question

type StringQuestion string

func (s *StringQuestion) FromString(str string) error {
	*s = StringQuestion(str)
	return nil
}

func (s StringQuestion) String() string {
	return string(s)
}
