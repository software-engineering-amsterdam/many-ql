package event

import "github.com/software-engineering-amsterdam/many-ql/carlos.cirello/ast"

type Symbol struct {
	Command SymbolEventType
	Name    string

	// Writing
	Content *ast.QuestionNode

	// Reading
	Ret chan *ast.QuestionNode
}

type SymbolEventType int

const (
	// SymbolCreate creates an entry on the symbol table.
	// Keep intact if already exists
	SymbolCreate SymbolEventType = iota
	// SymbolRead reads an entry from the symbol table. Panics if not exists
	SymbolRead
	// SymbolUpdate updates an existing entry on the symbol table.
	SymbolUpdate
)
