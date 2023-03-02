import java.awt.*;
import java.awt.event.*;
import java.util.*;
import javax.swing.*;

public class TicTacTaoe implements ActionListener
{
    Random random = new Random();
    JFrame frame = new JFrame();
    JPanel title_panel= new JPanel();
    JPanel button_panel= new JPanel();
    JLabel textfield = new JLabel();
    JButton[] button= new JButton[9];
    boolean player1_turn;
    
    TicTacTaoe()
    {
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setSize(800,800);
            frame.getContentPane().setBackground(new Color(50,50,50));
            frame.setLayout(new BorderLayout());
            frame.setVisible(true);

            textfield.setBackground(new Color(25,25,25));
            textfield.setForeground(Color.white);
            textfield.setFont(new Font("Times New Romans",Font.BOLD,75));
            textfield.setHorizontalAlignment(JLabel.CENTER);
            textfield.setText("Tic-Tac-Toe");
            textfield.setOpaque(true);

            title_panel.setLayout(new BorderLayout());
            title_panel.setBounds(0,0,800,100);
            
            button_panel.setLayout(new GridLayout(3,3));
            button_panel.setBackground(new Color(150,150,150));
            
            for(int i=0; i<9; i++)
            {
                button[i]= new JButton();
                button_panel.add(button[i]);
                button[i].setFont(new Font("My Boli",Font.BOLD,120));
                button[i].setFocusable(false);
                button[i].addActionListener(this);
            }

            title_panel.add(textfield);
            frame.add(title_panel,BorderLayout.NORTH);
            frame.add(button_panel);

            firstTurn();
        }
        public void firstTurn()
        {   
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
            if(random.nextInt(2)==0)
            {
                player1_turn=true;
                textfield.setText("Player 1");
            }
            else
            {
                player1_turn=false;
                textfield.setText("Player 2");
            }
        }
        
        public void check()
        {
                    if((button[0].getText()=="X")&&
                       (button[1].getText()=="X")&&
                       (button[0].getText()=="X"))
                       {
                        xWins(0, 1, 2);
                       }
                    if((button[3].getText()=="X")&&
                       (button[4].getText()=="X")&&
                       (button[5].getText()=="X"))
                       {
                        xWins(3, 4, 5);
                       }  
                    if((button[6].getText()=="X")&&
                       (button[7].getText()=="X")&&
                       (button[8].getText()=="X"))
                       {
                        xWins(6, 7, 8);
                       }
                    if((button[0].getText()=="X")&&
                       (button[3].getText()=="X")&&
                       (button[6].getText()=="X"))
                       {
                        xWins(0, 3, 6);
                       }       
                    if((button[1].getText()=="X")&&
                       (button[4].getText()=="X")&&
                       (button[7].getText()=="X"))
                       {
                        xWins(1, 4, 7);
                       }  
                    if((button[2].getText()=="X")&&
                       (button[5].getText()=="X")&&
                       (button[8].getText()=="X"))
                       {
                        xWins(2, 5, 8);
                       } 
                    if((button[0].getText()=="X")&&
                       (button[4].getText()=="X")&&
                       (button[8].getText()=="X"))
                       {
                        xWins(0, 4, 8);
                       }  
                    if((button[2].getText()=="X")&&
                       (button[4].getText()=="X")&&
                       (button[6].getText()=="X"))
                       {
                        xWins(2, 4, 6);
                       }
                    if((button[0].getText()=="O")&&
                       (button[1].getText()=="O")&&
                       (button[0].getText()=="O"))
                       {
                        oWins(0, 1, 2);
                       }
                    if((button[3].getText()=="O")&&
                       (button[4].getText()=="O")&&
                       (button[5].getText()=="O"))
                       {
                        oWins(3, 4, 5);
                       }  
                    if((button[6].getText()=="O")&&
                       (button[7].getText()=="O")&&
                       (button[8].getText()=="O"))
                       {
                        oWins(6, 7, 8);
                       }
                    if((button[0].getText()=="O")&&
                       (button[3].getText()=="O")&&
                       (button[6].getText()=="O"))
                       {
                        oWins(0, 3, 6);
                       }       
                    if((button[1].getText()=="O")&&
                       (button[4].getText()=="O")&&
                       (button[7].getText()=="O"))
                       {
                        oWins(1, 4, 7);
                       }  
                    if((button[2].getText()=="O")&&
                       (button[5].getText()=="O")&&
                       (button[8].getText()=="O"))
                       {
                        oWins(2, 5, 8);
                       } 
                    if((button[0].getText()=="O")&&
                       (button[4].getText()=="O")&&
                       (button[8].getText()=="O"))
                       {
                        oWins(0, 4, 8);
                       }  
                    if((button[2].getText()=="O")&&
                       (button[4].getText()=="O")&&
                       (button[6].getText()=="O"))
                       {
                        oWins(2, 4, 6);
                       }  
        }
        
        public void xWins(int a, int b, int c)
        {
            button[a].setBackground(Color.yellow);
            button[b].setBackground(Color.yellow);
            button[c].setBackground(Color.yellow);
            for(int i=0; i<9; i++)
            {
                button[i].setEnabled(false);
            }
            textfield.setText("Player 1 Wins");
        }
        
        public void oWins(int a, int b, int c)
        {
            button[a].setBackground(Color.yellow);
            button[b].setBackground(Color.yellow);
            button[c].setBackground(Color.yellow);
            for(int i=0; i<9; i++)
            {
                button[i].setEnabled(false);
            }
            textfield.setText("Player 2 Wins");
        }
        
        
    
    
    
    @Override
    public void actionPerformed(ActionEvent e) {
        for(int i=0;i<9;i++)
        {
            if(e.getSource()==button[i])
            {
                if(player1_turn)
                {
                    if(button[i].getText()=="")
                    {
                        button[i].setForeground(Color.BLACK);
                        button[i].setText("X");
                        player1_turn=false;
                        textfield.setText("Player 2");
                        check();
                    }
                }
                else
                {
                    if(button[i].getText()=="")
                    {
                        button[i].setForeground(Color.RED);
                        button[i].setText("O");
                        player1_turn=true;
                        textfield.setText("Player 1");
                        check();
                    }
                }
            }
        }
        
    }
}