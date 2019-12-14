/**
 * 
 */
package genePlay;

/**
 * @author bourk
 *
 */
import java.util.Random;

public class TestSubject {
	
	private int[] eyeColour = new int[4];
	private int[] hairColour = new int[4];
	Random ran = new Random();
	int colour1 = 0;
	int colour2 = 1;

	public TestSubject(){
		for(int i = 0; i<4; i++){
			int choice = ran.nextInt(2);
			eyeColour[i] = choice;
			}
		for(int i = 0; i<4; i++){
			int choice = ran.nextInt(2);
			hairColour[i] = choice;
			}
		}

	public TestSubject(int[] eyeColour){
		this.eyeColour = eyeColour;
		}
	
	public TestSubject(int[] eyeColour, int[] hairColour) {
		this.eyeColour = eyeColour;
		this.hairColour = hairColour;
	}
	

	public void displayEyeColour(){
		System.out.println(eyeColour.toString());
		}

	public int[] getEyeColour(){
		return eyeColour;
		}
	
	public int[] getHairColour() {
		return hairColour;
		}
}
