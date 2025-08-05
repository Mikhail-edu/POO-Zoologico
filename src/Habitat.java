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
            if (animal.bioma.equals(tipo) || tipo.equals("misto")) {
                animais.add(animal);
                System.out.println("Animal " + animal.nome + " adicionado no habitat " + idHabitat);
            } else {
                System.out.println("Bioma do animal não é compativel com o habitat " + idHabitat);
            }
        } else {
            System.out.println("Habitat " + idHabitat + " cheio, nao da pra adicionar mais animais.");
        }
    }

    public void removerAnimal(Animal animal) {
        if (animais.contains(animal)) {
            animais.remove(animal);
            System.out.println("Animal " + animal.nome + " removido do habitat " + idHabitat);
        } else {
            System.out.println("Animal não encontrado no habitat " + idHabitat);
        }
    }

    public void transferirAnimal(Animal animal, Habitat outroHabitat) {
        if (animais.contains(animal)) {
            if (outroHabitat.animais.size() < outroHabitat.capacidade) {
                if (animal.bioma.equals(outroHabitat.tipo) || outroHabitat.tipo.equals("misto")) {
                    animais.remove(animal);
                    outroHabitat.animais.add(animal);
                    System.out.println("Animal " + animal.nome + " transferido de habitat " + idHabitat + " para habitat " + outroHabitat.idHabitat);
                } else {
                    System.out.println("Bioma incompativel. Animal " + animal.nome + " permanece no habitat " + idHabitat);
                }
            } else {
                System.out.println("Habitat " + outroHabitat.idHabitat + " cheio. Animal " + animal.nome + " permanece no habitat " + idHabitat);
            }
        } else {
            System.out.println("Animal " + animal.nome + " nao esta no habitat " + idHabitat);
        }
    }

    @Override
    public String toString() {
        return "[Habitat " + idHabitat + "] capacidade: " + capacidade + ", tipo: " + tipo + ", animais: " + animais.size();
    }
}