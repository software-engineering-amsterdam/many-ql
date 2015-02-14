package ast

type TermNode struct {
	NumericConstant     float32
	IdentifierReference string
}

type Evaluatable interface{}

type SingleTermNode struct {
	LeftTerm *TermNode

	Evaluatable
}

type DoubleTermNode struct {
	LeftTerm  *TermNode
	RightTerm *TermNode
}

type EqualsNode struct {
	DoubleTermNode
	Evaluatable
}

type LessThanNode struct {
	DoubleTermNode
	Evaluatable
}

type MoreThanNode struct {
	DoubleTermNode
	Evaluatable
}

type LessOrEqualsThanNode struct {
	DoubleTermNode
	Evaluatable
}

type MoreOrEqualsThanNode struct {
	DoubleTermNode
	Evaluatable
}
