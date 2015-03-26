FORM Questionnaire {
	myCheckbox "1. If you check this box, you'll get extra questions" choice
	hasSoldHouse "2. How much did you get for your house?" digits
	amountHouses "3. How much did you pay for new house?" digits
	calculation "4. The difference between q#2 and q#3 equals to:" digits (hasSoldHouse -amountHouses)
	extra "5. Above should appear if-question" text
	
} END