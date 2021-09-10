package com.revature;

import com.revature.Create.Creator;

public class Driver {


    public static void main(String[] args) {
        Creator dbCreator = new Creator();

        dbCreator.createTable("TestTable");
    }

}

