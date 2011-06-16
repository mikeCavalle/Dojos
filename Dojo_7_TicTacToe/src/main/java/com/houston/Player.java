/**
 * 
 */
package com.houston;

/**
 * Player object.<br>
 * <p>
 * Description: Player object is an entity class which stores the Players "letter" and number.
 * </p>
 * date: 12.6.2011
 * @author heikki
 *
 */
public class Player {

	private String letter;
	private int number;
	
	public Player(int number, String letter) {
		super();
		this.number = number;
		this.letter = letter;
	}

	/**
	 * @return
	 */
	public String getLetter() {
		return letter;
	}

	/**
	 * @return
	 */
	public int getNumber() {
		return number;
	}

}
