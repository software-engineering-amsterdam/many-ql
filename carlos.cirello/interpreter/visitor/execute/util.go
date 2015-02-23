package execute

import (
	"log"

	"github.com/software-engineering-amsterdam/many-ql/carlos.cirello/ast"
	"github.com/software-engineering-amsterdam/many-ql/carlos.cirello/interpreter/event"
)

func (exec Execute) resolveBothMathNodes(n ast.DoubleTermNode) (left,
	right float32) {
	lt := n.LeftTerm()
	rt := n.RightTerm()

	left = exec.resolveMathNode(lt)
	right = exec.resolveMathNode(rt)

	return left, right
}

func (exec Execute) resolveMathNode(n interface{}) float32 {
	switch t := n.(type) {
	default:
		pos := n.(ast.Positionable).Pos()
		log.Fatalf("%s:runtime error: Unknown type while resolving node %T", pos, t)
	case *ast.MathAddNode:
		return exec.MathAddNode(n.(*ast.MathAddNode))
	case *ast.MathSubNode:
		return exec.MathSubNode(n.(*ast.MathSubNode))
	case *ast.MathMulNode:
		return exec.MathMulNode(n.(*ast.MathMulNode))
	case *ast.MathDivNode:
		return exec.MathDivNode(n.(*ast.MathDivNode))
	case *ast.TermNode:
		return exec.MathTermNode(n.(*ast.TermNode))
	}
	return 0
}

func (exec *Execute) resolveNumeric(n *ast.TermNode) float32 {
	node := exec.resolveTermNode(n)
	var nodeVal float32
	switch t := node.(type) {
	default:
		pos := n.Pos()
		log.Fatalf("%s:runtime error: Type impossible to execute comparison. got: %T", pos, t)
	case int:
		nodeVal = float32(node.(int))
	case float32:
		nodeVal = node.(float32)
	}
	return nodeVal
}

func (exec *Execute) resolveTermNode(t interface{}) interface{} {
	identifier := t.(*ast.TermNode).IdentifierReference()
	if identifier != "" {
		ret := make(chan *ast.QuestionNode)
		exec.symbolChan <- &event.Symbol{
			Command: event.SymbolRead,
			Name:    identifier,
			Ret:     ret,
		}

		q := <-ret

		if q == nil {
			return nil
		}

		switch q.Type() {
		case ast.BoolQuestionType:
			content := q.Content().(*ast.BoolQuestion)
			return content.Value()
		case ast.NumericQuestionType:
			content := q.Content().(*ast.NumericQuestion)
			return content.Value()
		case ast.StringQuestionType:
			content := q.Content().(*ast.StringQuestion)
			return content.String()
		}
	}
	switch t.(*ast.TermNode).Type() {
	case ast.NumericConstantNodeType:
		return t.(*ast.TermNode).NumericConstant()
	case ast.StringConstantNodeType:
		return t.(*ast.TermNode).StringConstant()
	}
	return nil
}
