package question

import "fmt"

type Parser interface {
	FromString(str string) error
	fmt.Stringer
}

type Question struct {
	Label string

	// todo(carlos) convert this to interface which represents the behavior common to all questions
	Content interface{}
}
