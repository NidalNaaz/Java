import java.util.Scanner;

public class SquareMatrix extends Matrix 
{
    public SquareMatrix( int c ) 
    {
        super( c , c ) ;
        Scanner sqMatrix = new Scanner( System.in ) ;
        System.out.println("Enter the elements of the matrix: " ) ;
        for ( int i = 0 ; i < c ; i++ ) 
        {
            for ( int j = 0 ; j < c ; j++ )
            {
                getData( )[ i ][ j ] = sqMatrix.nextDouble( ) ;
            }
        }
    }

    public boolean isSymmetric( ) 
    {
        for ( int i = 0 ; i < getRows( ) ; i++ ) 
        {
            for ( int j = 0 ; j < getColumns ( ) ; j++ ) 
            {
                if (getData( ) [ i ][ j ] != getData( )[ j ][ i ])
                {
                    return false ;
                }
            }
        }

        return true ;
    }

    public boolean isSkew( )
    {
        for ( int i = 0 ; i < getRows( ) ; i++ )  
        {
            for ( int j = 0 ; j < getColumns( ) ; j++ )
            {
                if ( i != j && getData( ) [ i ][ j ] != -getData( )[ j ][ i ] ) 
                {
                    return false ;
                } 
                else if ( i == j && getData( )[ i ][ j ] != 0 )
                {
                    return false ;
                }
            }
        }

        return true ;
    }

    public double findTrace( ) 
    {
        double trace = 0 ;
        for ( int i = 0 ; i < getRows( ) ; i++ ) 
        {
            trace += getData( )[ i ][ i ] ;
        }
        return trace ;
    }
}
