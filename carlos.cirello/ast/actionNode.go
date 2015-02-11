package ast

// ActionNode represents the ambiguous node which may branch (if) or operate.
type ActionNode struct {
	QuestionNode *QuestionNode
	IfNode       *IfNode
}
