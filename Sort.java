import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JTextArea;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Arrays;
import javax.swing.JLabel;
public class Sort {

	private JFrame frame;
	private JTextField input;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Sort window = new Sort();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Sort() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("\u8F93\u5165\u6570\u7EC4\u5185\u5BB9\uFF0C\u6BCF\u4E2A\u6570\u5B57\u4EE5\u7A7A\u683C\u9694\u5F00");
		lblNewLabel.setBounds(0, 5, 424, 26);
		frame.getContentPane().add(lblNewLabel);
		
		input = new JTextField();
		input.setBounds(0, 40, 424, 26);
		frame.getContentPane().add(input);
		input.setColumns(10);

		JTextArea output = new JTextArea();
		output.setBounds(0, 99, 424, 152);
		frame.getContentPane().add(output);
		
		JButton array = new JButton("\u6392\u5E8F");
		array.setBounds(24, 76, 93, 23);
		frame.getContentPane().add(array);
		int[] x = {};
		array.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				if(e.getSource()==array){
					output.setText("");
					String str = input.getText();
					String[] str1 = str.split(" ");
					int[] array = new int[str1.length];
					for(int i=0;i<str1.length;i++){
						array[i] = Integer.valueOf(str1[i]);
					}
					Arrays.sort(array);
					for(int i=0;i<array.length;i++){
						output.append(array[i]+"   ");
					}
					input.setText("");
				}
			}
		});
		
		JButton reserve = new JButton("\u53CD\u8F6C");
		reserve.setBounds(315, 76, 93, 23);
		frame.getContentPane().add(reserve);
		reserve.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				if(e.getSource()==reserve){
					output.setText("");
					String str = input.getText();
					String[] str1 = str.split(" ");
					int[] array = new int[str1.length];
					for(int i=0;i<str1.length;i++){
						array[i] = Integer.valueOf(str1[i]);
					}
					for(int j=0;j<array.length/2;j++){
						int temp = array[j];
						array[j] = array[array.length-j-1];
						array[array.length-j-1] = temp;
					}
					for(int k=0;k<array.length;k++){
						output.append(array[k]+"   ");
					}
					input.setText("");
				}
			}
		});
	}
}
