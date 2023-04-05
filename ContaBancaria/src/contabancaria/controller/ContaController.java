package contabancaria.controller;

import contabancaria.model.Conta;
import contabancaria.repository.ContaRepository;

import java.util.ArrayList;

public class ContaController implements ContaRepository {

    private ArrayList<Conta> listaContas = new ArrayList<Conta>();

    @Override
    public void procurarPorNumero(int numero) {
        var conta = buscarNaCollection(numero);

        if (conta != null) {
            conta.visualizar();
        } else
            System.out.println("\nA conta não foi encontrada!");
    }

    public Conta buscarNaCollection(int numero) {
        for (var conta : listaContas) {
            if (conta.getNumero() == numero) {
                return conta;
            }
        }
        return null;
    }

    @Override
    public void listarTodas() {
        for (var conta : listaContas) {
            conta.visualizar();
        }
    }

    @Override
    public void cadastrar(Conta conta) {
        //conta.setNumero(gerarNumero());
        listaContas.add(conta);
        System.out.println("\nA conta foi criada!");
    }

    public int gerarNumero() {//Indicação pra usar para ID automático.
        return listaContas.size() + 1;
    }

    @Override
    public void atualizar(Conta conta) {

    }

    @Override
    public void deletar(int numero) {
        var conta = buscarNaCollection(numero);

        if (conta != null) {
            if(listaContas.remove(conta) == true){
                System.out.println("\nA conta foi deletada!");
            }
        } else
            System.out.println("\nA conta não foi encontrada!");

    }

    @Override
    public void sacar(int numero, float valor) {

    }

    @Override
    public void depositar(int numero, float valor) {

    }

    @Override
    public void transferir(int numeroOrigem, int numeroDestino, float valor) {

    }
}
