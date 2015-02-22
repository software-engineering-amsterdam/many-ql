package execute

import (
	"log"

	"github.com/software-engineering-amsterdam/many-ql/carlos.cirello/ast"
)

// MathAddNode is the visitor for addition operation nodes
func (exec Execute) MathAddNode(n *ast.MathAddNode) float32 {
	left, right := exec.resolveBothMathNodes(n.DoubleTermNode)
	return left + right
}

// MathSubNode is the visitor for subtraction operation nodes
func (exec Execute) MathSubNode(n *ast.MathSubNode) float32 {
	left, right := exec.resolveBothMathNodes(n.DoubleTermNode)
	return left - right
}

// MathMulNode is the visitor for multiplication operation nodes
func (exec Execute) MathMulNode(n *ast.MathMulNode) float32 {
	left, right := exec.resolveBothMathNodes(n.DoubleTermNode)
	return left * right
}

// MathDivNode is the visitor for divistion operation nodes
func (exec Execute) MathDivNode(n *ast.MathDivNode) float32 {
	left, right := exec.resolveBothMathNodes(n.DoubleTermNode)
	return left / right
}

// MathTermNode is the visitor for deepest TermNodes nodes that holds a number
func (exec Execute) MathTermNode(s *ast.TermNode) float32 {
	value := exec.resolveTermNode(s)
	switch t := value.(type) {
	default:
		log.Fatalf("%s: variable %s not a number. Got %T", s.Pos(), s.IdentifierReference(), t)
	case int:
		return float32(value.(int))
	case float32:
		return value.(float32)
	}
	return 0
}
