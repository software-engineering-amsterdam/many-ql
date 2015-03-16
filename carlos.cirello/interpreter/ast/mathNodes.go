package ast

import "text/scanner"

// MathAddNode is the AST node for addition operation.
type MathAddNode struct {
	DoubleTermNode
	Evaluatable
}

// NewMathAddNode factory for MathAddNode AST node.
func NewMathAddNode(leftTerm, rightTerm Evaluatable,
	pos scanner.Position) *MathAddNode {
	mathAddNode := new(MathAddNode)
	mathAddNode.DoubleTermNode = *NewDoubleTermNode(leftTerm, rightTerm,
		pos)
	return mathAddNode
}

//----

// MathSubNode is the AST node for subtraction operation.
type MathSubNode struct {
	DoubleTermNode
	Evaluatable
}

// NewMathSubNode factory for MathSubNode AST node.
func NewMathSubNode(leftTerm, rightTerm Evaluatable,
	pos scanner.Position) *MathSubNode {
	mathSubNode := new(MathSubNode)
	mathSubNode.DoubleTermNode = *NewDoubleTermNode(leftTerm, rightTerm,
		pos)
	return mathSubNode
}

//----

// MathMulNode is the AST node for multiplication operation.
type MathMulNode struct {
	DoubleTermNode
	Evaluatable
}

// NewMathMulNode factory for MathMulNode AST node.
func NewMathMulNode(leftTerm, rightTerm Evaluatable,
	pos scanner.Position) *MathMulNode {
	mathMulNode := new(MathMulNode)
	mathMulNode.DoubleTermNode = *NewDoubleTermNode(leftTerm, rightTerm,
		pos)
	return mathMulNode
}

//----

// MathDivNode is the AST node for division operation.
type MathDivNode struct {
	DoubleTermNode
	Evaluatable
}

// NewMathDivNode factory for MathDivNode AST node.
func NewMathDivNode(leftTerm, rightTerm Evaluatable,
	pos scanner.Position) *MathDivNode {
	mathDivNode := new(MathDivNode)
	mathDivNode.DoubleTermNode = *NewDoubleTermNode(leftTerm, rightTerm,
		pos)
	return mathDivNode
}
