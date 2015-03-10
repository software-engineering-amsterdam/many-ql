package ast

// PageNode is the root node for QLS AST
type PageNode struct {
	label string
	stack []*ActionNode
}

// NewPageNode is the factory for PageNode
func NewPageNode(label string, stack []*ActionNode) *PageNode {
	return &PageNode{label, stack}
}

// Label returns the QLS main name. Internally it is discarded
func (s *PageNode) Label() string {
	return s.label
}

// Stack is the list of action items, comprising: default widget for questions,
// page and section declarations
func (s *PageNode) Stack() []*ActionNode {
	return s.stack
}
