FORM anotherOne {
	if (hasSoldHouse || (price > 20 && price <= 35)) {
 	sellingPrice "How much did you pay?" digits
	}
	else {
	sellingPrice "Let's fix this else part?" text
	}
	hasBoughtHouse "How much did you pay for it?" text
	hasBoughtHouse "Well, well" text (hasSoldHouse * hasBoughtHouse)
} END