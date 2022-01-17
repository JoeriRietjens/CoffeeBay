package com.joeri.coffeebay.responses;

public class OrderRequest {
    private String name;
    private boolean isReady;

    public OrderRequest() {
    }
 
    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean getIsReady() {
        return this.isReady;
    }

    public void setIsReady(boolean isReady) {
        this.isReady = isReady;
    }

}
