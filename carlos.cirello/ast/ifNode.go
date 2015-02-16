package ast

// IfNode stores an execution branch in the AST.
type IfNode struct {
	Conditions Evaluatable
	Stack      []*ActionNode
	ElseNode   *IfNode
}
