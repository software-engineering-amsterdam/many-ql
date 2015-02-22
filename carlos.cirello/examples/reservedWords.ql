form SomeForm {
	"3 - Are you happy today?" questionThree bool

	if (questionThree == true) {
		"4 - Why are you happy today?" questionFour string
		"5 - Grade your happiness?"    questionFive numeric
	}
}
