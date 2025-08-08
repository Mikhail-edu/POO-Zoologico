abstract class Animal {
    String nome; 

    abstract void fazerSom ();


    void dormir(){
        System.out.println("dormindo...");
    }

class Cachorro extends Animal {

    public Cachorro(String nome) {
        this.nome = nome;
    }

    @Override
    void fazerSom() {
        System.out.println(nome + " está latindo: Au au!");
    }
    
}
}
