package lightsout;

import org.junit.Assert;
import org.junit.Test;

public class LightsOutTest {
	// LightsOut can be instantiated at a size of one or greater. All
	// lights should start unlit.
	@Test
	public void instantiate(){
		
	}
	
	// getSize should return the same size provided to the constructor.
	@Test
	public void canGetSize(){
		
	}
	
	// press should toggle the lights at the location pressed and at the
	// four adjacent squares.
	@Test
	public void canPress(){
		
	}
	
	// press should throw an index out of bounds exception should it be
	// used outside the range 0 to getSize()-1 for both rows and columns.
	@Test(expected=IndexOutOfBoundsException.class)
	public void pressIndexOutOfBounds(){
		
	}
	
	// press should not throw an exception just because one of the adjacent
	// squares is out of bounds.
	@Test
	public void pressOutOfRangeNoException(){
		
	}
	
	// forceLit should change the liat state of the location properly
	@Test
	public void canForceLit(){
		
	}
}
