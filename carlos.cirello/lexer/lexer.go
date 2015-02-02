package lexer

import (
	"fmt"
	"unicode/utf8"
)

const (
	eof        = -1
	whitespace = " "
)

type stateFn func(*lexer) stateFn

// lexer holds the state of the scanner.
type lexer struct {
	input string    // the string being scanned.
	start int       // start position of this item.
	pos   int       // current position in the input.
	width int       // width of last rune read from input.
	items chan item // channel of scanned items.
}

func lex(input string) *lexer {
	l := &lexer{
		input: input,
		items: make(chan item, 10),
	}
	return l
}

func (l *lexer) emit(t itemType) {
	l.items <- item{t, l.input[l.start:l.pos]}
	l.start = l.pos
}

// run lexes the input by executing state functions until
// the state is nil.
func (l *lexer) run() {
	for state := lexText; state != nil; {
		state = state(l)
	}
	close(l.items) // No more tokens will be delivered.
}

// next returns the next rune in the input.
func (l *lexer) next() (rune int) {
	if l.pos >= len(l.input) {
		l.width = 0
		return eof
	}
	r, w := utf8.DecodeRuneInString(l.input[l.pos:])

	rune = int(r)
	l.width = w

	l.pos += l.width
	return rune
}

// ignore skips over the pending input before this point.
func (l *lexer) ignore() {
	l.start = l.pos
}

// walks the current word
func (l *lexer) walkWord() {
	for {
		// todo(carlos) test for EOF and abort scanning
		l.next()
		if l.input[l.pos:l.pos+1] == " " {
			break
		}
	}
}

// skip the next whitespaces until the next word
func (l *lexer) walkNextWord() {
	for {
		// todo(carlos) test for EOF and abort scanning
		l.next()
		if l.input[l.pos:l.pos+1] != " " {
			break
		}
	}
}

// error returns an error token and terminates the scan
// by passing back a nil pointer that will be the next
// state, terminating l.run.
func (l *lexer) errorf(format string, args ...interface{}) stateFn {
	l.items <- item{
		itemError,
		fmt.Sprintf(format, args...),
	}
	return nil
}
