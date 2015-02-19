package interpreter

import "github.com/software-engineering-amsterdam/many-ql/carlos.cirello/ast"

// Walk implements Executer interface, and it is used by Visitor to traverse
// AST
type Walk struct {
	toFrontend chan *Event
	nest       int
}

// NewWalk is the factory for Walk struct
func NewWalk(toFrontend chan *Event) *Visitor {
	return &Visitor{
		&Walk{
			toFrontend: toFrontend,
			nest:       0,
		},
	}
}

// QuestionaireNode Walker all actionNodes of a questionaire (form)
func (walk Walk) QuestionaireNode(v *Visitor, q *ast.QuestionaireNode) {
	for _, actionNode := range q.Stack() {
		v.Visit(actionNode)
	}
}

// ActionNode branches to QuestionNode or IfNode Walkerrs
func (walk Walk) ActionNode(v *Visitor, a *ast.ActionNode) {
	v.Visit(a.Action())
}

// QuestionNode adds question to symbol table, and dispatch to frontend
// rendering.
func (walk Walk) QuestionNode(v *Visitor, q *ast.QuestionNode) {
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
func (walk Walk) IfNode(v *Visitor, i *ast.IfNode) {
	walk.nest++
	for _, actionNode := range i.Stack() {
		v.Visit(actionNode)
	}
	if i.ElseNode() != nil {
		v.Visit(i.ElseNode())
	}
	walk.nest--
}
