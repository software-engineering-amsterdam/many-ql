package ast

import "text/scanner"

type DoubleTermNode struct {
	leftTerm  Evaluatable
	rightTerm Evaluatable
	pos       scanner.Position
}

type Positionable interface {
	Pos() scanner.Position
}

func NewDoubleTermNode(leftTerm, rightTerm Evaluatable,
	pos scanner.Position) *DoubleTermNode {
	return &DoubleTermNode{
		leftTerm:  leftTerm,
		rightTerm: rightTerm,
		pos:       pos,
	}
}
func (d *DoubleTermNode) LeftTerm() Evaluatable {
	return d.leftTerm
}

func (d *DoubleTermNode) RightTerm() Evaluatable {
	return d.rightTerm
}

func (d *DoubleTermNode) Pos() scanner.Position {
	return d.pos
}
