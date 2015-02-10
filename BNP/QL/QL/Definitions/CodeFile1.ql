
============ VERSION 1 ============

Form FirstForm{
"Hello, this is the form"

Text HowAreYouQuestion{
"How are you?"
}

Checkbox Lucky(HowAreYouQuestion)
{
"Are you feeling lucky?"
}
Money GrossIncome
>"How much money did you earn?"

Number P22_3((GrossIncome+1000) > 1000.12)
>
P22_3*.20
"S akfjbaskjfbsakjbfk"


}

 
============ VERSION 2 FINAL ============

form FormName {
	question Q2 (bool, ) "question?";
	statement Smth (int, (Q1+132)) "left part";
	statement Smth (string, "var") "left part";
}


if (condition)
{
	question Q3 (type, optionality,con, "here")
	question Q4 (type, optionality,con, "here")
} 
else if (condition)
{
	question Q5 (type, optionality,con, "here")
} 
else
{
	question Q6 (type, optionality,con, "here")
}

types are yesno, number, text
