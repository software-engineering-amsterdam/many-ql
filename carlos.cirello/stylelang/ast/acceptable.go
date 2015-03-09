package ast

// Acceptable interfaces describe the node part of Visitor Pattern
type Acceptable interface {
	Accept(v *Visitor)
}

// Accept takes the visitor and acts on node type
func (n *ActionNode) Accept(v *Visitor) {
	v.ActionNode(n)
}

// Accept takes the visitor and acts on node type
func (n *StyleNode) Accept(v *Visitor) {
	v.StyleNode(n)
}

// Accept takes the visitor and acts on node type
func (n *DefaultNode) Accept(v *Visitor) {
	v.DefaultNode(n)
}

// Accept takes the visitor and acts on node type
func (n *QuestionNode) Accept(v *Visitor) {
	v.QuestionNode(n)
}

// Accept takes the visitor and acts on node type
func (n *PageNode) Accept(v *Visitor) {
	v.PageNode(n)
}
