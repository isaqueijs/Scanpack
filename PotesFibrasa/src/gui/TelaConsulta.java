package gui;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import negocios.Fachada;
import negocios.Pote;

import javax.swing.GroupLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.GroupLayout.Alignment;
import java.awt.Dimension;
import java.awt.Color;
import java.awt.Component;
import javax.swing.SwingConstants;
import javax.swing.LayoutStyle.ComponentPlacement;
import java.awt.Font;
import javax.swing.border.LineBorder;
import java.awt.event.ActionListener;
import java.io.FileInputStream;
import java.awt.event.ActionEvent;
import java.awt.Frame;
import java.awt.Insets;

public class TelaConsulta extends JFrame {

	private JPanel contentPane;
	ImageIcon img = new ImageIcon(getClass().getResource("/gui/imagens/potes.png"));
	private JTextField codigoProduto;
	ImageIcon imgM = new ImageIcon("");
	JTextArea textDescricao = new JTextArea();
	JOptionPane msgErro = new JOptionPane("Codigo inexistente");
	private Pote pote = null;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaConsulta frame = new TelaConsulta();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	@SuppressWarnings("deprecation")
	public TelaConsulta() {
		setMaximumSize(new Dimension(1080, 1920));
		setUndecorated(true);
		setExtendedState(Frame.MAXIMIZED_BOTH);
		setMinimumSize(new Dimension(802, 602));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 844, 743);
		contentPane = new JPanel();
		contentPane.setMaximumSize(new Dimension(1080, 1920));
		contentPane.setMinimumSize(new Dimension(800, 600));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);

		JLabel topo = new JLabel("");
		topo.setHorizontalTextPosition(SwingConstants.RIGHT);
		topo.setHorizontalAlignment(SwingConstants.CENTER);
		topo.setAlignmentX(Component.CENTER_ALIGNMENT);
		topo.setIcon(new ImageIcon(TelaConsulta.class.getResource("/gui/imagens/fibrasa2.png")));
		topo.setBackground(Color.BLACK);

		JLabel imgPotes = new JLabel("");
		imgPotes.setMaximumSize(new Dimension(800, 1000));
		imgPotes.setIcon(new ImageIcon(TelaConsulta.class.getResource("/gui/imagens/potes.png")));
		imgPotes.setAlignmentY(Component.TOP_ALIGNMENT);
		imgPotes.setAlignmentX(Component.CENTER_ALIGNMENT);
		imgPotes.setHorizontalTextPosition(SwingConstants.CENTER);
		imgPotes.setHorizontalAlignment(SwingConstants.CENTER);

		JLabel label = new JLabel("C\u00F3digo do produto:");
		label.setFont(new Font("Arial Black", Font.PLAIN, 12));

		codigoProduto = new JTextField();
		codigoProduto.setColumns(10);
		codigoProduto.setBorder(new LineBorder(new Color(0, 128, 0), 2));

		JTextArea textDescricao = new JTextArea();
		textDescricao.setMargin(new Insets(2, 8, 2, 2));
		textDescricao.setToolTipText("");
		textDescricao.setFont(new Font("Arial", Font.BOLD, 69));

		textDescricao.setBorder(new LineBorder(new Color(0, 128, 0), 2));
		textDescricao.setEditable(false);

		JLabel label_1 = new JLabel("Descri\u00E7\u00E3o do produto:");
		label_1.setFont(new Font("Arial Black", Font.PLAIN, 12));

		JButton btnBuscar = new JButton("OK");
		getRootPane().setDefaultButton(btnBuscar);
		btnBuscar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				try {
					pote = Fachada.getInstancia().buscarPote(codigoProduto.getText());
					imgPotes.setIcon(null);
					ImageIcon imgM = new ImageIcon(pote.getImagem());
					System.out.println(pote.getImagem());
					// imgM.setImage(imgM.getImage().getScaledInstance(imgPotes.getWidth(),
					// imgPotes.getHeight(), 1));
					// imgPotes.setBorder(new LineBorder(new Color(0, 128, 0), 2));
					imgPotes.setIcon(imgM);
					textDescricao.setText(pote.getDescricao());
					textDescricao.setLineWrap(true);
				} catch (NullPointerException npe) {
					// JOptionPane.showMessageDialog(null, "Codigo inexistente", null,
					// JOptionPane.ERROR_MESSAGE);
					// ImageIcon imgE = new ImageIcon("C:\\Scanpack\\produtos\\semimagem.jpeg");
					ImageIcon imgE = new ImageIcon(getClass().getResource("/gui/imagens/semimagem.jpeg"));
					// imgE.setImage(imgE.getImage().getScaledInstance(imgPotes.getWidth(),
					// imgPotes.getHeight(), 1));
					imgPotes.setIcon(imgE);
					imgM.getClass().getResource("");
					textDescricao.setText("PRODUTO NÃO CADASTRADO");

				}

				codigoProduto.setText("");

			}
		});
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup().addGap(205)
						.addComponent(topo, GroupLayout.DEFAULT_SIZE, 435, Short.MAX_VALUE).addGap(194))
				.addGroup(gl_contentPane.createSequentialGroup().addGap(44).addGroup(gl_contentPane
						.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createSequentialGroup()
								.addComponent(label_1, GroupLayout.PREFERRED_SIZE, 152, GroupLayout.PREFERRED_SIZE)
								.addPreferredGap(ComponentPlacement.RELATED, 638, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_contentPane.createSequentialGroup()
								.addComponent(label, GroupLayout.PREFERRED_SIZE, 134, GroupLayout.PREFERRED_SIZE)
								.addGap(18)
								.addComponent(codigoProduto, GroupLayout.PREFERRED_SIZE, 224,
										GroupLayout.PREFERRED_SIZE)
								.addGap(18)
								.addComponent(btnBuscar, GroupLayout.PREFERRED_SIZE, 73, GroupLayout.PREFERRED_SIZE)))
						.addContainerGap())
				.addGroup(Alignment.TRAILING,
						gl_contentPane.createSequentialGroup().addGap(27)
								.addComponent(textDescricao, GroupLayout.DEFAULT_SIZE, 790, Short.MAX_VALUE).addGap(17))
				.addGroup(gl_contentPane.createSequentialGroup().addGap(145)
						.addComponent(imgPotes, GroupLayout.PREFERRED_SIZE, 555, Short.MAX_VALUE).addGap(134)));
		gl_contentPane.setVerticalGroup(gl_contentPane.createParallelGroup(Alignment.LEADING).addGroup(gl_contentPane
				.createSequentialGroup().addContainerGap()
				.addComponent(topo, GroupLayout.PREFERRED_SIZE, 74, GroupLayout.PREFERRED_SIZE)
				.addPreferredGap(ComponentPlacement.RELATED)
				.addComponent(imgPotes, GroupLayout.DEFAULT_SIZE, 464, Short.MAX_VALUE).addGap(18)
				.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createSequentialGroup()
								.addComponent(label, GroupLayout.PREFERRED_SIZE, 23, GroupLayout.PREFERRED_SIZE)
								.addPreferredGap(ComponentPlacement.RELATED)
								.addComponent(label_1, GroupLayout.PREFERRED_SIZE, 18, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
								.addComponent(codigoProduto, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
										GroupLayout.PREFERRED_SIZE)
								.addComponent(btnBuscar)))
				.addPreferredGap(ComponentPlacement.RELATED)
				.addComponent(textDescricao, GroupLayout.PREFERRED_SIZE, 96, GroupLayout.PREFERRED_SIZE)
				.addContainerGap()));
		contentPane.setLayout(gl_contentPane);

	}
}
