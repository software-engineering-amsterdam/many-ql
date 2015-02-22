package main

import (
	"fmt"
	"strings"

	"github.com/software-engineering-amsterdam/many-ql/carlos.cirello/interpreter/visitor/typechecker"
	"github.com/software-engineering-amsterdam/many-ql/carlos.cirello/parser"
)

func main() {
	form := parser.ReadQL(strings.NewReader(`
	form SomeForm {
		"QuestionLabel" question1 string

		if(question3){
			"question2" question2 bool
		}

		if(question2){
			"question3" question3 bool
		}
	}`), "test.ql")
	tc, st := typechecker.New()
	tc.Visit(form)
	if err := st.Err(); err != nil {
		for _, e := range err {
			fmt.Println("Typechecker error:", e)
		}
	} else {
		fmt.Println("Success!")
	}
}
