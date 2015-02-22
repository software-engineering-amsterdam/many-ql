package typecheck

import (
	"fmt"

	"github.com/software-engineering-amsterdam/many-ql/carlos.cirello/ast"
	"github.com/software-engineering-amsterdam/many-ql/carlos.cirello/interpreter/event"
)

type symbolTable struct {
	Events chan *event.Symbol

	table map[string]*ast.QuestionNode
	err   []error
}

func newSymbolTable(events chan *event.Symbol) *symbolTable {
	table := &symbolTable{
		table:  make(map[string]*ast.QuestionNode),
		Events: events,
	}

	go table.loop()
	return table
}

func (s symbolTable) Err() []error {
	return s.err
}

func (s *symbolTable) loop() {
	for r := range s.Events {
		switch r.Command {
		default:
			s.err = append(s.err, fmt.Errorf(
				"Invalid operation at typechecker table: %#v",
				r.Command))
		case event.SymbolRead:
			question, ok := s.table[r.Name]
			if !ok {
				s.err = append(s.err, fmt.Errorf(
					"Identifier unknown at typechecker table: %s",
					r.Name))
			}
			r.Ret <- question
		case event.SymbolCreate:
			if _, ok := s.table[r.Name]; !ok {
				s.table[r.Name] = r.Content
			} else {
				s.err = append(s.err, fmt.Errorf(
					"Duplicated identifier found at typechecker: %s",
					r.Name))
			}
		case event.SymbolUpdate:
			if _, ok := s.table[r.Name]; ok {
				s.table[r.Name] = r.Content
			}
		}
	}
}
