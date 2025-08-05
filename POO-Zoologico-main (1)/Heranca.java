
public class Heranca extends Animal {

    public Heranca(String nome, String especie, int id, String bioma, int idade, int fome) throws IdadeInvalidaException {
        super(nome, especie, id, bioma, idade, fome);
    }

    public void emitirSom() {
        System.out.println(nome + " trombeta alto! PRRRRRRRRRRR!");
    }
}