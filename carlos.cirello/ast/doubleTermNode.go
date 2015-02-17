package ast

type DoubleTermNode struct {
	leftTerm  Evaluatable
	rightTerm Evaluatable
}

func NewDoubleTermNode(leftTerm, rightTerm Evaluatable) *DoubleTermNode {
	return &DoubleTermNode{
		leftTerm:  leftTerm,
		rightTerm: rightTerm,
	}
}
func (d *DoubleTermNode) LeftTerm() Evaluatable {
	return d.leftTerm
}

func (d *DoubleTermNode) RightTerm() Evaluatable {
	return d.rightTerm
}
