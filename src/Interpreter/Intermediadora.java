package Interpreter;

import java.util.List;

import static Interpreter.InstrucaoAdd.InstrucaoAdd;
import static Interpreter.InstrucaoCall.InstrucaoCall;
import static Interpreter.InstrucaoConst.InstrucaoConst;
import static Interpreter.InstrucaoDiv.InstrucaoDiv;
/*import static Interpreter.InstrucaoElse.InstrucaoElse;*/
import static Interpreter.InstrucaoEq.InstrucaoEq;
import static Interpreter.InstrucaoGe.InstrucaoGe;
import static Interpreter.InstrucaoGet.InstrucaoGet;
import static Interpreter.InstrucaoGt.InstrucaoGt;
/*import static Interpreter.InstrucaoIf;*/
import static Interpreter.InstrucaoLe.InstrucaoLe;
import static Interpreter.InstrucaoLoad.InstrucaoLoad;
import static Interpreter.InstrucaoLt.InstrucaoLt;
import static Interpreter.InstrucaoMul.InstrucaoMul;
import static Interpreter.InstrucaoNe.InstrucaoNe;
import static Interpreter.InstrucaoNew.InstrucaoNew;
import static Interpreter.InstrucaoPop.InstrucaoPop;
import static Interpreter.InstrucaoRet.InstrucaoRet;
import static Interpreter.InstrucaoSet.InstrucaoSet;
import static Interpreter.InstrucaoStore.InstrucaoStore;
import static Interpreter.InstrucaoSub.InstrucaoSub;




public class Intermediadora {

    public static void Intermediadora(String linhaCompilada, List<Var> pilha){
        Boolean resposta;

        resposta = InstrucaoStore(linhaCompilada, pilha);
        if(!resposta){

            resposta = InstrucaoSub(linhaCompilada, pilha);
            if(!resposta){

                resposta = InstrucaoAdd(linhaCompilada, pilha);
                if(!resposta){

                    resposta = InstrucaoCall(linhaCompilada, pilha);
                    if(!resposta){

                        resposta = InstrucaoConst(linhaCompilada, pilha);
                        if(!resposta){

                            resposta = InstrucaoDiv(linhaCompilada, pilha);
                            if(!resposta){

                                resposta = InstrucaoEq(linhaCompilada, pilha);
                                if(!resposta){

                                    resposta = InstrucaoGe(linhaCompilada, pilha);
                                    if(!resposta){

                                        resposta = InstrucaoGet(linhaCompilada, pilha);
                                        if(!resposta){

                                            resposta = InstrucaoGt(linhaCompilada, pilha);
                                            if(!resposta){

                                                resposta = InstrucaoLe(linhaCompilada, pilha);
                                                if(!resposta){

                                                    resposta = InstrucaoLoad(linhaCompilada, pilha);
                                                    if(!resposta){

                                                        resposta = InstrucaoLt(linhaCompilada, pilha);
                                                        if(!resposta){

                                                            resposta = InstrucaoMul(linhaCompilada, pilha);
                                                            if(!resposta){

                                                                resposta = InstrucaoNe(linhaCompilada, pilha);
                                                                if(!resposta){

                                                                    resposta = InstrucaoNew(linhaCompilada, pilha);
                                                                    if(!resposta){

                                                                        resposta = InstrucaoPop(linhaCompilada, pilha);
                                                                        if(!resposta){

                                                                            resposta = InstrucaoRet(linhaCompilada, pilha);
                                                                            if(!resposta){

                                                                                resposta = InstrucaoSet(linhaCompilada, pilha);
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
