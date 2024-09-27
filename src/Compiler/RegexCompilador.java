package src.Compiler;

import java.io.BufferedReader;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.ArrayList;

import static src.Compiler.NewArgumento.newArg;
import static src.Compiler.Atribuicao.atribuicao;
import static src.Compiler.CallMethod.callMethod;
import static src.Compiler.ReturnResposta.returnResposta;
import static src.Compiler.BeginEnd.beginEnd;
import static src.Compiler.IfElse.ifElse;
import static src.Compiler.NomeVar.variavelOuAtributo;
import static src.Compiler.DeclaracaoMetodo.declaracaoMetodo;
import static src.Compiler.DeclaracaoVars.declaracaoVars;
import static src.Compiler.DeclaracaoClasse.declaracaoClasse;
import static src.Compiler.AtribuicaoComOperador.atribuicaoComOperador;


public class RegexCompilador {

    private final String falha = "FALHA";
    String linhaCompilada = falha;

    public RegexCompilador(){

    }


    public String mainRgex(String linhaOriginal, BufferedReader bufferedR){

        linhaCompilada = newArg(linhaOriginal);
        if(linhaCompilada.equals(falha)){
            //System.out.println("entrou atribuicao");
            linhaCompilada = atribuicao(linhaOriginal);
            if(linhaCompilada.equals(falha)){
                //System.out.println("entrou call");
                linhaCompilada = callMethod(linhaOriginal);
                if(linhaCompilada.equals(falha)){

                    linhaCompilada = beginEnd(linhaOriginal);
                    if(linhaCompilada.equals(falha)){

                        linhaCompilada = returnResposta(linhaOriginal);
                        if(linhaCompilada.equals(falha)){

                            linhaCompilada = declaracaoClasse(linhaOriginal);
                            if(linhaCompilada.equals(falha)){

                                linhaCompilada = declaracaoMetodo(linhaOriginal);
                                if(linhaCompilada.equals(falha)){

                                    linhaCompilada = declaracaoVars(linhaOriginal);
                                    if(linhaCompilada.equals(falha)){

                                        linhaCompilada = atribuicaoComOperador(linhaOriginal);
                                        if(linhaCompilada.equals(falha)){

                                            linhaCompilada = ifElse(linhaOriginal, bufferedR);
                                            if(linhaCompilada.equals(falha)){

                                            }
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }


        return linhaCompilada;
    }


}
