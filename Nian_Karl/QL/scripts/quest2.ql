form FamilySurvey {
	name: "What is your name?" Str
	age: "How old are you?" Int
	isMarried: "Are you married?" Bool
    
	if (isMarried) {
		hasChild: "Do you have a child?" Bool	
	}
	if (hasChild) {
		ageChild: "How old is your oldest child?" Int
		ageDiff: "The difference between the age of you and your child is :" Int(age - ageChild)
	} else {
		isPlan: "Are you plan to have a child?" Bool
	}
}