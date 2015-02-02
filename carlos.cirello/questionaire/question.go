package questionaire

type StringQuestion string

type Question struct {
	Label string

	// todo(carlos) convert this to interface which represents the behavior common to all questions
	//Content interface{}
	Content interface{}
}
