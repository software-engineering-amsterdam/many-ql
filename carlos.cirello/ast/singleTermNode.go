package ast

import "text/scanner"

// SingleTermNode is the base struct for all node types comprising left and
// right children
type SingleTermNode struct {
	term Evaluatable
	pos  scanner.Position
}

// NewSingleTermNode factory for SingleTermNode struct
func NewSingleTermNode(leftTerm Evaluatable, pos scanner.Position) *SingleTermNode {
	return &SingleTermNode{
		term: leftTerm,
		pos:  pos,
	}
}

// Term getter method for left child
func (s *SingleTermNode) Term() Evaluatable {
	return s.term
}

// Pos getter method for lexer injected information about filename, line and
// column position of the node
func (s *SingleTermNode) Pos() scanner.Position {
	return s.pos
}
