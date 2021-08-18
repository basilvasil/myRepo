package com.revature.Update;

import org.junit.Test;

public class UpdaterTest {
    private static final String testTable = "Test_Table";
    private static final String testTableNew = "Test_Table1";
    private static final String testColumn = "Test_Column";
    private static final String testColumnNew = "Test_Column1";
    private static final String testRecord = "'Test_Record1'";
    private static final String condition = "ID=1";


    @Test
    public void renameTableTest(){Updater.renameTable(testTable,testTableNew);}

    @Test
    public void renameColumnTest(){Updater.renameColumn(testTable,testColumn,testColumnNew);}

    @Test
    public void updateRecordTest(){Updater.updateRecord(testTable,testColumn,testRecord,condition);}
}
