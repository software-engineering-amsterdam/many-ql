package typechecker

import (
	"github.com/software-engineering-amsterdam/many-ql/carlos.cirello/interpreter/ast"
	"github.com/software-engineering-amsterdam/many-ql/carlos.cirello/interpreter/ast/execute"
	"github.com/software-engineering-amsterdam/many-ql/carlos.cirello/interpreter/symboltable"
	"github.com/software-engineering-amsterdam/many-ql/carlos.cirello/plumbing"
)

// New is the factory for Typechecker visitor struct
func New() (ast.Executer, *symboltable.SymbolTable) {
	toFrontend := make(chan *plumbing.Frontend)
	st := symboltable.New()

	go fakeFrontendDriver(toFrontend)

	tc := &Typechecker{
		execute: execute.New(toFrontend, st),
	}
	return tc, st
}

func fakeFrontendDriver(toFrontend chan *plumbing.Frontend) {
	go func(toFrontend chan *plumbing.Frontend) {
		for {
			<-toFrontend
		}
	}(toFrontend)
}

// Typechecker is the delegation structure for Execute and typechecking
// visitors.
type Typechecker struct {
	execute ast.Executer
}

// QuestionaireNode execute all actionNodes of a questionaire (form).
func (tc Typechecker) QuestionaireNode(q *ast.QuestionaireNode) {
	ast.DelegateQuestionaireNodeExecution(tc, q)
}

// ActionNode branches to QuestionNode or IfNode executers
func (tc Typechecker) ActionNode(a *ast.ActionNode) {
	ast.DelegateActionNodeExecution(tc, a)
}

// QuestionNode adds question to symbol table, and dispatch to frontend
// rendering.
func (tc Typechecker) QuestionNode(q *ast.QuestionNode) {
	tc.execute.QuestionNode(q)
}

// IfNode analyzes condition and run all children (ActionNodes).
func (tc Typechecker) IfNode(i *ast.IfNode) {
	tc.execute.(ast.Comparator).ResolveComparisonNode(i.Conditions())

	for _, actionNode := range i.Stack() {
		tc.ActionNode(actionNode)
	}

	if i.ElseNode() != nil {
		tc.IfNode(i.ElseNode())
	}
}
