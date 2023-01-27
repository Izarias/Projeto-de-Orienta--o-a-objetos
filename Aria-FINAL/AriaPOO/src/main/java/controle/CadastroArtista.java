package controle;
/**
* Classe CadastroArtista cria um Arraylist para as instâncias de Artista e faz o CRUD de Artista.
* @author Pedro Augusto Dourado Izarias
* @since 2023
*/

//Imports de modelo, controle e do swing
import modelo.Artista;
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

public class CadastroArtista extends JFrame {
//Declara um JPanel
	private JPanel contentPane;
/**
* Método main .
* torna visível a tela de CadastroArtista.
* @return void
*/
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CadastroArtista frame = new CadastroArtista();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
//Cria um array de String e JTextField para todos os atributos, além de um int para registros
	List <String>artista1 = new ArrayList<String>();
	private JTextField nome;
	private JTextField ano_nascimento;
	private JTextField nacionalidade;
	private JTextField instrumento;
	private JTextField cidade;
	private JTextField telefone;
	private JTextField banda;
	private int registros;
	JList list = new JList();
	DefaultListModel model = new DefaultListModel();
/**
* Construtor de CadastroArtista .
* Possui todos os botões e inputs de artista e seus métodos.
*/
	public CadastroArtista() {
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
		JLabel lblNewLabel_1 = new JLabel(registros + " - registros");
		lblNewLabel_1.setFont(new Font("Comic Sans MS", Font.PLAIN, 14));
		lblNewLabel_1.setBounds(48, 146, 105, 30);
		cad_1.add(lblNewLabel_1);
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
				nome.setText("");
				ano_nascimento.setText("");
				nacionalidade.setText("");
				instrumento.setText("");
				cidade.setText("");
				telefone.setText("");
				banda.setText("");
				
			}
		});
		btnLimpar.setFont(new Font("Comic Sans MS", Font.BOLD, 12));
		btnLimpar.setBounds(163, 184, 95, 27);
		cad_1.add(btnLimpar);
/**
* Cria uma instância de Artista .
* Adiciona os atributos na lista e aumenta 1 na quantidade de registros
* @return void
*/
		JButton btnSalvar = new JButton("salvar");
		btnSalvar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {	
					Artista cad = new Artista (instrumento.getText(), nacionalidade.getText(), ano_nascimento.getText(), nome.getText(), cidade.getText(),telefone.getText(),banda.getText());
					artista1.add(cad.getBanda());
					model.addElement(cad.getBanda());
					list.setModel(model);
					registros = registros + 1;
					lblNewLabel_1.setText(registros + " - registros");	
			}
		});
//Botão de salvar                
		btnSalvar.setFont(new Font("Comic Sans MS", Font.BOLD, 12));
		btnSalvar.setBounds(30, 187, 95, 27);
		cad_1.add(btnSalvar);
//Texto do input nome
		JLabel lblNewLabel = new JLabel("Nome:");
		lblNewLabel.setFont(new Font("Comic Sans MS", Font.PLAIN, 12));
		lblNewLabel.setBounds(5, 11, 45, 21);
		cad_1.add(lblNewLabel);
//Texto do input nascimento		
		JLabel lblNascimento = new JLabel("Nascimento:");
		lblNascimento.setFont(new Font("Comic Sans MS", Font.PLAIN, 12));
		lblNascimento.setBounds(10, 50, 110, 21);
		cad_1.add(lblNascimento);
//Texto do input nacionalidade
		JLabel lblNacionalidade = new JLabel("Nacionalidade:");
		lblNacionalidade.setFont(new Font("Comic Sans MS", Font.PLAIN, 12));
		lblNacionalidade.setBounds(10, 96, 110, 21);
		cad_1.add(lblNacionalidade);
//Texto do input instrumento
		JLabel lblInstrumento = new JLabel("Instrumento:");
		lblInstrumento.setFont(new Font("Comic Sans MS", Font.PLAIN, 12));
		lblInstrumento.setBounds(145, 15, 90, 21);
		cad_1.add(lblInstrumento);
//Texto do input cidade
		JLabel lblCidade = new JLabel("Cidade:");
		lblCidade.setFont(new Font("Comic Sans MS", Font.PLAIN, 12));
		lblCidade.setBounds(230, 54, 80, 21);
		cad_1.add(lblCidade);
//Texto do input telefone
		JLabel lblTelefone = new JLabel("Telefone:");
		lblTelefone.setFont(new Font("Comic Sans MS", Font.PLAIN, 12));
		lblTelefone.setBounds(230, 100, 78, 21);
		cad_1.add(lblTelefone);
//Texto do input banda
		JLabel lblBanda = new JLabel("Banda:");
		lblBanda.setFont(new Font("Comic Sans MS", Font.PLAIN, 12));
		lblBanda.setBounds(313, 15, 78, 21);
		cad_1.add(lblBanda);
//input nome
		nome = new JTextField();
		nome.setBounds(50, 12, 90, 20);
		cad_1.add(nome);
		nome.setColumns(10);
//input ano de nascimento		
		ano_nascimento = new JTextField();
		ano_nascimento.setColumns(10);
		ano_nascimento.setBounds(120, 51, 86, 20);
		cad_1.add(ano_nascimento);
//input nacionalidade
		nacionalidade = new JTextField();
		nacionalidade.setColumns(10);
		nacionalidade.setBounds(120, 97, 86, 20);
		cad_1.add(nacionalidade);
//input instrumento
		instrumento = new JTextField();
		instrumento.setColumns(10);
		instrumento.setBounds(225, 12, 85, 20);
		cad_1.add(instrumento);
//input cidade
		cidade = new JTextField();
		cidade.setColumns(10);
		cidade.setBounds(310, 51, 86, 20);
		cad_1.add(cidade);
//input telefone
		telefone = new JTextField();
		telefone.setColumns(10);
		telefone.setBounds(310, 97, 86, 20);
		cad_1.add(telefone);
//input banda
		banda = new JTextField();
		banda.setColumns(10);
		banda.setBounds(360, 12, 55, 20);
		cad_1.add(banda);
//Cria uma aba chamada lista
		JPanel lista = new JPanel();
		lista.setBackground(SystemColor.inactiveCaption);
		tabbedPane.addTab("Lista", null, lista, null);
		lista.setLayout(null);
/**
* Remove um artista .
* remove um artista da lista quando selecionado, se a resposta da caixa de diálogo for sim
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
		btnRemover.setBounds(40, 186, 133, 25);
		lista.add(btnRemover);
/**
* Remove todos os artistas .
* remove todos os artistas da lista, se a resposta da caixa de diálogo for sim
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
		btnRemoverTodos.setBounds(240, 186, 133, 25);
		lista.add(btnRemoverTodos);
		lista.add(list);
//Configura as dimensões de list
		list.setFont(new Font("Comic Sans MS", Font.PLAIN, 12));
		list.setBounds(10, 11, 399, 164);
	}
}

