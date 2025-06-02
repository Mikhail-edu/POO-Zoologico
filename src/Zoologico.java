// Classe Zoologico (Main)
public class Zoologico {
    public static void main(String[] args) {

        // Criando habitats
        Habitat habitat1 = new Habitat("savana", 10, "terrestre", 13);
        Habitat habitat2 = new Habitat("pantano", 9, "aquatico", 17);
        Habitat habitat3 = new Habitat("deserto", 10, "terrestre", 11);
        Habitat habitat4 = new Habitat("floresta", 20, "misto", 19);
        Habitat habitat5 = new Habitat("mar", 10, "aquatico", 15);

        // Criando animais
        Animal animal1 = new Animal("Viper", "cobra", 1, "terrestre", 12, 60);
        Animal animal2 = new Animal("chubarao", "tubarao", 2, "aquatico", 50, 29);
        Animal animal3 = new Animal("krocodile", "crocodilo", 3, "aquatico", 80, 20);
        Animal animal4 = new Animal("chifrudo", "bufalo", 4, "terrestre", 8, 50);
        Animal animal5 = new Animal("blue", "arara-azul", 5, "misto", 25, 15);

        // Adicionando animais nos habitats
        habitat3.adicionarAnimal(animal1); // deserto
        habitat5.adicionarAnimal(animal2); // mar
        habitat2.adicionarAnimal(animal3); // pantano
        habitat1.adicionarAnimal(animal4); // savana
        habitat4.adicionarAnimal(animal5); // floresta

        // Criando cuidadores
        Cuidador cuidador1 = new Cuidador("Otavio", habitat3.idHabitat);
        Cuidador cuidador2 = new Cuidador("Arthur", habitat2.idHabitat);
        Cuidador cuidador3 = new Cuidador("Mikhail", habitat4.idHabitat);
        Cuidador cuidador4 = new Cuidador("Felipe", habitat1.idHabitat);
        Cuidador cuidador5 = new Cuidador("Valesson", habitat5.idHabitat);

        // Alimentando os animais (com e sem horário)
        animal2.alimentacao(50);
        animal1.alimentacao(40, "10:00");
        animal3.alimentacao(60);
        animal4.alimentacao(70, "12:30");
        animal5.alimentacao(50, "13:15");

        // Impressão dos habitats
        System.out.println("\nHabitats:");
        System.out.println(habitat1);
        System.out.println(habitat2);
        System.out.println(habitat3);
        System.out.println(habitat4);
        System.out.println(habitat5);

        // Impressão dos animais
        System.out.println("\nAnimais:");
        System.out.println(animal1);
        System.out.println(animal2);
        System.out.println(animal3);
        System.out.println(animal4);
        System.out.println(animal5);

        // Impressão dos cuidadores
        System.out.println("\nCuidadores:");
        System.out.println(cuidador1);
        System.out.println(cuidador2);
        System.out.println(cuidador3);
        System.out.println(cuidador4);
        System.out.println(cuidador5);

        // Transferências
        System.out.println("\nTransferencia de animais:");
        habitat2.transferirAnimal(animal3, habitat5);
        habitat5.transferirAnimal(animal2, habitat4);

        // Impressão dos habitats após transferência
        System.out.println("\nHabitats apos as transferencias:");
        System.out.println(habitat1);
        System.out.println(habitat2);
        System.out.println(habitat3);
        System.out.println(habitat4);
        System.out.println(habitat5);

        // Estatísticas finais
        System.out.println("\nTotal de animais no zoologico: " + Animal.getTotalAnimais());
        System.out.println("Total de alimentacoes: " + Animal.getTotalAlimentacoes());
    }
}
