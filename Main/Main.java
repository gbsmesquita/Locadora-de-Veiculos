package Main;

public class Main {

    public static void imprimeMenu() {
        System.out.println("\n>>>> Menu <<<<\n" +
            "1 - Cadastrar veículo\n" +
            "2 - Alterar um veículo cadastrado\n" +
            "3 - Buscar um veículo por parte do nome\n" +
            "4 - Cadastrar o cliente (pessoa física e jurídica)\n" +
            "5 - Alterar o cliente (pessoa física e jurídica)\n" +
            "6 - Alugar um veículo\n" +
            "7 - Devolver um veículo\n" +
            "8 - Sair\n");
    }

    public static void main(String[] args) {
        imprimeMenu();
    }
}

