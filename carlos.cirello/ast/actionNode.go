package ast

import "text/scanner"

// ActionNode represents the ambiguous node which may branch (if) or operate.
type ActionNode struct {
	action interface{}
	pos    scanner.Position
}

func NewActionNode(action interface{}, pos scanner.Position) *ActionNode {
	return &ActionNode{action, pos}
}

func (a *ActionNode) Action() interface{} {
	return a.action
}
