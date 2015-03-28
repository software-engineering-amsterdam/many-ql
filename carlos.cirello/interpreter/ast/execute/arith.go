package execute

import (
	"log"
	"strconv"

	"github.com/software-engineering-amsterdam/many-ql/carlos.cirello/interpreter/ast"
)

// MathAddNode is the visitor for addition operation nodes.
func (exec Execute) MathAddNode(n *ast.MathAddNode) float32 {
	left, right := exec.resolveBothMathNodes(n.DoubleTermNode)
	return left + right
}

// MathSubNode is the visitor for subtraction operation nodes.
func (exec Execute) MathSubNode(n *ast.MathSubNode) float32 {
	left, right := exec.resolveBothMathNodes(n.DoubleTermNode)
	return left - right
}

// MathMulNode is the visitor for multiplication operation nodes.
func (exec Execute) MathMulNode(n *ast.MathMulNode) float32 {
	left, right := exec.resolveBothMathNodes(n.DoubleTermNode)
	return left * right
}

// MathDivNode is the visitor for divistion operation nodes.
func (exec Execute) MathDivNode(n *ast.MathDivNode) float32 {
	left, right := exec.resolveBothMathNodes(n.DoubleTermNode)
	return left / right
}

// MathModNode is the visitor for divistion operation nodes.
func (exec Execute) MathModNode(n *ast.MathModNode) float32 {
	left, right := exec.resolveBothMathNodes(n.DoubleTermNode)
	return float32(int(left) % int(right))
}

// MathTermNode is the visitor for deepest TermNodes nodes that holds a number.
func (exec Execute) MathTermNode(s *ast.TermNode) float32 {
	value := exec.resolveTermNode(s)
	switch t := value.(type) {
	default:
		log.Panicf("%s: variable %s not a number. Got %T", s.Pos(),
			s.IdentifierReference(), t)
	case nil:
		return 0
	case int:
		return float32(value.(int))
	case float32:
		return value.(float32)
	case string:
		str := value.(string)
		v, err := strconv.ParseFloat(str, 32)
		if err != nil {
			log.Panicf("%s: variable %s not a number. Got: %s",
				s.Pos(), s.IdentifierReference(), str)
		}
		return float32(v)
	}
	return 0
}
