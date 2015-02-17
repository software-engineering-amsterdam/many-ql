package ast

import "text/scanner"

// IfNode stores an execution branch in the AST.
type IfNode struct {
	conditions Evaluatable
	stack      []*ActionNode
	elseNode   *IfNode
	pos        scanner.Position
}

func NewIfNode(conditions Evaluatable, stack []*ActionNode, elseNode *IfNode,
	pos scanner.Position) *IfNode {
	return &IfNode{conditions, stack, elseNode, pos}
}

func (i *IfNode) Conditions() Evaluatable {
	return i.conditions
}

func (i *IfNode) Stack() []*ActionNode {
	return i.stack
}

func (i *IfNode) ElseNode() *IfNode {
	return i.elseNode
}
