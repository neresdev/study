package app.service;

import app.response.PeopleResponse;

public class PeopleServicePF implements IPeopleService{

    @Override
    public PeopleResponse getData() {
        PeopleResponse response = new PeopleResponse();
        
        response.setAddress("street 1");
        response.setName("people PF");

        return response;
    }

}
