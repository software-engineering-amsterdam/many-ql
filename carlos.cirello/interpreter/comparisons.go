package interpreter

import (
	"log"

	"github.com/software-engineering-amsterdam/many-ql/carlos.cirello/ast"
)

// EqualsNode is the visitor for Equals comparison operation
func (exec Execute) EqualsNode(n *ast.EqualsNode) bool {
	lt, ltOk := n.LeftTerm().(*ast.TermNode)
	rt, rtOk := n.RightTerm().(*ast.TermNode)
	if ltOk && rtOk {
		vl := exec.resolveTermNode(lt)
		vr := exec.resolveTermNode(rt)
		return vl == vr
	}

	left, right := exec.resolveBothMathNodes(n.DoubleTermNode)
	return left == right
}

// NotEqualsNode is the visitor for not equals comparison operation
func (exec Execute) NotEqualsNode(n *ast.NotEqualsNode) bool {
	lt, ltOk := n.LeftTerm().(*ast.TermNode)
	rt, rtOk := n.RightTerm().(*ast.TermNode)
	if ltOk && rtOk {
		vl := exec.resolveTermNode(lt)
		vr := exec.resolveTermNode(rt)
		return vl != vr
	}

	left, right := exec.resolveBothMathNodes(n.DoubleTermNode)
	return left != right
}

// MoreThanNode is the visitor for More Than comparison operation
func (exec Execute) MoreThanNode(n *ast.MoreThanNode) bool {
	left, right := exec.resolveBothMathNodes(n.DoubleTermNode)
	return left > right
}

// LessThanNode is the visitor for Less Than comparison operation
func (exec Execute) LessThanNode(n *ast.LessThanNode) bool {
	left, right := exec.resolveBothMathNodes(n.DoubleTermNode)
	return left < right
}

// MoreOrEqualsThanNode is the visitor for More Or Equals Than comparison operation
func (exec Execute) MoreOrEqualsThanNode(n *ast.MoreOrEqualsThanNode) bool {
	left, right := exec.resolveBothMathNodes(n.DoubleTermNode)
	return left >= right
}

// LessOrEqualsThanNode is the visitor for Less Or Equals Than comparison operation
func (exec Execute) LessOrEqualsThanNode(n *ast.LessOrEqualsThanNode) bool {
	left, right := exec.resolveBothMathNodes(n.DoubleTermNode)
	return left <= right
}

// TermNode is the visitor for Term comparison operation
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

// BoolAndNode is the visitor for "and" comparison operation
func (exec Execute) BoolAndNode(n *ast.BoolAndNode) bool {
	left := exec.resolveComparisonNode(n.DoubleTermNode.LeftTerm())
	right := exec.resolveComparisonNode(n.DoubleTermNode.RightTerm())
	return left && right
}

// BoolOrNode is the visitor for "or" comparison operation
func (exec Execute) BoolOrNode(n *ast.BoolOrNode) bool {
	left := exec.resolveComparisonNode(n.DoubleTermNode.LeftTerm())
	right := exec.resolveComparisonNode(n.DoubleTermNode.RightTerm())
	return left || right
}

func (exec *Execute) resolveComparisonNode(n interface{}) bool {
	conditionState := true
	switch t := n.(type) {
	default:
		pos := n.(ast.Positionable).Pos()
		log.Fatalf("%s:runtime error: impossible condition type. got: %T", pos, t)
	case *ast.TermNode:
		if !exec.TermNode(n.(*ast.TermNode)) {
			conditionState = false
		}
	case *ast.NotEqualsNode:
		if !exec.NotEqualsNode(n.(*ast.NotEqualsNode)) {
			conditionState = false
		}
	case *ast.EqualsNode:
		if !exec.EqualsNode(n.(*ast.EqualsNode)) {
			conditionState = false
		}
	case *ast.MoreThanNode:
		if !exec.MoreThanNode(n.(*ast.MoreThanNode)) {
			conditionState = false
		}
	case *ast.LessThanNode:
		if !exec.LessThanNode(n.(*ast.LessThanNode)) {
			conditionState = false
		}
	case *ast.MoreOrEqualsThanNode:
		if !exec.MoreOrEqualsThanNode(n.(*ast.MoreOrEqualsThanNode)) {
			conditionState = false
		}
	case *ast.LessOrEqualsThanNode:
		if !exec.LessOrEqualsThanNode(n.(*ast.LessOrEqualsThanNode)) {
			conditionState = false
		}
	case *ast.BoolAndNode:
		if !exec.BoolAndNode(n.(*ast.BoolAndNode)) {
			conditionState = false
		}
	case *ast.BoolOrNode:
		if !exec.BoolOrNode(n.(*ast.BoolOrNode)) {
			conditionState = false
		}
	}
	return conditionState
}
