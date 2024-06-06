package app;

import app.service.IPeopleService;
import app.service.PeopleFactory;
import app.service.PeopleServicePF;

public class App {
    public static void main(String[] args) throws Exception {

        //without method factory

        PeopleServicePF peopleServicePF = new PeopleServicePF();
        System.out.println("People PF name: " + peopleServicePF.getData().getName());

        PeopleServicePF peopleServicePJ = new PeopleServicePF();
        System.out.println("People PJ name: " + peopleServicePJ.getData().getName());

        // with method facotry
        IPeopleService peopleServicePFWithFactoryMethod = PeopleFactory.creatPeopleService(1);
        System.out.println("People PF with factory method name: " + peopleServicePFWithFactoryMethod.getData().getName());

        IPeopleService peopleServicePJWithFactoryMethod = PeopleFactory.creatPeopleService(2);
        System.out.println("People PJ with facotry method name: " + peopleServicePJWithFactoryMethod.getData().getName());
    }
}
