package test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.Before;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import main.*;


class PlayRoomTest {
	
	private PlayRoom pr;
	private Trunk mytrunk;
	private int[] location;


    @BeforeEach
    public void setUp() {  
         this.mytrunk= new Trunk(300); 
         this.location = new int[] {30,80,110,160,250};

    }

	@Test
	void testReturnMax() {
		pr = new PlayRoom();
		pr.playGames(5, location, mytrunk);
        double result = pr.returnMax();		
		assertEquals(54.0,result);
	}

	@Test
	void testReturnMin() {
		pr = new PlayRoom();
		pr.playGames(5, location, mytrunk);
        double result = pr.returnMin();		
		assertEquals(28.0,result);
	}

}
