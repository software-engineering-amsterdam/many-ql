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
	// SymbolCreate creates an entry on the symbol table.
	// Keep intact if already exists
	SymbolCreate symbolEventType = iota
	// SymbolRead reads an entry from the symbol table. Panics if not exists
	SymbolRead
	// SymbolUpdate updates an existing entry on the symbol table.
	SymbolUpdate
)
