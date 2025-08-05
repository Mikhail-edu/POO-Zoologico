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
        Animal animal6 = new Animal("listrado", "zebra", 8, "terrestre", 3, 90);
        Animal animal7 = new Animal("pescossuda", "girafa", 6, "terrestre", 12, 90);
        Animal animal8 = new Animal("Dumbo", "elefante", 7, "terrestre", 50, 100);
        Animal animal9= new Animal("Pumba,", "javali", 9, "terrestre", 5, 90);
        Animal animal10 = new Animal("timao", "suricato", 10, "terrestre", 6, 50);
        Animal animal11 = new Animal("veloz", "Antílope", 12, "terrestre", 10, 50);
        Animal animal12 = new Animal("galopa", "gnu", 13, "terrestre", 5, 40);
        Animal animal13 = new Animal("chifrao", "Rinoceronte", 14, "terrestre", 7, 70);
        Animal animal14 = new Animal("pavao", "pavao", 15, "terrestre", 10, 50);
        Animal animal15 = new Animal("piton", "cobra", 16, "terrestre", 15, 80);

        
        // Adicionando animais nos habitats
        habitat3.adicionarAnimal(animal1); // deserto
        habitat5.adicionarAnimal(animal2); // mar
        habitat2.adicionarAnimal(animal3); // pantano
        habitat1.adicionarAnimal(animal4); // savana
        habitat4.adicionarAnimal(animal5); // floresta
        habitat1.adicionarAnimal(animal6);
        habitat1.adicionarAnimal(animal7);
        habitat1.adicionarAnimal(animal8);
        habitat1.adicionarAnimal(animal9);
        habitat1.adicionarAnimal(animal10);
        habitat1.adicionarAnimal(animal11);
        habitat1.adicionarAnimal(animal12);
        habitat1.adicionarAnimal(animal13);
        habitat1.adicionarAnimal(animal14);
        habitat1.adicionarAnimal(animal15);

        // Criando cuidadores
        Cuidador cuidador1 = new Cuidador("Otavio", habitat3.idHabitat);
        Cuidador cuidador2 = new Cuidador("Arthur", habitat2.idHabitat);
        Cuidador cuidador3 = new Cuidador("Mikhail", habitat4.idHabitat);
        Cuidador cuidador4 = new Cuidador("Felipe", habitat1.idHabitat);
        Cuidador cuidador5 = new Cuidador("Valesson", habitat5.idHabitat);

        // Alimentando os animais (com e sem horário)
        animal2.alimentacao(50);
        animal1.alimentacao(40, "10:00");
        animal3.alimentacao(60,"6:30");
        animal4.alimentacao(70, "12:30");
        animal5.alimentacao(50, "13:15");
        animal6.alimentacao(100,"13:30");
        animal7.alimentacao(50,"12:00");
        animal8.alimentacao(100,"8:00");
        animal9.alimentacao(100,"7:00");
        animal10.alimentacao(50,"9:30");
        animal11.alimentacao(70,"17:00");
        animal12.alimentacao(79,"19:00");
        animal13.alimentacao(30,"15:00");
        animal14.alimentacao(29,"2:00");
        animal15.alimentacao(50,"2:30");
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
        System.out.println(animal6);
        System.out.println(animal7);
        System.out.println(animal8);
        System.out.println(animal9);
        System.out.println(animal10);
        System.out.println(animal11);
        System.out.println(animal12);
        System.out.println(animal13);
        System.out.println(animal14);
        System.out.println(animal15);


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
         Heranca elefante = new Heranca("Dumbo", "Elefante", 1, "Savana", 12, 60);
        elefante.emitirSom(); // Saída: Dumbo trombeta alto! PRRRRRRRRRRR! para adicionar na classe zoologico
        // Estatísticas finais
        System.out.println("\nTotal de animais no zoologico: " + Animal.getTotalAnimais());
        System.out.println("Total de alimentacoes: " + Animal.getTotalAlimentacoes());
    }
}