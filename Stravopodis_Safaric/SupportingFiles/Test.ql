form HouseSelling {
    
    question hasSoldHouse typeof boolean {
        hasSoldHouse = "Did you sold an house?";
        hasSoldHouse.questionType = ComputableQuestion;
        hasSoldHouse.value = false ;
    }
    question hasRentHouse typeof boolean {
        hasRentHouse = "Did you rent a house?";
        hasRentHouse.questionType = OrdinaryQuestion;
        hasRentHouse.value = false;
    }

    if (hasSoldHouse == true){
        question hasBoughtHouse typeof int {
            hasBoughtHouse = "What was the price of the house?";
            hasBoughtHouse.questionType = ComputableQuestion;
            hasBoughtHouse.value = 100000;
        }
    }
}
