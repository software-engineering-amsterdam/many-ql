form TheForm {
	"Name" name string
	"Surname" surname string
	"Full name" fullname computed = name . surname
}