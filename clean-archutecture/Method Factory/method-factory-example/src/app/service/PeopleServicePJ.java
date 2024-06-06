package app.service;

import app.response.PeopleResponse;

public class PeopleServicePJ implements IPeopleService{

    @Override
    public PeopleResponse getData() {
        PeopleResponse response = new PeopleResponse();
        
        response.setAddress("street 2");
        response.setName("people PJ");

        return response;
    }

}
