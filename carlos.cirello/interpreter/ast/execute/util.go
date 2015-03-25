package execute

import (
	"fmt"
	"log"
	"strings"

	"github.com/software-engineering-amsterdam/many-ql/carlos.cirello/interpreter/ast"
	"github.com/software-engineering-amsterdam/many-ql/carlos.cirello/interpreter/symboltable"
)

func (exec Execute) resolveExpressionIntoString(expr interface{}) string {
	r := exec.resolveExpression(expr)
	switch r.(type) {
	case float32:
		return fmt.Sprintf("%f", r)
	case bool:
		return symboltable.BoolString(r.(bool))
	default:
		return fmt.Sprintf("%s", r)
	}
}

func (exec Execute) resolveBothExpressions(n ast.DoubleTermNode) (left, right interface{}) {
	lt := n.LeftTerm()
	rt := n.RightTerm()

	left = exec.resolveExpression(lt)
	right = exec.resolveExpression(rt)

	return left, right
}

func (exec Execute) resolveExpression(n interface{}) interface{} {
	switch n.(type) {
	case *ast.ConcatNode:
		return exec.resolveStringNode(n)
	case *ast.TermNode:
		return exec.resolveTermNode(n)
	}

	v, err := exec.visitComparisonNode(n)
	if err == nil {
		return v
	}

	return exec.resolveMathNode(n)
}

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
		log.Panicf(
			"%s:runtime error: Unknown type while resolving node %T",
			pos, t)
	case *ast.MathAddNode:
		return exec.MathAddNode(n.(*ast.MathAddNode))
	case *ast.MathSubNode:
		return exec.MathSubNode(n.(*ast.MathSubNode))
	case *ast.MathMulNode:
		return exec.MathMulNode(n.(*ast.MathMulNode))
	case *ast.MathDivNode:
		return exec.MathDivNode(n.(*ast.MathDivNode))
	case *ast.MathModNode:
		return exec.MathModNode(n.(*ast.MathModNode))
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
		log.Panicf(
			"%s:runtime error: Type impossible to execute comparison. got: %T",
			pos, t)
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
		q := exec.symboltable.Read(identifier)

		if q == nil {
			return nil
		}

		return q.(symboltable.ValueLoader).Value()
	}
	switch t.(*ast.TermNode).Type() {
	case ast.NumericLiteralNodeType:
		return t.(*ast.TermNode).NumericLiteral()
	case ast.StringLiteralNodeType:
		return t.(*ast.TermNode).StringLiteral()
	case ast.BooleanLiteralNodeType:
		return t.(*ast.TermNode).BooleanLiteral()
	}
	return nil
}

func convertToStringAndTrim(term interface{}) string {
	return strings.TrimSpace(strings.ToLower(fmt.Sprintf("%s", term)))
}
