import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JFrame;
import javax.swing.JTextArea;
import javax.swing.JButton;

//该方法主要是实现选择序排序法的实现，
//但是有一个地方程序有问题就是排序数组中元素交换的过程有问题
//反过来交换就有问题

public class SelectSort {

	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					SelectSort window = new SelectSort();
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
	public SelectSort() {
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
		
		JTextArea input = new JTextArea();
		input.setBounds(10, 0, 414, 87);
		frame.getContentPane().add(input);

		JTextArea output = new JTextArea();
		output.setBounds(10, 128, 414, 101);
		frame.getContentPane().add(output);
		
		JButton make = new JButton("\u751F\u6210\u968F\u673A\u6570");
		make.setBounds(137, 97, 112, 23);
		frame.getContentPane().add(make);
		int[] x = new int[6];
		make.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				if(e.getSource()==make){
					int arrays;
					
					for(int i=0;i<x.length;i++){
						arrays = (int)(Math.random()*100);
						x[i] = arrays;
					}
					for(int i=0;i<x.length;i++){
						input.append(x[i]+"    ");
					}
				}
			}
		});
		
		JButton array = new JButton("\u6570\u7EC4\u6392\u5E8F");
		array.setBounds(137, 228, 112, 23);
		frame.getContentPane().add(array);
		array.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				if(e.getSource()==array){
					int index;
					for(int i=1;i<x.length;i++){
						index = 0;
						for(int j=1;j<x.length-i;j++){
							if(x[j]>x[index]){
								index = j;
							}
						}
						int temp = x[x.length-i];
						x[x.length-i] = x[index];
						x[index] = temp;
					}
					for(int i=0;i<x.length;i++){
						output.append(x[i]+"     ");
					}
				}
			}
		});
		

		JButton reset = new JButton("\u91CD\u7F6E");
		reset.setBounds(302, 228, 93, 23);
		frame.getContentPane().add(reset);
		reset.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				if(e.getSource()==reset){
					input.setText("");
					output.setText("");
				}
			}
		});
	}
}
