import java.util.Scanner;

public class DiagonalMatrix extends SquareMatrix
{
    public DiagonalMatrix ( int s , double[ ] v ) 
    {
        super() ;
        Scanner dgMatrix = new Scanner( System.in ) ;
        System.out.println("Enter the diagonal elements of the matrix: " ) ;

        for ( int i = 0 ; i < s ; i++ ) 
        {
            for ( int j = 0 ; j < s ; j++ )
            {
                if ( i == j )
                {
                    getData( )[ i ][ i ] = dgMatrix.nextDouble( ) ;
                }
                else
                {
                    getData( )[ i ][ j ] = 0 ;
                }
            }
        }
    }

    public void DGelements () 
    {
        for ( int i = 0 ; i < getRows( ) ; i++ ) 
        {
            for ( int j = 0 ; j < getColumns ( ) ; j++ ) 
            {
                System.out.print( getData( )[ i ][ j ] );
            }
        }
    }
}