package com.stringbuilderex;

/**
 * StringBuilder Ex
 *
 * @author Gennady Khoroshikch
 *
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        StringBuilderEx sbx = new StringBuilderEx(10);
        sbx.append("один;");
        sbx.append("два;");
        sbx.append("три;");
        sbx.append("один;");
        System.out.println(sbx.toString() + "\n" );
        sbx.undo();
        System.out.println(sbx.toString() + "\n" );
        sbx.undo();
        System.out.println(sbx.toString() + "\n" );
        sbx.undo();
        System.out.println(sbx.toString() + "\n" );
        sbx.undo();
        System.out.println(sbx.toString() + "\n" );
    }
}
