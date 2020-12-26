package CruxOnline.GameDevelopment;

import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class TicTacToe extends JFrame implements ActionListener {

	public static final int BOARD_SIZE = 3;

	public JButton[][] board = new JButton[BOARD_SIZE][BOARD_SIZE];

	public boolean crossTurn = true;

	public static enum GameStatus {
		Incomplete, XWins, ZWins, Tie
	}

	public TicTacToe() {
		super.setTitle("TicTacToe");
		super.setSize(800, 800);
		GridLayout grid = new GridLayout(BOARD_SIZE, BOARD_SIZE);
		super.setLayout(grid);
		super.setResizable(false);
		super.setVisible(true);

		Font font = new Font("Comic Sans", 1, 150);

		for (int row = 0; row < BOARD_SIZE; row++) {
			for (int col = 0; col < BOARD_SIZE; col++) {

				JButton button = new JButton("");
				board[row][col] = button;

				button.setFont(font);
				button.addActionListener(this);
				super.add(button);
			}
		}

	}

	@Override
	public void actionPerformed(ActionEvent e) {

		JButton button = (JButton) e.getSource();
		makeMove(button);
		GameStatus gs = this.getGameStatus();

		if (gs == GameStatus.Incomplete)
			return;
		declareWinner(gs);

		int choice = JOptionPane.showConfirmDialog(this, "Do you want to play Again?");
		if (choice == JOptionPane.OK_OPTION) {
			for (int row = 0; row < BOARD_SIZE; row++) {
				for (int col = 0; col < BOARD_SIZE; col++) {
					board[row][col].setText("");
				}
			}
			crossTurn = true;
		} else {
			super.dispose();
		}

	}

	private void makeMove(JButton button) {
		String btnTxt = button.getText();

		if (btnTxt.length() > 0) {
			JOptionPane.showMessageDialog(this, "Invalid Move");
		} else {
			if (crossTurn) {
				button.setText("X");
			} else {
				button.setText("0");
			}
			crossTurn = !crossTurn;
		}
	}

	private GameStatus getGameStatus() {

		String text1 = "", text2 = "";

		// Inside the row
		int row, col;

		row = 0;
		while (row < BOARD_SIZE) {
			col = 0;
			while (col < BOARD_SIZE - 1) {
				text1 = board[row][col].getText();
				text2 = board[row][col + 1].getText();

				if (!text1.equals(text2) || text1.length() == 0)
					break;

				col++;
			}

			if (col == BOARD_SIZE - 1) {
				if (text1.equals("X"))
					return GameStatus.XWins;
				else
					return GameStatus.ZWins;
			}

			row++;
		}

		// Inside the columns
		col = 0;
		while (col < BOARD_SIZE) {
			row = 0;
			while (row < BOARD_SIZE - 1) {
				text1 = board[row][col].getText();
				text2 = board[row + 1][col].getText();

				if (!text1.equals(text2) || text1.length() == 0)
					break;

				row++;
			}

			if (row == BOARD_SIZE - 1) {
				if (text1.equals("X"))
					return GameStatus.XWins;
				else
					return GameStatus.ZWins;
			}

			col++;
		}

		// Along the dialog
		row = 0;
		col = 0;
		while (col < BOARD_SIZE - 1) {
			text1 = board[row][col].getText();
			text2 = board[row + 1][col + 1].getText();

			if (!text1.equals(text2) || text1.length() == 0)
				break;

			row++;
			col++;
		}

		if (row == BOARD_SIZE - 1) {
			if (text1.equals("X"))
				return GameStatus.XWins;
			else
				return GameStatus.ZWins;
		}

		// Along second diagonal
		row = BOARD_SIZE - 1;
		col = 0;

		while (row > 0) {
			text1 = board[row][col].getText();
			text2 = board[row - 1][col + 1].getText();

			if (!text1.equals(text2) || text1.length() == 0)
				break;

			row--;
			col++;
		}

		if (row == 0) {
			if (text1.equals("X"))
				return GameStatus.XWins;
			else
				return GameStatus.ZWins;
		}

		// Checking if the game is incomplete
		String txt = "";

		for (row = 0; row < BOARD_SIZE; row++) {
			for (col = 0; col < BOARD_SIZE; col++) {
				txt = board[row][col].getText();

				if (txt.length() == 0)
					return GameStatus.Incomplete;
			}
		}

		return GameStatus.Tie;
	}

	private void declareWinner(GameStatus gs) {
		
		if(gs==GameStatus.XWins) {
			JOptionPane.showMessageDialog(this, "Cross Wins");
		}else if(gs==GameStatus.ZWins) {
			JOptionPane.showMessageDialog(this, "Zero Wins");
		}else{
			JOptionPane.showMessageDialog(this, "It's a Tie");
		}
		
	}

}
