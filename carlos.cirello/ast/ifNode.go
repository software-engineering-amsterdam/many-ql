package ast

type IfNode struct {
	condition string
	stack     []*ActionNode
}
