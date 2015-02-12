package ast

type Executer interface {
	Exec(node interface{})
	QuestionaireNode(q *QuestionaireNode)
	ActionNode(a *ActionNode)
	QuestionNode(q *QuestionNode)
	IfNode(i *IfNode)
}
