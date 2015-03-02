package ast

type Acceptable interface {
	Accept(v *Visitor)
}

func (n *ActionNode) Accept(v *Visitor) {
	v.Tree.ActionNode(v, n)
}

func (n *IfNode) Accept(v *Visitor) {
	v.Tree.IfNode(v, n)
}

func (n *QuestionaireNode) Accept(v *Visitor) {
	v.Tree.QuestionaireNode(v, n)
}

func (n *QuestionNode) Accept(v *Visitor) {
	v.Tree.QuestionNode(v, n)
}
