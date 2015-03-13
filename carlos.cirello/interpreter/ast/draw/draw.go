package draw

import (
	"github.com/software-engineering-amsterdam/many-ql/carlos.cirello/interpreter/ast"
	"github.com/software-engineering-amsterdam/many-ql/carlos.cirello/plumbing"
)

// Draw implements Executer interface, and it is used by Visitor to traverse
// AST
type Draw struct {
	toFrontend chan *plumbing.Frontend
	nest       int
}

// New is the factory for Draw struct
func New(toFrontend chan *plumbing.Frontend) ast.Executer {
	return &Draw{toFrontend: toFrontend, nest: 0}
}

// QuestionaireNode Drawer all actionNodes of a questionaire (form)
func (d Draw) QuestionaireNode(q *ast.QuestionaireNode) {
	ast.DelegateQuestionaireNodeExecution(d, q)
}

// ActionNode branches to QuestionNode or IfNode Drawerrs
func (d Draw) ActionNode(a *ast.ActionNode) {
	ast.DelegateActionNodeExecution(d, a)
}

// QuestionNode adds question to symbol table, and dispatch to frontend
// rendering.
func (d Draw) QuestionNode(q *ast.QuestionNode) {

	qcpy := q.Clone()
	visible := plumbing.Hidden
	if 0 == d.nest {
		visible = plumbing.Visible
	}

	ftyp := ""
	if qcpy.Type() == ast.ScalarQuestionType {
		ftyp = qcpy.Primitive()
	}

	d.toFrontend <- &plumbing.Frontend{
		Type: plumbing.DrawQuestion,

		Identifier: qcpy.Identifier(),
		Label:      qcpy.Label(),
		FieldType:  ftyp,

		Visible: visible,
	}
}

// IfNode analyzes condition and run all children (ActionNodes)
func (d Draw) IfNode(i *ast.IfNode) {
	d.nest++
	for _, actionNode := range i.Stack() {
		d.ActionNode(actionNode)
	}
	if i.ElseNode() != nil {
		d.IfNode(i.ElseNode())
	}
	d.nest--
}
