public class Zoologico {
    public static void main(String[] args) {



        Habitat habitat1 = new Habitat("savana", 10, "terrestre", 13); 
        Habitat habitat2 = new Habitat("pantano", 9, "aquatico", 17); 
        Habitat habitat3 = new Habitat("deserto", 10, "terrestre", 11); 
        Habitat habitat4 = new Habitat("floresta", 20, "misto", 19);    
        Habitat habitat5 = new Habitat("mar", 10, "aquatico", 15);      

        System.out.println(" Habitats: ");
        System.out.println(habitat1);
        System.out.println(habitat2);
        System.out.println(habitat3);
        System.out.println(habitat4);
        System.out.println(habitat5);

       
        Animal animal1 = new Animal("Viper", "cobra", 1, "deserto", 12,60);
        Animal animal2 = new Animal("chubarao", "tubarao", 2, "mar", 50 ,29);
        Animal animal3 = new Animal("krocodile", "crocodilo", 3, "pantano", 80,20);
        Animal animal4 = new Animal("chifrudo", "bufalo", 4, "savana", 8,50);
        Animal animal5 = new Animal("blue", "arara-azul", 5, "floresta", 25,15);
        System.out.println(" Animais: ");
        System.out.println(animal1);
        System.out.println(animal2);
        System.out.println(animal3);
        System.out.println(animal4);
        System.out.println(animal5);


        System.out.println(" Status dos animais antes de alimentar:");
        System.out.println(animal1);
        System.out.println(animal2);
        System.out.println(animal3);
        System.out.println(animal4);
        System.out.println(animal5);
        
                animal2.alimentacao(50);
                animal1.alimentacao(40);
                animal3.alimentacao(60);
                animal4.alimentacao(70);
                 animal5.alimentacao(50);

        
        System.out.println("\n Status dos animais após alimentação:");
        System.out.println(animal1);
        System.out.println(animal2);
        System.out.println(animal3);
        System.out.println(animal4);
        System.out.println(animal5);
        
        Cuidador cuidador1 = new Cuidador("Otavio", habitat3.idHabitat); // Associado ao Deserto (ID 11)
        Cuidador cuidador2 = new Cuidador("Arthur", habitat2.idHabitat); // Associado ao Pantano (ID 17)
        Cuidador cuidador3 = new Cuidador("Mikhail", habitat4.idHabitat); // Associado à Floresta (ID 19)
        Cuidador cuidador4 = new Cuidador("Felipe", habitat1.idHabitat); // Associado à Savana (ID 13)
        Cuidador cuidador5 = new Cuidador("valesson", habitat5.idHabitat); // Associado ao Mar (ID 15)

        System.out.println(" Cuidadores:");
        System.out.println(cuidador1);
        System.out.println(cuidador2);
        System.out.println(cuidador3);
        System.out.println(cuidador4);
        System.out.println(cuidador5);
    }
}