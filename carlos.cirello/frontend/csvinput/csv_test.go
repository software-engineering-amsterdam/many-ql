package csvinput

import (
	"strings"
	"testing"

	"github.com/software-engineering-amsterdam/many-ql/carlos.cirello/plumbing"
)

const fakeCsv = `
question1,"description","1"
question2,"description","2"
`

func TestCsvInputFrontend(t *testing.T) {
	pipes := plumbing.New()
	expectedAnswers := make(chan map[string]string)
	fakeInterpreter(pipes, expectedAnswers)

	csvinput := New(pipes, strings.NewReader(fakeCsv))
	go csvinput.Read()

	got := <-expectedAnswers
	rowcount := len(got)
	if rowcount != 2 {
		t.Error(
			"Error parsing input CSV file. Expected 2 rows. Got:",
			rowcount,
		)
	}
}

func fakeInterpreter(pipes *plumbing.Pipes,
	expectedAnswers chan map[string]string) {
	receive := pipes.FromInterpreter()
	send := pipes.ToInterpreter()

	go func(receive chan *plumbing.Frontend) {
		for {
			receive <- &plumbing.Frontend{
				Type: plumbing.Flush,
			}
		}
	}(receive)
	go func(send chan *plumbing.Frontend,
		expectedAnswers chan map[string]string) {
		for {
			r := <-send
			if r.Type == plumbing.Answers {
				expectedAnswers <- r.Answers
			}
		}
	}(send, expectedAnswers)
}
