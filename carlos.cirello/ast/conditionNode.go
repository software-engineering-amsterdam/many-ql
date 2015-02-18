package ast

import "text/scanner"

type EqualsNode struct {
	DoubleTermNode
	Evaluatable
}

func NewEqualsNode(leftTerm, rightTerm Evaluatable,
	pos scanner.Position) *EqualsNode {
	equalsNode := new(EqualsNode)
	equalsNode.DoubleTermNode = *NewDoubleTermNode(leftTerm, rightTerm, pos)
	return equalsNode
}

//----

type LessThanNode struct {
	DoubleTermNode
	Evaluatable
}

func NewLessThanNode(leftTerm, rightTerm Evaluatable,
	pos scanner.Position) *LessThanNode {
	lessThanNode := new(LessThanNode)
	lessThanNode.DoubleTermNode = *NewDoubleTermNode(leftTerm, rightTerm, pos)
	return lessThanNode
}

//----

type MoreThanNode struct {
	DoubleTermNode
	Evaluatable
}

func NewMoreThanNode(leftTerm, rightTerm Evaluatable,
	pos scanner.Position) *MoreThanNode {
	moreThanNode := new(MoreThanNode)
	moreThanNode.DoubleTermNode = *NewDoubleTermNode(leftTerm, rightTerm, pos)
	return moreThanNode
}

//----

type LessOrEqualsThanNode struct {
	DoubleTermNode
	Evaluatable
}

func NewLessOrEqualsThanNode(leftTerm, rightTerm Evaluatable,
	pos scanner.Position) *LessOrEqualsThanNode {
	lessOrEqualsThanNode := new(LessOrEqualsThanNode)
	lessOrEqualsThanNode.DoubleTermNode = *NewDoubleTermNode(leftTerm,
		rightTerm, pos)
	return lessOrEqualsThanNode
}

//----

type MoreOrEqualsThanNode struct {
	DoubleTermNode
	Evaluatable
}

func NewMoreOrEqualsThanNode(leftTerm, rightTerm Evaluatable,
	pos scanner.Position) *MoreOrEqualsThanNode {
	moreOrEqualsThanNode := new(MoreOrEqualsThanNode)
	moreOrEqualsThanNode.DoubleTermNode = *NewDoubleTermNode(leftTerm,
		rightTerm, pos)
	return moreOrEqualsThanNode
}
