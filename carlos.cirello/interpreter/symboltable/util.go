package symboltable

import (
	"fmt"

	"github.com/software-engineering-amsterdam/many-ql/carlos.cirello/interpreter/ast"
)

func scalarQuestionFactory(primitive string) (fmt.Stringer, error) {
	switch primitive {
	default:
		return new(StringQuestion), nil
	case ast.ScalarNumericPrimitive:
		return new(NumericQuestion), nil
	case ast.ScalarBoolPrimitive:
		return new(BoolQuestion), nil
	}
	return NewInvalidQuestion(primitive),
		fmt.Errorf("Invalid question type. Got %s", primitive)
}
