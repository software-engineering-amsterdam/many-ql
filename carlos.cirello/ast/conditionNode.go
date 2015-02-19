package ast

import "text/scanner"

// EqualsNode is the AST node for equality (==) comparison
type EqualsNode struct {
	DoubleTermNode
	Evaluatable
}

// NewEqualsNode factory for EqualsNode AST node
func NewEqualsNode(leftTerm, rightTerm Evaluatable,
	pos scanner.Position) *EqualsNode {
	equalsNode := new(EqualsNode)
	equalsNode.DoubleTermNode = *NewDoubleTermNode(leftTerm, rightTerm, pos)
	return equalsNode
}

//----

// LessThanNode is the AST node for Less Than (<) comparison
type LessThanNode struct {
	DoubleTermNode
	Evaluatable
}

// NewLessThanNode factory for LessThanNode AST node
func NewLessThanNode(leftTerm, rightTerm Evaluatable,
	pos scanner.Position) *LessThanNode {
	lessThanNode := new(LessThanNode)
	lessThanNode.DoubleTermNode = *NewDoubleTermNode(leftTerm, rightTerm, pos)
	return lessThanNode
}

//----

// MoreThanNode is the AST node for More Than (>) comparison
type MoreThanNode struct {
	DoubleTermNode
	Evaluatable
}

// NewMoreThanNode factory for MoreThanNode AST node
func NewMoreThanNode(leftTerm, rightTerm Evaluatable,
	pos scanner.Position) *MoreThanNode {
	moreThanNode := new(MoreThanNode)
	moreThanNode.DoubleTermNode = *NewDoubleTermNode(leftTerm, rightTerm, pos)
	return moreThanNode
}

//----

// LessOrEqualsThanNode is the AST node for Less Or Equals Than (<=) comparison
type LessOrEqualsThanNode struct {
	DoubleTermNode
	Evaluatable
}

// NewLessOrEqualsThanNode factory for LessOrEqualsThanNode AST node
func NewLessOrEqualsThanNode(leftTerm, rightTerm Evaluatable,
	pos scanner.Position) *LessOrEqualsThanNode {
	lessOrEqualsThanNode := new(LessOrEqualsThanNode)
	lessOrEqualsThanNode.DoubleTermNode = *NewDoubleTermNode(leftTerm,
		rightTerm, pos)
	return lessOrEqualsThanNode
}

//----

// MoreOrEqualsThanNode is the AST node for More Or Equals Than (>=) comparison
type MoreOrEqualsThanNode struct {
	DoubleTermNode
	Evaluatable
}

// NewMoreOrEqualsThanNode factory for MoreOrEqualsThanNode AST node
func NewMoreOrEqualsThanNode(leftTerm, rightTerm Evaluatable,
	pos scanner.Position) *MoreOrEqualsThanNode {
	moreOrEqualsThanNode := new(MoreOrEqualsThanNode)
	moreOrEqualsThanNode.DoubleTermNode = *NewDoubleTermNode(leftTerm,
		rightTerm, pos)
	return moreOrEqualsThanNode
}
