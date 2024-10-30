package Compiler;

import java.io.BufferedReader;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.ArrayList;

import static Compiler.NewArgumento.newArg;
import static Compiler.Atribuicao.atribuicao;
import static Compiler.CallMethod.callMethod;
import static Compiler.ReturnResposta.returnResposta;
import static Compiler.BeginEnd.beginEnd;
import static Compiler.IfElse.ifElse;
import static Compiler.NomeVar.variavelOuAtributo;
import static Compiler.DeclaracaoMetodo.declaracaoMetodo;
import static Compiler.DeclaracaoVars.declaracaoVars;
import static Compiler.DeclaracaoClasse.declaracaoClasse;
import static Compiler.AtribuicaoComOperador.atribuicaoComOperador;
import static Compiler.EndMainBlank.endMainBlank;


public class RegexCompilador {

    private final String falha = "FALHA";
    String linhaCompilada = falha;

    public RegexCompilador(){

    }


    public String mainRgex(String linhaOriginal, BufferedReader bufferedR){

        linhaCompilada = newArg(linhaOriginal);
        if(linhaCompilada.equals(falha)){
            linhaCompilada = atribuicao(linhaOriginal);
            if(linhaCompilada.equals(falha)){
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

                                                linhaCompilada = endMainBlank(linhaOriginal);
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
        }
        return linhaCompilada;
    }


}
