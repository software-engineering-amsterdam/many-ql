package event

import "github.com/software-engineering-amsterdam/many-ql/carlos.cirello/ast"

// Symbol is the message protocol used for interpreter communication with
// SymbolTable process
type Symbol struct {
	Command    SymbolEventType
	Identifier string

	// Writing
	Content *ast.QuestionNode

	// Reading
	Ret chan *ast.QuestionNode
}

// SymbolEventType is the enum with possible messages types for SymbolTable
// process
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
