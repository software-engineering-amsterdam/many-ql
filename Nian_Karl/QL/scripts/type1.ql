form FamilySurvey {
	name: "What is your name?" Str
	age1: "How old are you?" Int
	isMarried: "Are you married?" Bool
	if (true == false) {
	
	}
    
	
	if (isMarried) {
		hasChild: "Do you have a child?" Bool	
		age: "How old are you1?" Int
		if (hasChild) {
			ageChild: "How old is your oldest child?" Int
			age: "How old are you2?" Int
			//ageDiff: "The difference between the age of you and your child is :" Int(ageDiff + age2)
			
			
		} else {
			isPlan: "Are you plan to have a child?" Bool
			age: "How old are you3?" Int
		}
	}	
	
	
	
	if (isPlan == isMarried) {
	
	}
}