package com.application.assignment.bean;


import java.util.List;

public class OwnerCompanyBean {

    private Integer companyId;
    private List<Integer> selection;


    public Integer getCompanyId() {
        return companyId;
    }

    public void setCompanyId(Integer companyId) {
        this.companyId = companyId;
    }

    public List<Integer> getSelection() {
        return selection;
    }

    public void setSelection(List<Integer> selection) {
        this.selection = selection;
    }
}
