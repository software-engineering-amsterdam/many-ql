package ast

// ActionNode represents the ambiguous node which may branch (if) or operate.
type ActionNode struct {
	action interface{}
}

func NewActionNode(action interface{}) *ActionNode {
	return &ActionNode{action}
}

func (a *ActionNode) Action() interface{} {
	return a.action
}
