package Interpreter;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

import static Interpreter.Intermediadora.intermediadora;
import static Interpreter.ListasObjetos.*;
import static Interpreter.GarbageCollector.*;

public class BoolInterpreter {
    public static void main(String[] args) {
        String arquivoEntrada;
        List<Var> pilhaList = new LinkedList<Var>();
        IoEstrutura objetoIO = new IoEstrutura();
        Var ioVariavel = new Var("cinza", objetoIO);

        getMemoriaFisica().addFirst(ioVariavel);
        HashMap<String, Var> hashIO = new HashMap<>();
        hashIO.put("io", ioVariavel);
        getEscopos().put("io", hashIO);


        try{
            arquivoEntrada = args[0];

            try(BufferedReader br = new BufferedReader( new FileReader( arquivoEntrada ) )){
                String linhaCompilada = br.readLine();

                setContadorInstrucoes(0);
                setCorDaVez("vermelho");
                while(linhaCompilada != null){
                    intermediadora(linhaCompilada, pilhaList, br);
                    linhaCompilada = br.readLine();

                    incrementaContador();
                    if(getContadorInstrucoes() == 5){
                        mudaCorDaVez();
                        pintaMemoria(getEscopos());
                        setContadorInstrucoes(0);
                        coletorDeLixo();
                    }
                }
            } catch (IOException error){
                System.out.println("Error: " + error.getMessage());
            }
        } catch(ArrayIndexOutOfBoundsException error){
            System.out.println("O arquivo de entrada compilado deve ser informado na execução do programa");
            error.printStackTrace();
        }


    }
}
