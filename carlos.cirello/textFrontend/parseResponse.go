package textFrontend

import (
	"bufio"
	"fmt"
	"io"

	"github.com/software-engineering-amsterdam/many-ql/carlos.cirello/question"
)

type Reader struct {
	bufferedInput  *bufio.Reader
	bufferedOutput io.Writer
}

func NewReader(r *bufio.Reader, w io.Writer) *Reader {
	return &Reader{
		r,
		w,
	}
}
func (r *Reader) readFromConsole() string {
	var text string
	fmt.Fscanln(r.bufferedInput, &text)
	return text
}

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
