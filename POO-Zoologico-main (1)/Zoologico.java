import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Zoologico {
    private static final String ARQUIVO_DADOS = "zoologico.dat";
    private static List<Habitat> habitats;
    private static List<Cuidador> cuidadores;

    public static void main(String[] args) {
        carregarDados();

        Scanner scanner = new Scanner(System.in);
        int opcao;
        
        do {
            System.out.println("\n=== MENU ZOOLÓGICO ===");
            System.out.println("1 - Listar habitats e animais");
            System.out.println("2 - Listar cuidadores");
            System.out.println("3 - Alimentar animal");
            System.out.println("4 - Transferir animal");
            System.out.println("5 - Adicionar novo animal");
            System.out.println("0 - Sair e salvar");
            System.out.print("Escolha: ");
            
            opcao = scanner.nextInt();
            scanner.nextLine(); // Limpar buffer
            
            switch(opcao) {
                case 1:
                    listarHabitats();
                    break;
                case 2:
                    listarCuidadores();
                    break;
                case 3:
                    alimentarAnimal(scanner);
                    break;
                case 4:
                    transferirAnimal(scanner);
                    break;
                case 5:
                    adicionarAnimal(scanner);
                    break;
                case 0:
                    salvarDados();
                    System.out.println("Dados salvos. Até logo!");
                    break;
                default:
                    System.out.println("Opção inválida!");
            }
        } while(opcao != 0);
        
        scanner.close();
    }

@SuppressWarnings("unchecked")
private static void carregarDados() {
    try (ObjectInputStream in = new ObjectInputStream(new FileInputStream(ARQUIVO_DADOS))) {
        habitats = (List<Habitat>) in.readObject();
        cuidadores = (List<Cuidador>) in.readObject();
        System.out.println("Dados carregados com sucesso!");
    } catch (FileNotFoundException e) {
        System.out.println("Arquivo de dados não encontrado. Inicializando dados padrão.");
        inicializarDadosPadrao();
    } catch (IOException | ClassNotFoundException e) {
        System.err.println("Erro ao carregar dados: " + e.getMessage());
        inicializarDadosPadrao();
    }
    }

    private static void salvarDados() {
        try (ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(ARQUIVO_DADOS))) {
            out.writeObject(habitats);
            out.writeObject(cuidadores);
            System.out.println("Dados salvos com sucesso!");
        } catch (IOException e) {
            System.err.println("Erro ao salvar dados: " + e.getMessage());
        }
    }

    private static void inicializarDadosPadrao() {
        habitats = new ArrayList<>();
        cuidadores = new ArrayList<>();
        
        // Criar habitats
        habitats.add(new Habitat("savana", 10, "terrestre", 13));
        habitats.add(new Habitat("pantano", 9, "aquatico", 17));
        habitats.add(new Habitat("deserto", 10, "terrestre", 11));
        habitats.add(new Habitat("floresta", 20, "misto", 19));
        habitats.add(new Habitat("mar", 10, "aquatico", 15));
        
        // Criar cuidadores
        cuidadores.add(new Cuidador("Otavio", 11));
        cuidadores.add(new Cuidador("Arthur", 17));
        cuidadores.add(new Cuidador("Mikhail", 19));
        cuidadores.add(new Cuidador("Felipe", 13));
        cuidadores.add(new Cuidador("Valesson", 15));
        
        
    }

    // Métodos auxiliares (listarHabitats, listarCuidadores, alimentarAnimal, transferirAnimal, adicionarAnimal)
    private static void listarHabitats() {
        System.out.println("\nHabitats:");
        for (Habitat habitat : habitats) {
            System.out.println(habitat);
            for (Animal animal : habitat.animais) {
                System.out.println("  - " + animal);
            }
        }
    }

    private static void listarCuidadores() {
        System.out.println("\nCuidadores:");
        for (Cuidador cuidador : cuidadores) {
            System.out.println(cuidador);
        }
    }

    private static void alimentarAnimal(Scanner scanner) {
        listarHabitats();
        System.out.print("Digite o ID do habitat: ");
        int idHabitat = scanner.nextInt();
        
        Habitat habitat = habitats.stream()
            .filter(h -> h.idHabitat == idHabitat)
            .findFirst()
            .orElse(null);
        
        if (habitat != null && !habitat.animais.isEmpty()) {
            System.out.println("Animais no habitat " + idHabitat + ":");
            for (int i = 0; i < habitat.animais.size(); i++) {
                System.out.println(i + " - " + habitat.animais.get(i).nome);
            }
            
            System.out.print("Digite o id do animal: ");
            int numAnimal = scanner.nextInt();
            System.out.print("Quantidade de comida: ");
            int quantidade = scanner.nextInt();
            
            if (numAnimal >= 0 && numAnimal < habitat.animais.size()) {
                habitat.animais.get(numAnimal).alimentacao(quantidade);
            } else {
                System.out.println("Número de animal inválido!");
            }
        } else {
            System.out.println("Habitat não encontrado ou vazio!");
        }
    }

    private static void transferirAnimal(Scanner scanner) {
        listarHabitats();
        System.out.print("Digite o ID do habitat de origem: ");
        int origemId = scanner.nextInt();
        
        Habitat origem = habitats.stream()
            .filter(h -> h.idHabitat == origemId)
            .findFirst()
            .orElse(null);
        
        if (origem != null && !origem.animais.isEmpty()) {
            System.out.println("Animais no habitat " + origemId + ":");
            for (int i = 0; i < origem.animais.size(); i++) {
                System.out.println(i + " - " + origem.animais.get(i).nome);
            }
            
            System.out.print("Digite o número do animal para transferir: ");
            int numAnimal = scanner.nextInt();
            
            System.out.print("Digite o ID do habitat de destino: ");
            int destinoId = scanner.nextInt();
            
            Habitat destino = habitats.stream()
                .filter(h -> h.idHabitat == destinoId)
                .findFirst()
                .orElse(null);
                
            if (destino != null && numAnimal >= 0 && numAnimal < origem.animais.size()) {
                origem.transferirAnimal(origem.animais.get(numAnimal), destino);
            } else {
                System.out.println("Dados inválidos para transferência!");
            }
        } else {
            System.out.println("Habitat de origem não encontrado ou vazio!");
        }
    }
private static void adicionarAnimal(Scanner scanner) {
    System.out.println("Informe os dados do novo animal:");

    try {
        System.out.print("Nome: ");
        String nome = scanner.nextLine();

        System.out.print("Espécie: ");
        String especie = scanner.nextLine();

        System.out.print("ID: ");
        int id = Integer.parseInt(scanner.nextLine());  // para evitar problemas com nextInt + nextLine

        System.out.print("Bioma: ");
        String bioma = scanner.nextLine();

        System.out.print("Idade: ");
        int idade = Integer.parseInt(scanner.nextLine());

        System.out.print("Nível de fome: ");
        int fome = Integer.parseInt(scanner.nextLine());

        Animal novoAnimal = new Animal(nome, especie, id, bioma, idade, fome);
        // adiciona o animal no habitat (por exemplo)
        System.out.println("Animal criado com sucesso: " + novoAnimal);

    } catch (IdadeInvalidaException e) {
        System.out.println("Erro: " + e.getMessage());
    } catch (NumberFormatException e) {
        System.out.println("Erro: Entrada inválida. Por favor, digite números válidos para ID, idade e fome.");
    }
}

}