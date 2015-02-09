package ast

import "fmt"

// Parser interface describes the interface between the application and human
// beings.
type Parser interface {
	From(str string) error
	fmt.Stringer
}

// Question models the structure of one question within a Questionaire.
type Question struct {
	Label      string
	Identifier string
	Content    Parser
	Answered   bool
}

// Clone Question to be used for transmission between VM and Frontend
func (q Question) Clone() Question {
	return q
}

// From takes the input from Frontend and stores locally,
// into the concrete question type.
func (q Question) From(str string) error {
	return q.Content.From(str)
}
