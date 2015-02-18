package interpreter

import (
	"log"

	"github.com/software-engineering-amsterdam/many-ql/carlos.cirello/ast"
)

// Walk implements Executer interface, and walks through AST
type Walk struct {
	toFrontend chan *Event
	nest       int
}

// Exec type switch through all possible root AST node types
func (walk Walk) Exec(node interface{}) {
	switch t := node.(type) {
	default:
		log.Fatalf("unexpected execution node type. got: %T", t)
	case *ast.QuestionaireNode:
		walk.QuestionaireNode(node.(*ast.QuestionaireNode))
	case *ast.ActionNode:
		walk.ActionNode(node.(*ast.ActionNode))
	case *ast.QuestionNode:
		walk.QuestionNode(node.(*ast.QuestionNode))
	case *ast.IfNode:
		walk.IfNode(node.(*ast.IfNode))
	}
}

// QuestionaireNode Walker all actionNodes of a questionaire (form)
func (walk Walk) QuestionaireNode(q *ast.QuestionaireNode) {
	for _, actionNode := range q.Stack() {
		walk.Exec(actionNode)
	}
}

// ActionNode branches to QuestionNode or IfNode Walkerrs
func (walk Walk) ActionNode(a *ast.ActionNode) {
	walk.Exec(a.Action())
}

// QuestionNode adds question to symbol table, and dispatch to frontend
// rendering.
func (walk Walk) QuestionNode(q *ast.QuestionNode) {
	questionCopy := q.Clone()
	visible := Hidden
	if 0 == walk.nest {
		visible = Visible
	}
	walk.toFrontend <- &Event{
		Type:     Draw,
		Question: questionCopy,
		Visible:  visible,
	}
}

// IfNode analyzes condition and run all children (ActionNodes)
func (walk Walk) IfNode(i *ast.IfNode) {
	walk.nest++
	for _, actionNode := range i.Stack() {
		walk.Exec(actionNode)
	}
	if i.ElseNode() != nil {
		walk.Exec(i.ElseNode())
	}
	walk.nest--
}
