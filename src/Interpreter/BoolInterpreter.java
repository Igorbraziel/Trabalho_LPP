package src.Interpreter;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;
import java.util.ArrayList;

public class BoolInterpreter {
    public static void main(String[] args) {
        String arquivoEntrada;
        List<Object> pilha = new ArrayList<>();

        try{
            arquivoEntrada = args[0];

            try(BufferedReader br = new BufferedReader( new FileReader( arquivoEntrada ) )){
                String linhaCompilada = br.readLine();

                while(linhaCompilada != null){
                    System.out.println(linhaCompilada);
                    linhaCompilada = br.readLine();
                }
            } catch (IOException error){
                System.out.println("Error: " + error.getMessage());
            }
        } catch(Exception error){
            System.out.println("O arquivo de entrada compilado deve ser informado na execução do programa");
            System.out.println("Error: " + error.getMessage());
        }
    }
}
