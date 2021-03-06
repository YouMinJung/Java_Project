import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;

public class Liberal_Arts_Required extends JFrame
{
	Data_Base D;
	
	Liberal_Arts_Required(Data_Base D)
	{
		this.D = D;
		int num=90;
		int i=0;

		setTitle("Information Of Liberal Arts Required");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		Container c = getContentPane();
		c.setLayout(null);

		JLabel la = new JLabel("<< Information Of Liberal Arts Required >>");
		la.setBounds(50, 20, 650, 40);	
		la.setFont(new Font("Jokerman", Font.ITALIC, 30));
		c.add(la);

		for(i=0; i<D.L_total; i++)
		{
			String s = D.TITLE.get(i) + " : " + D.PROFESSOR.get(i);
			int n = i;

			if(D.FIELD.get(i).equals("Liberal Arts Required"))
			{
				JButton B = new JButton(s);
				B.setBounds(120, num, 90, 30);
				c.add(B);

				B.addActionListener(new ActionListener()
				{
					public void actionPerformed(ActionEvent e)
					{
						JButton b = (JButton)e.getSource();

						if(b.getText().equals(s))
						{
							new L_Information(D, n);
						}
					}
				});

				num = num+40;
			}
		}


		JButton ok = new JButton("Exit");
		ok.setBounds(280, 400, 90, 30);
		c.add(ok);

		ok.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{
				JButton b = (JButton)e.getSource();

				if(b.getText().equals("Exit"))
				{
					dispose();
				}
			}
		});

		setSize(670, 500);
		setLocation(700, 200);
		setVisible(true);
	}
}