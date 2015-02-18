package ast

import "text/scanner"

type MathAddNode struct {
	DoubleTermNode
	Evaluatable
}

func NewMathAddNode(leftTerm, rightTerm Evaluatable, pos scanner.Position) *MathAddNode {
	mathAddNode := new(MathAddNode)
	mathAddNode.DoubleTermNode = *NewDoubleTermNode(leftTerm, rightTerm, pos)
	return mathAddNode
}

//----

type MathSubNode struct {
	DoubleTermNode
	Evaluatable
}

func NewMathSubNode(leftTerm, rightTerm Evaluatable, pos scanner.Position) *MathSubNode {
	mathSubNode := new(MathSubNode)
	mathSubNode.DoubleTermNode = *NewDoubleTermNode(leftTerm, rightTerm, pos)
	return mathSubNode
}

//----

type MathMulNode struct {
	DoubleTermNode
	Evaluatable
}

func NewMathMulNode(leftTerm, rightTerm Evaluatable, pos scanner.Position) *MathMulNode {
	mathMulNode := new(MathMulNode)
	mathMulNode.DoubleTermNode = *NewDoubleTermNode(leftTerm, rightTerm, pos)
	return mathMulNode
}

//----

type MathDivNode struct {
	DoubleTermNode
	Evaluatable
}

func NewMathDivNode(leftTerm, rightTerm Evaluatable, pos scanner.Position) *MathDivNode {
	mathDivNode := new(MathDivNode)
	mathDivNode.DoubleTermNode = *NewDoubleTermNode(leftTerm, rightTerm, pos)
	return mathDivNode
}
