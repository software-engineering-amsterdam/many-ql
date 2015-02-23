package typechecker

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
		question, ok := s.symbolExistP(r.Identifier)
		switch r.Command {
		default:
			s.err = append(s.err, fmt.Errorf(
				"Invalid operation at typechecker table: %#v",
				r.Command))

		case event.SymbolRead:
			if !ok {
				s.appendErrf(
					"Identifier unknown at typechecker table: %s",
					r.Identifier)
			}
			r.Ret <- question

		case event.SymbolCreate:
			if !ok {
				s.addSymbol(r.Identifier, r.Content)
				s.detectRepeatedLabel(r.Content.Label(), r.Identifier)
			} else {
				s.appendErrf(
					"Duplicated identifier found at typechecker: %s",
					r.Identifier)
			}
		}
	}
}

func (s *SymbolTable) addSymbol(identifier string, content *ast.QuestionNode) {
	s.symbols[identifier] = content
}

func (s *SymbolTable) symbolExistP(identifier string) (question *ast.QuestionNode, ok bool) {
	question, ok = s.symbols[identifier]
	return question, ok
}

func (s *SymbolTable) detectRepeatedLabel(label, identifier string) {
	if _, ok := s.labels[label]; ok {
		s.appendWarnf(
			"Repeated question label at typechecker: %s for %s",
			label, identifier)
	}
	s.labels[label] = append(s.labels[label], identifier)
}

func (s *SymbolTable) appendErrf(err string, vars ...interface{}) {
	s.err = append(s.err, fmt.Errorf(err, vars...))
}

func (s *SymbolTable) appendWarnf(warn string, vars ...interface{}) {
	s.warn = append(s.warn, fmt.Errorf(warn, vars...))
}
