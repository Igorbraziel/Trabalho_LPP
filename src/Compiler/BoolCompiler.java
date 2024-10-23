package Compiler;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.lang.Exception;


public class BoolCompiler {
    public static void main(String[] args) {
        String arquivoEntrada, arquivoSaida, linhaCompilada;
        RegexCompilador regex = new RegexCompilador();

        try {
            arquivoEntrada = args[0];
            arquivoSaida = args[1];

            try(BufferedReader br = new BufferedReader( new FileReader(arquivoEntrada) )) {
                try(BufferedWriter bw = new BufferedWriter( new FileWriter(arquivoSaida) )){
                    String linha = br.readLine();

                    while(linha != null){
                        linhaCompilada = regex.mainRgex(linha, br);
                        if(linhaCompilada != "FALHA") {
                            bw.write(linhaCompilada);
                        }
                        linha = br.readLine();
                    }

                } catch(IOException error){
                    System.out.println("Erro no arquivo de saída: " + error.getMessage());
                }
            } catch (IOException error){
                System.out.println("Erro no arquivo de entrada: " + error.getMessage());
            }
        } catch(Exception error){
            System.out.println("Os Arquivos de entrada e saída devem ser informados na execução do programa");
            error.printStackTrace();
        }

    }
}
