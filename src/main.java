
public class main {

	public static void main(String[] args) {
		Integer[][] test = {{12,2,3},{4,5,6},{7,8,9}};
		Matrix<Integer> test1 = new Matrix(test);
		test1.printMatrix();
		Integer[] vector ={4,1,2};
		
		System.out.println(test1.vectorMult(vector)[0]+" "+test1.vectorMult(vector)[1]+" "+test1.vectorMult(vector)[2]);
		
	}

}
