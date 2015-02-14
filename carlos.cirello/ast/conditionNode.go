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

type EqualsNode struct {
	LeftTerm  *TermNode
	RightTerm *TermNode

	Evaluatable
}

type LessThanNode struct {
	LeftTerm  *TermNode
	RightTerm *TermNode

	Evaluatable
}

type MoreThanNode struct {
	LeftTerm  *TermNode
	RightTerm *TermNode

	Evaluatable
}
