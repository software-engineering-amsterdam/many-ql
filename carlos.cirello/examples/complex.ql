form TaxForm {
	"Has sold a house?" sold bool

	"%" percentage numeric
	"commission" commission numeric
	"Possess a contract?" contract bool

	if (contract and sold) {
		"duration of contract in years" years numeric
		"how many temporary contracts" tempcontracts numeric
		"computed value based on boolean logic" computedboolean computed = years >= tempcontracts
	}

	if (sold) {
		"Sell Price?" price numeric
		"Additional Cost" additional numeric
		"Final" final computed = (price - additional * (percentage - commission))
	}
}