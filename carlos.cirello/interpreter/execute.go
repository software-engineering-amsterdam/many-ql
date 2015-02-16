package interpreter

import (
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
	for _, actionNode := range q.Stack {
		exec.Exec(actionNode)
	}
}

// ActionNode branches to QuestionNode or IfNode executers
func (exec Execute) ActionNode(a *ast.ActionNode) {
	exec.Exec(a.Action)
}

// QuestionNode adds question to symbol table, and dispatch to frontend
// rendering.
func (exec Execute) QuestionNode(q *ast.QuestionNode) {
	exec.symbolChan <- &symbolEvent{
		command: SymbolCreate,
		name:    q.Identifier,
		content: q,
	}

	questionCopy := q.Clone()
	exec.toFrontend <- &Event{
		Type:     Render,
		Question: questionCopy,
	}
}

// IfNode analyzes condition and run all children (ActionNodes)
func (exec Execute) IfNode(i *ast.IfNode) {

	conditionState := true
	c := i.Conditions
	switch t := c.(type) {
	default:
		log.Fatalf("impossible condition type. got: %T", t)
	case *ast.TermNode:
		if !exec.TermNode(c.(*ast.TermNode)) {
			conditionState = false
		}
	case *ast.EqualsNode:
		if !exec.EqualsNode(c.(*ast.EqualsNode)) {
			conditionState = false
		}
	case *ast.MoreThanNode:
		if !exec.MoreThanNode(c.(*ast.MoreThanNode)) {
			conditionState = false
		}
	case *ast.LessThanNode:
		if !exec.LessThanNode(c.(*ast.LessThanNode)) {
			conditionState = false
		}
	case *ast.MoreOrEqualsThanNode:
		if !exec.MoreOrEqualsThanNode(c.(*ast.MoreOrEqualsThanNode)) {
			conditionState = false
		}
	case *ast.LessOrEqualsThanNode:
		if !exec.LessOrEqualsThanNode(c.(*ast.LessOrEqualsThanNode)) {
			conditionState = false
		}
	}

	if conditionState {
		for _, actionNode := range i.Stack {
			exec.Exec(actionNode)
		}
	} else if i.ElseNode != nil {
		exec.Exec(i.ElseNode)
	}
}
