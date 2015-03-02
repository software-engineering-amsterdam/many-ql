package ast

// Executer interface describe all functions necessary to iterate through AST
type Executer interface {
	QuestionaireNode(v *Visitor, q *QuestionaireNode)
	ActionNode(v *Visitor, a *ActionNode)
	QuestionNode(v *Visitor, q *QuestionNode)
	IfNode(v *Visitor, i *IfNode)
}
