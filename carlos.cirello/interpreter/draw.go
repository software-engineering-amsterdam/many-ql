package interpreter

import "github.com/software-engineering-amsterdam/many-ql/carlos.cirello/ast"

// Draw implements Executer interface, and it is used by Visitor to traverse
// AST
type Draw struct {
	toFrontend chan *Event
	nest       int
}

// NewDraw is the factory for Draw struct
func NewDraw(toFrontend chan *Event) *Visitor {
	return &Visitor{
		&Draw{
			toFrontend: toFrontend,
			nest:       0,
		},
	}
}

// QuestionaireNode Drawer all actionNodes of a questionaire (form)
func (Draw Draw) QuestionaireNode(v *Visitor, q *ast.QuestionaireNode) {
	for _, actionNode := range q.Stack() {
		v.Visit(actionNode)
	}
}

// ActionNode branches to QuestionNode or IfNode Drawerrs
func (Draw Draw) ActionNode(v *Visitor, a *ast.ActionNode) {
	v.Visit(a.Action())
}

// QuestionNode adds question to symbol table, and dispatch to frontend
// rendering.
func (Draw Draw) QuestionNode(v *Visitor, q *ast.QuestionNode) {
	questionCopy := q.Clone()
	visible := Hidden
	if 0 == Draw.nest {
		visible = Visible
	}
	Draw.toFrontend <- &Event{
		Type:     DrawQuestion,
		Question: questionCopy,
		Visible:  visible,
	}
}

// IfNode analyzes condition and run all children (ActionNodes)
func (Draw *Draw) IfNode(v *Visitor, i *ast.IfNode) {
	Draw.nest++
	for _, actionNode := range i.Stack() {
		v.Visit(actionNode)
	}
	if i.ElseNode() != nil {
		v.Visit(i.ElseNode())
	}
	Draw.nest--
}
