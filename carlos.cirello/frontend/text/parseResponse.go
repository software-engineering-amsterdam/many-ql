// Package text is the text interface for the language. It aims both to prove the modularity of the system as much facilitate the development of the VM.
package text

import (
	"bufio"
	"fmt"
	"io"

	"github.com/software-engineering-amsterdam/many-ql/carlos.cirello/ast"
)

// Reader holds the pointers for text interface IO/
type Reader struct {
	bufferedInput  *bufio.Reader
	bufferedOutput io.Writer
}

// NewReader instantiates a new *Reader for I/O in text interface
func NewReader(input *bufio.Reader, output io.Writer) *Reader {
	return &Reader{
		input,
		output,
	}
}

// InputQuestion reads user's input and insert into content of the question
func (r *Reader) InputQuestion(q *ast.Question) {
	fmt.Fprintln(r.bufferedOutput, q.Label)
	input := r.readFromConsole()
	q.Answered = true
	q.FromString(input)
}

func (r *Reader) readFromConsole() string {
	var text string
	fmt.Fscanln(r.bufferedInput, &text)
	return text
}
