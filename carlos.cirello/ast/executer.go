package ast

// Executer interface describe all functions necessary to iterate through AST
type Executer interface {
	Exec(node interface{})
	QuestionaireNode(q *QuestionaireNode)
	ActionNode(a *ActionNode)
	QuestionNode(q *QuestionNode)
	IfNode(i *IfNode)
}
