form TheForm {
	"Age1" age1 numeric
	"Age2" age2 numeric
	"Total" totalAge computed = age1 + age2

	if (age1 > 0){
		"You are" computedAge computed = totalAge
		"You are (duplicated)" computedAge2 computed = totalAge * 2
	}
}