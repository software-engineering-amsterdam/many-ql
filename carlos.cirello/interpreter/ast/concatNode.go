package ast

import "text/scanner"

// ConcatNode is the AST node for addition operation.
type ConcatNode struct {
	DoubleTermNode
	Evaluatable
}

// NewConcatNode factory for ConcatNode AST node.
func NewConcatNode(leftTerm, rightTerm Evaluatable,
	pos scanner.Position) *ConcatNode {
	concatNode := new(ConcatNode)
	concatNode.DoubleTermNode = *NewDoubleTermNode(leftTerm, rightTerm,
		pos)
	return concatNode
}

//----
