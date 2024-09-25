package Compiler;

import java.io.File;
import java.io.FileReader;
import java.io.BufferedReader;
import java.io.FileWriter;
import java.io.BufferedWriter;
import java.io.IOException;

public class BoolCompiler {

    public static void main(String[] args){
        if(args.length != 2) {
            System.out.println("Input and Output files need to be informed when running the program");
            return;
            
        }
        String boolFileName = args[0];
        String compiledFileName = args[1];

        File filePath = new File(boolFileName);
        File compiledFilePath = new File(compiledFileName);

        // Reading the bool file
        try(BufferedReader br = new BufferedReader(new FileReader(filePath.getPath()))){ 
            String line = br.readLine();  

            while(line != null){
                System.out.println(line);
                line = br.readLine();
            }

        } catch (IOException error){
            System.out.println("Error: " + error.getMessage());
        }

        // FAZER A PARTE DE LEITURA
        // Writing the bool compiled file
        try(BufferedWriter bw = new BufferedWriter(new FileWriter(compiledFilePath.getPath()))){

        } catch (IOException error){
            System.out.println("Error: " + error.getMessage());
        }
    }
}
