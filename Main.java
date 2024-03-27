import java.util.Scanner;

public class Main {
    public static void main ( String[ ] args ) 
    {
        //Matrix matrix0 = new Matrix() ;
//
        //System.out.println("Enter the elements of matrix, space seperated: ") ;
        //String string = args[matrix0.getColumns()*matrix0.getRows()] ;
//
        //matrix0.spaceSeperated(string);

        System.out.println("Matrix 1: " ) ;
        Matrix matrix1 = new Matrix( ) ;
        matrix1.setElements( ) ;
        

        System.out.println("Matrix 2:" ) ;
        Matrix matrix2 = new Matrix( ) ;
        matrix2.setElements( ) ;

        Matrix matrix3 = new Matrix( matrix1.getRows( ) , matrix1.getColumns( ) ) ;
        matrix3 = matrix3.addMatrix( matrix1, matrix2 ) ;

        System.out.println("Adding the elements:" ) ;
        matrix3.getElements( ) ;

        Matrix matrix4 = new Matrix( matrix1.getRows( ) , matrix1.getColumns( ) ) ;
        matrix4 = matrix4.diffMatrix ( matrix1 , matrix2 ) ;

        System.out.println("Subtracting the elements:" ) ;
        matrix4.getElements( ) ;

        Matrix matrix5 = new Matrix ( matrix1.getRows( ) , matrix2.getColumns( ) ) ;
        matrix5 = matrix5.productMatrix ( matrix1 , matrix2 ) ;

        System.out.println("Multiplying the matrices:" ) ;
        matrix5.getElements( ) ;

        Matrix matrix6 = new Matrix ( matrix1.getColumns( ) , matrix1.getRows( ) ) ; 
        matrix6 = matrix6.transpose( matrix1 ) ;

        System.out.println("Transpose of the given matrix:" ) ;
        matrix6.getElements( ) ;

        String value = matrix6.elementString( matrix1 ) ;
        System.out.println("String Elements:" ) ;
        System.out.println ( value ) ;

        
        Scanner scanner = new Scanner ( System.in ) ;
        System.out.println("Enter the row number to add:" ) ;
        int rowToAdd = scanner.nextInt( ) ;
        matrix1.addRowElements( rowToAdd ) ;

        System.out.println("Enter the column number to add:" ) ;
        int colToAdd = scanner.nextInt( ) ;
        matrix1.addColumnElements( colToAdd ) ;

        System.out.println("Average of all elements in Matrix 1:" ) ;
        matrix1.averageElements( ) ;

        System.out.println("Check if Matrix is diagonal:" ) ;
        System.out.println( matrix1.checkDiagonal( ) ) ;

        System.out.println("CHILD CLASS: " ) ;
        System.out.println("Enter the dimension for the square matrix:" ) ;
        int dimension = scanner.nextInt( ) ;
        SquareMatrix squareMatrix = new SquareMatrix( dimension ) ;

        System.out.println("Is the square matrix symmetric? " + squareMatrix.isSymmetric( ) ) ;
        System.out.println("Is the square matrix skew symmetric? " + squareMatrix.isSkew( ) ) ;

        //System.out.println( "Is the square matrix singular? " + squareMatrix.isSingular( ) ) ;
        //System.out.println( "Determinant of the square matrix: " + squareMatrix.determinant( ) ) ;
        
        System.out.println( "Trace of the square matrix: " + squareMatrix.findTrace( ) ) ;

        System.out.println( "CHILD OF CHILD: " ) ;
        DiagonalMatrix diagonalMatrix = new DiagonalMatrix(dimension, null) ;
        diagonalMatrix.DGelements( ) ;
    }
}
