import java.util.Scanner ;
import java.lang.Math ;  
import java.util.Random ;

public class Matrix
{
    private int row ;
    private int coulumn ;
    private double[ ][ ] value ;

    int i , j ;

    public void setElements ( int r , int c )
    {
        row = r ;
        coulumn = c ;
        value = new double[ r ][ c ] ;


        System.out.println("Enter the elements of the matrix: " ) ;

        for ( i = 0 ; i < row ; i++ )
        {
            for  ( j = 0; j < coulumn ;j++ )
            {
                Scanner matrix = new Scanner ( System.in ) ;
                value[ i ][ j ] = matrix.nextDouble( ) ;
            }
        }
    }



    public void getElements ()
    {
        System.out.println("The elements of the matrix: " ) ;
        System.out.println("" ) ;

        for ( i = 0 ; i < row ; i++ )
        {
            for  ( j = 0 ; j < coulumn ; j++ )
            {
                System.out.print( value[ i ][ j ] + " " ) ;
            }

            System.out.println("") ;
        }

        System.out.println("" ) ;
    }



    public void transpose ()
    {
        System.out.print( "The transpose of matrix: " ) ;
        System.out.println("" ) ;

        for ( j = 0 ; j < coulumn ; j++ )
        {
            for  ( i = 0 ; i < row ; i++ )
            {
                System.out.print( value[ i ][ j ] + " " ) ;
            }

            System.out.println("") ;
        }
        System.out.println("" ) ;
    }



    public void stringElements ()
    {
        System.out.print( "The elements of matrix as string: " );
        System.out.println("" );

        for ( i = 0 ; i < row ; i++ )
        {
            for ( j = 0 ; j < coulumn ; j++ )
                {
                    System.out.print( String.valueOf(value[i][j]) + " " ) ;
                }

            System.out.println("") ;
        }
        System.out.println("" );
    }

    public void addElements ( Matrix M2 ) 
    {
        M2.setElements( row, coulumn ) ;

        for ( i = 0 ; i < row ; i++ )
        {
            for ( j = 0 ; j < coulumn ; j++ )
                {
                    System.out.print( value[i][j] + M2.value[i][j] + " ") ;
                }

            System.out.println("") ;
        }
        System.out.println("" );

    }

    public void subtractElements ( Matrix M3 ) 
    {
        M3.setElements( row, coulumn ) ;

        for ( i = 0 ; i < row ; i++ )
        {
            for ( j = 0 ; j < coulumn ; j++ )
                {
                    System.out.print( value[i][j] - M3.value[i][j] + " ") ;
                }

            System.out.println("") ;

        }
        System.out.println("" );

    }


    public void multiplyElements ( Matrix M2 ) 
    {
        M2.setElements( row, coulumn ) ;
        int k = 0 ;

        for ( int i = 0 ; i < row ; i++ )
        {
            
            for ( k = 0 ; k < coulumn ;k++ ) 
            {
                double sum = 0 , p ;

                for ( j = 0 ; j < coulumn ; j++ )
                {
                    p = value[i][j] * M2.value[j][k] ;
                    sum = sum + p ;
                }

                System.out.print(sum + " " ) ;
            }
            System.out.println(" " ) ;
        }
    }


        
    
    public Matrix ( )
    {
        Random randomV = new Random();

        int r = ( ( int ) ( Math.random( ) * 10 ) ) + 1 ;
        int c = ( ( int ) ( Math.random( ) * 10 ) ) + 1 ;
        value = new double[ r ][ c ] ;
    
        for ( i = 0 ; i < r ; i++ )
        {
            for  ( j = 0; j < c ; j++ )
            {
                value[i][j] = randomV.nextInt(1000);
            }
        }

        System.out.println("The elements of the matrix: " ) ;
        System.out.println("" ) ;

        for ( i = 0 ; i < r ; i++ )
        {
            for  ( j = 0 ; j < c ; j++ )
            {
                System.out.print( value[ i ][ j ] + " " ) ;
            }

            System.out.println("") ;
        }
    }


    public void addRowElements ( int r ) 
    {
        double sum = 0 ;

        for ( j = 0 ; j < coulumn ; j++ )
        {
            sum = sum + value[r-1][j] ;
        }
        System.out.println(sum);
    }

    public void addCoulumnElements ( int c ) 
    {
        double sum = 0 ;

        for ( i = 0 ; i < row ; i++ )
        {
            sum = sum + value[i][c-1] ;
        }
        System.out.println(sum);
    }


    public void averageElements ( ) 
    {
        double sum = 0 ;

        for ( i = 0 ; i < row ; i++ )
        {
            for ( j = 0 ; j < coulumn ; j++ )
                {
                    sum = sum + value[i][j] ;
                }
        }
        System.out.println( sum / ( row + coulumn ) ) ;
    }


    public String checkDiagonal ( ) 
    {
        for ( i = 0 ; i < row ; i++ )
        {
            for ( j = 0 ; j < coulumn ; j++ )
                {
                    if ( i != j )
                    {
                        if (value[i][j] != 0 )
                        {
                            return ("NO. The given matrix is not a diagonal matrix." ) ;
                           
                        }
                    }
                    else 
                    {
                        if ( value[i][j] == 0 )
                        {
                            return ( "Elements of a diagonal matrix must be non-zero." ) ;
                            
                            
                        }
                    }
                }
        }
        return ( "YES. It is a diagonal matrix." ) ;
    }

public class SquareMatrix extends Matrix
{

    public void squareMatrix ( int c )
    {
        value = new double[ c ][ c ] ;


        System.out.println("Enter the elements of the matrix: " ) ;

        for ( i = 0 ; i < c ; i++ )
        {
            for  ( j = 0; j < c ;j++ )
            {
                Scanner sqMatrix = new Scanner ( System.in ) ;
                value[ i ][ j ] = sqMatrix.nextDouble( ) ;
            }
        }
    }


    public boolean isSymmetric ( int c ) 
    {
        for ( int i = 0 ; i < c; i++ )
        {
            for  ( int j = 0 ; j < c ; j++ )
            {
                if ( value[ i ][ j ] != value[ j ][ i ] ) 
                {
                    return false ;
                }
            }
        }
        return true ;
    }

    public boolean isSkew ( int c ) 
    {
        for ( int i = 0 ; i < c; i++ )
        {
            for  ( int j = 0 ; j < c ; j++ )
            {
                if ( i != j )
                {
                    if ( value[ i ][ j ] != (-1)*(value[ j ][ i ]) ) 
                    {
                    return false ;
                    }
                }
                else 
                {
                    if ( value[ i ][ j ] != 0 )
                    {
                        return false ;
                    }
                }
                
            }
        }
        return true ;
    }
}
    public static void main(String[] args)
 {
    int rows1 , coulumns1 = 3 ;
    //int questionNo ;
//
    //Matrix myMatrix1 = new Matrix( ) ;
    //Matrix myMatrix2 = new Matrix( ) ;
//
    //System.out.println( "Enter the question number: " ) ;
    //Scanner question = new Scanner ( System.in ) ;
    //questionNo = question.nextInt( ) ;
//
    //switch ( questionNo )
    //{
    //    case 1 :
//
    //    System.out.println( "Enter the number of rows: " ) ;
    //    Scanner myRow1 = new Scanner ( System.in ) ;
    //    rows1 = myRow1.nextInt( ) ;
    //
    //    System.out.println("Enter the number of coulumns: ") ;
    //    Scanner myCoulumn1 = new Scanner (System.in) ;
    //    coulumns1 = myCoulumn1.nextInt( ) ;
    //
    //    myMatrix1.setElements( rows1 , coulumns1 ) ;
    //    myMatrix1.getElements( ) ;
    //    myMatrix1.transpose( ) ;
    //    myMatrix1.stringElements( ) ;
//
    //    System.out.println("To add,") ;
    //    myMatrix1.addElements( myMatrix2 ) ;
//
    //    System.out.println("To subtract,") ;
    //    myMatrix1.subtractElements( myMatrix2 ) ;
//
    //    System.out.println("To multiply,") ;
//
    //    if ( rows1 == coulumns1 )
    //    {
    //        myMatrix1.multiplyElements( myMatrix2 ) ;
    //    }
    //    else 
    //    {
    //        System.out.println("Cant multiply matrices with unagreeing rows and coulumns.") ;
    //    }
//
    //    break ;
//
    //    case 3 :
    //    
    //    System.out.println( "Enter the number of rows: " ) ;
    //    Scanner myRow2 = new Scanner ( System.in ) ;
    //    rows1 = myRow2.nextInt( ) ;
    //    
    //    System.out.println("") ;
    //
    //    System.out.println("Enter the number of coulumns: ") ;
    //    Scanner myCoulumn2 = new Scanner (System.in) ;
    //    coulumns1 = myCoulumn2.nextInt( ) ;
//
    //    System.out.println("") ;
//
    //    myMatrix1.setElements( rows1 , coulumns1 ) ;
    //    myMatrix1.getElements( ) ;
//
    //    System.out.println("") ;
//
    //    Matrix matx = new Matrix( ) ;
    //    matx = myMatrix1;
   //
    //    System.out.println( "Enter the row you would like to add: " ) ;
    //    Scanner addRow = new Scanner ( System.in ) ;
    //    int addrow = addRow.nextInt( ) ;
//
    //    System.out.println("") ;
//
    //    System.out.println( "Sum of elements of row: " ) ;
    //    myMatrix1.addRowElements( addrow ) ;
//
    //    System.out.println("") ;
//
    //    System.out.println("Enter the coulumn you would like to add: ") ;
    //    Scanner addCol = new Scanner (System.in) ;
    //    int addcol = addCol.nextInt( ) ;
//
    //    System.out.println("") ;
//
    //    System.out.println( "Sum of elements of coulumn: " ) ;
    //    myMatrix1.addCoulumnElements( addcol ) ;
//
    //    System.out.println("") ;
//
    //    System.out.println("The average of elements of matrix: ") ;
    //    myMatrix1.averageElements() ;
//
    //    System.out.println("") ;
    //
    //    System.out.println("Checking if the matrix is diagonal... ") ;
    //    System.out.println( myMatrix1.checkDiagonal( ) ) ;
//
    //    System.out.println("") ;
//
    //    System.out.println( "Thank You! " ) ;
//
    //    break ;
    //}
    Matrix matrix = new Matrix();
    Matrix.SquareMatrix squareMatrixx = matrix.new SquareMatrix();

    squareMatrixx.squareMatrix(3);
    System.out.println(squareMatrixx.isSymmetric(3)) ;
    System.out.println(squareMatrixx.isSkew(3)) ;
 }
}