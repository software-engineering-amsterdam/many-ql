package lexer

import "strings"

func lexText(l *lexer) stateFn {
	for {
		if strings.HasPrefix(l.input[l.pos:], formHeader) {
			if l.pos > l.start {
				l.emit(itemText)
			}
			return lexFormHeader // Next state.
		}
		if l.next() == eof {
			break
		}
	}
	// Correctly reached EOF.
	if l.pos > l.start {
		l.emit(itemText)
	}
	l.emit(itemEOF) // Useful to make EOF a token.
	return nil      // Stop the run loop.
}

const formHeader = "form"

func lexFormHeader(l *lexer) stateFn {
	l.pos += len(formHeader)
	l.emit(itemForm)
	l.walkNextWord()
	l.emit(itemWhitespace)
	// l.walkWord()
	// l.emit(itemText)
	// l.walkNextWord()
	// l.emit(itemWhitespace)
	return nil
}
