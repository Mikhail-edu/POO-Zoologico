public class Habitat{
        String nomedobioma;
        int capacidade;
        String tipo;
        int idHabitat;
    
    
    Habitat(String nomedobioma, int capacidade, String tipo, int idHabitat){
        this.nomedobioma = nomedobioma;
        this.capacidade = capacidade;
        this.tipo = tipo;
        this.idHabitat = idHabitat;
    }
 @Override
   public String toString(){
 return "nome do bioma: " + nomedobioma +  " capacidade: " + capacidade  + " tipo: " + tipo + " idhabitat: " + idHabitat;
   }
 
}