public class Cuidador {
    String nome;
    int idHabitatResponsavel; 

    
    public Cuidador(String nome, int idHabitat) {
        this.nome = nome;
        this.idHabitatResponsavel = idHabitat; 
    }

    @Override
    public String toString() {
        return "Nome do Cuidador: " + nome + ", (ID) do habitat responsável: " + idHabitatResponsavel;
    }
}