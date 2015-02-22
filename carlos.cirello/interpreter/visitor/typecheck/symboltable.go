package typecheck

import (
	"fmt"

	"github.com/software-engineering-amsterdam/many-ql/carlos.cirello/ast"
	"github.com/software-engineering-amsterdam/many-ql/carlos.cirello/interpreter/event"
)

// SymbolTable is the typechecker specific symbol table which detects duplicated
// identifiers and labels
type SymbolTable struct {
	Events chan *event.Symbol

	symbols map[string]*ast.QuestionNode
	labels  map[string][]string

	err  []error
	warn []error
}

func newSymbolTable(events chan *event.Symbol) *SymbolTable {
	table := &SymbolTable{
		symbols: make(map[string]*ast.QuestionNode),
		labels:  make(map[string][]string),
		Events:  events,
	}

	go table.loop()
	return table
}

// Err returns all found errors during symbolTabel operation
func (s SymbolTable) Err() []error {
	return s.err
}

// Warn returns all found warnings during symbolTabel operation
func (s SymbolTable) Warn() []error {
	return s.warn
}

func (s *SymbolTable) loop() {
	for r := range s.Events {
		switch r.Command {
		default:
			s.err = append(s.err, fmt.Errorf(
				"Invalid operation at typechecker table: %#v",
				r.Command))
		case event.SymbolRead:
			question, ok := s.symbols[r.Name]
			if !ok {
				s.err = append(s.err, fmt.Errorf(
					"Identifier unknown at typechecker table: %s",
					r.Name))
			}
			r.Ret <- question
		case event.SymbolCreate:
			if _, ok := s.symbols[r.Name]; !ok {
				s.symbols[r.Name] = r.Content
				if _, ok := s.labels[r.Content.Label()]; ok {
					s.warn = append(s.warn, fmt.Errorf(
						"Repeated question caption at typechecker: %s for %s",
						r.Content.Label(), r.Name))
				}
				s.labels[r.Content.Label()] = append(s.labels[r.Content.Label()], r.Content.Identifier())
			} else {
				s.err = append(s.err, fmt.Errorf(
					"Duplicated identifier found at typechecker: %s",
					r.Name))
			}
		case event.SymbolUpdate:
			if _, ok := s.symbols[r.Name]; ok {
				s.symbols[r.Name] = r.Content
			}
		}
	}
}
