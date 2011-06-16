package com.houston;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.util.Arrays;

import javax.swing.JButton;

import org.hamcrest.BaseMatcher;
import org.hamcrest.Description;
import org.hamcrest.Factory;
import org.hamcrest.Matcher;
import org.hamcrest.Matchers;
import org.hamcrest.TypeSafeMatcher;
import org.jmock.Expectations;
import org.jmock.Mockery;
import org.jmock.lib.legacy.ClassImposteriser;
import org.junit.Test;


public class TicTacToeTest {

	@Test
	public void shouldMakeComputerMoveAfterPlayerHasMoved() {
		Mockery mockery = new Mockery() {{
			setImposteriser(ClassImposteriser.INSTANCE);
		}};
		
		final TicTacToePlayer player = mockery.mock(TicTacToePlayer.class);
		final ActionEvent event = mockery.mock(ActionEvent.class);
		final JButton button = mockery.mock(JButton.class);
		TicTacToe game = new TicTacToe(1,1,player) {
			@Override
			protected void setVisible() {
				
			}
		};
	
		mockery.checking(new Expectations() {{
			oneOf(player).move(with(any(int[].class))); will(returnValue(1));
			allowing(event).getSource(); will(returnValue(button));
			allowing(button).setText("X");
			allowing(button).setEnabled(false);
			
			allowing(button).setFont(with(any(Font.class)));
		}});
		
		game.execute();
		game.actionPerformed(event);
		
		mockery.assertIsSatisfied();
	}
	
	@Test
	public void shouldConvertButtonsToIntArray() {
		JButton[] buttons = buttons();
		Mockery mockery = new Mockery() {{
			setImposteriser(ClassImposteriser.INSTANCE);
		}};
		final TicTacToePlayer player = mockery.mock(TicTacToePlayer.class);
		final ActionEvent event = mockery.mock(ActionEvent.class);
		final JButton button = mockery.mock(JButton.class);
		buttons[0] = button;
		TicTacToe game = new TicTacToe(1, 1, player,buttons) {
			@Override
			protected void setVisible() {
				
			}
			
			@Override
			protected boolean checkForAWinner() {
				return false;
			}
			
			@Override
			protected boolean boardIsFull(){
				return false;
			}
		};
		
		final int[] expectedBoard = new int[] {1,0,0,0,0,0,0,0,0};
		
		mockery.checking(new Expectations() {{
			allowing(event).getSource(); will(returnValue(button));
			allowing(button).setText("X");
			allowing(button).setEnabled(false);
			allowing(button).setFont(with(any(Font.class)));
			oneOf(player).move(with(boardMatcher(expectedBoard))); will(returnValue(1));
			
		}});
		
		game.execute();
		game.actionPerformed(event);
		
		mockery.assertIsSatisfied();

	}

	private JButton[] buttons() {
		JButton buttons[] = new JButton[9];
		for (int i = 0; i < buttons.length; i++) {
			buttons[i] = new JButton();
		}
		return buttons;
	}
	
	@Factory
	public BoardMatcher boardMatcher(int[] expectedModel) {
	    return new BoardMatcher(expectedModel);
	}

	
	protected class BoardMatcher extends TypeSafeMatcher<int[]> {
		
		private final int[] expectedBoard;

		public BoardMatcher(int[] expectedModel) {
			this.expectedBoard = expectedModel;
		}

		@Override
		public void describeTo(Description arg0) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public boolean matchesSafely(int[] arg0) {
			return Arrays.equals(arg0, expectedBoard);
		}

	}
}
