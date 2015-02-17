package ast

type MathAddNode struct {
	DoubleTermNode
	Evaluatable
}

func NewMathAddNode(leftTerm, rightTerm Evaluatable) *MathAddNode {
	mathAddNode := new(MathAddNode)
	mathAddNode.DoubleTermNode = *NewDoubleTermNode(leftTerm, rightTerm)
	return mathAddNode
}

//----

type MathSubNode struct {
	DoubleTermNode
	Evaluatable
}

func NewMathSubNode(leftTerm, rightTerm Evaluatable) *MathSubNode {
	mathSubNode := new(MathSubNode)
	mathSubNode.DoubleTermNode = *NewDoubleTermNode(leftTerm, rightTerm)
	return mathSubNode
}

//----

type MathMulNode struct {
	DoubleTermNode
	Evaluatable
}

func NewMathMulNode(leftTerm, rightTerm Evaluatable) *MathMulNode {
	mathMulNode := new(MathMulNode)
	mathMulNode.DoubleTermNode = *NewDoubleTermNode(leftTerm, rightTerm)
	return mathMulNode
}

//----

type MathDivNode struct {
	DoubleTermNode
	Evaluatable
}

func NewMathDivNode(leftTerm, rightTerm Evaluatable) *MathDivNode {
	mathDivNode := new(MathDivNode)
	mathDivNode.DoubleTermNode = *NewDoubleTermNode(leftTerm, rightTerm)
	return mathDivNode
}
