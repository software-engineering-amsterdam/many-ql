package ast

// Executer interface describe all functions necessary to iterate through AST
type Executer interface {
	ActionNode(a *ActionNode)
	IfNode(i *IfNode)
	QuestionaireNode(q *QuestionaireNode)
	QuestionNode(q *QuestionNode)
}

type Comparator interface {
	ResolveComparisonNode(n interface{}) bool
}
