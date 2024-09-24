package Compiler;

import java.io.File;
import java.io.FileReader;
import java.io.BufferedReader;
import java.io.IOException;

public class BoolCompiler {

    public static void main(String[] args){
        if(args.length == 2) {
            String boolFileName = args[0];
            String compiledFileName = args[1];
        } else {
            System.out.println("Input and Output files need to be informed when running the program");
            return;
        }
        File filePath = new File("Data/examplefile.bool");

        try(BufferedReader br = new BufferedReader(new FileReader(filePath.getPath()))){
            String line = br.readLine();

            while(line != null){
                System.out.println(line);
                line = br.readLine();
            }

        } catch (IOException error){
            System.out.println("Error: " + error.getMessage());
        }
    }
}
