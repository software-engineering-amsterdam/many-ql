package symboltable

import (
	"log"

	"github.com/software-engineering-amsterdam/many-ql/carlos.cirello/ast"
	"github.com/software-engineering-amsterdam/many-ql/carlos.cirello/interpreter/event"
)

// SymbolTable holds a map with pairs of question identifiers and a reference to
// it. It is the core of SymbolTable process.
type SymbolTable struct {
	Events chan *event.Symbol

	symbols map[string]*ast.QuestionNode
}

// New is the factory for SymbolTable process. It spawns a background process
// which listen for queries to its internal map.
func New(events chan *event.Symbol) *SymbolTable {
	table := &SymbolTable{
		Events:  events,
		symbols: make(map[string]*ast.QuestionNode),
	}

	go table.loop()
	return table
}

func (s *SymbolTable) loop() {
	for r := range s.Events {
		question, ok := s.symbolExistP(r.Identifier)
		switch r.Command {
		default:
			log.Fatalf("Invalid operation at symbols table: %#v",
				r.Command)

		case event.SymbolRead:
			if !ok {
				log.Fatalf("Identifier unknown at symbols table: %s", r.Identifier)
			}
			r.Ret <- question

		case event.SymbolCreate:
			if !ok {
				s.upsertSymbol(r.Identifier, r.Content)
			}

		case event.SymbolUpdate:
			if ok {
				s.upsertSymbol(r.Identifier, r.Content)
			}
		}
	}
}

func (s *SymbolTable) upsertSymbol(identifier string, content *ast.QuestionNode) {
	s.symbols[identifier] = content
}

func (s *SymbolTable) symbolExistP(identifier string) (question *ast.QuestionNode, ok bool) {
	question, ok = s.symbols[identifier]
	return question, ok
}
