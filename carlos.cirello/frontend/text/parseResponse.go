// Package text is the text interface for the language. It aims both to prove the modularity of the system as much facilitate the development of the VM.
package text

import (
	"bufio"
	"fmt"
	"io"

	"github.com/software-engineering-amsterdam/many-ql/carlos.cirello/question"
)

// Reader holds the pointers for text interface IO/
type Reader struct {
	bufferedInput  *bufio.Reader
	bufferedOutput io.Writer
}

// NewReader instantiates a new *Reader for I/O in text interface
func NewReader(r *bufio.Reader, w io.Writer) *Reader {
	return &Reader{
		r,
		w,
	}
}

// InputQuestion reads user's input and insert into content of the question
func (r *Reader) InputQuestion(q *question.Question) {
	fmt.Fprintln(r.bufferedOutput, q.Label)
	input := r.readFromConsole()
	content := q.Content

	switch content.(type) {
	case *question.IntQuestion:
		q.Content.(*question.IntQuestion).FromString(input)
	case *question.StringQuestion:
		q.Content.(*question.StringQuestion).FromString(input)
	case *question.BoolQuestion:
		q.Content.(*question.BoolQuestion).FromString(input)
	default:
		panic("Impossible type")
	}
}

func (r *Reader) readFromConsole() string {
	var text string
	fmt.Fscanln(r.bufferedInput, &text)
	return text
}
