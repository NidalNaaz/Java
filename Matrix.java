import java.util.Scanner ;
import java.lang.Math ;  
import java.util.Random ;
import java.util.Date ;

public class Matrix
{

    private int rows;
    private int columns;
    private double[ ][ ] data;
    private String name;
    private int uniqueID ;
    public Date creationDate ;
    private static int count = 2300 ;


    public void setRows( int rows )
    {
        this.rows = rows ;
    }

    public void setColumns( int columns )
    {
        this.columns = columns ;
    }

    public void setData( double[ ][ ] data )
    {
        this.data = data ;
    }

    public void setName( String name )
    {
        this.name = name ;
    }



    public int getColumns( )
    {
        return columns ;
    }

    public double[ ][ ] getData( )
    {
        return data ;
    }

    public int getRows( )
    {
        return rows ;
    }
    public String getName( )
    {
        return name ;
    }
     public int getID( )
    {
        return uniqueID ;
    }


    Matrix ( )
    {
        count = count + 1  ;
        uniqueID = count ;
        creationDate = new Date( ) ;

        
        System.out.println("Unique ID: " + uniqueID ) ;
        System.out.println("Creation date: " + creationDate ) ;
        System.out.println(" " ) ;


        System.out.println("Random Matrix Creation: " ) ;
        Random randomV = new Random( ) ;

        int r = ( ( int ) ( Math.random( ) * 10 ) ) + 1 ;
        int c = ( ( int ) ( Math.random( ) * 10 ) ) + 1 ;
        data = new double[ r ][ c ] ;
   
        for ( int i = 0 ; i < r ; i++ )
        {
            for  ( int j = 0; j < c ; j++ )
            {
                data[ i ][ j ] = randomV.nextInt(1000 ) ;
            }
        }

        System.out.println("The elements of the matrix: " ) ;
        System.out.println("" ) ;

        for ( int i = 0 ; i < r ; i++ )
        {
            for  ( int j = 0 ; j < c ; j++ )
            {
                System.out.print( data[ i ][ j ] + " " ) ;
            }

            System.out.println("") ;
        }
       
       
        System.out.println("") ;
        Scanner scanner = new Scanner( System.in ) ;

        System.out.print("Enter no of rows for the matrix: ") ;
        rows = scanner.nextInt( ) ;

        System.out.print("Enter no of Coulumns for the matrix: ") ;
        columns = scanner.nextInt( ) ;


        data = new double[ rows ][ columns ] ;


        for ( int i = 0 ; i < rows ; i++ )
   {
            for ( int j = 0 ; j < columns ; j++ )
       {
                data[ i ][ j ] = 0 ;
            }
        }
    }



    Matrix ( int rows , int columns )
    {
        count++ ;
        uniqueID = count ;
        creationDate = new Date( ) ;

        System.out.println("Unique ID: " + uniqueID ) ;
        System.out.println("Creation date: " + creationDate ) ;
        System.out.println(" " ) ;

        this.rows = rows ;
        this.columns = columns ;
        data = new double[ rows ][ columns ] ;
        for ( int i = 0 ; i < rows ; i++ )
     {
            for ( int j = 0 ; j < columns ; j++ )
       {
                data[ i ][ j ] = 0 ;
            }
        }
    }

    public void spaceSeperated ( String string )
    {
        Scanner sstring = new Scanner( string ) ;
  
        while ( sstring.hasNextInt( ) ) 
        {
            for ( int i = 0 ; i < rows ; i++ )
            {
                for ( int j = 0 ; j < columns ; j++ )
                {
                    data[ i ][ j ] = sstring.nextDouble( ) ; 
                }
            }
        }

        sstring.close();

        for ( int i = 0 ; i < rows ; i++ )
        {
            for ( int j = 0 ; j < columns ; j++ )
            {
                System.out.print( data[ i ][ j ] + "  " ) ; 
            }            
                System.err.println( "" );
        }
    }


    public void setElements( )
    {
        int a = 1 ;

        Scanner scans = new Scanner( System.in ) ;

        for ( int i = 0 ; i < rows ; i++ )
        {
            for  ( int j = 0 ; j < columns ; j++ )
            {
                System.out.println( "Enter " + a++ + "th element:" ) ;
                double temp = scans.nextDouble( ) ;
                data[ i ][ j ] = temp ;
            }
        }
    }


    public void getElements( )
    {
        for( int i = 0 ; i < rows ; i++ )
        {   
            for ( int j = 0 ; j < columns ; j++ )
            {
                System.out.print( data[ i ][ j ]+ " \t " ) ;
            }
            System.out.println( );
        }
    }


    public Matrix addMatrix( Matrix M1 , Matrix M2 )
    {
        Matrix result ;

        if ( M1.rows != M2.rows || M1.columns != M2.columns )  
        {
            System.out.println("Not possible to add unlike matrices. " ) ;
            result = new Matrix( 0, 0 ) ;
        }
        else
        {
            result = new Matrix( M1.rows , M1.columns ) ;
            for ( int i = 0 ; i < M1.rows ;  i++ )
            {
                for ( int j = 0 ; j < M1.columns ; j++ )
                {
                    result.data[ i ][ j ] = M1.data[ i ][ j ] + M2.data[ i ][ j ] ;
                }
            }
        }
        return result ;
    }


    public Matrix diffMatrix( Matrix M1 , Matrix M2 )
    {
        Matrix result ;
        if ( M1.rows != M2.rows || M1.columns != M2.columns )
        {
            System.out.println("Not possible to subtract unlike matrices." ) ;
            result = new Matrix( 0, 0 ) ;
        }
        else
        {
            result = new Matrix ( M1.rows , M1.columns ) ;
            for ( int i = 0 ; i < M1.rows ; i++ )
            {
                for ( int j = 0 ; j < M1.columns ; j++ )
                {
                    result.data[ i ][ j ] = M1.data[ i ][ j ] - M2.data[ i ][ j ] ;
                }
            }
        }
        return result ;
    }


    public Matrix productMatrix( Matrix M1 , Matrix M2 )
    {
        Matrix result ;
        if ( M1.columns != M2.rows )
        {
            System.out.println("Not possible to multiply unagreeing matrices. " ) ;
            result = new Matrix ( 0 , 0 ) ;
        }
        else
        {
            result = new Matrix( M1.rows, M2.columns ) ;
            for ( int i = 0 ; i < M1.rows ; i++ )
            {
                for ( int j = 0 ; j < M2.columns ; j++ )
                {
                    for ( int k = 0 ; k < M1.columns ; k++ )
                    {
                        result.data[ i ][ j ] += M1.data[ i ][ k ] * M2.data[ k ][ j ] ;
                    }
                }
            }
        }
        return result ;
    }


    public Matrix transpose ( Matrix M1 )
    {
        Matrix result = new Matrix( M1.columns , M1.rows ) ;

        for( int i = 0 ; i < result.rows ; i++ )
        {
            for ( int j = 0 ; j < result.columns ; j++ )
            {
                result.data[ i ][ j ] = M1.data[ j ][ i ] ;
            }
        }
        return result ;
    }


    public String elementString( Matrix M1 )
    {
          name = " ";
        for ( int i = 0 ; i < M1.rows ; i++ )
        {
            for ( int j = 0 ; j < M1.columns ; j++ )
            {
                String temp = String.valueOf( M1.data[ i ][ j ] ) ;
                name = name.concat( temp.concat(" ") ) ;
            }
        }
        return name;
    }

    public void addRowElements ( int  r )
    {
        if ( r > columns || r < 0 )
        {
            System.out.println("Invalid input. ") ;
        }
        else
        {
            double sum = 0 ;
            for ( int j = 0 ; j < columns ; j++ )  
            {
                 sum += data[ r - 1 ][ j ] ;
            }

            System.out.println("Sum of elements in row " + r + ": " + sum ) ;
        }
    }

    public void addColumnElements( int c )
    {
        if ( c > rows + 1 || c < 0 )
        {
            System.out.println("Invalid input. ") ;
        }
        else
        {
            double sum = 0 ;
            for ( int i = 0 ; i < rows ; i++ )
            {
                 sum += data[ i ][ c - 1 ] ;
            }

             System.out.println("Sum of elements in column " + c + ": " + sum ) ;
        }
    }

    public void averageElements( )
    {
        double sum = 0 ;
        for ( int i = 0 ; i < rows ; i++ )
        {
            for ( int j = 0 ; j < columns ; j++ )
            {
                sum += data[ i ][ j ] ;
            }
        }

        double average = sum / (rows * columns);
        System.out.println("Average of all elements: " + average);
    }

    public String checkDiagonal() {
        for ( int i = 0 ; i < rows ; i++ )
        {
            for ( int j = 0 ; j < columns ; j++ )
            {
                if ( i != j && data[ i ][ j ] != 0 )
                {
                    return "NO. The given matrix is not a diagonal matrix." ;
                }
                else if ( i == j && data[ i ][ j ] == 0 )
                {
                    return "Elements of a diagonal matrix must be non-zero." ;
                }
            }
        }
        return "YES. It is a diagonal matrix. " ;
    }
}
