package controle;
/**
* Classe CadastroMusica cria um Arraylist para as instâncias de Estrangeira e Nacional e faz o CRUD de ambos.
* @author Pedro Augusto Dourado Izarias
* @since 2023
*/

//Imports de modelo, controle e do swing
import modelo.Artista;
import modelo.Estrangeira;
import modelo.Nacional;
import controle.*;
import view.MenuPrincipal;
import java.awt.BorderLayout;
import java.util.List;
import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTabbedPane;
import java.awt.SystemColor;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import javax.swing.JTextField;
import java.awt.Color;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

public class CadastroMusica extends JFrame {
//Declara um JPanel
	private JPanel contentPane;
/**
* Método main .
* torna visível a tela de CadastroMusica.
* @return void
*/
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CadastroMusica frame = new CadastroMusica();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
/**
* Cria dois arrays de String para instancias de musica estrangeira e nacional
* e JTextField para todos os atributos, além de um int para registros
*/
	List <String> estrangeira = new ArrayList<String>(); 
	List <String> nacional = new ArrayList<String>();
	private JTextField artista;
	private JTextField nome;
	private JTextArea letra; 
        private JScrollPane barra;
	private JTextField anolancamento;
	private JTextField genero;
	private JTextField estado;
	private JTextField lingua;
        private JTextField pesquisarNomeMusica;
        private JTextField pesquisarNomeArtista;
	private int registros;
	JList list = new JList();
	DefaultListModel model = new DefaultListModel();
/**
* Construtor de CadastroMusica .
* Possui todos os botões e inputs de musica e seus métodos.
*/	
	public CadastroMusica() {
 //Cria um painel
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		setLocationRelativeTo(null);
		contentPane = new JPanel();
		contentPane.setBackground(SystemColor.activeCaption);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
//Cria uma aba chamada cadastro
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setBackground(SystemColor.inactiveCaption);
		tabbedPane.setBounds(0, 0, 424, 250);
		contentPane.add(tabbedPane);
		
		JPanel cad_1 = new JPanel();
		cad_1.setBackground(SystemColor.inactiveCaption);
		tabbedPane.addTab("Cadastro", null, cad_1, null);
		cad_1.setLayout(null);
//Mostra a quantidade de registros
		final JLabel lblNewLabel_1 = new JLabel(registros + " - registros");
		lblNewLabel_1.setFont(new Font("Comic Sans MS", Font.PLAIN, 14));
		lblNewLabel_1.setBounds(48, 146, 105, 30);
		cad_1.add(lblNewLabel_1);
//Texto que informa ao usuário que o campo lingua não é para musica nacional		
		JLabel lblNewLabel_2 = new JLabel("Campo lingua para musica estrangeira");
		lblNewLabel_2.setForeground(new Color(255, 0, 0));
		lblNewLabel_2.setFont(new Font("Comic Sans MS", Font.ITALIC, 13));
		lblNewLabel_2.setBounds(30, 118, 362, 21);
		cad_1.add(lblNewLabel_2);
//Texto que informa ao usuário que o campo estado não é para musica estrangeira	
                JLabel lblNewLabel_3 = new JLabel("Campo estado para musica nacional");
		lblNewLabel_3.setForeground(new Color(255, 0, 0));
		lblNewLabel_3.setFont(new Font("Comic Sans MS", Font.ITALIC, 13));
		lblNewLabel_3.setBounds(30, 133, 362, 21);
		cad_1.add(lblNewLabel_3);
/**
* Volta para MenuPrincipal .
* @return void
*/
		JButton btnVoltar = new JButton("voltar");
		btnVoltar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				MenuPrincipal menu = new MenuPrincipal ();
				menu.setVisible(true);
				dispose();
			}
		});
		btnVoltar.setFont(new Font("Comic Sans MS", Font.BOLD, 12));
		btnVoltar.setBounds(297, 184, 95, 27);
		cad_1.add(btnVoltar);
/**
* Limpa os campos para um novo cadastro .
* @return void
*/
		JButton btnLimpar = new JButton("limpar");
		btnLimpar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				artista.setText("");
				nome.setText("");
				letra.setText("");
				anolancamento.setText("");
				genero.setText("");
				estado.setText("");
				lingua.setText("");
			}
		});
		btnLimpar.setFont(new Font("Comic Sans MS", Font.BOLD, 12));
		btnLimpar.setBounds(163, 184, 95, 27);
		cad_1.add(btnLimpar);
/**
* Cria uma instância de Musica.
* Se o input lingua estiver vazio, cria uma instância de Nacional.
* Senão, cria uma instância de Estrangeira.
* Para o atributo do tipo artista, se cria uma nova instância de Artista com o nome 
* recebido no input artista.
* Adiciona os atributos na lista e aumenta 1 na quantidade de registros.
* @return void
*/
		JButton btnSalvar = new JButton("salvar");
		btnSalvar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (lingua.getText().equalsIgnoreCase("")) {
                                        Artista art = new Artista ("Instrumento"+1,"Nacionalidade"+1,"ano_nascimento"+1,artista.getText(),"cidade"+1,"telefone"+1,"banda"+1);
					Nacional cad = new Nacional (nome.getText(), art, anolancamento.getText(), letra.getText(), genero.getText(),estado.getText());
					nacional.add(cad.getEstado());
					model.addElement(cad.getEstado());
					list.setModel(model);
					registros = registros + 1;
					lblNewLabel_1.setText(registros + " - registros");
				}else{
                                    Artista art = new Artista ("Instrumento"+1,"Nacionalidade"+1,"ano_nascimento"+1,artista.getText(),"cidade"+1,"telefone"+1,"banda"+1);
                                    Estrangeira cad = new Estrangeira (nome.getText(), art, anolancamento.getText(), letra.getText(), genero.getText(),lingua.getText());
                                    estrangeira.add(cad.getLingua());
                                    model.addElement(cad.getLingua());
                                    list.setModel(model);
                                    registros = registros + 1;
                                    lblNewLabel_1.setText(registros + " - registros");
				} 
			}
		});
//Botão de salvar
		btnSalvar.setFont(new Font("Comic Sans MS", Font.BOLD, 12));
		btnSalvar.setBounds(30, 187, 95, 27);
		cad_1.add(btnSalvar);
//Texto do input Artista
		JLabel lblNewLabel = new JLabel("Artista:");
		lblNewLabel.setFont(new Font("Comic Sans MS", Font.PLAIN, 12));
		lblNewLabel.setBounds(10, 11, 45, 21);
		cad_1.add(lblNewLabel);
//Texto do input Nome		
		JLabel lblNomeMusica = new JLabel("Nome:");
		lblNomeMusica.setFont(new Font("Comic Sans MS", Font.PLAIN, 12));
		lblNomeMusica.setBounds(10, 50, 45, 21);
		cad_1.add(lblNomeMusica);
//Texto do input Letra
		JLabel lblLetra = new JLabel("Letra:");
		lblLetra.setFont(new Font("Comic Sans MS", Font.PLAIN, 12));
		lblLetra.setBounds(10, 96, 45, 21);
		cad_1.add(lblLetra);
//Texto do input Ano
		JLabel lblAno = new JLabel("Ano:");
		lblAno.setFont(new Font("Comic Sans MS", Font.PLAIN, 12));
		lblAno.setBounds(163, 15, 45, 21);
		cad_1.add(lblAno);
//Texto do input Genero
		JLabel lblGenero = new JLabel("Genero:");
		lblGenero.setFont(new Font("Comic Sans MS", Font.PLAIN, 12));
		lblGenero.setBounds(145, 54, 60, 21);
		cad_1.add(lblGenero);
//Texto do input Estado
		JLabel lblEstado = new JLabel("Estado:");
		lblEstado.setFont(new Font("Comic Sans MS", Font.PLAIN, 12));
		lblEstado.setBounds(290, 54, 78, 21);
		cad_1.add(lblEstado);
//Texto do input Lingua
		JLabel lblLingua = new JLabel("Lingua:");
		lblLingua.setFont(new Font("Comic Sans MS", Font.PLAIN, 12));
		lblLingua.setBounds(297, 15, 78, 21);
		cad_1.add(lblLingua);
//input artista
		artista = new JTextField();
		artista.setBounds(67, 12, 86, 20);
		cad_1.add(artista);
		artista.setColumns(10);
//input nome		
		nome = new JTextField();
		nome.setColumns(10);
		nome.setBounds(55, 51, 86, 20);
		cad_1.add(nome);
//input letra		
		letra = new JTextArea();
                barra = new JScrollPane(letra);
		letra.setColumns(10);
		letra.setBounds(65, 97, 345, 20);
		cad_1.add(letra);
                cad_1.add(barra);
//input ano de lançamento		
		anolancamento = new JTextField();
		anolancamento.setColumns(10);
		anolancamento.setBounds(201, 12, 86, 20);
		cad_1.add(anolancamento);
//input genero		
		genero = new JTextField();
		genero.setColumns(10);
		genero.setBounds(197, 51, 86, 20);
		cad_1.add(genero);
//input estado
		estado = new JTextField();
		estado.setColumns(10);
		estado.setBounds(340, 54, 70, 20);
		cad_1.add(estado);
//input lingua
		lingua = new JTextField();
		lingua.setColumns(10);
		lingua.setBounds(368, 12, 41, 20);
		cad_1.add(lingua);
//Cria uma aba chamada lista
		JPanel lista = new JPanel();
		lista.setBackground(SystemColor.inactiveCaption);
		tabbedPane.addTab("Lista", null, lista, null);
		lista.setLayout(null);
//input para pesquisar Musica por nome
                pesquisarNomeMusica = new JTextField();
		pesquisarNomeMusica.setColumns(10);
		pesquisarNomeMusica.setBounds(250, 157, 110, 20);
		lista.add(pesquisarNomeMusica);
/**
* Pesquisa por musica .
* pesquisa musica pelo nome digitado no input pesquisarNomeMusica e imprime em um alerta
* se o input lingua estiver vazio, procura no array de nacional
* senão, procura no array de estrangeira
* @return void
*/                
                JButton btnpesquisarMusica = new JButton("Buscar por Musica");
                btnpesquisarMusica.setFont(new Font("Comic Sans MS", Font.BOLD, 14));
		btnpesquisarMusica.setBounds(40, 157, 200, 23);
		lista.add(btnpesquisarMusica);
                btnpesquisarMusica.addActionListener(new ActionListener() {
                    public void actionPerformed(ActionEvent e) {
                        int aux=0;
                        if(lingua.getText().equals("")){
                            String resposta="";
                            for(int i = 0; i < nacional.size(); i++){
                                String line = nacional.get(i);
                                String[] array = line.split(" ");
                                String campo = array[3];
                                if(pesquisarNomeMusica.getText().equals(campo)){
                                    aux++;
                                    resposta+=line+"\n";
                                }
                            }
                            if(aux!=0){
                                JOptionPane.showMessageDialog(null, resposta, "Musica encontrada", JOptionPane.INFORMATION_MESSAGE);
                            }                        
                        }else{
                            String resposta="";
                            for(int i = 0; i < estrangeira.size(); i++){
                                String line = estrangeira.get(i);
                                String[] array = line.split(" ");
                                String campo = array[3];   
                                if(pesquisarNomeMusica.getText().equals(campo)){
                                    aux++;
                                    resposta+=line+"\n";
                                }
                            }
                            if(aux!=0){
                                JOptionPane.showMessageDialog(null, resposta, "Musica encontrada", JOptionPane.INFORMATION_MESSAGE);
                            }                                 
                        }
                        if(aux==0){
                            JOptionPane.showMessageDialog(null, "Não foi encontrada!", "Musica não encontrada", JOptionPane.INFORMATION_MESSAGE);
                        }
                    }
                });
//input para pesquisar Musica por artista
                pesquisarNomeArtista = new JTextField();
		pesquisarNomeArtista.setColumns(10);
		pesquisarNomeArtista.setBounds(250, 177, 110, 20);
		lista.add(pesquisarNomeArtista);
/**
* Pesquisa por musica .
* pesquisa musica pelo nome digitado no input pesquisarNomeArtista e imprime em um alerta
* se o input lingua estiver vazio, procura no array de nacional
* senão, procura no array de estrangeira
* @return void
*/           
                JButton btnPesquisarArtista = new JButton("Buscar por Artista");
                btnPesquisarArtista.setFont(new Font("Comic Sans MS", Font.BOLD, 14));
		btnPesquisarArtista.setBounds(40, 179, 200, 23);
		lista.add(btnPesquisarArtista);
                btnPesquisarArtista.addActionListener(new ActionListener() {
                    public void actionPerformed(ActionEvent e) {
                        int aux=0;
                        if(lingua.getText().equals("")){
                            
                            String resposta="";
                            for(int i = 0; i < nacional.size(); i++){
                                String line = nacional.get(i);
                                String[] array = line.split(" ");
                                String campo = array[1];
                                System.out.println(campo);
                                if(pesquisarNomeArtista.getText().equals(campo)){
                                    aux++;
                                    resposta+=line+"\n";
                                }
                            }
                            if(aux!=0){
                                JOptionPane.showMessageDialog(null, resposta, "Musica encontrada", JOptionPane.INFORMATION_MESSAGE); 
                            }                        
                        }else{
                            String resposta="";
                            for(int i = 0; i < estrangeira.size(); i++){
                                String line = estrangeira.get(i);
                                String[] array = line.split(" ");
                                String campo = array[1];   
                                if(pesquisarNomeArtista.getText().equals(campo)){
                                    aux++;
                                    resposta+=line+"\n";
                                }
                            }
                            if(aux!=0){
                                JOptionPane.showMessageDialog(null, resposta, "Musica encontrada", JOptionPane.INFORMATION_MESSAGE);
                            }                                 
                        }
                        if(aux==0){
                            JOptionPane.showMessageDialog(null, "Não foi encontrada!", "Musica não encontrada", JOptionPane.INFORMATION_MESSAGE);
                        }
                    }
                });
/**
* Remove uma musica .
* remove uma musica da lista quando selecionada, se a resposta da caixa de diálogo for sim
* @return void
*/     
		JButton btnRemover = new JButton("Remover");
		btnRemover.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String resp = JOptionPane.showInputDialog("Certeza que deseja remover este elemento?");
				if (resp.equalsIgnoreCase("sim")) {
					model.removeElement(list.getSelectedValue());
					list.setModel(model);
				}
			}
		});
                
                btnRemover.setFont(new Font("Comic Sans MS", Font.BOLD, 14));
		btnRemover.setBounds(40, 202, 133, 23);
		lista.add(btnRemover);
/**
* Remove todas as musicas .
* remove todas as musicas da lista, se a resposta da caixa de diálogo for sim
* @return void
*/
		JButton btnRemoverTodos = new JButton("Remover todos");
		btnRemoverTodos.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String resp = JOptionPane.showInputDialog("Certeza que deseja remover todos os elementos?");
				if (resp.equalsIgnoreCase("sim")) {
					model.removeAllElements();
					list.setModel(model);
				}
			}
		});
		btnRemoverTodos.setFont(new Font("Comic Sans MS", Font.BOLD, 14));
		btnRemoverTodos.setBounds(190, 202, 170, 23);
		lista.add(btnRemoverTodos);
		lista.add(list);
//Configura as dimensões de list
		list.setFont(new Font("Comic Sans MS", Font.PLAIN, 12));
		list.setBounds(10, 11, 399, 140);
	}
}
