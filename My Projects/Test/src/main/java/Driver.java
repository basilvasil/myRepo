import com.revature.Create.Creator;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


public class Driver {




    public static void main(String[] args){

        Creator myCreator = new Creator("project0");
        myCreator.createTable("newTable",
                "newColumn",
                "varchar" );

    }

}
