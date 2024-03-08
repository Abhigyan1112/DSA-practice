package TicTacToe;

public class TTT {
    char player;
    char[][] table=new char[3][3];
    TTT(){
        player='X';
        char n='1';
        for(int i=0;i<3;i++){
            for(int j=0;j<3;j++){
                table[i][j]=n++;
            }
        }
    }
    protected boolean insert(int n){
        if(!check(n))return false;
        table[(n-1)/3][(n-1)%3]=player;
        return true;
    }
    protected boolean haveWon(){
        for(int i=0;i<3;i++){
            if(table[i][0]==player && table[i][1]==player && table[i][2]==player){
                return true;
            }
            if(table[0][i]==player && table[1][i]==player && table[2][i]==player){
                return true;
            }
        }
        if(table[0][0]==player && table[1][1]==player && table[2][2]==player){
            return true;
        }
        if(table[0][2]==player && table[1][1]==player && table[2][0]==player){
            return true;
        }
        if(player=='X') player='O';
        else player='X';
        return false;
    }
    protected void printTable(){
        for(int i=0;i<3;i++){
            System.out.print("| ");
            for(int j=0;j<3;j++){
                System.out.print(table[i][j]+" | ");
            }
            System.out.println();
        }
        System.out.println();
    }
    protected boolean check(int n){
        if(table[(n-1)/3][(n-1)%3]!='X' && table[(n-1)/3][(n-1)%3]!='O'){
            return true;
        }
        return false;
    }
}
