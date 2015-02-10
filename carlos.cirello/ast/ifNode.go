package ast

type IfNode struct {
	Condition string
	Stack     []*ActionNode
}
