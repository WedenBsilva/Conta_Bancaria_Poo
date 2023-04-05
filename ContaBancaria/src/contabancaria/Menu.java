package contabancaria;

import contabancaria.controller.ContaController;
import contabancaria.model.Conta;
import contabancaria.model.ContaCorrente;
import contabancaria.model.ContaPoupanca;
import contabancaria.util.Cores;

import java.io.IOException;
import java.util.Scanner;

public class Menu {
    public static void main(String[] args) {
        int opcao, numero, agencia, tipo, aniversario;
        float saldo, limite;
        String titular;
        Scanner scanner = new Scanner(System.in);
        Cores cores = new Cores();

        ContaController contas = new ContaController();

        ContaCorrente cc1 = new ContaCorrente(contas.gerarNumero(), 123, 1, "João", 10000.0f, 100.0f);
        contas.cadastrar(cc1);//cadastrar conta cc1 na listaContas - CRIAR

        contas.listarTodas();//Listando com base no metodo listarTodas() usando o visualizar()


        while (true) {
            System.out.println(Cores.TEXT_YELLOW + Cores.ANSI_BLACK_BACKGROUND + "****************************************************************");
            System.out.println("*                                                              *");
            System.out.println("*                       BANCO DO BRAZIL                        *");
            System.out.println("*                                                              *");
            System.out.println("****************************************************************");
            System.out.println("*                                                              *");
            System.out.println("*          1 - Criar Conta                                     *");
            System.out.println("*          2 - Listar todas as contas                          *");
            System.out.println("*          3 - Buscar Conta por Numero                         *");
            System.out.println("*          4 - Atualizar Dados da Conta                        *");
            System.out.println("*          5 - Apagar Conta                                    *");
            System.out.println("*          6 - Sacar                                           *");
            System.out.println("*          7 - Depositar                                       *");
            System.out.println("*          8 - Transferir Valores Entre Contas                 *");
            System.out.println("*          9 - Sair                                            *");
            System.out.println("*                                                              *");
            System.out.println("****************************************************************");
            System.out.print("Entre com a opção desejada: ");
            System.out.println("                                                                ");
            opcao = scanner.nextInt();


            if (opcao == 7) {
                System.out.println("Banco do Brazil com Z - O seu futuro começa aqui!");
                scanner.close();
                System.exit(0);
            }
            switch (opcao) {
                case 1:
                    System.out.println("\nCriar Conta");
                    System.out.println("\nDigite o Número da Agência: ");
                    agencia = scanner.nextInt();
                    System.out.println("\nDigite o Nome do Titular: ");
                    scanner.skip("\\R?");//limpar o scanner
                    titular = scanner.nextLine();
                    System.out.println("\nDigite o Tipo da Conta(1-CC | 2-CP): ");
                    tipo = scanner.nextInt();
                    System.out.println("\nDigite o Saldo da conta: R$");
                    saldo = scanner.nextFloat();
                    switch (tipo) {
                        case 1 -> {
                            System.out.println("\nDigite o limite da conta: R$");
                            limite = scanner.nextFloat();
                            contas.cadastrar(new ContaCorrente(contas.gerarNumero(),agencia,tipo,titular,saldo,limite));
                        }
                        case 2 -> {
                            System.out.println("\nDigite o dia do aniverersário: ");
                            aniversario = scanner.nextInt();
                            contas.cadastrar(new ContaPoupanca(contas.gerarNumero(),agencia,tipo,titular,saldo,aniversario));
                        }
                    }
                    keyPress();
                    break;
                case 2:
                    System.out.println("\nListar Todas as Contas");

                    contas.listarTodas();

                    keyPress();
                    break;
                case 3:
                    System.out.println("\nBuscar Conta por Numero");
                    System.out.println("\nDigite o numero da conta: ");
                    numero = scanner.nextInt();
                    contas.procurarPorNumero(numero);
                    keyPress();
                    break;
                case 4:
                    System.out.println("\nAtualizar Dados da Conta");
                    keyPress();
                    break;
                case 5:
                    System.out.println("\nApagar Conta");
                    System.out.println("\nDigite o numero da conta: ");
                    numero = scanner.nextInt();

                    contas.deletar(numero);

                    keyPress();
                    break;
                case 6:
                    System.out.println("\nSacar");
                    keyPress();
                    break;
                case 7:
                    System.out.println("\nDepositar");
                    keyPress();
                    break;
                case 8:
                    System.out.println("\nTransferir Valores Entre Contas");
                    keyPress();
                    break;

                default:
                    System.out.println("OPÇÃO INVÁLIDA!!");
                    keyPress();
                    break;
            }

        }
    }

    public static void keyPress() {
        try {
            System.out.println(Cores.TEXT_RESET + "\n\nPressione Enter para continuar...");
            System.in.read();
        } catch (IOException e) {
            System.out.println("Você pressionou uma tecla diferente de enter!");
        }
    }
}