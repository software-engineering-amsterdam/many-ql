package text

import (
	"bufio"
	"log"
	"os"
	"strings"
	"testing"

	"github.com/software-engineering-amsterdam/many-ql/carlos.cirello/ast"
)

func TestParseResponse(t *testing.T) {
	aQuestionaire := &ast.Questionaire{
		Label: "University of Amsterdam Revenue Service",
		Questions: []*ast.Question{
			&ast.Question{
				Label:   "What is the answer to life the universe and everything?",
				Content: new(ast.IntQuestion),
			},
			&ast.Question{
				Label:   "Who said the logic is the cement of our civilization with which we ascended from Chaos using reason as our guide?",
				Content: new(ast.StringQuestion),
			},
			&ast.Question{
				Label:   "Hungry-p",
				Content: new(ast.BoolQuestion),
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

	firstAnswer := questions[0].Content.(*ast.IntQuestion).String()
	if firstAnswer != "42" {
		log.Fatalf("Error parsing input. Expected 42. Got %s", questions[0].Content.(*ast.IntQuestion).String())
	}

	secondAnswer := questions[1].Content.(*ast.StringQuestion).String()
	if secondAnswer != "T'Plana-Hath" {
		log.Fatalf("Error parsing input. Expected T'Plana-Hath. Got %s", questions[1].Content.(*ast.StringQuestion).String())
	}

	thirdAnswer := questions[2].Content.(*ast.BoolQuestion).String()
	if thirdAnswer != "Yes" {
		log.Fatalf("Error parsing input. Expected Yes. Got %s", questions[2].Content.(*ast.BoolQuestion).String())
	}
}
