package com.example.ontap;

import java.util.ArrayList;
import java.util.List;

public class ListPeople {
    public static void main(String[] args) {
        List<People> listPeople = new ArrayList<>();
        listPeople.add(new People("1","1","1","1","1"));
        listPeople.add(new People("2","1","1","1","1"));
        listPeople.add(new People("3","1","1","1","1"));
        listPeople.add(new People("4","1","1","1","1"));
        listPeople.add(new People("5","1","1","1","1"));

        for (int i = 0; i < listPeople.size(); i++) {
            System.out.println(listPeople.get(i));
        }

        People people = new People("3","5544","3","3","22");

        for (People people1 : listPeople) {
            if (people.getId() == people1.getId()) {
                listPeople.set(listPeople.indexOf(people1), people);
                break;
            }
        }

        for (int i = 0; i < listPeople.size(); i++) {
            System.out.println(listPeople.get(i));
        }
    }
}
