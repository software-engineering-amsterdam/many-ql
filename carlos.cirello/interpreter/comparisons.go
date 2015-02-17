package interpreter

import "github.com/software-engineering-amsterdam/many-ql/carlos.cirello/ast"

func (exec Execute) EqualsNode(s *ast.EqualsNode) bool {
	lt := s.LeftTerm()
	rt := s.RightTerm()
	left := exec.resolveMathNode(lt)
	right := exec.resolveMathNode(rt)

	return left == right
}

func (exec Execute) MoreThanNode(n *ast.MoreThanNode) bool {
	left, right := exec.resolveBothMathNodes(n.DoubleTermNode)
	return left > right
}

func (exec Execute) LessThanNode(n *ast.LessThanNode) bool {
	left, right := exec.resolveBothMathNodes(n.DoubleTermNode)
	return left < right
}

func (exec Execute) MoreOrEqualsThanNode(n *ast.MoreOrEqualsThanNode) bool {
	left, right := exec.resolveBothMathNodes(n.DoubleTermNode)
	return left >= right
}

func (exec Execute) LessOrEqualsThanNode(n *ast.LessOrEqualsThanNode) bool {
	left, right := exec.resolveBothMathNodes(n.DoubleTermNode)
	return left <= right
}

func (exec Execute) TermNode(s *ast.TermNode) bool {
	value := exec.resolveTermNode(s)

	switch value.(type) {
	case bool:
		return value.(bool)
	case int:
		return value.(int) != 0
	case float32:
		return value.(float32) != 0
	case string:
		return value.(string) != ""
	}

	return false
}
