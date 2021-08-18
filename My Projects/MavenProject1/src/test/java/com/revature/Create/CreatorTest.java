package com.revature.Create;

import org.junit.Test;



public class CreatorTest {

    private static String testTable = "Test_Table";
    private static String testColumn = "Test_Column";
    private static String testRecord = "'Test_Record'";
    private static String dataType = "varchar(100)";


    @Test
    public void createTableTest(){Creator.createTable(testTable);}

    @Test
    public void createColumn(){Creator.createColumn(testTable,testColumn,dataType);}

    @Test
    public void createRecordTest(){Creator.createRecord(testTable,testColumn,testRecord);}

}
