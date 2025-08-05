import java.util.ArrayList;
import java.util.List;

public class Animal {

     String nome;
    private String especie;
    private int id;
     String bioma;
    private int idade;
    private int fome;
    private List<String> registroAlimentacao;

    private static int totalAnimais = 0;
    private static int totalAlimentacoes = 0;

    public Animal(String nome, String especie, int id, String bioma, int idade, int fome) {
        this.nome = nome;
        this.especie = especie;
        this.id = id;
        this.bioma = bioma;
        this.idade = idade;
        this.fome = fome;
        this.registroAlimentacao = new ArrayList<>();
        totalAnimais++;
    }

    public static int getTotalAnimais() {
        return totalAnimais;
    }

    public static int getTotalAlimentacoes() {
        return totalAlimentacoes;
    }

    public void alimentacao(int quantidadeComida) {
        if (quantidadeComida <= 0) {
            System.out.println("Quantidade inválida para " + nome);
            return;
        }

        if (fome == 0) {
            System.out.println(nome + " já está satisfeito e não precisa comer.");
        } else {
            System.out.println("\nAlimentando " + nome + " com " + quantidadeComida + " unidades de comida.");
            fome -= quantidadeComida;
            totalAlimentacoes++;
            if (fome < 0) fome = 0;
            System.out.println(nome + " agora está com fome: " + fome);

            if (fome == 0) {
                System.out.println(nome + " agora está satisfeito!");
            }
        }
    }

    

    public void alimentacao(int quantidadeComida, String horario) {
        System.out.println("\nRegistro de alimentação às " + horario + ":");
        alimentacao(quantidadeComida);
    }

    public void registroAlimentacao(String tipoComida) {
        String registro = nome + " comeu " + tipoComida + " (quantidade padrão: 100g)";
        registroAlimentacao.add(registro);
        totalAlimentacoes++;
        System.out.println(registro);
    }

    public void registroAlimentacao(String tipoComida, double quantidade, String horario) {
        String registro = nome + " comeu " + quantidade + "g de " + tipoComida + " às " + horario;
        registroAlimentacao.add(registro);
        totalAlimentacoes++;
        System.out.println(registro);
    }

    @Override
    public String toString() {
        String estadoFome = (fome == 0) ? "Satisfeito" : "Fome: " + fome;
        return nome + " - " + especie + " (ID: " + id + "), idade: " + idade +
               ", bioma: " + bioma + ", " + estadoFome;
    }

    public void mostrarHistoricoAlimentacao() {
        System.out.println("\nHistórico de alimentação de " + nome + ":");
        for (String registro : registroAlimentacao) {
            System.out.println(" - " + registro);
        }
    }
}


class Main {
    public static void main(String[] args) {
        Animal tubarao = new Animal("Chubarão", "Tubarão", 1, "Oceano", 7, 10);

        System.out.println(tubarao);

        tubarao.alimentacao(5);
        tubarao.registroAlimentacao("carne");
        tubarao.registroAlimentacao("carne", 150, "14:30");

        tubarao.mostrarHistoricoAlimentacao();

        System.out.println("\nTotal de animais: " + Animal.getTotalAnimais());
        System.out.println("Total de alimentações registradas: " + Animal.getTotalAlimentacoes());
    }
}