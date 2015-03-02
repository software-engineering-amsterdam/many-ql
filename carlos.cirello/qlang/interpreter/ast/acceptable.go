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

func (n *QuestionaireNode) QuestionaireNode(v *Visitor) {
	v.Tree.QuestionaireNode(v, n)
}

func (n *QuestionNode) QuestionNode(v *Visitor) {
	v.Tree.QuestionNode(v, n)
}
