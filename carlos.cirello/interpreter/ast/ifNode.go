package ast

import "text/scanner"

// IfNode stores an execution branch in the AST.
type IfNode struct {
	conditions Evaluatable
	stack      []*ActionNode
	elseNode   *IfNode
	pos        scanner.Position
}

// NewIfNode factory for IfNode AST struct.
func NewIfNode(conditions Evaluatable, stack []*ActionNode, elseNode *IfNode,
	pos scanner.Position) *IfNode {
	return &IfNode{conditions, stack, elseNode, pos}
}

// Conditions getter method conditions property.
func (i *IfNode) Conditions() Evaluatable {
	return i.conditions
}

// Stack getter method stack property.
func (i *IfNode) Stack() []*ActionNode {
	return i.stack
}

// ElseNode getter method elseNode property.
func (i *IfNode) ElseNode() *IfNode {
	return i.elseNode
}
