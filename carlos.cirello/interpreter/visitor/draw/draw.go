package draw

import (
	"github.com/software-engineering-amsterdam/many-ql/carlos.cirello/ast"
	"github.com/software-engineering-amsterdam/many-ql/carlos.cirello/interpreter/event"
	"github.com/software-engineering-amsterdam/many-ql/carlos.cirello/interpreter/visitor"
)

// Draw implements Executer interface, and it is used by Visitor to traverse
// AST
type Draw struct {
	toFrontend chan *event.Frontend
	nest       int
}

// New is the factory for Draw struct
func New(toFrontend chan *event.Frontend) *visitor.Visitor {
	return visitor.NewVisitor(&Draw{toFrontend: toFrontend, nest: 0})
}

// QuestionaireNode Drawer all actionNodes of a questionaire (form)
func (Draw Draw) QuestionaireNode(v *visitor.Visitor, q *ast.QuestionaireNode) {
	for _, actionNode := range q.Stack() {
		v.Visit(actionNode)
	}
}

// ActionNode branches to QuestionNode or IfNode Drawerrs
func (Draw Draw) ActionNode(v *visitor.Visitor, a *ast.ActionNode) {
	v.Visit(a.Action())
}

// QuestionNode adds question to symbol table, and dispatch to frontend
// rendering.
func (Draw Draw) QuestionNode(v *visitor.Visitor, q *ast.QuestionNode) {

	qcpy := q.Clone()
	visible := event.Hidden
	if 0 == Draw.nest {
		visible = event.Visible
	}
	Draw.toFrontend <- &event.Frontend{
		Type: event.DrawQuestion,

		Identifier: qcpy.Identifier(),
		Label:      qcpy.Label(),
		FieldType:  qcpy.Type(),

		Visible: visible,
	}
}

// IfNode analyzes condition and run all children (ActionNodes)
func (Draw *Draw) IfNode(v *visitor.Visitor, i *ast.IfNode) {
	Draw.nest++
	for _, actionNode := range i.Stack() {
		v.Visit(actionNode)
	}
	if i.ElseNode() != nil {
		v.Visit(i.ElseNode())
	}
	Draw.nest--
}
