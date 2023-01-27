package modelo;
/**
* Classe Estrangeira possui atributos de uma musica estrangeira, herda de Musica e adiciona também a lingua.
* @author Pedro Augusto Dourado Izarias
* @since 2023
*/
public class Estrangeira extends Musica{
//Atributos	
    private String lingua;
//Gets e sets
    public String getLingua() {
	return lingua;
    }

    public void setLingua(String lingua) {
	this.lingua = lingua;
    }
/**
* Construtor da classe Estrangeira. 
* Coloca as Strings recebidas nos atributos e ao final, coloca tudo em uma String chamada show
* que vai ser mostrada através do atributo lingua
*/
	public Estrangeira(String nomeMusica, Artista artista, String ano_lancamento, String letra, String genero,String lingua) {
		this.setAno_lancamento(ano_lancamento);
		this.setGenero(genero);
		this.setArtista(artista);
		this.setNomeMusica(nomeMusica);
		this.setLetra(letra);
                this.setLingua(lingua);
		String show = "Estrangeira: " + this.getArtista().getNome() + " " + this.getAno_lancamento() + " " + this.getNomeMusica() + " " + this.getLetra() + " " + this.getGenero() + " "+this.getLingua()+" ";
		this.setLingua(show);
	}	
}
