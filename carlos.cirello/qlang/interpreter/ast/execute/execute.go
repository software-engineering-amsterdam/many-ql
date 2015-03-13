package execute

import (
	"fmt"

	"github.com/software-engineering-amsterdam/many-ql/carlos.cirello/qlang/interpreter/ast"
	"github.com/software-engineering-amsterdam/many-ql/carlos.cirello/qlang/interpreter/plumbing"
	"github.com/software-engineering-amsterdam/many-ql/carlos.cirello/qlang/interpreter/symboltable"
)

// Execute implements Executer interface, and it is used by Visitor to traverse
// AST
type Execute struct {
	toFrontend  chan *plumbing.Frontend
	symboltable *symboltable.SymbolTable
}

// New is the factory for a ast.Visitor with Execute struct tree inside
func New(toFrontend chan *plumbing.Frontend, symboltable *symboltable.SymbolTable) ast.Executer {
	return &Execute{
		toFrontend:  toFrontend,
		symboltable: symboltable,
	}
}

// QuestionaireNode execute all actionNodes of a questionaire (form)
func (exec Execute) QuestionaireNode(q *ast.QuestionaireNode) {
	ast.DelegateQuestionaireNodeExecution(exec, q)
}

// ActionNode branches to QuestionNode or IfNode executers
func (exec Execute) ActionNode(a *ast.ActionNode) {
	ast.DelegateActionNodeExecution(exec, a)
}

// QuestionNode adds question to symbol table, and dispatch to frontend
// rendering.
func (exec Execute) QuestionNode(q *ast.QuestionNode) {
	exec.symboltable.Create(q)

	r := exec.symboltable.Read(q.Identifier())

	if q.Type() == ast.ComputedQuestionType {
		expr := q.Content().(*ast.ComputedQuestion).Expression()
		computed := fmt.Sprintf("%f", exec.resolveMathNode(expr))
		r.(symboltable.StringParser).From(computed)
	}

	exec.toFrontend <- &plumbing.Frontend{
		Type:       plumbing.UpdateQuestion,
		Identifier: q.Identifier(),
		Label:      q.Label(),
		Value:      r.(fmt.Stringer).String(),
	}
}

// IfNode analyzes condition and run all children (ActionNodes)
func (exec Execute) IfNode(i *ast.IfNode) {
	if exec.ResolveComparisonNode(i.Conditions()) {
		for _, actionNode := range i.Stack() {
			exec.ActionNode(actionNode)
		}
	} else if i.ElseNode() != nil {
		exec.IfNode(i.ElseNode())
	}
}
