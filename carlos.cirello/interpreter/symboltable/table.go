package symboltable

import (
	"fmt"
	"log"

	"github.com/software-engineering-amsterdam/many-ql/carlos.cirello/interpreter/ast"
)

// SymbolTable is the typechecker specific symbol table which detects duplicated
// identifiers and labels.
type SymbolTable struct {
	symbols map[string]interface{}
	labels  map[string][]string

	watchError bool
	err        []error
	warn       []error
}

// New is the constructor for SymbolTable.
func New() *SymbolTable {
	table := &SymbolTable{
		symbols: make(map[string]interface{}),
		labels:  make(map[string][]string),
	}

	return table
}

// SetWatchError toggles the warnings and error handling inside of symboltable.
// This is supposed to be used only for type checking.
func (s *SymbolTable) SetWatchError(v bool) {
	s.watchError = v
}

// Err returns all found errors during symbolTable operation.
func (s SymbolTable) Err() []error {
	return s.err
}

// Warn returns all found warnings during symbolTable operation.
func (s SymbolTable) Warn() []error {
	return s.warn
}

// ShowWarn iterates through all warnings and prints them.
func (s *SymbolTable) ShowWarn() bool {
	if warn := s.Warn(); warn != nil {
		for _, e := range warn {
			log.Printf("warning: %s", e)
		}
		return true
	}
	return false
}

// PanicErr iterates through all errors, prints them and panic in the end.
func (s *SymbolTable) PanicErr() {
	if err := s.Err(); err != nil {
		for _, e := range err {
			log.Println(e)
		}
		panic("typechecker errors found")
	}
}

// Read looks for identifier in symboltable and returns its content.
func (s *SymbolTable) Read(identifier string) interface{} {
	question, ok := s.symbolExistP(identifier)
	if !ok {
		s.appendErrf(
			"Identifier unknown at typechecker table: %s",
			identifier)
		return nil
	}
	return question
}

// Create looks for identifier in symboltable and creates a pointer if missing.
func (s *SymbolTable) Create(q *ast.QuestionNode) {
	identifier := q.Identifier()
	label := q.Label()
	qType := q.Type()
	pos := q.Pos()
	primitive := q.Primitive()

	_, ok := s.symbolExistP(identifier)
	if ok {
		s.appendErrf("%s:symboltable error: duplicated identifier found at symbol table: %s",
			pos, identifier)
		return
	}

	var symbol interface{}
	switch qType {
	case ast.ScalarQuestionType:
		newSymbol, err := scalarQuestionFactory(primitive)
		if err != nil {
			s.appendErrf("%s:symboltable error: %s", pos,
				err.Error())
		}
		symbol = newSymbol
	case ast.ComputedQuestionType:
		symbol = new(ComputedQuestion)
	}
	s.upsert(identifier, symbol)
	s.detectRepeatedLabel(identifier, label)
}

// Update looks for identifier in symboltable and updates a pointer if existing.
func (s *SymbolTable) Update(identifier string, content interface{}) {
	_, ok := s.symbolExistP(identifier)
	if ok {
		s.upsert(identifier, content)
	}
}

func (s *SymbolTable) appendErrf(err string, vars ...interface{}) {
	s.err = append(s.err, fmt.Errorf(err, vars...))
}

func (s *SymbolTable) appendWarnf(warn string, vars ...interface{}) {
	s.warn = append(s.warn, fmt.Errorf(warn, vars...))
}

func (s *SymbolTable) detectRepeatedLabel(identifier, label string) {
	if _, ok := s.labels[label]; ok {
		s.appendWarnf(
			"Repeated question label at typechecker: %s for %s",
			label, identifier)
	}
	s.labels[label] = append(s.labels[label], identifier)
}

func (s *SymbolTable) symbolExistP(identifier string) (value interface{}, ok bool) {
	value, ok = s.symbols[identifier]
	return value, ok
}

func (s *SymbolTable) upsert(identifier string, value interface{}) {
	s.symbols[identifier] = value
}
