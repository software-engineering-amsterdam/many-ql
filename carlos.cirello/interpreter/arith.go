package interpreter

import (
	"log"

	"github.com/software-engineering-amsterdam/many-ql/carlos.cirello/ast"
)

func (exec Execute) MathAddNode(n *ast.MathAddNode) float32 {
	left, right := exec.resolveBothMathNodes(n.DoubleTermNode)
	return left + right
}

func (exec Execute) MathSubNode(n *ast.MathSubNode) float32 {
	left, right := exec.resolveBothMathNodes(n.DoubleTermNode)
	return left - right
}

func (exec Execute) MathMulNode(n *ast.MathMulNode) float32 {
	left, right := exec.resolveBothMathNodes(n.DoubleTermNode)
	return left * right
}

func (exec Execute) MathDivNode(n *ast.MathDivNode) float32 {
	left, right := exec.resolveBothMathNodes(n.DoubleTermNode)
	return left / right
}

func (exec Execute) MathTermNode(s *ast.TermNode) float32 {
	value := exec.resolveTermNode(s)
	switch t := value.(type) {
	default:
		log.Fatalf("Variable not a number. Got %T", t)
	case int:
		return float32(value.(int))
	case float32:
		return value.(float32)
	}
	return 0
}
