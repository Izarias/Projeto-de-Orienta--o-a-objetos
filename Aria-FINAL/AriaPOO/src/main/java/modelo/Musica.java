package modelo;
/**
* Classe Abstrata Musica que contém os atributos básicos de uma musica e um objeto da classe Artista.
* @author Pedro Augusto Dourado Izarias
* @since 2023
*/
public abstract class Musica {
//Atributos
	private String letra;
	private String ano_lancamento;
	private Artista artista;
	private String nome;
	private String genero;
//Gets e sets
	public String getLetra() {
		return letra;
	}
	public void setLetra(String letra) {
		this.letra = letra;
	}
	
	public String getNomeMusica() {
		return nome;
	}
	public void setNomeMusica(String nome) {
		this.nome = nome;
	}
	public String getGenero() {
		return genero;
	}
	public void setGenero(String genero) {
		this.genero = genero;
	}
	
	public String getAno_lancamento() {
		return ano_lancamento;
	}
	public void setAno_lancamento(String ano_lancamento) {
		this.ano_lancamento = ano_lancamento;
	}

        public Artista getArtista() {
            return artista;
        }

        public void setArtista(Artista artista) {
            this.artista = artista;
        }
}

