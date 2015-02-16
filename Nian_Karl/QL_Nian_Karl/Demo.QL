form SalarySurvey{
	Str name "What is your name?";
	Int age "How old are you?";
	Dec height "Waht is your height?";
	Cur salary "How much is your annual salary?";
	Bool isMarried "Are you married?";
	
	if(age > 25){
		Int employeeNr "What is your employee number?";
	} else {
		Int studentNr "What is your student number?";
	}
}
