package modelo;
/**
* * Classe Nacional possui atributos de uma musica nacional, herda de Musica e adiciona também o estado(UF).
* @author Pedro Augusto Dourado Izarias
* @since 2023
*/
public class Nacional extends Musica{
//Atributos
	private String estado;
//Gets e sets
        public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}
/**
* Construtor da classe Nacional. 
* Coloca as Strings recebidas nos atributos e ao final, coloca tudo em uma String chamada show
* que vai ser mostrada através do atributo estado
*/
	public Nacional(String nome, Artista artista, String ano_lancamento, String letra, String genero,String estado) {
		this.setAno_lancamento(ano_lancamento);
		this.setGenero(genero);
		this.setArtista(artista);
		this.setNomeMusica(nome);
		this.setLetra(letra);
                this.setEstado(estado);
		String show = "Nacional: " + this.getArtista().getNome() + " " + this.getAno_lancamento() + " " + this.getNomeMusica() + " " + this.getLetra() + " " + this.getGenero() + " "+this.getEstado()+" ";
		this.setEstado(show);
	}
}
