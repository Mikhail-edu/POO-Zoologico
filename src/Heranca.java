
public class Heranca extends Animal {

    public Heranca(String nome, String especie, int id, String bioma, int idade, int fome) {
        super(nome, especie, id, bioma, idade, fome);
    }

    // Método que emite o som característico do animal
    public void emitirSom() {
        System.out.println(nome + " trombeta alto! PRRRRRRRRRRR!");
    }
}