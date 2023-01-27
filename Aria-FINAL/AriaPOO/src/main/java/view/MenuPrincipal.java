package view;
/**
* Classe Menuprincipal mostra as opções ao usuario e as redirecionam para as classes de controle.
* @author Pedro Augusto Dourado Izarias
* @since 2023
*/

//Imports
import controle.CadastroArtista;
import controle.CadastroMusica;
import java.awt.BorderLayout;
import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.SystemColor;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Color;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class MenuPrincipal extends JFrame {
//Declara variavel contentPane
	private JPanel contentPane;
/**
* Método main .
* torna visível a tela de menu.
* @return void
*/
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MenuPrincipal frame = new MenuPrincipal();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
/**
* Construtor de MenuPrincipal .
* Possui todos os botões do menu e as classes respectivas que cada um executa.
*/
	public MenuPrincipal() {
//Painel principal
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		setLocationRelativeTo(null);
		contentPane = new JPanel();
		contentPane.setBackground(SystemColor.activeCaption);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
//Textos de apresentação
		JLabel lblNewLabel = new JLabel("Aria - cadastro de musicas");
		lblNewLabel.setForeground(new Color(255, 215, 0));
		lblNewLabel.setFont(new Font("Ink Free", Font.BOLD, 22));
		lblNewLabel.setBackground(SystemColor.activeCaption);
		lblNewLabel.setBounds(45, 11, 500, 75);
		contentPane.add(lblNewLabel);

		JLabel lblNewLabel_1 = new JLabel("Escolha o tipo de cadastro:");
		lblNewLabel_1.setFont(new Font("Comic Sans MS", Font.PLAIN, 16));
                lblNewLabel_1.setForeground(new Color(255, 250, 250));
		lblNewLabel_1.setBounds(126, 83, 250, 23);
		contentPane.add(lblNewLabel_1);
//Botão de cadastrar musica estrangeira
		JButton btnEstrangeira = new JButton("Musica Estrangeira");
		btnEstrangeira.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				CadastroMusica cadastro = new CadastroMusica ();
				cadastro.setVisible(true);
				dispose();
			}
		});
		btnEstrangeira.setFont(new Font("Comic Sans MS", Font.BOLD, 14));
		btnEstrangeira.setBounds(10, 117, 200, 46);
		contentPane.add(btnEstrangeira);
//Botão de cadastrar musica Nacional
		JButton btnNacional = new JButton("Musica Nacional");
		btnNacional.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				CadastroMusica cadastro = new CadastroMusica ();
				cadastro.setVisible(true);
				dispose();
			}
		});
		btnNacional.setFont(new Font("Comic Sans MS", Font.BOLD, 14));
		btnNacional.setBounds(230, 117, 200, 46);
		contentPane.add(btnNacional);
//Botão de cadastrar Artista
		JButton btnArtista = new JButton("Artista");
		btnArtista.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				CadastroArtista cadastroartista = new CadastroArtista ();
				cadastroartista.setVisible(true);
				dispose();
			}
		});
		btnArtista.setFont(new Font("Comic Sans MS", Font.BOLD, 14));
		btnArtista.setBounds(42, 204, 122, 46);
		contentPane.add(btnArtista);
//Botão de Sair
		JButton btnSair = new JButton("Sair");
		btnSair.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				setVisible(false);
				dispose();
				System.exit(0);
			}
		});
		btnSair.setFont(new Font("Comic Sans MS", Font.BOLD, 14));
		btnSair.setBounds(256, 204, 122, 46);
		contentPane.add(btnSair);
	}
}
