package ast

import (
	"reflect"
	"testing"
)

func TestQuestionIndex(t *testing.T) {
	theStyle := NewStyleNode(
		[]*ActionNode{
			NewActionNode(
				NewPageNode(
					"Page1",
					[]*ActionNode{
						NewActionNode(NewDefaultNode("bool", "switch")),
						NewActionNode(NewQuestionNode("p1q1")),
					},
				),
			),
			NewActionNode(
				NewPageNode(
					"Page2",
					[]*ActionNode{
						NewActionNode(NewDefaultNode("bool", "switch")),
						NewActionNode(NewQuestionNode("p2q1")),
					},
				),
			),
			NewActionNode(
				NewPageNode(
					"Page3",
					[]*ActionNode{
						NewActionNode(NewDefaultNode("bool", "switch")),
						NewActionNode(NewQuestionNode("p3q1")),
					},
				),
			),
		},
	)
	vst := NewVisitor()
	vst.Visit(theStyle)

	expected := make(map[string][]string)
	expected["p1q1"] = []string{"root", "Page1"}
	expected["p2q1"] = []string{"root", "Page2"}
	expected["p3q1"] = []string{"root", "Page3"}
	if !reflect.DeepEqual(expected, vst.QuestionIndex()) {
		t.Error("Error generating index of question. Expected: ", expected, " Got:", vst.QuestionIndex())
	}
}
