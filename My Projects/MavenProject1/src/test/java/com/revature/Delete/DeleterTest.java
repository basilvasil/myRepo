package com.revature.Delete;
import org.junit.Test;

public class DeleterTest {
    private static final String testTable = "Test_Table";
    private static final String testColumn = "Test_Column";
    private static final String testRecord = "'Test_Record'";
    private static final String dataType = "varchar(100)";

    @Test
    public void dropTableTest(){
        Deleter.dropTable(testTable);
    }

    @Test
    public void dropColumnTest(){Deleter.dropColumn(testTable,testColumn);}

    @Test
    public void deleteRecordTest(){Deleter.deleteRecord(testTable,testColumn,testRecord);}
}
