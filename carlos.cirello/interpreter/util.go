package interpreter

import (
	"log"

	"github.com/software-engineering-amsterdam/many-ql/carlos.cirello/ast"
)

func (exec Execute) resolveMathNode(n ast.Evaluatable) float32 {
	switch t := n.(type) {
	default:
		log.Fatalf("Unknown type while resolving node %T", t)
	case *ast.MathAddNode:
		left := exec.resolveMathNode(n.(*ast.MathAddNode).LeftTerm)
		right := exec.resolveMathNode(n.(*ast.MathAddNode).RightTerm)
		return left + right
	case *ast.MathSubNode:
		left := exec.resolveMathNode(n.(*ast.MathSubNode).LeftTerm)
		right := exec.resolveMathNode(n.(*ast.MathSubNode).RightTerm)
		return left - right
	case *ast.TermNode:
		value := exec.resolveTermNode(n.(*ast.TermNode))
		switch t := value.(type) {
		default:
			log.Fatalf("Variable not a number. Got %T", t)
		case int:
			return float32(value.(int))
		case float32:
			return value.(float32)
		}
	}
	return 0
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
		case ast.StringQuestionType:
			content := q.Content.(*ast.StringQuestion)
			return content.String()
		}
	}
	return t.NumericConstant
}
