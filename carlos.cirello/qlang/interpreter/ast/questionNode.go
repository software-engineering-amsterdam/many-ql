package ast

import "text/scanner"

// Parser interface describes the interface between the application and human
// beings.
type Parser interface {
	Type() string
}

// QuestionNode models the structure of one question within a Questionaire.
type QuestionNode struct {
	label      string
	identifier string
	content    Parser
	pos        scanner.Position
}

// NewQuestionNode factor for QuestionNode AST struct
func NewQuestionNode(label, identifier string, content Parser,
	pos scanner.Position) *QuestionNode {
	return &QuestionNode{label, identifier, content, pos}
}

// Identifier getter method for identifier property
func (q *QuestionNode) Identifier() string {
	return q.identifier
}

// Content getter method for content property
func (q *QuestionNode) Content() Parser {
	return q.content
}

// Label getter method for label property
func (q *QuestionNode) Label() string {
	return q.label
}

// Clone Question to be used for transmission between VM and Frontend
func (q QuestionNode) Clone() QuestionNode {
	return q
}

// Type returns the question type in string to facilitate later evaluation at
// Frontend. It might be deprecated under architecture review.
func (q QuestionNode) Type() string {
	return q.content.Type()
}
