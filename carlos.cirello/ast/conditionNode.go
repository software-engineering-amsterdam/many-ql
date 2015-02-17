package ast

type EqualsNode struct {
	DoubleTermNode
	Evaluatable
}

func NewEqualsNode(leftTerm, rightTerm Evaluatable) *EqualsNode {
	equalsNode := new(EqualsNode)
	equalsNode.DoubleTermNode = *NewDoubleTermNode(leftTerm, rightTerm)
	return equalsNode
}

//----

type LessThanNode struct {
	DoubleTermNode
	Evaluatable
}

func NewLessThanNode(leftTerm, rightTerm Evaluatable) *LessThanNode {
	lessThanNode := new(LessThanNode)
	lessThanNode.DoubleTermNode = *NewDoubleTermNode(leftTerm, rightTerm)
	return lessThanNode
}

//----

type MoreThanNode struct {
	DoubleTermNode
	Evaluatable
}

func NewMoreThanNode(leftTerm, rightTerm Evaluatable) *MoreThanNode {
	moreThanNode := new(MoreThanNode)
	moreThanNode.DoubleTermNode = *NewDoubleTermNode(leftTerm, rightTerm)
	return moreThanNode
}

//----

type LessOrEqualsThanNode struct {
	DoubleTermNode
	Evaluatable
}

func NewLessOrEqualsThanNode(leftTerm, rightTerm Evaluatable) *LessOrEqualsThanNode {
	lessOrEqualsThanNode := new(LessOrEqualsThanNode)
	lessOrEqualsThanNode.DoubleTermNode = *NewDoubleTermNode(leftTerm, rightTerm)
	return lessOrEqualsThanNode
}

//----

type MoreOrEqualsThanNode struct {
	DoubleTermNode
	Evaluatable
}

func NewMoreOrEqualsThanNode(leftTerm, rightTerm Evaluatable) *MoreOrEqualsThanNode {
	moreOrEqualsThanNode := new(MoreOrEqualsThanNode)
	moreOrEqualsThanNode.DoubleTermNode = *NewDoubleTermNode(leftTerm,
		rightTerm)
	return moreOrEqualsThanNode
}
