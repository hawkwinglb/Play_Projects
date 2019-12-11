/**
 * 
 */
package genePlay;

/**
 * @author bourk
 *
 */
import java.util.Random;

public class NewGeneration {
	

	
	private TestSubject parent1;
	private TestSubject parent2;
	int[] eyeColour1;
	int[] eyeColour2;
	int[] eyeColourNew = new int[4];
	private TestSubject child;


	public NewGeneration(TestSubject parent1, TestSubject parent2){
		this.parent1 = parent1;
		this.parent2 = parent2;
		}

	public void createNewSubject(){
		eyeColour1 = parent1.getEyeColour();
		eyeColour2 = parent2.getEyeColour();
		Random ran = new Random();

		for(int i = 0; i<2; i++){
			int choice = ran.nextInt(3);
			eyeColourNew[i] = eyeColour1[choice];
			}
		for (int i = 2; i<4; i++){
			int choice = ran.nextInt(3);
			eyeColourNew[i] = eyeColour2[choice];
			}

		child = new TestSubject(eyeColourNew);
		}

	public TestSubject getChild(){
		return child;
		}



}
