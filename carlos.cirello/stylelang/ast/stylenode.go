package ast

// StyleNode is the root node for QLS AST
type StyleNode struct {
	label string
	stack []*ActionNode
}

// NewStyleNode is the factory for StyleNode
func NewStyleNode(label string, stack []*ActionNode) *StyleNode {
	return &StyleNode{label, stack}
}

// Label returns the QLS main name. Internally it is discarded
func (s *StyleNode) Label() string {
	return s.label
}

// Stack is the list of action items, comprising: default widget for questions,
// page and section declarations
func (s *StyleNode) Stack() []*ActionNode {
	return s.stack
}
