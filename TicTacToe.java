import java.util.Scanner ;
import InvalidMoveException ;

public class TicTacToe
{
        private String [ ][ ] board ;
        public TicTacToe( )
        { 
            board = new String[ 3 ][ 3 ] ;
        }
        

        public void initializeBoard ( )
        { 
            int i , j ;

            for ( i = 0 ; i < 3 ; i++ )
            {
                for ( j = 0 ; j < 3 ; j++ )
                {
                    board[ i ][ j ] = "_ " ;
                }
            }
        }


        public boolean makeMove ( int r , int c , int player )
        { 
            boolean move = false ;

            if ( player == 1 && board[ r ][ c ] == "_ " )
            { 
                board [ r ][ c ] = "X";
                move = true ;
            }
            else if ( player == 2 && board[ r ][ c ] == "_ " )
            {
                board [ r ][ c ] = "O" ;
                move = true ;
            }
            else
            {
                throw new InvalidMoveException ("Invalid move, Try again! ") ;
            }

            return move ;
        }


        public void displayBoard( )
        {
            int i , j ;
            
            for ( i = 0 ; i < 3 ; i++ )
            {
                for ( j = 0 ; j < 3 ; j++ )
                {
                    System.out.print( board[ i ][ j ] + " " ) ;
                }
                
                System.out.println("");
            }
        }


        public boolean checkWin( int r , int c , int player )
        {
            String value1 = "" ;
            String value2 = "" ;
            String value3 = "" ;
            String value4 = "" ;

            int i , j ;

            boolean win = false ;

            for ( i = 0 ; i < 3 ; i++ ) 
            {
                value1 += board[ i ][ c ] ;
            }

            for ( j = 0 ; j < 3 ; j++ )
            {
                value2 += board[ r ][ j ] ;
            }

            for ( i = 0 ; i < 3 ; i++ )
            {
                value3 += board[ i ][ i ] ;
            }

            for ( i = 0 ; i < 3 ; i++ )
            {
                for ( j = 0 ; j < 3 ; j++ )
                { 
                    if ( i + j == 2 )
                    {
                        value4 += board[ i ][ j ] ; 
                    }
                }
            }


            if ( value1.equals("XXX" ) || value2.equals("XXX" ) || value3.equals("XXX" ) || value4.equals("XXX" ) )
            {
                System.out.println(" Victory! ( Player 1 ) " ) ;
                win = true ;
            }

            if ( value1.equals("OOO" ) || value2.equals("OOO" ) || value3.equals("OOO" ) || value4.equals("OOO" ) )
            {
                System.out.println("Victory! ( Player 2 )") ;
                win = true ;
            }

            return win ;
        }

        public boolean gameOver( )
        {
            return true ;
        }

        public static void main ( String[] args )
        {
            Scanner scanner = new Scanner( System.in ) ;

            TicTacToe games = new TicTacToe( ) ;
            games.initializeBoard( ) ;
            
            System.out.println("Initial condition " ) ;
            games.displayBoard( ) ;

            boolean gameStatus = false ;
            
            System.out.print("Would you like to start the game? ( yes / no ) : " ) ;
            String choice = scanner.next( ) ;

            int player = 1 ;
            int count = 1 ;
            
            while ( choice.equals("yes" ) && gameStatus == false && count <= 9 )
            {
                System.out.print("Enter the row: " ) ;
                int row = scanner.nextInt( ) - 1 ;
                
                System.out.print("Enter the column: " ) ;
                int column = scanner.nextInt( ) - 1 ;

            try
            { 
                boolean move = games.makeMove( row , column , player ) ; 
                if ( move == false )
                {
                    System.out.print("Enter the row: " ) ;
                    row = scanner.nextInt( ) - 1 ;

                    System.out.print("Enter the column: " ) ;
                    column = scanner.nextInt( ) - 1 ;

                    games.makeMove( row , column , player ) ;
                }

                games.displayBoard( ) ;
                boolean isWin = games.checkWin( row , column , player ) ;
                if ( isWin == true )
                {
                    gameStatus = games.gameOver( ) ;
                }
                if ( player == 1 )
                {
                    player = 2 ;
                }
                else
                {
                    player=1;
                }

                count++ ;
            } 
            catch ( InvalidMoveException e )
            {
                System.out.println( e.getMessage( ) ) ;
            }

            }
        }
}