package com.company.Entity;

public class Group {
    public int idGroup;
    public String numGroup;

    @Override
    public String toString() {
        return "Group{" +
                "idGroup=" + idGroup +
                ", numGroup=" + numGroup +
                '}';
    }

    public int getIdGroup() {
        return idGroup;
    }

    public void setIdGroup(int idGroup) {
        this.idGroup = idGroup;
    }

    public String getNumGroup() {
        return numGroup;
    }

    public void setNumGroup(String numGroup) {
        this.numGroup = numGroup;
    }


    public Group() {

    }

    public Group(String numGroup) {


        this.numGroup = numGroup;
    }

    public Group(int idGroup) {
        this.idGroup = idGroup;

    }

    public Group(int idGroup, String numGroup) {
        this.idGroup = idGroup;
        this.numGroup = numGroup;
    }
}
