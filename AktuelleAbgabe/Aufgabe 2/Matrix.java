
public class Matrix<T extends Number> {
	public Matrix(T[][] matrix) {
		boolean squareMatrix = true;
		for(int i = 0; i<matrix.length;i++){
			if(matrix.length!=matrix[i].length){
				squareMatrix = false;
				break;
			}
		}
		if(squareMatrix = true){
			this.matrix = matrix;
		}else{
			this.matrix = null;
		}
	}

	public T[][] matrix;
	
	public void printMatrix(){
		for(int i = 0; i<this.matrix.length;i++){
			for(int j = 0; j < this.matrix.length; j++){
				System.out.print(matrix[i][j]+" ");
			}
		System.out.println();	
		}
	}
	public double[] vectorMult(T[] vector){
		double[] newVector = new double[this.matrix.length];
		for(int i = 0; i < vector.length;i++){
			newVector[i]=0;
		}
		if(vector.length == this.matrix.length){
			for(int i = 0; i < vector.length; i++){
				for(int j = 0 ; j<vector.length;j++){
					newVector[i]=newVector[i]+(Double.parseDouble(vector[j].toString())*Double.parseDouble(matrix[i][j].toString()));
				}
				//System.out.println(newVector[i]);
			}
		}		return newVector;
	}
	
}
