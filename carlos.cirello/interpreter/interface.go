package interpreter

import "github.com/software-engineering-amsterdam/many-ql/carlos.cirello/ast"

type visitor interface {
	QuestionaireNode(q *ast.QuestionaireNode)
	ActionNode(a *ast.ActionNode)
	QuestionNode(q *ast.QuestionNode)
	IfNode(i *ast.IfNode)
}
