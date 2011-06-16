/**
 * 
 */
package com.houston;

import java.util.ArrayList;
import java.util.List;

/**
 * Pool of Players.<br>
 * <p>
 * Description: Immutable storage for a number of players (limited to 2^31-1) objects and keep track turns of the players.
 * </p>
 * date: 12.6.2011
 * @author heikki
 * @see Player
 *
 */
public class PlayerPool {
	
	List<Player> players = new ArrayList<Player>();
	private int activePlayerNum;
	
	/**
	 * <p>
	 * Chain(able) builder pattern for creation of immutable PlayerPool.
	 * </p>
	 * <i>
	 * usage: PlayerPool.Builder().addPlayer("X").build();
	 * </i>
	 */
	public static class Builder {
		
		private List<Player> players = new ArrayList<Player>();
		private int count = 1;
		
		public Builder addPlayer(String key) { 
			Player player = new Player(count, key);
			players.add(player);
			count++;
			return this; 
		}
		
		public PlayerPool build(){
			return new PlayerPool(this);
		}
	}
	
	private PlayerPool(Builder builder){
		this.players = builder.players;
		activePlayerNum = 0;
	}
	
	
	/**
	 * Return the next player from the player pool.
	 * 
	 * @return the next Player in the sequence
	 * @see Player
	 */
	public Player getNextPlayer() {
		Player player = players.get(activePlayerNum);
		activePlayerNum = (++activePlayerNum >= players.size()) ? 0 : activePlayerNum;
		
		return player;
	}

}
