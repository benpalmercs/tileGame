
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class BoardDisplay implements ActionListener{
    private JButton[] spaces;
    private JFrame frame;
    private JPanel panel;
    private Board board;

    public BoardDisplay(){
        board = new Board();
        frame = new JFrame();
        panel = new JPanel();
        panel.setBorder(BorderFactory.createEmptyBorder(30, 30, 30, 30));
        panel.setLayout(new GridLayout(3,3));
        Font buttonFont = new Font("Arial",Font.PLAIN,40);
        spaces = new JButton[9];
        for(int i = 0; i < 9; i++){
            spaces[i] = new JButton(""+i);
            spaces[i].setFont(buttonFont);
            spaces[i].addActionListener(this);
            panel.add(spaces[i]);
        }

        frame.add(panel, BorderLayout.CENTER);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setTitle("My GUI");
        frame.pack();
        frame.setVisible(true);
        frame.setSize(500,500);

        
    }

    public void updateBoard(){
        for(int i = 0;i<9;i++){
            spaces[i].setText(""+board.getBoard()[i/3][i%3]);
            if(spaces[i].getText().equals("0")){
                spaces[i].setBackground(Color.WHITE);
            }
            else{
                spaces[i].setBackground(Color.BLUE);
            }
        }
    }

    public void scramble(){
        board.scrambleBoard();
    }

    public Boolean hasWonGame(){
        return board.hasWon();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        Object source = e.getSource();
        for(int i = 0; i<9;i++){
            if(source==spaces[i]){
                board.moveTile(i/3,i%3);
                this.updateBoard();
                break;
            }
        }
    }
}
