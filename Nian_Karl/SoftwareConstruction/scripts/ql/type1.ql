form FamilySurvey {
	name1: "What is your name?" Str
	name2: "What is your name?" Str
	age1: "How old are you?" Int
	age2: "How old are you?" Int(age1)
	age3: "How old are you?" Int(age2)
	age4: "How old are you?" Int(age2 + age3)
	age1: "How old are you?" Int(age3)

	isMarried: "Are you married?" Bool
	isMarried1: "Are you married?" Bool

	if (isMarried) {
		hasChild: "Do you have a child?" Bool	
		age: "How old are you1?" Int
		if (hasChild) {
			ageChild: "How old is your oldest child?" Int
		} else {
			isPlan: "Are you plan to have a child?" Bool
		}
	}	

	if (age1 == age1) {
	
	}
}