package ast

// ActionNode represents the ambiguous node which may branch (if) or operate.
type ActionNode struct {
	action interface{}
}

// NewActionNode factory of ActionNode struct
func NewActionNode(action interface{}) *ActionNode {
	// return &ActionNode{action, pos}
	return &ActionNode{action}
}

// Action getter method for action property
func (a *ActionNode) Action() interface{} {
	return a.action
}
