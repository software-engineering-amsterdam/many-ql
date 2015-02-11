package ast

// IfNode stores an execution branch in the AST.
type IfNode struct {
	Condition string
	Stack     []*ActionNode
}
