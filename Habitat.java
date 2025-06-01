import java.util.ArrayList;

public class Habitat {
    String nomedobioma;
    int capacidade;
    String tipo;
    int idHabitat;
    ArrayList<Animal> animais;

    Habitat(String nomedobioma, int capacidade, String tipo, int idHabitat) {
        this.nomedobioma = nomedobioma;
        this.capacidade = capacidade;
        this.tipo = tipo;
        this.idHabitat = idHabitat;
        this.animais = new ArrayList<>();
    }

    public void adicionarAnimal(Animal animal) {
        if (animais.size() < capacidade) {
            if (animal.bioma.equals(nomedobioma)) {
                animais.add(animal);
                System.out.println("Animal " + animal.nome + " adicionado no habitat " + nomedobioma);
            } else {
                System.out.println("Bioma do animal não é compatível com o habitat.");
            }
        } else {
            System.out.println("Habitat cheio, não dá pra adicionar mais animais.");
        }
    }

    public void removerAnimal(Animal animal) {
        if (animais.contains(animal)) {
            animais.remove(animal);
            System.out.println("Animal " + animal.nome + " removido do habitat " + nomedobioma);
        } else {
            System.out.println("Animal não encontrado no habitat.");
        }
    }

   public void transferirAnimal(Animal animal, Habitat outroHabitat) {
    if (animais.contains(animal)) {
        // Verifica se o habitat de destino tem espaço
        if (outroHabitat.animais.size() < outroHabitat.capacidade) {
            // Verifica se o bioma do animal é compatível
            if (animal.bioma.equals(outroHabitat.nomedobioma)) {
                // Faz a transferência
                animais.remove(animal);
                outroHabitat.animais.add(animal);
                System.out.println("Animal " + animal.nome + " transferido de " + nomedobioma + " para " + outroHabitat.nomedobioma);
            } else {
                System.out.println("Bioma incompatível. Animal " + animal.nome + " permanece no habitat " + nomedobioma);
            }
        } else {
            System.out.println("Habitat de destino cheio. Animal " + animal.nome + " permanece no habitat " + nomedobioma);
        }
    } else {
        System.out.println("Animal " + animal.nome + " não está no habitat " + nomedobioma);
    }
}

    public String toString() {
        return "Habitat: " + nomedobioma + ", capacidade: " + capacidade + ", tipo: " + tipo + ", id: " + idHabitat + ", animais: " + animais.size();
    }
}
