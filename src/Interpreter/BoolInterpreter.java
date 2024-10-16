package Interpreter;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

import java.util.Stack;

public class BoolInterpreter {
    public static void main(String[] args) {
        String arquivoEntrada;
        Stack<Object> pilha = new Stack<>();

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
