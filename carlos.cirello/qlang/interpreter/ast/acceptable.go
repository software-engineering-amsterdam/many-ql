package ast

// Acceptable interfaces describe the node part of Visitor Pattern
type Acceptable interface {
	Accept(v *Visitor)
}

// Accept takes the visitor and acts on node type
func (n *ActionNode) Accept(v *Visitor) {
	v.Tree.ActionNode(v, n)
}

// Accept takes the visitor and acts on node type
func (n *IfNode) Accept(v *Visitor) {
	v.Tree.IfNode(v, n)
}

// Accept takes the visitor and acts on node type
func (n *QuestionaireNode) Accept(v *Visitor) {
	v.Tree.QuestionaireNode(v, n)
}

// Accept takes the visitor and acts on node type
func (n *QuestionNode) Accept(v *Visitor) {
	v.Tree.QuestionNode(v, n)
}
