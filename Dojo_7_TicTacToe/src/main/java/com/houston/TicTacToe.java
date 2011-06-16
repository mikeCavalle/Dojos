/**
 * 
 */
package com.houston;

import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

/**
 * GUI and Game Logic class.<br>
 * <p>
 * Description: http://en.wikipedia.org/wiki/Tic-tac-toe
 * </p>
 * date: 12.6.2011
 * @author heikki
 *
 */
public class TicTacToe implements ActionListener {

	private static final String GAME_TITLE = "Tic-Tac-Toe";
	private static final int NUMBER_OF_SQUARES = 9;

	private int[][] winningSquares = new int[][] { 
			{ 0, 1, 2 }, { 3, 4, 5 }, { 6, 7, 8 }, 
			{ 0, 3, 6 }, { 1, 4, 7 }, { 2, 5, 8 },
			{ 0, 4, 8 }, { 2, 4, 6 }
	};
	
	private JFrame window = new JFrame(GAME_TITLE);
	private JButton buttons[] = new JButton[NUMBER_OF_SQUARES];
	
	private PlayerPool playerPool;
	private boolean win = false;
	
	private int xdim;
	private int ydim;
	private TicTacToePlayer computerPlayer;
	private int[] board = new int[NUMBER_OF_SQUARES];
	
	public TicTacToe(int xdim, int ydim) {
		
		this.xdim = (xdim >= 0) ? xdim : 300;
		this.ydim = (ydim >= 0) ? ydim : 300;
	}
	
	public TicTacToe(int i, int j, TicTacToePlayer computerPlayer) {
		this.computerPlayer = computerPlayer;
	}
	
	public TicTacToe(int i, int j, TicTacToePlayer computerPlayer, JButton[] buttons) {
		this.computerPlayer = computerPlayer;
		this.buttons = buttons;
	}

	public void execute() {
		
		configureTheBoard();
		
		playerPool = new PlayerPool.Builder().addPlayer("X").addPlayer("Y").build();
		
		for (int i = 1; i < buttons.length; i++) {
			buttons[i] = new JButton();
			window.add(buttons[i]);
			buttons[i].addActionListener(this);
		}
		
		setVisible();
	}

	
	public void actionPerformed(ActionEvent a) {
		
		Player player = playerPool.getNextPlayer();
		
		JButton pressedButton = (JButton) a.getSource();
		pressedButton.setFont(new Font("Helvetica", Font.BOLD, 25));
		pressedButton.setText(player.getLetter());
		pressedButton.setEnabled(false);
		
		for (int i = 0; i < buttons.length; i++) {
			if (buttons[i] == pressedButton) {
				board[i] = player.getNumber();
				break;
			}
		}

		win = checkForAWinner();

		if (win == true) {
			JOptionPane.showMessageDialog(null, "Player: " + player.getNumber() + " wins the game!");
			System.exit(0);
		} else if (boardIsFull()) {
			JOptionPane.showMessageDialog(null, "The game is tie!");
			System.exit(0);
		}

		computerPlayer.move(board);
	}

	/**
	 * Iterate through the table searching for non-empty squares.
	 * 
	 * @return false if empty squares are found, otherwise true
	 */
	protected boolean boardIsFull() {
		for (int i = 0; i < buttons.length; i++){
			if (buttons[i].getText().isEmpty()) {
				return false;
			}
		}
		
		return true;
	}
	
	/*
	 * Set up the board dimensions and GUI functionality 
	 */
	private void configureTheBoard() {
		window.setSize(xdim, ydim);
		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		int numberOfSquarePerDimension = (int) Math.sqrt(NUMBER_OF_SQUARES);
		window.setLayout(new GridLayout(numberOfSquarePerDimension, numberOfSquarePerDimension));
	}
	
	/*
	 * Check for the winner by iterating through the squares with winning combinations and 
	 * checking if a all the letter in the squares equal each other.
	 * 
	 * @return true if a winning combination is found, otherwise false 
	 */
	protected boolean checkForAWinner() {
		for (int i = 0; i < winningSquares.length; i++) {
			if (buttons[winningSquares[i][0]].getText().equals(
					buttons[winningSquares[i][1]].getText())
						&& buttons[winningSquares[i][1]].getText().equals(
							buttons[winningSquares[i][2]].getText())
								&& !buttons[winningSquares[i][0]].getText().isEmpty()) {
				return true;
			}
		}
		
	return false;	
	}
	
	protected void setVisible() {
		window.setVisible(true);
	}
	
}
