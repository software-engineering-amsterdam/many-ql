package symboltable

import (
	"log"

	"github.com/software-engineering-amsterdam/many-ql/carlos.cirello/ast"
	"github.com/software-engineering-amsterdam/many-ql/carlos.cirello/interpreter/event"
)

type SymbolTable struct {
	Events chan *event.Symbol

	table map[string]*ast.QuestionNode
}

func New(events chan *event.Symbol) *SymbolTable {
	table := &SymbolTable{
		table:  make(map[string]*ast.QuestionNode),
		Events: events,
	}

	go table.loop()
	return table
}

func (s *SymbolTable) loop() {
	for r := range s.Events {
		switch r.Command {
		default:
			log.Fatalf("Invalid operation at symbols table: %#v",
				r.Command)
		case event.SymbolRead:
			question, ok := s.table[r.Name]
			if !ok {
				log.Fatalf("Identifier unknown: %s", r.Name)
			}
			r.Ret <- question
		case event.SymbolCreate:
			if _, ok := s.table[r.Name]; !ok {
				s.table[r.Name] = r.Content
			}
		case event.SymbolUpdate:
			if _, ok := s.table[r.Name]; ok {
				s.table[r.Name] = r.Content
			}
		}
	}
}
