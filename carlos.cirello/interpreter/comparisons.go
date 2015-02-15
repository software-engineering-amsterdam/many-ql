package interpreter

import "github.com/software-engineering-amsterdam/many-ql/carlos.cirello/ast"

func (exec Execute) EqualsNode(s *ast.EqualsNode) bool {
	left := exec.resolveMathNode(s.LeftTerm)
	right := exec.resolveMathNode(s.RightTerm)

	return left == right
}

func (exec Execute) MoreThanNode(s *ast.MoreThanNode) bool {
	left := exec.resolveMathNode(s.LeftTerm.(*ast.TermNode))
	right := exec.resolveMathNode(s.RightTerm.(*ast.TermNode))

	return left > right
}

func (exec Execute) LessThanNode(s *ast.LessThanNode) bool {
	left := exec.resolveMathNode(s.LeftTerm.(*ast.TermNode))
	right := exec.resolveMathNode(s.RightTerm.(*ast.TermNode))

	return left < right
}

func (exec Execute) MoreOrEqualsThanNode(s *ast.MoreOrEqualsThanNode) bool {
	left := exec.resolveMathNode(s.LeftTerm.(*ast.TermNode))
	right := exec.resolveMathNode(s.RightTerm.(*ast.TermNode))

	return left >= right
}

func (exec Execute) LessOrEqualsThanNode(s *ast.LessOrEqualsThanNode) bool {
	left := exec.resolveMathNode(s.LeftTerm.(*ast.TermNode))
	right := exec.resolveMathNode(s.RightTerm.(*ast.TermNode))

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
