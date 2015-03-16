package ast

import "text/scanner"

// BoolNegNode is the AST node for equality (==) comparison.
type BoolNegNode struct {
	SingleTermNode
	Evaluatable
}

// NewBoolNegNode factory for BoolNegNode AST node.
func NewBoolNegNode(term Evaluatable, pos scanner.Position) *BoolNegNode {
	boolNegNode := new(BoolNegNode)
	boolNegNode.SingleTermNode = *NewSingleTermNode(term, pos)
	return boolNegNode
}

//----

// BoolAndNode is the AST node for equality (==) comparison.
type BoolAndNode struct {
	DoubleTermNode
	Evaluatable
}

// NewBoolAndNode factory for BoolAndNode AST node.
func NewBoolAndNode(leftTerm, rightTerm Evaluatable,
	pos scanner.Position) *BoolAndNode {
	boolAndNode := new(BoolAndNode)
	boolAndNode.DoubleTermNode = *NewDoubleTermNode(leftTerm, rightTerm, pos)
	return boolAndNode
}

//----

// BoolOrNode is the AST node for equality (==) comparison.
type BoolOrNode struct {
	DoubleTermNode
	Evaluatable
}

// NewBoolOrNode factory for BoolOrNode AST node.
func NewBoolOrNode(leftTerm, rightTerm Evaluatable,
	pos scanner.Position) *BoolOrNode {
	boolOrNode := new(BoolOrNode)
	boolOrNode.DoubleTermNode = *NewDoubleTermNode(leftTerm, rightTerm, pos)
	return boolOrNode
}

//----

// EqualsNode is the AST node for equality (==) comparison.
type EqualsNode struct {
	DoubleTermNode
	Evaluatable
}

// NewEqualsNode factory for EqualsNode AST node.
func NewEqualsNode(leftTerm, rightTerm Evaluatable,
	pos scanner.Position) *EqualsNode {
	equalsNode := new(EqualsNode)
	equalsNode.DoubleTermNode = *NewDoubleTermNode(leftTerm, rightTerm, pos)
	return equalsNode
}

//----

// NotEqualsNode is the AST node for equality (==) comparison.
type NotEqualsNode struct {
	DoubleTermNode
	Evaluatable
}

// NewNotEqualsNode factory for NotEqualsNode AST node.
func NewNotEqualsNode(leftTerm, rightTerm Evaluatable,
	pos scanner.Position) *NotEqualsNode {
	notEqualsNode := new(NotEqualsNode)
	notEqualsNode.DoubleTermNode = *NewDoubleTermNode(leftTerm, rightTerm, pos)
	return notEqualsNode
}

//----

// LessThanNode is the AST node for Less Than (<) comparison.
type LessThanNode struct {
	DoubleTermNode
	Evaluatable
}

// NewLessThanNode factory for LessThanNode AST node.
func NewLessThanNode(leftTerm, rightTerm Evaluatable,
	pos scanner.Position) *LessThanNode {
	lessThanNode := new(LessThanNode)
	lessThanNode.DoubleTermNode = *NewDoubleTermNode(leftTerm, rightTerm, pos)
	return lessThanNode
}

//----

// MoreThanNode is the AST node for More Than (>) comparison.
type MoreThanNode struct {
	DoubleTermNode
	Evaluatable
}

// NewMoreThanNode factory for MoreThanNode AST node.
func NewMoreThanNode(leftTerm, rightTerm Evaluatable,
	pos scanner.Position) *MoreThanNode {
	moreThanNode := new(MoreThanNode)
	moreThanNode.DoubleTermNode = *NewDoubleTermNode(leftTerm, rightTerm, pos)
	return moreThanNode
}

//----

// LessOrEqualsThanNode is the AST node for Less Or Equals Than (<=) comparison.
type LessOrEqualsThanNode struct {
	DoubleTermNode
	Evaluatable
}

// NewLessOrEqualsThanNode factory for LessOrEqualsThanNode AST node.
func NewLessOrEqualsThanNode(leftTerm, rightTerm Evaluatable,
	pos scanner.Position) *LessOrEqualsThanNode {
	lessOrEqualsThanNode := new(LessOrEqualsThanNode)
	lessOrEqualsThanNode.DoubleTermNode = *NewDoubleTermNode(leftTerm,
		rightTerm, pos)
	return lessOrEqualsThanNode
}

//----

// MoreOrEqualsThanNode is the AST node for More Or Equals Than (>=) comparison.
type MoreOrEqualsThanNode struct {
	DoubleTermNode
	Evaluatable
}

// NewMoreOrEqualsThanNode factory for MoreOrEqualsThanNode AST node.
func NewMoreOrEqualsThanNode(leftTerm, rightTerm Evaluatable,
	pos scanner.Position) *MoreOrEqualsThanNode {
	moreOrEqualsThanNode := new(MoreOrEqualsThanNode)
	moreOrEqualsThanNode.DoubleTermNode = *NewDoubleTermNode(leftTerm,
		rightTerm, pos)
	return moreOrEqualsThanNode
}

//----

// LikeNode is the AST node for More Or Equals Than (>=) comparison.
type LikeNode struct {
	DoubleTermNode
	Evaluatable
}

// NewLikeNode factory for LikeNode AST node.
func NewLikeNode(leftTerm, rightTerm Evaluatable,
	pos scanner.Position) *LikeNode {
	likeNode := new(LikeNode)
	likeNode.DoubleTermNode = *NewDoubleTermNode(leftTerm,
		rightTerm, pos)
	return likeNode
}
