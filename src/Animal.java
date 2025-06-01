public class Animal {

    String nome;
    String especie;
    int id;
    String bioma;
    int idade;
    int fome;
    static int totalAnimais = 0;
    static int totalAlimentacoes = 0;

    public Animal(String nome, String especie, int id, String bioma, int idade, int fome) {
        this.nome = nome;
        this.id = id;
        this.bioma = bioma;
        this.especie = especie;
        this.idade = idade;
        this.fome = fome;
        totalAnimais++;
    }

    public static int getTotalAnimais() {
        return totalAnimais;
    }

    public static int getTotalAlimentacoes() {
        return totalAlimentacoes;
    }

    public void alimentacao(int quantidadeComida) {
        if (fome == 0) {
            System.out.println(nome + " já está satisfeito e não precisa comer.");
        } else {
            System.out.println("\nAlimentando " + nome + " com " + quantidadeComida + " unidades de comida.");
            fome -= quantidadeComida;
            totalAlimentacoes++;

            if (fome < 0) {
                fome = 0;
            }
            System.out.println(nome + " agora está com fome: " + fome);
            if (fome == 0) {
                System.out.println(nome + " agora está satisfeito!");
            }
        }
    }

    @Override
    public String toString() {
        String estadoFome = (fome == 0) ? "Satisfeito" : "Fome: " + fome;
        return nome + " - " + especie + " (ID: " + id + "), idade: " + idade + ", bioma: " + bioma + ", " + estadoFome;
    }
}
