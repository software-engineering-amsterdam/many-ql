package textFrontend

import (
	"bufio"
	"log"
	"os"
	"strings"
	"testing"

	"github.com/software-engineering-amsterdam/many-ql/carlos.cirello/question"
	"github.com/software-engineering-amsterdam/many-ql/carlos.cirello/questionaire"
)

func TestParseResponse(t *testing.T) {
	aQuestionaire := &questionaire.Questionaire{
		Label: "University of Amsterdam Revenue Service",
		Questions: []*question.Question{
			&question.Question{
				Label:   "What is the answer to life the universe and everything?",
				Content: new(question.IntQuestion),
			},
			&question.Question{
				Label:   "Who said the logic is the cement of our civilization with which we ascended from Chaos using reason as our guide?",
				Content: new(question.StringQuestion),
			},
			&question.Question{
				Label:   "Hungry-p",
				Content: new(question.BoolQuestion),
			},
		},
	}

	answers := strings.NewReader("42\nT'Plana-Hath\n1")
	textFE := NewReader(
		bufio.NewReader(answers),
		os.Stdout,
	)
	for _, question := range aQuestionaire.Questions {
		textFE.InputQuestion(question)
	}

	questions := aQuestionaire.Questions

	firstAnswer := questions[0].Content.(*question.IntQuestion).String()
	if firstAnswer != "42" {
		log.Fatalf("Error parsing input. Expected 42. Got %s", questions[0].Content.(*question.IntQuestion).String())
	}

	secondAnswer := questions[1].Content.(*question.StringQuestion).String()
	if secondAnswer != "T'Plana-Hath" {
		log.Fatalf("Error parsing input. Expected T'Plana-Hath. Got %s", questions[1].Content.(*question.StringQuestion).String())
	}

	thirdAnswer := questions[2].Content.(*question.BoolQuestion).String()
	if thirdAnswer != "Yes" {
		log.Fatalf("Error parsing input. Expected Yes. Got %s", questions[2].Content.(*question.BoolQuestion).String())
	}
}
