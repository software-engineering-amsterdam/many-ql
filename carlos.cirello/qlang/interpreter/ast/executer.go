package ast

// Executer interface describe all functions necessary to iterate through AST
type Executer interface {
	ActionNode(v *Visitor, a *ActionNode)
	IfNode(v *Visitor, i *IfNode)
	QuestionaireNode(v *Visitor, q *QuestionaireNode)
	QuestionNode(v *Visitor, q *QuestionNode)
}
