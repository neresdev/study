package app.service;


public class PeopleFactory {
    
    public static IPeopleService creatPeopleService(int peopleType){
        if(peopleType == 1){
            return new PeopleServicePF();
        }else if (peopleType == 2){
            return new PeopleServicePJ();
        }
        throw new IllegalArgumentException("People type not found");
    }

}
