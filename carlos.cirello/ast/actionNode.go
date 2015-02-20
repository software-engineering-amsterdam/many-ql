package ast

import "text/scanner"

// ActionNode represents the ambiguous node which may branch (if) or operate.
type ActionNode struct {
	action interface{}
	pos    scanner.Position
}

// NewActionNode factory of ActionNode struct
func NewActionNode(action interface{}, pos scanner.Position) *ActionNode {
	return &ActionNode{action, pos}
}

// Action getter method for action property
func (a *ActionNode) Action() interface{} {
	return a.action
}
