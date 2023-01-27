package modelo;
/**
* Classe Artista possui os atributos de um artista na vida real.
* @author Pedro Augusto Dourado Izarias
* @since 2023
*/
public class Artista{
//Atriutos
    private String nome;
    private String ano_nascimento;
    private String nacionalidade;
    private String instrumento;
    private String cidade;
    private String telefone;
    private String banda;
//Gets e sets
    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getAno_nascimento() {
        return ano_nascimento;
    }

    public void setAno_nascimento(String ano_nascimento) {
        this.ano_nascimento = ano_nascimento;
    }

    public String getNacionalidade() {
        return nacionalidade;
    }

    public void setNacionalidade(String nacionalidade) {
        this.nacionalidade = nacionalidade;
    }

    public String getInstrumento() {
        return instrumento;
    }

    public void setInstrumento(String instrumento) {
        this.instrumento = instrumento;
    }

    public String getCidade() {
        return cidade;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getBanda() {
        return banda;
    }

    public void setBanda(String banda) {
        this.banda = banda;
    }
/**
* Construtor da classe Artista. 
* Coloca as Strings recebidas nos atributos e ao final, coloca tudo em uma String chamada show
* que vai ser mostrada através do atributo banda
*/
	public Artista(String instrumento, String nacionalidade, String ano_nascimento, String nome, String cidade, String telefone,String banda) {
		this.setAno_nascimento(ano_nascimento);
		this.setCidade(cidade);
		this.setNacionalidade(nacionalidade);
		this.setInstrumento(instrumento);
		this.setNome(nome);
		this.setTelefone(telefone);
                this.setBanda(banda);
                String show = "Artista: " + this.getInstrumento() + " " + this.getAno_nascimento() + " " + this.getNacionalidade() + " " + this.getNome() + " " + this.getCidade() + " " + this.getTelefone() + " "+ " " + this.getBanda();
		this.setBanda(show);
	}
}
