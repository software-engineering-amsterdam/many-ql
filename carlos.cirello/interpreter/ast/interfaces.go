package ast

import "text/scanner"

// Executer interface describe all functions necessary to iterate through AST.
type Executer interface {
	ActionNode(a *ActionNode)
	IfNode(i *IfNode)
	QuestionaireNode(q *QuestionaireNode)
	QuestionNode(q *QuestionNode)
}

// Comparator interface describe the root call to resolve comparison nodes in
// AST.
type Comparator interface {
	ResolveComparisonNode(n interface{}) bool
}

// Evaluatable common interface among all AST nodes.
type Evaluatable interface{}

// Positionable interface meant to be used in error message rendering.
type Positionable interface {
	Pos() scanner.Position
}
