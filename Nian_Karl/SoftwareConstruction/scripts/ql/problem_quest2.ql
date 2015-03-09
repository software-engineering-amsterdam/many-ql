form SalarySurvey{
	howAreYou: "How are you today" Str
	howAreYou2: "How are you today" Str
	someDependentQuestion: "If you are 'Good' then this checkbox should be ticked." Bool(howAreYou == "Good")
	someDependentQuestion2: "If you are 'Good' then this checkbox should be ticked." Bool(howAreYou == howAreYou2)
}