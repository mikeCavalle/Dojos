package com.houston;

/**
 * Tic Tac Toe application runner.<br>
 * date: 12.6.2011
 * 
 * @author heikki
 */
public class App {

	public static void main(String [] args){
		TicTacToe game = new TicTacToe(400, 450);
		game.execute();
	}
}