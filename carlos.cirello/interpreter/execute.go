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

// Exec type switch through all possible AST node types
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
	for _, c := range i.Conditions {
		switch t := c.(type) {
		default:
			log.Fatalf("impossible condition type. got: %T", t)
		case *ast.SingleTermNode:
			if !exec.SingleTermNode(c.(*ast.SingleTermNode)) {
				return
			}
		case *ast.EqualsNode:
			if !exec.EqualsNode(c.(*ast.EqualsNode)) {
				return
			}
		case *ast.MoreThanNode:
			if !exec.MoreThanNode(c.(*ast.MoreThanNode)) {
				return
			}
		case *ast.LessThanNode:
			if !exec.LessThanNode(c.(*ast.LessThanNode)) {
				return
			}
		case *ast.MoreOrEqualsThanNode:
			if !exec.MoreOrEqualsThanNode(c.(*ast.MoreOrEqualsThanNode)) {
				return
			}
		case *ast.LessOrEqualsThanNode:
			if !exec.LessOrEqualsThanNode(c.(*ast.LessOrEqualsThanNode)) {
				return
			}
		}
	}
	for _, actionNode := range i.Stack {
		exec.Exec(actionNode)
	}

}

func (exec Execute) SingleTermNode(s *ast.SingleTermNode) bool {
	value := exec.resolveTermNode(s.LeftTerm)

	switch value.(type) {
	case bool:
		return value.(bool)
	case int:
		return value.(int) != 0
	case float32:
		return value.(float32) != 0
	}

	return false
}

func (exec Execute) EqualsNode(s *ast.EqualsNode) bool {
	left := exec.resolveNumeric(s.LeftTerm)
	right := exec.resolveNumeric(s.RightTerm)

	return left == right
}

func (exec Execute) MoreThanNode(s *ast.MoreThanNode) bool {
	left := exec.resolveNumeric(s.LeftTerm)
	right := exec.resolveNumeric(s.RightTerm)

	return left > right
}

func (exec Execute) LessThanNode(s *ast.LessThanNode) bool {
	left := exec.resolveNumeric(s.LeftTerm)
	right := exec.resolveNumeric(s.RightTerm)

	return left < right
}

func (exec Execute) MoreOrEqualsThanNode(s *ast.MoreOrEqualsThanNode) bool {
	left := exec.resolveNumeric(s.LeftTerm)
	right := exec.resolveNumeric(s.RightTerm)

	return left >= right
}

func (exec Execute) LessOrEqualsThanNode(s *ast.LessOrEqualsThanNode) bool {
	left := exec.resolveNumeric(s.LeftTerm)
	right := exec.resolveNumeric(s.RightTerm)

	return left <= right
}

func (exec *Execute) resolveNumeric(t *ast.TermNode) float32 {
	node := exec.resolveTermNode(t)
	var nodeVal float32
	switch t := node.(type) {
	default:
		log.Fatalf("Type impossible to execute comparison. got: %T", t)
	case int:
		nodeVal = float32(node.(int))
	case float32:
		nodeVal = node.(float32)
	}
	return nodeVal
}

func (exec *Execute) resolveTermNode(t *ast.TermNode) interface{} {
	identifier := t.IdentifierReference
	if identifier != "" {
		ret := make(chan *ast.QuestionNode)
		exec.symbolChan <- &symbolEvent{
			command: SymbolRead,
			name:    identifier,
			ret:     ret,
		}

		q := <-ret

		switch q.Type() {
		case ast.BoolQuestionType:
			content := q.Content.(*ast.BoolQuestion)
			return content.Value()
		case ast.IntQuestionType:
			content := q.Content.(*ast.IntQuestion)
			return content.Value()
		}
	}
	return t.NumericConstant
}
