package com.crud.library.domain;

public enum BookCopyStatus {
    FREE("free"), BORROWED("borrowed");

    private String status;

    private BookCopyStatus(String e){
        this.status = e;
    }

    public String getStatus() {
        return status;
    }
}
