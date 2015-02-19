package ast

import "text/scanner"

// DoubleTermNode is the base struct for all node types comprising left and
// right children
type DoubleTermNode struct {
	leftTerm  Evaluatable
	rightTerm Evaluatable
	pos       scanner.Position
}

// NewDoubleTermNode factory for DoubleTermNode struct
func NewDoubleTermNode(leftTerm, rightTerm Evaluatable,
	pos scanner.Position) *DoubleTermNode {
	return &DoubleTermNode{
		leftTerm:  leftTerm,
		rightTerm: rightTerm,
		pos:       pos,
	}
}

// LeftTerm getter method for left child
func (d *DoubleTermNode) LeftTerm() Evaluatable {
	return d.leftTerm
}

// RightTerm getter method for right child
func (d *DoubleTermNode) RightTerm() Evaluatable {
	return d.rightTerm
}

// Pos getter method for lexer injected information about filename, line and
// column position of the node
func (d *DoubleTermNode) Pos() scanner.Position {
	return d.pos
}

// Positionable interface meant to be used in error message rendering
type Positionable interface {
	Pos() scanner.Position
}
