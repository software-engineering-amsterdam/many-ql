package csvinput

import (
	"strings"
	"testing"

	"github.com/software-engineering-amsterdam/many-ql/carlos.cirello/qlang/interpreter/event"
)

const fakeCsv = `
question1,"description","1"
question2,"description","2"
`

func TestCsvInputFrontend(t *testing.T) {
	receive := make(chan *event.Frontend)
	send := make(chan *event.Frontend)
	expectedAnswers := make(chan map[string]string)
	fakeInterpreter(receive, send, expectedAnswers)

	csvinput := New(receive, send, strings.NewReader(fakeCsv))
	go csvinput.Read()

	got := <-expectedAnswers
	rowcount := len(got)
	if rowcount != 2 {
		t.Error("Error parsing input CSV file. Expected 2 rows. Got:", rowcount)
	}
}

func fakeInterpreter(receive, send chan *event.Frontend, expectedAnswers chan map[string]string) {
	go func(receive chan *event.Frontend) {
		for {
			receive <- &event.Frontend{
				Type: event.Flush,
			}
		}
	}(receive)
	go func(send chan *event.Frontend, expectedAnswers chan map[string]string) {
		for {
			r := <-send
			if r.Type == event.Answers {
				expectedAnswers <- r.Answers
			}
		}
	}(send, expectedAnswers)
}
