package linkedlistassignment;


/**
 * Superclass of all entities that can be placed in rooms and interacted with by the Player.
 * 
 * @author Richard Thomas <richard.thomas@uq.edu.au>
 *
 */
public class TestObject {
	private String description;
	
	public TestObject(String description) {
		this.description = description;
	}
	
	@Override
	public String toString() {
		return description;
	}
}
