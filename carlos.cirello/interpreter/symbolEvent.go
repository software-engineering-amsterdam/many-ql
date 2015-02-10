package interpreter

import "github.com/software-engineering-amsterdam/many-ql/carlos.cirello/ast"

type symbolEvent struct {
	command symbolEventType
	name    string

	// Writing
	content *ast.QuestionNode

	// Reading
	ret chan *ast.QuestionNode
}

type symbolEventType int

const (
	SymbolCreate symbolEventType = iota
	SymbolRead
	SymbolUpdate
)
