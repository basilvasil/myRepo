package com.revature;

import com.revature.models.Hero;
import com.revature.services.Crud;

public class Driver {

    public static void main(String[] args){
        Crud crud = new Crud();
        Hero hulk = new Hero("bruce","banner", "hulk");

        System.out.println();crud.readORM();

    }
}
