package interpreter

import (
	"fmt"
	"log"

	"github.com/software-engineering-amsterdam/many-ql/carlos.cirello/ast"
)

// Execute implements Executer interface, and walks through AST
type Execute struct {
	toFrontend chan *Event
	symbolChan chan *symbolEvent
}

// Exec type switch through all possible root AST node types
func (exec Execute) Exec(node interface{}) {
	switch t := node.(type) {
	default:
		log.Fatalf("unexpected execution node type. got: %T", t)
	case *ast.QuestionaireNode:
		exec.QuestionaireNode(node.(*ast.QuestionaireNode))
	case *ast.ActionNode:
		exec.ActionNode(node.(*ast.ActionNode))
	case *ast.QuestionNode:
		exec.QuestionNode(node.(*ast.QuestionNode))
	case *ast.IfNode:
		exec.IfNode(node.(*ast.IfNode))
	}
}

// QuestionaireNode execute all actionNodes of a questionaire (form)
func (exec Execute) QuestionaireNode(q *ast.QuestionaireNode) {
	for _, actionNode := range q.Stack() {
		exec.Exec(actionNode)
	}
}

// ActionNode branches to QuestionNode or IfNode executers
func (exec Execute) ActionNode(a *ast.ActionNode) {
	exec.Exec(a.Action())
}

// QuestionNode adds question to symbol table, and dispatch to frontend
// rendering.
func (exec Execute) QuestionNode(q *ast.QuestionNode) {
	exec.symbolChan <- &symbolEvent{
		command: SymbolCreate,
		name:    q.Identifier(),
		content: q,
	}

	if q.Type() == ast.ComputedQuestionType {
		expr := q.Content().(*ast.ComputedQuestion).Expression
		q.From(fmt.Sprintf("%f", exec.resolveMathNode(expr)))
	}

	questionCopy := q.Clone()
	exec.toFrontend <- &Event{
		Type:     Render,
		Question: questionCopy,
	}
}

// IfNode analyzes condition and run all children (ActionNodes)
func (exec Execute) IfNode(i *ast.IfNode) {
	if exec.resolveComparisonNode(i.Conditions()) {
		for _, actionNode := range i.Stack() {
			exec.Exec(actionNode)
		}
	} else if i.ElseNode() != nil {
		exec.Exec(i.ElseNode())
	}
}
