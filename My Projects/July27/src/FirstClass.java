import java.io.*;

public class FirstClass {

    public static void main(String[] args){

        Model dodge = new Model();
        String dodgeColor = dodge.carColor("Black");
        String dodgeModel = dodge.carModel("Avenger");


        System.out.println(dodgeColor + " " + dodgeModel);

        File newFile = new File("src/Resources/car.txt");
        String userInput = "My test text";

        write(userInput,newFile);
        readFile(newFile);




    }

    public static void readFile(File file) {
        try {
            FileReader reader = new FileReader(file);
            BufferedReader bufferedReader = new BufferedReader(reader);

            String line = "";
            while ((line = bufferedReader.readLine()) != null) {
                System.out.println(line);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public static void write(String input, File file){
            try {
                FileWriter fw = new FileWriter(file, true);
                BufferedWriter bw = new BufferedWriter(fw);
                bw.write(input);
                bw.close();
            } catch (IOException e){
                e.printStackTrace();
            }
        }
    }

