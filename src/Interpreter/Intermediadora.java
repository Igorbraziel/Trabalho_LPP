package Interpreter;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.List;

import static Interpreter.DefinicaoClasse.definicaoClasse;
import static Interpreter.InstrucaoAdd.instrucaoAdd;
import static Interpreter.InstrucaoCall.instrucaoCall;
import static Interpreter.InstrucaoConst.instrucaoConst;
import static Interpreter.InstrucaoDiv.instrucaoDiv;
import static Interpreter.InstrucaoEq.instrucaoEq;
import static Interpreter.InstrucaoGe.instrucaoGe;
import static Interpreter.InstrucaoGet.instrucaoGet;
import static Interpreter.InstrucaoGt.instrucaoGt;
import static Interpreter.InstrucaoLe.instrucaoLe;
import static Interpreter.InstrucaoLoad.instrucaoLoad;
import static Interpreter.InstrucaoLt.instrucaoLt;
import static Interpreter.InstrucaoMul.instrucaoMul;
import static Interpreter.InstrucaoNe.instrucaoNe;
import static Interpreter.InstrucaoNew.instrucaoNew;
import static Interpreter.InstrucaoPop.instrucaoPop;
import static Interpreter.InstrucaoRet.instrucaoRet;
import static Interpreter.InstrucaoSet.instrucaoSet;
import static Interpreter.InstrucaoStore.instrucaoStore;
import static Interpreter.InstrucaoSub.instrucaoSub;
import static Interpreter.DefinicaoClasse.definicaoClasse;
import static Interpreter.InstrucaoIfElse.instrucaoIfElse;
import static Interpreter.InstrucaoVars.instrucaoVars;
import static Interpreter.ListasObjetos.*;






public class Intermediadora {

    public static void Intermediadora(String linhaCompilada, List<Var> pilha, BufferedReader br) throws IOException {
        Boolean resposta;

        resposta = instrucaoStore(linhaCompilada, pilha);
        if(!resposta){

            resposta = instrucaoSub(linhaCompilada, pilha);
            if(!resposta){

                resposta = instrucaoAdd(linhaCompilada, pilha);
                if(!resposta){

                    resposta = instrucaoCall(linhaCompilada, pilha);
                    if(!resposta){

                        resposta = instrucaoConst(linhaCompilada, pilha);
                        if(!resposta){

                            resposta = instrucaoDiv(linhaCompilada, pilha);
                            if(!resposta){

                                resposta = instrucaoEq(linhaCompilada, pilha);
                                if(!resposta){

                                    resposta = instrucaoGe(linhaCompilada, pilha);
                                    if(!resposta){

                                        resposta = instrucaoGet(linhaCompilada, pilha);
                                        if(!resposta){

                                            resposta = instrucaoGt(linhaCompilada, pilha);
                                            if(!resposta){

                                                resposta = instrucaoLe(linhaCompilada, pilha);
                                                if(!resposta){

                                                    resposta = instrucaoLoad(linhaCompilada, pilha, "main");
                                                    if(!resposta){

                                                        resposta = instrucaoLt(linhaCompilada, pilha);
                                                        if(!resposta){

                                                            resposta = instrucaoMul(linhaCompilada, pilha);
                                                            if(!resposta){

                                                                resposta = instrucaoNe(linhaCompilada, pilha);
                                                                if(!resposta){

                                                                    resposta = instrucaoNew(linhaCompilada, pilha);
                                                                    if(!resposta){

                                                                        resposta = instrucaoPop(linhaCompilada, pilha);
                                                                        if(!resposta){

                                                                            resposta = instrucaoRet(linhaCompilada, pilha);
                                                                            if(!resposta){

                                                                                resposta = instrucaoSet(linhaCompilada, pilha);
                                                                                if(!resposta){

                                                                                    resposta = definicaoClasse(linhaCompilada, pilha, br);
                                                                                    if(!resposta){

                                                                                        //resposta = instrucaoIfElse(linhaCompilada, pilha, br);
                                                                                        if(!resposta){

                                                                                            resposta = instrucaoVars(linhaCompilada, getFuncaoEmExecucao().getFirst());
                                                                                            if(!resposta){

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

    }
}
