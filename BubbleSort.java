import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JTextArea;
import javax.swing.JButton;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.SwingConstants;
public class BubbleSort {

	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					BubbleSort window = new BubbleSort();
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
	public BubbleSort() {
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
		
		JTextArea textArea = new JTextArea();
		textArea.setBounds(10, 0, 414, 24);
		frame.getContentPane().add(textArea);

		JTextArea output = new JTextArea();
		output.setBounds(10, 63, 414, 169);
		frame.getContentPane().add(output);
		
		JButton input = new JButton("\u751F\u6210\u968F\u673A\u6570");
		input.setHorizontalAlignment(SwingConstants.LEFT);
		input.setBounds(172, 34, 109, 23);
		frame.getContentPane().add(input);
		int[] x = new int[8];
		input.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				textArea.setText("");
				if(e.getSource()==input){
					for(int i=0;i<x.length;i++){
						x[i] = (int)(Math.random()*100);
						textArea.append(x[i]+"   ");
					}
				}
			}
		});
		
		JButton array = new JButton("\u5192\u6CE1\u6392\u5E8F\u6CD5");
		array.setHorizontalAlignment(SwingConstants.LEFT);
		array.setBounds(172, 238, 109, 23);
		frame.getContentPane().add(array);
		array.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				output.setText("");
				if(e.getSource()==array){
					for(int i=0;i<x.length-1;i++){
						for(int j=i+1;j<x.length;j++){
							if(x[i]<x[j]){
								int temp=x[j];
								x[j] = x[i];
								x[i] = temp;
							}
						}
						String str = "第"+(i+1)+"次的排序结果是：";
						output.append(str);
						for(int k=0;k<x.length;k++){
							output.append(x[k]+"   ");	
						}
						output.append("\n");
					}
				}
			}
		});
	}

}
