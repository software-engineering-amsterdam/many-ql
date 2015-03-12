FORM Questionnaire {
	stupidMe "Should have turned it on..." choice
	if(stupidMe) {
		ifBody1 "If-statement please work" digits
		ifBody2 "If-statement one more" digits
	}
	
	hasSoldHouse "How much did you get for your house?" digits
	amountHouses "How much did you pay for new house?" digits
	calculation "The difference is equals to:?" digits (hasSoldHouse - amountHouses)
	
} END