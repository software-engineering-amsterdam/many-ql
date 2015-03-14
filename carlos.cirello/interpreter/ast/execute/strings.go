package execute

import (
	"log"

	"github.com/software-engineering-amsterdam/many-ql/carlos.cirello/interpreter/ast"
)

// ConcatNode is the visitor for addition operation nodes
func (exec Execute) ConcatNode(n *ast.ConcatNode) string {
	left, right := exec.resolveBothStringNodes(n.DoubleTermNode)
	return left + right
}

// MathTermNode is the visitor for deepest TermNodes nodes that holds a number
func (exec Execute) StringTermNode(s *ast.TermNode) string {
	value := exec.resolveTermNode(s)
	switch t := value.(type) {
	default:
		log.Fatalf("%s: variable %s not a string. Got %T", s.Pos(), s.IdentifierReference(), t)
	case string:
		return value.(string)
	}
	return ""
}

func (exec Execute) resolveBothStringNodes(n ast.DoubleTermNode) (left,
	right string) {
	lt := n.LeftTerm()
	rt := n.RightTerm()

	left = exec.resolveStringNode(lt)
	right = exec.resolveStringNode(rt)

	return left, right
}

func (exec Execute) resolveStringNode(n interface{}) string {
	switch t := n.(type) {
	default:
		pos := n.(ast.Positionable).Pos()
		log.Fatalf("%s:runtime error: Unknown type while resolving node %T", pos, t)
	case *ast.ConcatNode:
		return exec.ConcatNode(n.(*ast.ConcatNode))
	case *ast.TermNode:
		return exec.StringTermNode(n.(*ast.TermNode))
	}
	return ""
}
