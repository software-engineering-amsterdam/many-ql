form SalarySurvey{
	name: "First name" Str
	lastName: "last name" Str
	age: "Age" Int
	married: "Are you married?" Bool
	
	if (married) {
		hasChild: "Do you have a child?" Bool	
		if (hasChild) {
			ageChild: "How old is your oldest child?" Int
			ageDiff: "The difference between the age of you and your child is" Int(age - ageChild)
		}
		male: "Is your partner a male?" Bool
		if( male ){
			nameHusband: "What is the name of your husband?" Str
		}
	}
	if(age > 18){
		driversLicense: "Do you have a driver license?" Bool
		
	}
}