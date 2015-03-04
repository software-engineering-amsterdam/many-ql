package ast

// StyleNode is the root node for QLS AST
type StyleNode struct {
	stack []*ActionNode
}

// NewStyleNode is the factory for StyleNode
func NewStyleNode(stack []*ActionNode) *StyleNode {
	return &StyleNode{stack}
}

// Stack is the list of action items, comprising: default widget for questions,
// page and section declarations
func (s *StyleNode) Stack() []*ActionNode {
	return s.stack
}
