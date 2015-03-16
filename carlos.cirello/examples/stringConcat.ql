form TheForm {
	"Age1" age1 numeric
	"Age2" age2 numeric
	"Total" totalAge computed = age1 + age2

	"Name" name string
	"Surname" surname string
	"Full name" fullname computed = name . " " . surname

	if (name . " ". surname == "carlos cirello"){
		"You are" fullnameCC computed = fullname
		"Age" age numeric
	}
}