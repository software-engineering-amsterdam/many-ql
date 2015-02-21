form SomeForm {
	"1 - Who said the logic is the cement of our civilization with which we ascended from chaos using reason as our guide?"
	questionOne   string

	"2 - What's the answer to life the universe and everything?"
	questionTwo   numeric

	"3 - Are you happy today?"
	questionThree bool

	"4 - Bad Question" questionTwentyTwo computed = questionOne + questionTwo
}
