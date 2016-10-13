package com.example.irwancannady.retrofitgithub;

/**
 * Created by adhitiahidayat on 10/13/16.
 */

public class Model {

    private String login;
    private String name;
    private String company;
    private int public_repos;

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    public int getPublic_repos() {
        return public_repos;
    }

    public void setPublic_repos(int public_repos) {
        this.public_repos = public_repos;
    }
}
