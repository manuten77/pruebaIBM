package com.etenuta.providers;

import java.util.Date;

public class Provider {
	private int id;
    private String name;
    private Date createDate;

    private int clientId;

    public Provider(int id, String name, Date createdate, int clientId) {
        this.id = id;
        this.name = name;
        this.createDate = createdate;
        this.clientId=clientId;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public int getClientId() {
        return clientId;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setCreateDate(Date createdate) {
        this.createDate = createdate;
    }

    public void setClientId(int clientId) {
        this.clientId = clientId;
    }

    @Override
    public String toString() {
        return "Provider{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", createDate=" + createDate +
                ", clientId=" + clientId +
                '}';
    }
}
