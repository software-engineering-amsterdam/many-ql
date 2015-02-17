package interpreter

import (
	"log"

	"github.com/software-engineering-amsterdam/many-ql/carlos.cirello/ast"
)

func (exec Execute) MathAddNode(s *ast.MathAddNode) float32 {
	lt := s.LeftTerm()
	rt := s.RightTerm()
	left := exec.resolveMathNode(lt)
	right := exec.resolveMathNode(rt)

	return left + right
}

func (exec Execute) MathSubNode(s *ast.MathSubNode) float32 {
	lt := s.LeftTerm()
	rt := s.RightTerm()
	left := exec.resolveMathNode(lt)
	right := exec.resolveMathNode(rt)

	return left - right
}

func (exec Execute) MathMulNode(s *ast.MathMulNode) float32 {
	lt := s.LeftTerm()
	rt := s.RightTerm()
	left := exec.resolveMathNode(lt)
	right := exec.resolveMathNode(rt)

	return left * right
}

func (exec Execute) MathDivNode(s *ast.MathDivNode) float32 {
	lt := s.LeftTerm()
	rt := s.RightTerm()
	left := exec.resolveMathNode(lt)
	right := exec.resolveMathNode(rt)

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
