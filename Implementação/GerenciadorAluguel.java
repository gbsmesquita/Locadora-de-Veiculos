package Implementação;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import Model.Aluguel;
import Model.Cliente;
import Model.TipoVeiculo;
import Model.Veiculo;

public class GerenciadorAluguel {
    private Map<String, Veiculo> veiculos = new HashMap<>();
    private Map<String, Cliente> clientes = new HashMap<>();
    private List<Aluguel> alugueis = new ArrayList<>();

    public void cadastrarVeiculo(String placa, TipoVeiculo tipo) {
        if (!veiculos.containsKey(placa)) {
            Veiculo novoVeiculo = new Veiculo(placa, tipo);
            veiculos.put(placa, novoVeiculo);
            System.out.println("Veículo cadastrado com sucesso.");
        } else {
            System.out.println("Placa já cadastrada para outro veículo.");
        }
    }
    
    public void alugarVeiculo(String placa, String identificadorCliente, String dataAluguel, String dataDevolucao) {
        if (veiculos.containsKey(placa)) {
            Veiculo veiculo = veiculos.get(placa);
            if (!veiculoEstaAlugado(veiculo)) {
                Cliente cliente = clientes.get(identificadorCliente);
                if (cliente != null) {
                    Aluguel novoAluguel = new Aluguel(veiculo, cliente, dataAluguel, dataDevolucao);
                    alugueis.add(novoAluguel);
                    System.out.println("Veículo alugado com sucesso.");
                } else {
                    System.out.println("Cliente não encontrado.");
                }
            } else {
                System.out.println("Veículo já está alugado.");
            }
        } else {
            System.out.println("Veículo não encontrado.");
        }
    }
    
    private boolean veiculoEstaAlugado(Veiculo veiculo) {
        for (Aluguel aluguel : alugueis) {
            if (aluguel.getVeiculo().equals(veiculo)) {
                return true;
            }
        }
        return false;
    }

    public void devolverVeiculo(String placa, String identificadorCliente, String dataDevolucao) {

    }

    // não sei se aqui isso faz sentido ou se tenho que criar uma pasta só de PessoaFisica.java e PessoaJuridica.java
    public class PessoaFisica extends Cliente {
        public PessoaFisica(String identificador, String nome) {
            super(identificador, nome);
        }
    }
    
    public class PessoaJuridica extends Cliente {
        public PessoaJuridica(String identificador, String nome) {
            super(identificador, nome);
        }
    }
    public void cadastrarCliente(String identificador, String nome, boolean pessoaFisica) {
        if (!clientes.containsKey(identificador)) {
            Cliente novoCliente;
            if (pessoaFisica) {
                novoCliente = new PessoaFisica(identificador, nome);
            } else {
                novoCliente = new PessoaJuridica(identificador, nome);
            }
            clientes.put(identificador, novoCliente);
            System.out.println("Cliente cadastrado com sucesso.");
        } else {
            System.out.println("Cliente já cadastrado.");
        }
    }
}
