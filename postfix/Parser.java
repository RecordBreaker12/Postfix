package postfix;

import java.io.IOException;

public class Parser {
    static int lookahead;
    
    public Parser() throws IOException{
        lookahead = System.in.read();
    }

    void match(int t) throws IOException{
        if(lookahead == t){
            lookahead = System.in.read();
        }
        else{
            throw new Error("syntax error");
        }
    }
    
    void term() throws IOException{
        if(Character.isDigit((char)lookahead)||(char)lookahead==' '){
            System.out.write((char)lookahead);
            match(lookahead);
        }
        else{
            throw new Error("syntax error");
        }
    }
    
    void expr() throws IOException{
        term();
        while(true){
            switch (lookahead) {
                case '+':
                    match('+');
                    term();
                    System.out.write('+');
                    break;
                case '-':
                    match('-');
                    term();
                    System.out.write('-');
                    break;
                default:
                    return;
            }
        }
    }
}
