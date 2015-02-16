package ast

import "fmt"

// Parser interface describes the interface between the application and human
// beings.
type Parser interface {
	From(str string) error
	Type() string
	fmt.Stringer
}

// QuestionNode models the structure of one question within a Questionaire.
type QuestionNode struct {
	Label      string
	Identifier string
	Content    Parser
	Answered   bool
}

// Clone Question to be used for transmission between VM and Frontend
func (q QuestionNode) Clone() QuestionNode {
	return q
}

// From takes the input from Frontend and stores locally,
// into the concrete question type.
func (q QuestionNode) From(str string) error {
	return q.Content.From(str)
}

// Type returns the question type in string to facilitate later evaluation at
// Frontend. It might be deprecated under architecture review.
func (q QuestionNode) Type() string {
	return q.Content.Type()
}
