package com.example.calculator;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class MainActivity extends AppCompatActivity {
    private static String rnum;
    Button b00,b0,b1,b2,b3,b4,b5,b6,b7,b8,b9,add,sub,multiply,divide,mod,exponents,log,roots,reciprocal,clear,backspace,open,close,equal,dot;
    TextView equation,answer;
    Boolean root=false;
    Double rn=0.0,num=0.0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        b00=findViewById(R.id.doublezero);
        b0=findViewById(R.id.zero);
        b1=findViewById(R.id.one);
        b2=findViewById(R.id.two);
        b3=findViewById(R.id.three);
        b4=findViewById(R.id.four);
        b5=findViewById(R.id.five);
        b6=findViewById(R.id.six);
        b7=findViewById(R.id.seven);
        b8=findViewById(R.id.eight);
        b9=findViewById(R.id.nine);
        add=findViewById(R.id.add);
        sub=findViewById(R.id.minus);
        multiply=findViewById(R.id.multiply);
        divide=findViewById(R.id.division);
        mod=findViewById(R.id.mod);
        exponents=findViewById(R.id.exponent);
        log=findViewById(R.id.log);
        roots=findViewById(R.id.root);
        reciprocal=findViewById(R.id.reciprocal);
        clear=findViewById(R.id.clear);
        backspace=findViewById(R.id.backspace);
        open=findViewById(R.id.open);
        close=findViewById(R.id.close);
        equal=findViewById(R.id.equal);
        dot=findViewById(R.id.decimal);

        equation=findViewById(R.id.equationview);
        answer=findViewById(R.id.answer);

        //onclick listeners
        b00.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                equation.setText(equation.getText()+"00");
            }
        });
        b0.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                equation.setText(equation.getText()+"0");
            }
        });
        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                equation.setText(equation.getText()+"1");
            }
        });
        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                equation.setText(equation.getText()+"2");
            }
        });
        b3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                equation.setText(equation.getText()+"3");
            }
        });
        b4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                equation.setText(equation.getText()+"4");
            }
        });
        b5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                equation.setText(equation.getText()+"5");
            }
        });
        b6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                equation.setText(equation.getText()+"6");
            }
        });
        b7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                equation.setText(equation.getText()+"7");
            }
        });
        b8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                equation.setText(equation.getText()+"8");
            }
        });
        b9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                equation.setText(equation.getText()+"9");
            }
        });
        add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                equation.setText(equation.getText()+"+");
            }
        });
        sub.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                equation.setText(equation.getText()+"-");
            }
        });
        multiply.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                equation.setText(equation.getText()+"*");
            }
        });
        divide.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                equation.setText(equation.getText()+"÷");
            }
        });
        mod.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                equation.setText(equation.getText()+"%");
            }
        });
        exponents.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                equation.setText(equation.getText()+"^");
            }
        });
        roots.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                root=true;
                String val = equation.getText().toString();
                rn = (Double.parseDouble(val));
                equation.setText(equation.getText()+"√");
            }
        });
        close.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                equation.setText(equation.getText()+")");
            }
        });
        open.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                equation.setText(equation.getText()+"(");
            }
        });
        dot.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                equation.setText(equation.getText()+".");
            }
        });
        clear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                equation.setText("");
                answer.setText("");
            }
        });
        backspace.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String val= equation.getText().toString();
                val=val.substring(0,val.length()-1);
                equation.setText(val);
            }
        });
        log.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                equation.setText(equation.getText()+"log");
            }
        });
        equal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(root){
                    rnum = equation.getText().toString();
                    String temporary = findnum(rnum);
                    num=(Double.parseDouble(temporary));
                    double result=Math.pow(num,1.0/rn);
                    answer.setText(String.valueOf(result));
                }else {
                    String val =equation.getText().toString();
                    String replacedstr = val.replace('÷','/');
                    double result = eval(replacedstr);
                    answer.setText(String.valueOf(result));
                }
            }
        });
        reciprocal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                equation.setText(equation.getText()+"^"+"(-1)");
            }

        });
    }
    public static double eval(final String str) {
        return new Object() {
            int pos = -1, ch;

            void nextChar() {
                ch = (++pos < str.length()) ? str.charAt(pos) : -1;
            }

            boolean eat(int charToEat) {
                while (ch == ' ') nextChar();
                if (ch == charToEat) {
                    nextChar();
                    return true;
                }
                return false;
            }

            double parse() {
                nextChar();
                double x = parseExpression();
                if (pos < str.length()) throw new RuntimeException("Unexpected: " + (char)ch);
                return x;
            }

            double parseExpression() {
                double x = parseTerm();
                for (;;) {
                    if      (eat('+')) x += parseTerm();
                    else if (eat('-')) x -= parseTerm();
                    else return x;
                }
            }

            double parseTerm() {
                double x = parseFactor();
                for (;;) {
                    if      (eat('*')) x *= parseFactor();
                    else if (eat('/')) x /= parseFactor();
                    else if (eat('%')) x %=parseFactor();
                    else return x;
                }
            }

            double parseFactor() {
                if (eat('+')) return parseFactor();
                if (eat('-')) return -parseFactor();

                double x;
                int startPos = this.pos;
                if (eat('(')) { // parentheses
                    x = parseExpression();
                    eat(')');
                } else if ((ch >= '0' && ch <= '9') || ch == '.') { // numbers
                    while ((ch >= '0' && ch <= '9') || ch == '.') nextChar();
                    x = Double.parseDouble(str.substring(startPos, this.pos));
                } else if (ch >= 'a' && ch <= 'z') { // functions
                    while (ch >= 'a' && ch <= 'z') nextChar();
                    String func = str.substring(startPos, this.pos);
                    x = parseFactor();
                    if (func.equals("sqrt")) x = Math.sqrt(x);
                    else if (func.equals("log")) x = Math.log10(x);
                    else throw new RuntimeException("Unknown function: " + func);
                } else {
                    throw new RuntimeException("Unexpected: " + (char)ch);
                }

                if (eat('^')) x = Math.pow(x, parseFactor());
                return x;
            }
        }.parse();
    }
    public static String findnum(String str){
        String eq = String.valueOf(rnum);
        String pattern = ".*√\\s*([\\d.]+)";
        Pattern regex = Pattern.compile(pattern);
        Matcher matcher = regex.matcher(eq);
        if (matcher.find()) {
            String numberStr = matcher.group(1);
            double number = Double.parseDouble(numberStr);
            str = String.valueOf(number);
    }
        return str;
}
}